package org.coding.kata.yatzy;

public interface YatzyScore {

    /**
     * score a GIVEN roll in a GIVEN category
     * @param categoryName the Yatzy Category name:  CHANCE, YATZY,
     *     ONES, TWOS, THREES, FOURS, FIVES, SIXES,
     *     PAIR, THREE_OF_A_KIND, FOUR_OF_A_KIND,
     *     SMALL_STRAIGHT, LARGE_STRAIGHT,
     *     TWO_PAIRS, FULL_HOUSE
     * @param dices the list of dice values
     * @return the calculated score
     */
    int score(String categoryName, int... dices);
}
