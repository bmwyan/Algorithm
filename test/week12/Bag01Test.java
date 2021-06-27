package week12;

import org.junit.Test;

import static org.junit.Assert.*;

public class Bag01Test {
    Bag01 b = new Bag01();

    @Test
    public void knapsack() {
        assertEquals(8, b.knapsack(new int[]{5, 2, 3}, new int[]{3, 2, 1}, 5));
    }
}