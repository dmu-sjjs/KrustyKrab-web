package js.krustykrab.service;

import js.krustykrab.dao.UserRepository;
import js.krustykrab.domain.User;
import js.krustykrab.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 회원가입
    public Optional<User> join(UserDto userDto) {
        // userDto 값 제대로 입력되었는지 검증은 프론트에서 처리
        Optional<User> optionalUser = Optional.empty();

        // 입력받은 아이디로 가입된 회원정보가 있는지 검증
        Optional<User> userById = userRepository.findById(userDto.getId());
        if(userById.isEmpty()) {
            optionalUser = Optional.of(userRepository.save(userDto.toEntity()));
        }
        return optionalUser;
    }
}
