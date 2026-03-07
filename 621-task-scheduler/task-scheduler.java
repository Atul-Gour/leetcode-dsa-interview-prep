import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int freq[] = new int[26];

        for(char c : tasks)
            freq[c-'A']++;

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq)
            if(f > 0)
                maxHeap.offer(f);

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while(!maxHeap.isEmpty() || !cooldown.isEmpty()){

            time++;

            if(!maxHeap.isEmpty()){
                int f = maxHeap.poll() - 1;

                if(f > 0)
                    cooldown.offer(new int[]{f, time + n});
            }

            if(!cooldown.isEmpty() && cooldown.peek()[1] == time){
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;
    }
}