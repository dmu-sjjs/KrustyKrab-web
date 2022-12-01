package js.krustykrab.csv.store;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import js.krustykrab.dto.MenuDto;
import js.krustykrab.dto.StoreDto;
import js.krustykrab.service.MenuService;
import js.krustykrab.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreCsvParser {
    private static boolean isDuplicate = false;


    public static void read(StoreService storeService) throws CsvValidationException, IOException {
        // csv파일의 절대경로 구하기
        String path = System.getProperty("user.dir");   //csv파일 path 저장
        List<StoreDto> storeList = storeService.findAllStore();

        try {
            //utf-8 형태로 csv 파일 파싱
            String[] storeData;
            CSVReader csvReader = new CSVReader(new InputStreamReader(new FileInputStream(path + "/src/main/java/js/krustykrab/csv/store/store.csv"), "EUC-KR"));

            do {
                storeData = csvReader.readNext();    // 한 라인 읽기 (자동으로 콤마 분리해서 배열에 저장 됌)
                if(validateNotNull(storeData)){
                    break;
                }
                if (validateDuplicate(storeData[0], storeList)) {  // 메뉴명 중복 체크
                    continue;
                }
                if (storeData != null) {
                    // menuDto 객체 생성하기
                    StoreDto storeDto = StoreDto.builder()
                            .storeName(storeData[0])
                            .storeLatitude(Long.parseLong(storeData[1]))
                            .storeLongitude(Long.parseLong(storeData[2]))
                            .storeTelNumber(storeData[3])
                            .build();

                    storeService.addStore(storeDto);   // DB에 INSERT
                }
            } while (storeData != null);
        } catch (EntityExistsException | CsvValidationException | IOException e) {
            throw e;
        }
    }

    private static boolean validateDuplicate(String storeNameToAdd, List<StoreDto> storeList) {
        for (StoreDto storeDto : storeList) {
            isDuplicate = (storeDto.getStoreName().equals(storeNameToAdd));
            if (isDuplicate) {  //중복 발견시 반복문 종료
                break;
            }
        }
        return isDuplicate; //중복 여부 리턴
    }

    private static boolean validateNotNull(String[] storeData) {
        if(storeData == null){
            return true;
        }
        return false;
    }

}
