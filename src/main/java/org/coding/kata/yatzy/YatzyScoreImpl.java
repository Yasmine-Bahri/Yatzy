package org.coding.kata.yatzy;

import org.coding.kata.enumeration.YatzyCategory;
import org.coding.kata.utils.YatzyCalculator;

public class YatzyScoreImpl implements YatzyScore{

    @Override
    public int score(String categoryName, int... dices) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);

        // calculate the score
        int result = switch (category) {
            case CHANCE ->
                // chance sums the dice
                YatzyCalculator.chance(dices);
            case YATZY ->
                // score for yatzy if all dice are the same
                YatzyCalculator.yatzy(dices);
            case ONES, TWOS, THREES, FOURS, FIVES, SIXES ->
                // sum all the ONES, TWOS, THREES, FOURS, FIVES, SIXES
                YatzyCalculator.oneToSixesCategory(category, dices);
            case PAIR ->
                // score pair if two dice are the same
                YatzyCalculator.pair(dices);
            case TWO_PAIRS ->
                // score if there are two pairs
                YatzyCalculator.twoPair(dices);
            case THREE_OF_A_KIND, FOUR_OF_A_KIND ->
                // score if three dice are the same
                YatzyCalculator.threeOrFourOfKind(category, dices);
            case SMALL_STRAIGHT ->
                // score if dice contains 1,2,3,4,5
                YatzyCalculator.smallStraight(dices);
            case LARGE_STRAIGHT ->
                // score if dice contains 2,3,4,5,6
                YatzyCalculator.largeStraight(dices);
            case FULL_HOUSE ->
                // score if there is a pair as well as three of a kind
                YatzyCalculator.fullHouse(dices);
        };
        return result;
    }
}
