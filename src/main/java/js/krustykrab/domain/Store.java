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

    @Column(name = "storeLocation")
    private String storeLocation;

    @Column(name = "storeTelNumber")
    private String storeTelNumber;


    public StoreDto toDto(){
        return StoreDto.builder()
                .storeId(storeId)
                .storeName(storeName)
                .storeLocation(storeLocation)
                .storeTelNumber(storeTelNumber)
                .build();
    }
}
