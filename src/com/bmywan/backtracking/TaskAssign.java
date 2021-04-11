package com.bmywan.backtracking;


public class TaskAssign {

    private int res = Integer.MAX_VALUE;

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] personTime = new int[k];
        backjob(jobs, personTime, 0);


        return res;
    }

    private void backjob(int[] jobs, int[] personTime, int index) {

        if (index == jobs.length) {
            int maxTime = -1;
            for (int time : personTime) {
                maxTime = Math.max(maxTime, time);
            }
            res=Math.min(res,maxTime);
            return;
        }

        for(int i=0;i<personTime.length;i++){
            if(personTime[i]+jobs[index]>res){
                continue;
            }

            personTime[i]+=jobs[index];
            this.backjob(jobs,personTime,index+1);
            personTime[i]-=jobs[index];
            if(personTime[i]==0){
                break;
            }

        }

    }


}
