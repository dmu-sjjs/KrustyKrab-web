package js.krustykrab.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserMypageDto {
    private Long userId;
    private String username;
    private String address;
    private String detailAddress;
    private String phoneNumber;
}
