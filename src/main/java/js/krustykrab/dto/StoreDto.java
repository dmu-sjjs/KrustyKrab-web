package js.krustykrab.dto;


import js.krustykrab.domain.Store;
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
    private String storeLatitude;
    private String storeLongitude;
    private String storeTelNumber;

    public Store toEntity() {
        return Store.builder()
                .storeName(storeName)
                .storeLatitude(storeLatitude)
                .storeLongitude(storeLongitude)
                .storeTelNumber(storeTelNumber)
                .build();
    }

    public Store toHasIdEntity() {
        return Store.builder()
                .storeId(storeId)
                .storeName(storeName)
                .storeLatitude(storeLatitude)
                .storeLongitude(storeLongitude)
                .storeTelNumber(storeTelNumber)
                .build();
    }
}
