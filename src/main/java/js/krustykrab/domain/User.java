package js.krustykrab.domain;

import js.krustykrab.dto.user.UserDto;
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

    @Column(name = "location")
    private String location;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "authority")
    private Authority authority;

    public UserDto toDto(){
        return UserDto.builder()
                .userId(userId)
                .id(id).pw(pw)
                .username(username)
                .location(location)
                .phoneNumber(phoneNumber)
                .authority(authority.name())
                .build();
    }
}