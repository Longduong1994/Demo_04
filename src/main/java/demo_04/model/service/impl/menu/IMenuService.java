package demo_04.model.service.impl.menu;

import demo_04.model.dto.response.MenuResponse;
import demo_04.model.service.impl.IGenericService;
import org.springframework.data.domain.Page;

public interface IMenuService<K,V,E> {
   Page<V> findAll(String name,int page,int size);
   V findById(E id);
   void save(K k);
   void delete(E id);
}
