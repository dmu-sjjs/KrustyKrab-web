package js.krustykrab.service;

import com.opencsv.exceptions.CsvValidationException;
import js.krustykrab.csv.menu.MenuCsvParser;
import js.krustykrab.dao.MenuRepository;
import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.menu.MenuType;
import js.krustykrab.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;


    public void addDefaultMenu() throws CsvValidationException, IOException {
        MenuCsvParser.read(this);
    }

    public MenuDto findMenu(Long menuId) {
        return menuRepository
                .findByMenuId(menuId).orElseThrow(() -> new IllegalArgumentException("일치하는 menuId가 없습니다."))
                .toDto();
    }

    public List<MenuDto> findAllMenu() {
        List<MenuDto> allMenu = new ArrayList<>();
        menuRepository.findAll().forEach(menu -> {
            allMenu.add(menu.toDto());
        });

        return allMenu;
    }

    public ArrayList<MenuDto> findMenuByMenuType(String menuType) {
        List<Menu> menus = menuRepository.findByMenuType(MenuType.valueOf(menuType));
        return menuListToDto(menus);
    }

    public ArrayList<MenuDto> findSaleMenus() {
        List<Menu> menus = menuRepository.findByIsSale(true);
        return menuListToDto(menus);
    }

    public void save(MenuDto menuDto) {
        menuRepository.save(menuDto.toEntity());
    }

    private ArrayList<MenuDto> menuListToDto(List<Menu> menus) {
        ArrayList<MenuDto> menuDtos = new ArrayList<>();
        menus.forEach(menu -> {
            menuDtos.add(menu.toDto());
        });

        return menuDtos;
    }
}
