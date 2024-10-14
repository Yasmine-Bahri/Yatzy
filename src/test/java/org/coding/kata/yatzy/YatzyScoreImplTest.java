package org.coding.kata.yatzy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YatzyScoreImplTest {

    static YatzyScore yatzyScore;

    @BeforeAll
    public static void beforeAll() {
        yatzyScore = new YatzyScoreImpl();
    }

    static Stream<Arguments> scoreTestProvider() {
        return Stream.of(
                Arguments.of(12, new int[]{4, 2, 1, 4, 1}, "CHANCE"),
                Arguments.of(50, new int[]{4, 4, 4, 4, 4}, "YATZY"),
                Arguments.of(3, new int[]{2, 1, 1, 4, 1}, "ONES"),
                Arguments.of(4, new int[]{2, 1, 2, 4, 1}, "TWOS"),
                Arguments.of(9, new int[]{3, 3, 2, 4, 3}, "THREES"),
                Arguments.of(4, new int[]{3, 3, 2, 4, 3}, "FOURS"),
                Arguments.of(10, new int[]{5, 5, 2, 4, 3}, "FIVES"),
                Arguments.of(6, new int[]{5, 5, 2, 6, 3}, "SIXES"),
                Arguments.of(10, new int[]{5, 5, 2, 6, 3}, "PAIR"),
                Arguments.of(14, new int[]{5, 5, 2, 6, 2}, "TWO_PAIRS"),
                Arguments.of(6, new int[]{5, 2, 2, 6, 2}, "THREE_OF_A_KIND"),
                Arguments.of(8, new int[]{2, 2, 2, 6, 2}, "FOUR_OF_A_KIND"),
                Arguments.of(15, new int[]{2, 1, 3, 4, 5}, "SMALL_STRAIGHT"),
                Arguments.of(20, new int[]{2, 6, 3, 4, 5}, "LARGE_STRAIGHT"),
                Arguments.of(8, new int[]{1, 2, 1, 2, 2}, "FULL_HOUSE")
        );
    }

    @ParameterizedTest
    @MethodSource("scoreTestProvider")
    void should_score_return_calculatedScoreOfRoll(int expected, int[] dices, String categoryName) {
        // when
        int result = yatzyScore.score(categoryName, dices);
        // then
        assertEquals(expected, result);
    }
}