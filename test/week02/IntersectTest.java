package week02;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectTest {
    Intersect in = new Intersect();

    @Test
    public void intersect() {
       int[] act=in.intersect(new int[]{4,7,9,7,6,7},new int[]{5,0,0,6,1,6,2,2,4});
       assertArrayEquals(new int[]{4,6},act);
    }
}