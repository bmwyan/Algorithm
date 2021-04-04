package com.bmywan;

import org.junit.Test;

import static org.junit.Assert.*;

public class Move0Test {

    Move0 m = new Move0();

    @Test
    public void moveZeroes() {
        m.moveZeroes(new int[]{1});
    }

    @Test
    public void moveZeroes2() {
        m.moveZeroes2(new int[]{0,1,0,3,12});
    }
}