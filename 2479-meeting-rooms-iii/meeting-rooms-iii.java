class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int rooms[] = new int[n];

        long arr[] = new long[n];

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        for (int meeting[] : meetings) {

            int avRoom = 0;
            long minTiming = arr[0];
            

            for( int i = 0 ; i < n ; i++ ){
                if(arr[i] <= meeting[0]){
                    avRoom = i;
                    break;
                }else{
                    if( arr[i] < minTiming ){
                        avRoom = i;
                        minTiming = Math.min( minTiming , arr[i] );
                    }
                }
            }

            rooms[avRoom]++;

            if ( arr[avRoom] <= meeting[0]) {
                arr[avRoom] = meeting[1];
            } else
                arr[avRoom] += (meeting[1] - meeting[0]);

        }

        int ans = 0;
        int maxMeeting = rooms[0];

        for (int i = 1; i < n; i++) {
            if (rooms[i] > maxMeeting) {
                ans = i;
                maxMeeting = Math.max(maxMeeting, rooms[i]);
            }
        }

        return ans;
    }
}