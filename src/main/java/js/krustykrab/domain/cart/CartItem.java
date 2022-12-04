package js.krustykrab.domain.cart;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CartItem {
    private Long menuId;
    private int count;
}
