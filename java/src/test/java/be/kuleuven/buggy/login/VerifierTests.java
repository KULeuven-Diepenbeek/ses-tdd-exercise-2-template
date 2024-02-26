package be.kuleuven.buggy.login;

import be.kuleuven.buggy.Verifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VerifierTests {

    @Test
    void verifyUrl_WithHTTP_ShouldSucceed() {
        assertThat(Verifier.verifyUrl("http://www.thundercats.com")).isEqualTo(true);
    }

    @Test
    void verifyUrl_URLEndingInDot_ShouldFail() {
        assertThat(Verifier.verifyUrl("http://.")).isEqualTo(false);
    }

    @Test
    void verifyUrl_URLWithoutHttpOrHttps_ShouldFail() {
        assertThat(Verifier.verifyUrl("google.com")).isEqualTo(false);
    }

    @Test
    void verifyUrl_WithAnIPAddress_ShouldFail() {
        assertThat(Verifier.verifyUrl("127.0.0.1")).isEqualTo(false);
    }

    @Test
    void verifyUrl_URLWithoutDomain_ShouldFail() {
        assertThat(Verifier.verifyUrl("http://")).isEqualTo(false);
    }

}