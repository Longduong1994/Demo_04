package demo_04.model.service.mapper.menu;

import demo_04.model.dto.request.MenuRequest;
import demo_04.model.dto.response.MenuResponse;
import demo_04.model.entity.Menu;
import demo_04.model.service.impl.upload_file.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class MenuMapper implements IMenuMapper {
    @Autowired
    private IStorageService storageService;
    @Override
    public MenuResponse toResponse(Menu menu) {
        return MenuResponse.builder()
                .id(menu.getId())
                .name(menu.getName())
                .image(menu.getImage())
                .description(menu.getDescription())
                .price(menu.getPrice())
                .created_date(menu.getCreated_date())
                .category(menu.getCategory())
                .status(menu.isStatus()).build();
    }

    @Override
    public Menu toEntity(MenuRequest menuRequest) {
        String url = storageService.uploadFile(menuRequest.getImage());
        return Menu.builder()
                .id(menuRequest.getId())
                .name(menuRequest.getName())
                .image(url)
                .description(menuRequest.getDescription())
                .price(menuRequest.getPrice())
                .created_date(new Date())
                .status(true)
                .category(menuRequest.getCategory()).build();
    }
}
