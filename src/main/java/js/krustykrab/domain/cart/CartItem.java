package js.krustykrab.domain.cart;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CartItem {
    private Long menuId;
    private String menuName;
    private String menuType;
    private int count;
    private int price;
}
