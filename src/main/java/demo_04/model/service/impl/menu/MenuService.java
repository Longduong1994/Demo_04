package demo_04.model.service.impl.menu;

import demo_04.model.dto.request.MenuRequest;
import demo_04.model.dto.response.MenuResponse;
import demo_04.model.entity.Menu;
import demo_04.model.repository.IMenuRepository;
import demo_04.model.service.mapper.IGenericMapper;
import demo_04.model.service.mapper.menu.IMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService implements IMenuService<MenuRequest, MenuResponse,Long>{
    @Autowired
    private IMenuRepository menuRepository;
    @Autowired
    private IMenuMapper menuMapper;

    @Override
    public Page<MenuResponse> findAll(String name, int page, int size) {
        Page<Menu> menus = menuRepository.findAllByNameContains(name, PageRequest.of(page, size));
        return menus.map(menu -> menuMapper.toResponse(menu));
    }


    @Override
    public MenuResponse findById(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isPresent()) {
            return menuMapper.toResponse(menu.get());
        }
        return null;
    }

    @Override
    public void save(MenuRequest menuRequest) {
        menuRepository.save(menuMapper.toEntity(menuRequest));
    }

    @Override
    public void delete(Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()) {
            menuRepository.deleteById(id);
        }
    }
}
