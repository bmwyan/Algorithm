package week01;

import org.junit.Assert;
import org.junit.Test;
import week01.PlusOne;

import static org.junit.Assert.*;

public class PlusOneTest {

    PlusOne p  = new PlusOne();
    @Test
    public void plusOne() {
        Assert.assertArrayEquals(new int[]{1,2,4},p.plusOne(new int[]{1,2,3}));
    }
}