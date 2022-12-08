package js.krustykrab.service;

import js.krustykrab.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static js.krustykrab.domain.user.Authority.ADMIN;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserService userService;

    public Boolean checkAuthority(UserDto userDto) {
        String authority = userDto.getAuthority();
        if (authority.equals(ADMIN.name())) {
            return true;
        }
        return false;
    }
}
