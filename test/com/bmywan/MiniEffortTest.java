package com.bmywan;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MiniEffortTest {
    MiniEffort m =new MiniEffort();


    @Test
    public void minimumEffort() {
        int[][]task = new int[][]{new int[]{1,2},new int[]{2,4},new int[]{4,8}};

        Assert.assertEquals(8,m.minimumEffort(task));
    }

    @Test
    public void minimumEffort2() {
        int[][]task = new int[][]{new int[]{1,3},new int[]{2,4},new int[]{10,11},new int[]{10,12},new int[]{8,9}};

        Assert.assertEquals(32,m.minimumEffort(task));
    }
}