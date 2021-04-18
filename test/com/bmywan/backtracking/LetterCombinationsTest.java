package com.bmywan.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsTest {
    LetterCombinations l = new LetterCombinations();

    @Test
    public void letterCombinations() {

        List<String> act = l.letterCombinations("23");

        List<String> expect = Arrays.asList(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"});
    }
}