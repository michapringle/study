package ca.mpringle.study.neet.slidingwindow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class StockTest {

    @ParameterizedTest
    @MethodSource("maxProfitData")
    void carFleetTest(final int[] prices, final int expected) {

        final int actual = Stock.maxProfit(prices);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> maxProfitData() {

        return Stream.of(
                Arguments.of(
                        null,
                        0
                ),
                Arguments.of(
                        new int[]{1},
                        0
                ),
                Arguments.of(
                        new int[]{1, 1},
                        0
                ),
                Arguments.of(
                        new int[]{1, 2},
                        1
                ),
                Arguments.of(
                        new int[]{5, 10, 1, 7},
                        6
                ),
                // Buy prices[1] and sell prices[4], profit = 7 - 1 = 6
                Arguments.of(
                        new int[]{10, 1, 5, 6, 7, 1},
                        6
                ),
                // No profitable transactions can be made, thus the max profit is 0.
                Arguments.of(
                        new int[]{10, 8, 7, 5, 2},
                        0
                ),
                Arguments.of(
                        new int[]{7,1,5,3,6,4},
                        5
                )
        );
    }
}
