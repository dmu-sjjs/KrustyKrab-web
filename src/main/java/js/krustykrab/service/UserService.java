package js.krustykrab.service;

import js.krustykrab.dao.UserRepository;
import js.krustykrab.domain.User;
import js.krustykrab.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 회원가입
    // userDto 값 제대로 입력되었는지 검증은 프론트에서 처리
    public UserDto join(UserDto userDto) {

        Optional<User> userWithEnteredId = userRepository.findById(userDto.getId());
        if (userWithEnteredId.isPresent()) {
            return null;
        }

        User joinedUser = userRepository.save(userDto.toEntity());
        return joinedUser.toDto();
    }

    // 로그인
    public UserDto login(UserDto userLoginDto) {

        Optional<User> optionalUser = userRepository.findByIdAndPw(userLoginDto.getId(), userLoginDto.getPw());
        if(optionalUser.isEmpty()){
            return null;
        }
        return optionalUser.get().toDto();
    }

    public boolean duplicationCheck(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return true;
        }
        return false;
    }
}
