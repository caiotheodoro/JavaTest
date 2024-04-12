package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

public class AddTest {

    @Test
    void testNullInputs() {
        Add add = new Add();
        List<Integer> nullList = null;
        assertNull(add.add(nullList, nullList));
    }

    @Test
    void testNullLeftInput() {
        Add add = new Add();
        List<Integer> nullList = null;
        List<Integer> emptyList = new ArrayList<>();
        assertNull(add.add(nullList, emptyList));
    }

    @Test
    void testNullRightInput() {
        Add add = new Add();
        List<Integer> nullList = null;
        List<Integer> emptyList = new ArrayList<>();
        assertNull(add.add(emptyList, nullList));
    }

    @Test
    void testEmptyInputs() {
        Add add = new Add();
        List<Integer> emptyList = new ArrayList<>();
        assertEquals(emptyList, add.add(emptyList, emptyList));
    }

    @Test
    void testEmptyLeftInput() {
        Add add = new Add();
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(UnsupportedOperationException.class, () -> add.add(emptyList, List.of(1, 2, 3)));
    }

    @Test
    void testEmptyRightInput() {
        Add add = new Add();
        List<Integer> emptyList = new ArrayList<>();
        assertThrows(UnsupportedOperationException.class, () -> add.add(List.of(1, 2, 3), emptyList));
    }

    @Test
    void testNegativeDigitInput() {
        Add add = new Add();
        List<Integer> negativeDigitList = List.of(1, -2);
        assertThrows(UnsupportedOperationException.class, () -> add.add(negativeDigitList, List.of(1)));
    }

    @Test
    void testDigitGreaterThanNineInput() {
        Add add = new Add();
        List<Integer> digitGreaterThanNineList = List.of(1, 10);
        assertThrows(UnsupportedOperationException.class, () -> add.add(digitGreaterThanNineList, List.of(1)));
    }

    @Test
    void testDigitLessThanZeroInput() {
        Add add = new Add();
        List<Integer> digitLessThanZeroList = List.of(-1, 2);
        assertThrows(UnsupportedOperationException.class, () -> add.add(digitLessThanZeroList, List.of(1)));
    }

    @Test
    void testValidPartitions() {
        Add add = new Add();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            List<Integer> left = randList(random);
            List<Integer> right = randList(random);
            List<Integer> expectedResult = expResult(left, right);
            assertEquals(expectedResult, add.add(left, right));
       }
    }

    private List<Integer> randList(Random random) {
        int min = 1;
        int max = 9;
        int size = random.nextInt(10) + 1;
        List<Integer> list = new ArrayList<>(); 
        for (int i = 0; i < size; i++) { 
            list.add(random.nextInt(max - min + 1) + min); 
        }
        return list;
    }

    private List<Integer> expResult(List<Integer> left, List<Integer> right) {
            Collections.reverse(left);
            Collections.reverse(right);  
            LinkedList<Integer> result = new LinkedList<>();
            int carry = 0;
            for (int i = 0; i < Math.max(left.size(), right.size()); i++) {
                int leftDigit = left.size() > i ? left.get(i) : 0;
                int rightDigit = right.size() > i ? right.get(i) : 0;
                int sum = leftDigit + rightDigit + carry;
                result.addFirst(sum % 10);
                carry = sum / 10;
            }
        
            return result;
    }
}