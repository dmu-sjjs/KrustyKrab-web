package js.krustykrab.dto;


import js.krustykrab.domain.Authority;
import js.krustykrab.domain.Store;
import js.krustykrab.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class StoreDto {
    private Long storeId;
    private String storeName;
    private String storeLocation;
    private String storeTelNumber;

    public Store toEntity(){
        return Store.builder()
                .storeName(storeName)
                .storeLocation(storeLocation)
                .storeTelNumber(storeTelNumber)
                .build();
    }
}
