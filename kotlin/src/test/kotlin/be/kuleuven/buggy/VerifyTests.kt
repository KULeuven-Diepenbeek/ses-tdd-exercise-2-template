package be.kuleuven.buggy

import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.hamcrest.CoreMatchers.`is` as Is

class VerifyTests {

    @Test
    fun verifyUrl_WithHTTP_ShouldSucceed() {
        assertThat(verify("http://www.thundercats.com"), Is(true))
    }

    @Test
    fun verifyUrl_URLEndingInDot_ShouldFail() {
        assertThat(verify("http://."), Is(false))
    }

    @Test
    fun verifyUrl_URLWithoutHttpOrHttps_ShouldFail() {
        assertThat(verify("google.com"), Is(false))
    }

    @Test
    fun verifyUrl_WithAnIPAddress_ShouldFail() {
        assertThat(verify("127.0.0.1"), Is(false))
    }

    @Test
    fun verifyUrl_URLWithoutDomain_ShouldFail() {
        assertThat(verify("http://"), Is(false))
    }

    // TODO add more? You'd think?

}