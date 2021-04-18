package week03;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermuteTest {
    Permute p = new Permute();

    @Test
    public void permute() {
        p.permute(new int[]{1, 2});
    }
}