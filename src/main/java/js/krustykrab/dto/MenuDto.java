package js.krustykrab.dto;

import js.krustykrab.domain.menu.Menu;
import js.krustykrab.domain.menu.MenuType;
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
    private String menuType;
    private boolean isSale;
    private int saleRate;

    public Menu toEntity(){
        return Menu.builder()
                .menuName(menuName)
                .menuDescription(menuDescription)
                .price(price)
                .menuType(MenuType.valueOf(menuType))
                .isSale(isSale)
                .saleRate(saleRate)
                .build();
    }
}
