package com.bmywan.recursion;

import com.bmywan.backtracking.TaskAssign;
import org.junit.Assert;
import org.junit.Test;

public class TaskAssignTest {
    TaskAssign task = new TaskAssign();

    @Test
    public void minimumTimeRequired() {

        Assert.assertEquals(3,task.minimumTimeRequired(new int[]{3,2,3},3));

    }
}