package zniuyang.others;

import java.util.*;

/**
 * @author : admin
 * @version V1.0
 * @Project: leecode
 * @Package zniuyang.others
 * @Description: leecode1834 单线程 CPU
 * @date Date : 2021年05月05日 23:24
 */
public class GetTaskOrder {

    class Task {
        private int index;
        private int enqueueTime;
        private int processingTime;

        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }


    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int index = 0;
        List<Task> taskList = new ArrayList<>();
        for (int[] row : tasks) {
            Task task = new Task(index, row[0], row[1]);
            taskList.add(task);
            index++;
        }

        //按入队时间排序
        Collections.sort(taskList, (t1, t2) -> {
            return t1.enqueueTime - t2.enqueueTime;
        });

        PriorityQueue<Task> queue = new PriorityQueue<>((t1, t2) -> {
            if (t1.processingTime == t2.processingTime) {
                return t1.index - t2.index;
            } else {
                return t1.processingTime - t2.processingTime;
            }
        });

        int now = 0;
        int[] res = new int[n];
        int p = 0;
        int i = 0;
        while (i < n) {
            while (i < n && taskList.get(i).enqueueTime <= now) {
                queue.offer(taskList.get(i));
                i++;
            }

            //队列空闲
            if (queue.isEmpty()) {
                now = taskList.get(i).enqueueTime;
                while (i < n && taskList.get(i).enqueueTime <= now) {
                    queue.offer(taskList.get(i));
                    i++;
                }
            }

            Task task = queue.poll();
            res[p++] = task.index;
            now += task.processingTime;

        }

        while (!queue.isEmpty()) {
            res[p++] = queue.poll().index;
        }
        return res;
    }

    public int[] getOrder2(int[][] tasks) {
        int n = tasks.length;
        List<Integer> idx = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idx.add(i);
        }
        //依据任务入队时间
        idx.sort(Comparator.comparingInt(a -> tasks[a][0]));
        //int[]{processtime,index}
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int[] res = new int[n];
        int now = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                int index = idx.get(i);
                now = Math.max(now, tasks[index][0]);
            }
            while (k < n && now >= tasks[idx.get(k)][0]) {
                int index = idx.get(k);
                queue.offer(new int[]{tasks[index][1], index});
                k++;
            }
            int[] t = queue.poll();
            now += t[0];
            res[i] = t[1];
        }

        return res;
    }


}
