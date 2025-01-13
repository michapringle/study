package ca.mpringle.study.neet.twopointers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ThreeSumTest {

    @ParameterizedTest
    @MethodSource("threeSumData")
    void threeSumTest(final int[] input, final List<List<Integer>> expected) {

        final List<List<Integer>> actual = ThreeSum.threeSum(input);

        assertEquals(expected, actual);
    }

    static Stream<Arguments> threeSumData() {


        return Stream.of(
                Arguments.of(null, new ArrayList<>()),
                Arguments.of(new int[]{}, new ArrayList<>()),
                Arguments.of(new int[]{0, 1, 1}, new ArrayList<>()),
                Arguments.of(
                        new int[]{0, 0, 0},
                        newList(newSortedList(0, 0, 0))
                ),
                Arguments.of(
                        new int[]{-1, 0, 1, 2, -1, -4},
                        newList(newSortedList(-1, -1, 2), newSortedList(-1, 0, 1))
                )
        );
    }

    private static <T> List<T> newList(final T... ts) {
        return Arrays.stream(ts).collect(Collectors.toList());
    }

    private static <T extends Comparable<T>> List<T> newSortedList(final T... ts) {
        return Arrays.stream(ts).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
