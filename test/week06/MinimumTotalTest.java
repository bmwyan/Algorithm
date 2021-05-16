package week06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumTotalTest {
    MinimumTotal min = new MinimumTotal();

    @Test
    public void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(new Integer[]{2});
        List<Integer> list2 = Arrays.asList(new Integer[]{3, 4});
        List<Integer> list3 = Arrays.asList(new Integer[]{6, 5, 7});
        List<Integer> list4 = Arrays.asList(new Integer[]{4, 1, 8, 3});
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        assertEquals(11, min.minimumTotal(triangle));
    }
}