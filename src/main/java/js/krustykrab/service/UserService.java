package js.krustykrab.service;

import js.krustykrab.dao.UserRepository;
import js.krustykrab.domain.user.User;
import js.krustykrab.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

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
        if (optionalUser.isEmpty()) {
            return null;
        }
        return optionalUser.get().toDto();
    }

    public boolean duplicationCheck(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return true;
        }
        return false;
    }

    public ArrayList<UserDto> findAllUser() {
        return userListToDto(userRepository.findAll());
    }

    public UserDto findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow().toDto();
    }

    private ArrayList<UserDto> userListToDto(List<User> users) {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(user.toDto());
        });

        return userDtos;
    }

    public UserDto changeUserData(Long userId, String username, String address, String detailAddress, String phoneNumber) {
        User user = userRepository.changeUserData(userId, username, address, detailAddress, phoneNumber);
        return user.toDto();
    }
}
