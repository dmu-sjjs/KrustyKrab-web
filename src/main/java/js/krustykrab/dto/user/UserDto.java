package js.krustykrab.dto.user;

import js.krustykrab.domain.Authority;
import js.krustykrab.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserDto {

    private Long userId;

    private String id;

    private String pw;

    private String username;

    private String location;

    private String phoneNumber;

    private String authority;

    public User toEntity(){
        checkAuthority();
        return User.builder()
                .userId(userId)
                .id(id).pw(pw)
                .username(username)
                .location(location)
                .phoneNumber(phoneNumber)
                .authority(Authority.valueOf(authority))
                .build();
    }

    private void checkAuthority(){
        if(authority == null){
            authority = Authority.USER.name();
        }
    }
}
