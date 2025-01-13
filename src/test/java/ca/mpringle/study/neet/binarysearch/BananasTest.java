package ca.mpringle.study.neet.binarysearch;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class BananasTest {

    @ParameterizedTest
    @MethodSource("minEatingSpeedData")
    void searchTest(final int[] piles, final int h, final int expected) {

        final int actual = Bananas.minEatingSpeed(piles, h);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> minEatingSpeedData() {

        return Stream.of(
                Arguments.of(
                        new int[]{30, 11, 23, 4, 20},
                        6,
                        23
                ),
                Arguments.of(
                        new int[]{
                                873375536, 395271806, 617254718, 970525912, 634754347, 824202576,
                                694181619, 20191396, 886462834, 442389139, 572655464, 438946009,
                                791566709, 776244944, 694340852, 419438893, 784015530, 588954527,
                                282060288, 269101141, 499386849, 846936808, 92389214, 385055341,
                                56742915, 803341674, 837907634, 728867715, 20958651, 167651719,
                                345626668, 701905050, 932332403, 572486583, 603363649, 967330688,
                                484233747, 859566856, 446838995, 375409782, 220949961, 72860128,
                                998899684, 615754807, 383344277, 36322529, 154308670, 335291837,
                                927055440, 28020467, 558059248, 999492426, 991026255, 30205761,
                                884639109, 61689648, 742973721, 395173120, 38459914, 705636911,
                                30019578, 968014413, 126489328, 738983100, 793184186, 871576545,
                                768870427, 955396670, 328003949, 786890382, 450361695, 994581348,
                                158169007, 309034664, 388541713, 142633427, 390169457, 161995664,
                                906356894, 379954831, 448138536
                        },
                        943223529,
                        46
                ),
                Arguments.of(
                        new int[]{312884470},
                        312884469,
                        2
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        3,
                        3
                ),
                Arguments.of(
                        new int[]{1, 2, 3},
                        4,
                        2
                ),
                Arguments.of(
                        new int[]{1, 4, 3, 2},
                        9,
                        2
                ),
                Arguments.of(
                        new int[]{25, 10, 23, 4},
                        4,
                        25
                )
        );
    }
}
