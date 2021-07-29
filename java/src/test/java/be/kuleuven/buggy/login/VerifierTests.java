package be.kuleuven.buggy.login;

import be.kuleuven.buggy.Verifier;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class VerifierTests {

    @Test
    void verifyUrl_WithHTTP_ShouldSucceed() {
        assertThat(Verifier.verifyUrl("http://www.thundercats.com"), is(true));
    }

    @Test
    void verifyUrl_URLEndingInDot_ShouldFail() {
        assertThat(Verifier.verifyUrl("http://."), is(false));
    }

    @Test
    void verifyUrl_URLWithoutHttpOrHttps_ShouldFail() {
        assertThat(Verifier.verifyUrl("google.com"), is(false));
    }

    @Test
    void verifyUrl_WithAnIPAddress_ShouldFail() {
        assertThat(Verifier.verifyUrl("127.0.0.1"), is(false));
    }

    @Test
    void verifyUrl_URLWithoutDomain_ShouldFail() {
        assertThat(Verifier.verifyUrl("http://"), is(false));
    }

}