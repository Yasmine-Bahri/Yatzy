package org.coding.kata.yatzy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YatzyScoreImplTest {

    static YatzyScore yatzyScore;

    @BeforeAll
    public static void beforeAll() {
        yatzyScore = new YatzyScoreImpl();
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsChance() {
        //given
        int expected = 12;
        int[] dices = {4,2,1,4,1};
        String categoryName = "CHANCE";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsYatzy() {
        //given
        int expected = 50;
        int[] dices = {4,4,4,4,4};
        String categoryName = "YATZY";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsOnes() {
        //given
        int expected = 3;
        int[] dices = {2,1,1,4,1};
        String categoryName = "ONES";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsTwos() {
        //given
        int expected = 4;
        int[] dices = {2,1,2,4,1};
        String categoryName = "TWOS";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsThrees() {
        //given
        int expected = 9;
        int[] dices = {3,3,2,4,3};
        String categoryName = "THREES";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsFours() {
        //given
        int expected = 4;
        int[] dices = {3,3,2,4,3};
        String categoryName = "FOURS";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsFives() {
        //given
        int expected = 10;
        int[] dices = {5,5,2,4,3};
        String categoryName = "FIVES";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsSixes() {
        //given
        int expected = 6;
        int[] dices = {5,5,2,6,3};
        String categoryName = "SIXES";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsPair() {
        //given
        int expected = 10;
        int[] dices = {5,5,2,6,3};
        String categoryName = "PAIR";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsTwoPair() {
        //given
        int expected = 14;
        int[] dices = {5,5,2,6,2};
        String categoryName = "TWO_PAIRS";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsThreeOfKind() {
        //given
        int expected = 6;
        int[] dices = {5,2,2,6,2};
        String categoryName = "THREE_OF_A_KIND";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsFourOfKind() {
        //given
        int expected = 8;
        int[] dices = {2,2,2,6,2};
        String categoryName = "FOUR_OF_A_KIND";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsSmallStraight() {
        //given
        int expected = 15;
        int[] dices = {2,1,3,4,5};
        String categoryName = "SMALL_STRAIGHT";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsLargeStraight() {
        //given
        int expected = 20;
        int[] dices = {2,6,3,4,5};
        String categoryName = "LARGE_STRAIGHT";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    public void should_score_return_calculatedScoreOfRoll_when_categoryIsFullHouse() {
        //given
        int expected = 8;
        int[] dices = {1,2,1,2,2};
        String categoryName = "FULL_HOUSE";
        //when
        int result = yatzyScore.score(categoryName, dices);
        //then
        assertEquals(expected, result);
    }
}