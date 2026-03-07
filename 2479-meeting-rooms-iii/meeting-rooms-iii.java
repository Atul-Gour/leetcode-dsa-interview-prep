class Solution {
    public int mostBooked(int m, int[][] meetings) {

        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        long[] freq = new long[m];

        PriorityQueue<Integer> free =
                new PriorityQueue<>();

        PriorityQueue<long[]> busy =
                new PriorityQueue<>((a,b)->{
                    if( a[0] != b[0] ) return Long.compare(a[0],b[0]);
                    else return Long.compare(a[1],b[1]);
                });

        for(int i=0;i<m;i++)
            free.offer(i);

        for(int[] meet : meetings){

            long start = meet[0];
            long end = meet[1];
            long duration = end - start;

            while(!busy.isEmpty() && busy.peek()[0] <= start){
                free.offer((int)busy.poll()[1]);
            }

            if(!free.isEmpty()){

                int room = free.poll();
                freq[room]++;
                busy.offer(new long[]{end, room});

            }else{

                long[] room = busy.poll();
                long newEnd = room[0] + duration;

                freq[(int)room[1]]++;

                busy.offer(new long[]{newEnd, room[1]});
            }
        }

        int ans = 0;

        for(int i=1;i<m;i++)
            if(freq[i] > freq[ans])
                ans = i;

        return ans;
    }
}