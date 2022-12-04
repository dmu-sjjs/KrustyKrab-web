package js.krustykrab.domain.cart;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItem {
    private Long menuId;
    private int count;
}
