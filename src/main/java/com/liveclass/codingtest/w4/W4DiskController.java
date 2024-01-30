package com.liveclass.codingtest.w4;

import java.util.*;

public class W4DiskController {

    public static void main(String[] args) {
        int result = 0;
//        result = solution(new int[][]{{0,3}, {2,4}, {1,40}, {6,5}, {1,9}, {2,6}});
//        System.out.println(result);
//        result = solution(new int[][]{{0, 3}, {2, 5}, {4, 2}});
//        System.out.println(result);
        result = solution(new int[][]{{1,4},{7,9},{1000,3}});
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        int n = jobs.length;
        int currTime = 0;
        int avgIndex = 0;
        int jobIndex = 0;
        int[] avgDuration = new int[n];

        while (avgIndex < n) {
            while (jobIndex < n && jobs[jobIndex][0] <= currTime) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }
/*
            for (int[] q : pq)
                System.out.println(Arrays.toString(q));
*/

            if (!pq.isEmpty()) {
                int[] q = pq.poll();
                currTime += q[1]; //작업 끝난 시간 저장
                avgDuration[avgIndex++] = currTime - q[0]; //작업의 소요시간 저장
            } else {
                currTime = jobs[jobIndex][0];
            }
        }

        answer = (int) Math.floor(Arrays.stream(avgDuration).sum() / n);
        return answer;
    }
}
