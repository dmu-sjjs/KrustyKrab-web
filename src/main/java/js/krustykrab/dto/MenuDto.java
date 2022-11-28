package js.krustykrab.dto;

import js.krustykrab.domain.Menu;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private Long menuId;
    private String menuName;
    private String menuDescription;
    private int price;

    public Menu toEntity(){
        return Menu.builder()
                .menuName(menuName)
                .menuDescription(menuDescription)
                .price(price)
                .build();
    }
}
