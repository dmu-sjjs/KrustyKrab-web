package js.krustykrab.dao;


import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.menu.MenuType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu save(Menu menu);
    Optional<Menu> findByMenuId(Long menuId);
    List<Menu> findByMenuType(MenuType menuType);
    List<Menu> findByIsSale(boolean isSale);
    List<Menu> findAll();
}
