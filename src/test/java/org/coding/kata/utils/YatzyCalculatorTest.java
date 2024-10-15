package org.coding.kata.utils;

import org.coding.kata.enumeration.YatzyCategory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.coding.kata.enumeration.YatzyCategory.FIVES;
import static org.coding.kata.enumeration.YatzyCategory.FOURS;
import static org.coding.kata.enumeration.YatzyCategory.FOUR_OF_A_KIND;
import static org.coding.kata.enumeration.YatzyCategory.ONES;
import static org.coding.kata.enumeration.YatzyCategory.SIXES;
import static org.coding.kata.enumeration.YatzyCategory.THREES;
import static org.coding.kata.enumeration.YatzyCategory.THREE_OF_A_KIND;
import static org.coding.kata.enumeration.YatzyCategory.TWOS;
import static org.junit.jupiter.api.Assertions.assertEquals;


class YatzyCalculatorTest {

    static Stream<Arguments> chanceDataProvider() {
        return Stream.of(
                Arguments.of(15, new int[]{2, 3, 4, 5, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("chanceDataProvider")
    public void should_chance_return_scoresSumAllDice_when_categoryIsChance(int expected, int[] dices) {
        int result = YatzyCalculator.chance(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> yatzyDataProvider() {
        return Stream.of(
                Arguments.of(50, new int[]{4, 4, 4, 4, 4}),
                Arguments.of(0, new int[]{4, 4, 1, 4, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("yatzyDataProvider")
    public void should_yatzy_return_score_when_dicesAllSame(int expected, int[] dices) {
        int result = YatzyCalculator.yatzy(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> oneToSixesDataProvider() {
        return Stream.of(
                Arguments.of(4, new int[]{1, 2, 1, 1, 1}, ONES),
                Arguments.of(0, new int[]{3, 2, 3, 4, 6}, ONES),
                Arguments.of(6, new int[]{1, 2, 2, 6, 2}, TWOS),
                Arguments.of(0, new int[]{3, 6, 1, 4, 6}, TWOS),
                Arguments.of(6, new int[]{2, 3, 1, 3, 4}, THREES),
                Arguments.of(0, new int[]{2, 2, 5, 4, 6}, THREES),
                Arguments.of(8, new int[]{4, 2, 1, 4, 1}, FOURS),
                Arguments.of(0, new int[]{3, 2, 3, 1, 6}, FOURS),
                Arguments.of(15, new int[]{5, 2, 5, 1, 5}, FIVES),
                Arguments.of(0, new int[]{3, 2, 3, 4, 6}, FIVES),
                Arguments.of(18, new int[]{1, 6, 1, 6, 6}, SIXES),
                Arguments.of(0, new int[]{3, 2, 3, 4, 5}, SIXES)
        );
    }

    @ParameterizedTest
    @MethodSource("oneToSixesDataProvider")
    public void should_oneToSixesCategory_return_sum_when_categoryIsOneToSixes(int expected, int[] dices, YatzyCategory category) {
        int result = YatzyCalculator.oneToSixesCategory(category, dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> pairDataProvider() {
        return Stream.of(
                Arguments.of(4, new int[]{2, 3, 2, 6, 5}),
                Arguments.of(12, new int[]{5, 3, 6, 6, 5}),
                Arguments.of(0, new int[]{5, 3, 6, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("pairDataProvider")
    public void should_pair_return_scoreSum_when_categoryIsPair(int expected, int[] dices) {
        int result = YatzyCalculator.pair(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> twoPairDataProvider() {
        return Stream.of(
                Arguments.of(16, new int[]{3, 3, 5, 5, 5}),
                Arguments.of(16, new int[]{3, 3, 5, 2, 5}),
                Arguments.of(0, new int[]{3, 3, 1, 2, 5}),
                Arguments.of(0, new int[]{3, 1, 5, 6, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("twoPairDataProvider")
    public void should_twoPair_return_scoreSum_when_categoryIsTwoPair(int expected, int[] dices) {
        int result = YatzyCalculator.twoPair(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> threeOrFourOfKindDataProvider() {
        return Stream.of(
                Arguments.of(15, new int[]{5, 3, 5, 2, 5}, THREE_OF_A_KIND),
                Arguments.of(0, new int[]{6, 3, 5, 2, 5}, THREE_OF_A_KIND),
                Arguments.of(0, new int[]{6, 5, 5, 2, 5}, FOUR_OF_A_KIND),
                Arguments.of(20, new int[]{5, 5, 5, 2, 5}, FOUR_OF_A_KIND)
        );
    }

    @ParameterizedTest
    @MethodSource("threeOrFourOfKindDataProvider")
    void should_threeOrFourOfKind_return_scoreSum_when_categoryIsThreeOrFourOfKind(int expected, int[] dices, YatzyCategory category) {
        int result = YatzyCalculator.threeOrFourOfKind(category, dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> smallStraightDataProvider() {
        return Stream.of(
                Arguments.of(15, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(0, new int[]{1, 6, 3, 4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("smallStraightDataProvider")
    void should_smallStraight_return_scoreSum_when_allDicesAreSmallStraight(int expected, int[] dices) {
        int result = YatzyCalculator.smallStraight(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> largeStraightDataProvider() {
        return Stream.of(
                Arguments.of(20, new int[]{2, 3, 4, 5, 6}),
                Arguments.of(0, new int[]{2, 3, 4, 5, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("largeStraightDataProvider")
    void should_largeStraight_return_scoreSum_when_allDicesAreLargeStraight(int expected, int[] dices) {
        int result = YatzyCalculator.largeStraight(dices);
        assertEquals(expected, result);
    }

    static Stream<Arguments> fullHouseDataProvider() {
        return Stream.of(
                Arguments.of(18, new int[]{6, 2, 2, 2, 6}),
                Arguments.of(14, new int[]{1, 4, 1, 4, 4}),
                Arguments.of(0, new int[]{2, 3, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("fullHouseDataProvider")
    void should_fullHouse_return_scoreSum_when_dicesAreFullHouse(int expected, int[] dices) {
        int result = YatzyCalculator.fullHouse(dices);
        assertEquals(expected, result);
    }
}
