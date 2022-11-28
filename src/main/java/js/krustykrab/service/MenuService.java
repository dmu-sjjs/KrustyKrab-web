package js.krustykrab.service;

import com.opencsv.exceptions.CsvValidationException;
import js.krustykrab.csv.MenuCsvParser;
import js.krustykrab.dao.MenuRepository;
import js.krustykrab.dto.menu.MenuDto;
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

    public MenuDto findMenu(Long menuId){
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

    public void save(MenuDto menuDto) {
        menuRepository.save(menuDto.toEntity());
    }
}
