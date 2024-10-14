package org.coding.kata.utils;

import org.junit.jupiter.api.Test;

import static org.coding.kata.enumeration.YatzyCategory.*;
import static org.junit.jupiter.api.Assertions.*;

class YatzyCalculatorTest {

    @Test
    public void should_chance_return_scoresSumAllDice_when_categoryIsChance() {
        //given
        int expected = 15;
        int[] dices = {2,3,4,5,1};
        //when
        int result = YatzyCalculator.chance(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_yatzy_return_fiftyAsScore_when_categoryIsYatzyAndDicesAllSame() {
        //given
        int expected = 50;
        int[] dices = {4,4,4,4,4};
        //when
        int result = YatzyCalculator.yatzy(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_yatzy_return_zeroAsScore_when_categoryIsYatzyAndDicesAllNotSame() {
        //given
        int expected = 0;
        int[] dices = {4,4,1,4,4};
        //when
        int result = YatzyCalculator.yatzy(dices);
        //then
        assertEquals(expected, result);
    }


    @Test
    public void should_oneToSixesCategory_return_sumOfOnes_when_categoryIsOnes() {
        //given
        int expected = 4;
        int[] dices = {1,2,1,1,1};
        //when
        int result = YatzyCalculator.oneToSixesCategory(ONES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsOnesAndDicesNotContainOnes() {
        //given
        int expected = 0;
        int[] dices = {3,2,3,4,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(ONES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_sumOfOnes_when_categoryIsTwos() {
        //given
        int expected = 6;
        int[] dices = {1,2,2,6,2};
        //when
        int result = YatzyCalculator.oneToSixesCategory(TWOS,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsTwosAndDicesNotContainTwos() {
        //given
        int expected = 0;
        int[] dices = {3,6,1,4,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(TWOS,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_sumOfThrees_when_categoryIsThrees() {
        //given
        int expected = 6;
        int[] dices = {2,3,1,3,4};
        //when
        int result = YatzyCalculator.oneToSixesCategory(THREES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsThreesAndDicesNotContainThrees() {
        //given
        int expected = 0;
        int[] dices = {2,2,5,4,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(THREES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_sumOfFours_when_categoryIsFours() {
        //given
        int expected = 8;
        int[] dices = {4,2,1,4,1};
        //when
        int result = YatzyCalculator.oneToSixesCategory(FOURS,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsFoursAndDicesNotContainFours() {
        //given
        int expected = 0;
        int[] dices = {3,2,3,1,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(FOURS,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_sumOfFives_when_categoryIsFives() {
        //given
        int expected = 15;
        int[] dices = {5,2,5,1,5};
        //when
        int result = YatzyCalculator.oneToSixesCategory(FIVES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsFivesAndDicesNotContainFives() {
        //given
        int expected = 0;
        int[] dices = {3,2,3,4,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(FIVES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_sumOfSixes_when_categoryIsSixes() {
        //given
        int expected = 18;
        int[] dices = {1,6,1,6,6};
        //when
        int result = YatzyCalculator.oneToSixesCategory(SIXES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_oneToSixesCategory_return_zero_when_categoryIsSixesAndDicesNotContainSixes() {
        //given
        int expected = 0;
        int[] dices = {3,2,3,4,5};
        //when
        int result = YatzyCalculator.oneToSixesCategory(SIXES,dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_pair_return_scoreSum_when_categoryIsPair() {
        //given
        int expected = 12;
        int[] dices = {5,3,6,6,5};
        //when
        int result = YatzyCalculator.pair(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_twoPair_return_scoreSum_when_categoryIsTwoPair() {
        //given
        int expected = 16;
        int[] dices = {3,3,5,5,5};
        //when
        int result = YatzyCalculator.twoPair(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_threeOrFourOfKind_return_scoreSum_when_categoryIsThreeOfKind() {
        //given
        int expected = 15;
        int[] dices = {5,3,5,2,5};
        //when
        int result = YatzyCalculator.threeOrFourOfKind(THREE_OF_A_KIND, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_threeOrFourOfKind_return_zeroAsScoreSum_when_categoryIsThreeOfKind() {
        //given
        int expected = 0;
        int[] dices = {6,3,5,2,5};
        //when
        int result = YatzyCalculator.threeOrFourOfKind(THREE_OF_A_KIND, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_threeOrFourOfKind_return_scoreSum_when_categoryIsFourOfKind() {
        //given
        int expected = 20;
        int[] dices = {5,5,5,2,5};
        //when
        int result = YatzyCalculator.threeOrFourOfKind(FOUR_OF_A_KIND, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_smallStraight_return_scoreSum_when_allDicesAreSmallStraight() {
        //given
        int expected = 15;
        int[] dices = {1,2,3,4,5};
        //when
        int result = YatzyCalculator.smallStraight(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_smallStraight_return_zeroAsScoreSum_when_allDicesAreNotSmallStraight() {
        //given
        int expected = 0;
        int[] dices = {1,6,3,4,5};
        //when
        int result = YatzyCalculator.smallStraight(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_largeStraight_return_scoreSum_when_allDicesAreLargeStraight() {
        //given
        int expected = 20;
        int[] dices = {2,3,4,5,6};
        //when
        int result = YatzyCalculator.largeStraight(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_largeStraight_return_zeroAsScoreSum_when_allDicesAreNotLargeStraight() {
        //given
        int expected = 0;
        int[] dices = {2,3,4,5,2};
        //when
        int result = YatzyCalculator.largeStraight(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_fullHouse_return_scoreSum_when_allDicesAreFullHouse() {
        //given
        int expected = 18;
        int[] dices = {6,2,2,2,6};
        //when
        int result = YatzyCalculator.fullHouse(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_fullHouse_return_zeroAsScoreSum_when_allDicesAreFullHouse() {
        //given
        int expected = 0;
        int[] dices = {2,3,4,5,6};
        //when
        int result = YatzyCalculator.fullHouse(dices);
        //then
        assertEquals(expected, result);
    }

}