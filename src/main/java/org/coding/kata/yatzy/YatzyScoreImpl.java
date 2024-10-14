package org.coding.kata.yatzy;

import org.coding.kata.enumeration.YatzyCategory;
import org.coding.kata.utils.YatzyCalculator;

public class YatzyScoreImpl implements YatzyScore{

    @Override
    public int score(String categoryName, int... dices) {
        YatzyCategory category = YatzyCategory.valueOf(categoryName);

        return switch (category) {
            case CHANCE ->
                YatzyCalculator.chance(dices);
            case YATZY ->
                YatzyCalculator.yatzy(dices);
            case ONES, TWOS, THREES, FOURS, FIVES, SIXES ->
                YatzyCalculator.oneToSixesCategory(category, dices);
            case PAIR ->
                YatzyCalculator.pair(dices);
            case TWO_PAIRS ->
                YatzyCalculator.twoPair(dices);
            case THREE_OF_A_KIND, FOUR_OF_A_KIND ->
                YatzyCalculator.threeOrFourOfKind(category, dices);
            case SMALL_STRAIGHT ->
                YatzyCalculator.smallStraight(dices);
            case LARGE_STRAIGHT ->
                YatzyCalculator.largeStraight(dices);
            case FULL_HOUSE ->
                YatzyCalculator.fullHouse(dices);
        };
    }
}
