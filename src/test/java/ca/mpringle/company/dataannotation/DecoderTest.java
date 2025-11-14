package ca.mpringle.company.dataannotation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

final class DecoderTest {

    @ParameterizedTest
    @MethodSource("decodeSecretMessageData")
    void decodeSecretMessageTest(final String url) throws IOException {

        Decoder.decodeSecretMessage(url);
    }

    static Stream<Arguments> decodeSecretMessageData() {

        return Stream.of(
                Arguments.of(
                        "https://docs.google.com/document/d/e/2PACX-1vTMOmshQe8YvaRXi6gEPKKlsC6UpFJSMAk4mQjLm_u1gmHdVVTaeh7nBNFBRlui0sTZ-snGwZM4DBCT/pub"
                ),
                Arguments.of(
                 "https://docs.google.com/document/d/e/2PACX-1vRPzbNQcx5UriHSbZ-9vmsTow_R6RRe7eyAU60xIF9Dlz-vaHiHNO2TKgDi7jy4ZpTpNqM7EvEcfr_p/pub"
                )
        );
    }
}
