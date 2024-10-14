package org.coding.kata.utils;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> tabToList(int[] dices) {
        List<Integer> list = new ArrayList<>();
        for (int num : dices) {
            list.add(num);
        }
        return list;
    }

    public static int sum(List<Integer> diceList) {
        return diceList.stream().mapToInt(Integer::intValue).sum();
    }
}
