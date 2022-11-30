package js.krustykrab.csv;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import js.krustykrab.dto.MenuDto;
import js.krustykrab.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuCsvParser {
    private static boolean isDuplicate = false;


    public static void read(MenuService menuService) throws CsvValidationException, IOException {
        // csv파일의 절대경로 구하기
        String path = System.getProperty("user.dir");   //csv파일 path 저장
        List<MenuDto> menuList = menuService.findAllMenu();


        try {
            //utf-8 형태로 csv 파일 파싱
            String[] menuData;
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(path + "/src/main/java/js/krustykrab/csv/menu.csv"), "EUC-KR"));

            do {
                menuData = csvReader.readNext();    // 한 라인 읽기 (자동으로 콤마 분리해서 배열에 저장 됌)
                if(validateNotNull(menuData)){
                    break;
                }
                if (validateDuplicate(menuData[0], menuList)) {  // 메뉴명 중복 체크
                    continue;
                }
                if (menuData != null) {
                    // menuDto 객체 생성하기
                    MenuDto menuDto = MenuDto.builder()
                            .menuName(menuData[0])
                            .menuDescription(menuData[1])
                            .price(Integer.parseInt(menuData[2]))
                            .menuType(menuData[3])
                            .isSale(getBooleanValue(menuData[4]))
                            .saleRate(Integer.parseInt(menuData[5]))
                            .build();

                    menuService.save(menuDto);   // DB에 INSERT
                }
            } while (menuData != null);
        } catch (EntityExistsException | CsvValidationException | IOException e) {
            throw e;
        }
    }

    private static boolean validateDuplicate(String menuNameToAdd, List<MenuDto> menuList) {
        for (MenuDto menu : menuList) {
            isDuplicate = (menu.getMenuName().equals(menuNameToAdd));
            if (isDuplicate) {  //중복 발견시 반복문 종료
                break;
            }
        }
        return isDuplicate; //중복 여부 리턴
    }

    private static boolean validateNotNull(String[] menuData) {
        if(menuData == null){
            return true;
        }
        return false;
    }

    private static boolean getBooleanValue(String isSale){
        if(isSale.equals("0")){
            return false;
        }
        return true;
    }

}
