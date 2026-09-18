package org.easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckIfNAndItsDoubleExistTest {
    CheckIfNAndItsDoubleExist checkIfNAndItsDoubleExist =  new CheckIfNAndItsDoubleExist();

    @Test
    public void test1() {
        int[] arr = {10,2,5,3};
        assertEquals(true, checkIfNAndItsDoubleExist.checkIfExist(arr));
    }

    @Test
    public void test2(){
        int[] arr = {3,1,7,11};
        assertEquals(false, checkIfNAndItsDoubleExist.checkIfExist(arr));
    }

    @Test
    public void test3() {
        int[] arr = {0,-2,2};
        assertEquals(false, checkIfNAndItsDoubleExist.checkIfExist(arr));
    }

    @Test
    public void test4() {
       int[] arr = {-10,12,-20,-8,15};
        assertEquals(true, checkIfNAndItsDoubleExist.checkIfExist(arr));
    }
}
