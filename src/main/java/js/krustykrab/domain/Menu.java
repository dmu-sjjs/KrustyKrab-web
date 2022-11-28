package js.krustykrab.domain;

import js.krustykrab.dto.menu.MenuDto;
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
@Table(name = "MENU")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Long menuId;

    @Column(name = "menuName")
    private String menuName;

    @Column(name = "menuDescription")
    private String menuDescription;

    @Column(name = "price")
    private int price;

    public MenuDto toDto(){
        return MenuDto.builder()
                .menuId(menuId)
                .menuName(menuName)
                .menuDescription(menuDescription)
                .price(price)
                .build();
    }
}
