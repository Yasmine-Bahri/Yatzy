package org.coding.kata.enumeration;

public enum YatzyCategory {
    CHANCE, YATZY,
    ONES(1), TWOS(2), THREES(3), FOURS(4), FIVES(5), SIXES(6),
    PAIR, THREE_OF_A_KIND(3), FOUR_OF_A_KIND(4),
    SMALL_STRAIGHT, LARGE_STRAIGHT,
    TWO_PAIRS, FULL_HOUSE;

    private int number;

    YatzyCategory(int number) {
        this.number = number;
    }

    YatzyCategory() {
    }

    public int getNumber() {
        return number;
    }
}
