package js.krustykrab.domain;

import js.krustykrab.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Table(name = "STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "storeLatitude")
    private String storeLatitude;

    @Column(name = "storeLongitude")
    private String storeLongitude;

    @Column(name = "storeTelNumber")
    private String storeTelNumber;


    public StoreDto toDto(){
        return StoreDto.builder()
                .storeId(storeId)
                .storeName(storeName)
                .storeLatitude(storeLatitude)
                .storeLongitude(storeLongitude)
                .storeTelNumber(storeTelNumber)
                .build();
    }
}
