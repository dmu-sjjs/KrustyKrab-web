package js.krustykrab.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AuthorityTest {

    @Test
    void valueOfTest(){
        assertThat(Authority.valueOf("USER")).isEqualTo(Authority.USER);
        assertThat(Authority.valueOf("ADMIN")).isEqualTo(Authority.ADMIN);
    }
}