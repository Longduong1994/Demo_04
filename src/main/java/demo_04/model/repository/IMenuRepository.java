package demo_04.model.repository;


import demo_04.model.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu,Long> {
    Page<Menu> findAllByNameContains(String name, Pageable pageable);
}
