package com.bmywan.recursion;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskAssignTest {
    TaskAssign task = new TaskAssign();

    @Test
    public void minimumTimeRequired() {

        Assert.assertEquals(3,task.minimumTimeRequired(new int[]{3,2,3},3));

    }
}