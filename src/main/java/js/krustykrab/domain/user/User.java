package js.krustykrab.domain.user;

import js.krustykrab.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "id")
    private String id;

    @Column(name = "pw")
    private String pw;

    @Column(name = "username")
    private String username;

    @Column(name = "address")
    private String address;

    @Column(name = "detailAddress")
    private String detailAddress;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "authority")
    private Authority authority;

    public UserDto toDto() {
        return UserDto.builder()
                .userId(userId)
                .id(id).pw(pw)
                .username(username)
                .address(address)
                .detailAddress(detailAddress)
                .phoneNumber(phoneNumber)
                .authority(authority.name())
                .build();
    }
}