package org.coding.kata.utils;

import org.coding.kata.enumeration.YatzyCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.coding.kata.enumeration.YatzyCategory.FULL_HOUSE;
import static org.coding.kata.enumeration.YatzyCategory.LARGE_STRAIGHT;
import static org.coding.kata.enumeration.YatzyCategory.SMALL_STRAIGHT;
import static org.coding.kata.utils.Util.tabToList;

public class YatzyCalculator {

    /**
     * chance sums the dice
     * @param dices list of dice values
     * @return the sum of all the dice values
     */
    public static int chance(int... dices) {
        List<Integer> dicesList = tabToList(dices);
        return Util.sum(dicesList);
    }

    /**
     * score for yatzy if all dice are the same
     * @param dices list of dice values
     * @return the sum of all dices if all the same
     */
    public static int yatzy(int... dices) {
        List<Integer> dicesList = tabToList(dices);
        Map<Integer, Long> frequencyMap = dicesList.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        boolean isYatzy = frequencyMap.values().stream().anyMatch(count -> count == 5);
        return isYatzy ? 50 : 0;
    }

    /**
     * sum all the ONES, TWOS, THREES, FOURS, FIVES, SIXES
     * @param category the category type: ONES, TWOS, THREES, FOURS, FIVES, SIXES
     * @param dices list of dice values
     * @return the sum of all dices
     */
    public static int oneToSixesCategory(YatzyCategory category, int... dices) {
        return IntStream.range(0, dices.length).filter(i -> dices[i] == category.getNumber())
            .map(i -> dices[i])
            .sum();
    }

    /**
     * score pair if two dice are the same
     * @param dices list of dice values
     * @return the sum of two equal dices
     */
    public static int pair(int... dices) {
        List<Integer> list = tabToList(dices);
        Integer pair = list.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() % 2 == 0 || entry.getValue() == 3)
            .map(Map.Entry::getKey)
            .max(Integer::compareTo)
            .orElse(0);
        return pair * 2;
    }

    /**
     * score if there are two pairs
     * @param dices list of dice values
     * @return the sum of the two pairs
     */
    public static int twoPair(int... dices) {
        List<Integer> list = tabToList(dices);
        return list.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(entry -> entry.getValue() != 3 ? entry.getKey() * entry.getValue() : entry.getKey()* 2)
            .mapToInt(Long::intValue)
            .sum();
    }

    /**
     * score if three dice are the same
     * @param category the category type: THREE_OF_A_KIND or FOUR_OF_A_KIND
     * @param dices list of dice values
     * @return the sum of the three or four dice with the same number
     */
    public static int threeOrFourOfKind(YatzyCategory category, int... dices) {
        return calculateTwoThreeFourOfKind(category, category.getNumber(), dices);
    }

    /**
     * score if dice contains 1,2,3,4,5
     * @param dices list of dice values
     * @return the sum of all the dice
     */
    public static int smallStraight(int... dices)
    {
        return calculateSmallLargeStraight(SMALL_STRAIGHT, dices);
    }

    /**
     * score if dice contains 2,3,4,5,6
     * @param dices list of dice values
     * @return the sum of all the dice
     */
    public static int largeStraight(int... dices)
    {
        return calculateSmallLargeStraight(LARGE_STRAIGHT, dices);
    }

    /**
     *  score if there is a pair as well as three of a kind
     * @param dices list of dice values
     * @return the sum of all the dice
     */
    public static int fullHouse(int... dices) {
        int twoOfKind = calculateTwoThreeFourOfKind(FULL_HOUSE, 2, dices);
        int threeOfKind = calculateTwoThreeFourOfKind(FULL_HOUSE, 3, dices);
        return twoOfKind + threeOfKind;
    }

    private static int calculateTwoThreeFourOfKind(YatzyCategory category, int categoryNumb, int... dices) {
        List<Integer> diceList = tabToList(dices);
        return diceList.stream()
            .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
            .entrySet().stream()
            .filter(entry -> category == FULL_HOUSE ? entry.getValue() == categoryNumb : entry.getValue() >= categoryNumb)
            .map(entry -> entry.getKey() * categoryNumb)
            .findFirst()
            .orElse(0);
    }

    private static int calculateSmallLargeStraight(YatzyCategory category, int... dices) {
        Set<Integer> diceSet = new HashSet<>(tabToList(dices));
        Set<Integer> requiredValues = category == SMALL_STRAIGHT
                ? Set.of(1, 2, 3, 4, 5)
                : Set.of(2, 3, 4, 5, 6);

        return diceSet.containsAll(requiredValues) ? Util.sum(diceSet) : 0;
    }

}



