class Solution {
    public int leastInterval(char[] tasksLetter, int n) {
        int tasksFreq[] = new int[26];
        int time[] = new int[26];

        for (char taskLetter : tasksLetter) {
            tasksFreq[taskLetter - 'A']++;
        }

        int interval = 1;

        boolean allSolved = false;

        while (!allSolved) {
            allSolved = true;
            int minIntervalReq = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < 26; i++) {
                if (tasksFreq[i] > 0) {
                    allSolved = false;

                    if (time[i] == 0 || interval - time[i] >= n + 1) {
                        if (minIntervalReq > 0 || tasksFreq[i] > tasksFreq[index]) {
                            minIntervalReq = 0;
                            index = i;
                        }
                    } else {
                        int req = n - (interval - time[i]) + 1;
                        if (req < minIntervalReq) {
                            minIntervalReq = req;
                            index = i;
                        }
                    }
                }
            }

            if (allSolved)
                return interval - 1;

            interval += minIntervalReq;
            time[index] = interval;
            tasksFreq[index]--;
            interval++;
        }

        return 0;

    }
}