package com.bmywan;

import java.util.PriorityQueue;

public class MiniEffort {
    class Task {
        int costEngine;
        int startEngine;

        public Task(int costEngine, int startEngine) {
            this.costEngine = costEngine;
            this.startEngine = startEngine;
        }
    }

    public int minimumEffort(int[][] tasks) {
        int sum = 0;
        PriorityQueue<Task> queue = new PriorityQueue<>((o1, o2) -> ((o2.startEngine - o2.costEngine) - (o1.startEngine - o1.costEngine)));

        for (int i = 0; i < tasks.length; i++) {
            Task task = new Task(tasks[i][0], tasks[i][1]);
            queue.add(task);
        }
        int costSum = 0;
        while (!queue.isEmpty()) {
            Task task = queue.poll();
            int gap = task.startEngine-(sum-costSum);
            if(gap>0)
            {
                sum+=gap;
            }
            costSum+=task.costEngine;

        }
        return sum;
    }
}
