package org.coding.kata.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void should_tabToList_return_list_when_inputTabIsNotEmpty() {
        //given
        List<Integer> expected = Arrays.asList(4,2,1,4,1);
        int[] dices = {4,2,1,4,1};
        //when
        List<Integer> result = Util.tabToList(dices);
        //then
        assertEquals(dices.length, result.size());
        assertEquals(expected, result);
    }

    @Test
    void should_sum_return_sumOfDices_when_dicesIsValid() {
        //given
        int expected = 7;
        List<Integer> dices = Arrays.asList(1,2,1,2,1);
        //when
        int result = Util.sum(dices);
        //then
        assertEquals(expected, result);
    }

    @Test
    void should_sum_return_sumOfSetDices_when_dicesIsValid() {
        //given
        int expected = 15;
        Set<Integer> dices = Set.of(1,2,3,4,5);
        //when
        int result = Util.sum(dices);
        //then
        assertEquals(expected, result);
    }
}