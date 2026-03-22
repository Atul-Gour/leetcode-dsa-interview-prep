import java.util.*;

class Solution {

    private boolean checkMonotone(int num) {
        if (num < 10) return true;
        List<Integer> digitList = new ArrayList<>();
        while (num > 0) { digitList.add(num % 10); num /= 10; }
        Collections.reverse(digitList);
        boolean rising = true, falling = true;
        for (int i = 1; i < digitList.size(); i++) {
            if (!(digitList.get(i) > digitList.get(i - 1))) rising = false;
            if (!(digitList.get(i) < digitList.get(i - 1))) falling = false;
        }
        return rising || falling;
    }

    private long[] solve(int idx, boolean bound, boolean begun, int last,
                         boolean canRise, boolean canFall, int total,
                         int[] numDigits, int len,
                         HashMap<Integer, long[]> cache) {

        if (idx == len) {
            long[] result = new long[4];
            if (!begun) return result;
            boolean isGood = canRise || canFall;
            boolean sumOk  = checkMonotone(total);
            result[(isGood ? 2 : 0) + (sumOk ? 1 : 0)] = 1;
            return result;
        }

        if (!bound) {
            int stateKey = (idx   << 15)
                    | ((begun    ? 1 : 0) << 14)
                    | (last      << 10)
                    | ((canRise  ? 1 : 0) << 9)
                    | ((canFall  ? 1 : 0) << 8)
                    | total;

            long[] hit = cache.get(stateKey);
            if (hit != null) return hit;

            long[] bucket = new long[4];

            for (int dig = 0; dig <= 9; dig++) {
                boolean nextBegun = begun || dig != 0;
                int     nextLast  = last;
                boolean nextRise  = canRise, nextFall = canFall;
                int     nextTotal = total;

                if (!nextBegun) {
                    nextLast = 10;
                } else if (!begun) {
                    nextLast  = dig;
                    nextRise  = true;
                    nextFall  = true;
                    nextTotal = total + dig;
                } else {
                    nextRise  = canRise && dig > last;
                    nextFall  = canFall && dig < last;
                    nextLast  = dig;
                    nextTotal = total + dig;
                }

                long[] child = solve(idx + 1, false, nextBegun, nextLast,
                                     nextRise, nextFall, nextTotal, numDigits, len, cache);
                for (int k = 0; k < 4; k++) bucket[k] += child[k];
            }

            cache.put(stateKey, bucket);
            return bucket;
        }

        long[] bucket = new long[4];
        int    ceiling = numDigits[idx];

        for (int dig = 0; dig <= ceiling; dig++) {
            boolean nextBegun = begun || dig != 0;
            int     nextLast  = last;
            boolean nextRise  = canRise, nextFall = canFall;
            int     nextTotal = total;

            if (!nextBegun) {
                nextLast = 10;
            } else if (!begun) {
                nextLast  = dig;
                nextRise  = true;
                nextFall  = true;
                nextTotal = total + dig;
            } else {
                nextRise  = canRise && dig > last;
                nextFall  = canFall && dig < last;
                nextLast  = dig;
                nextTotal = total + dig;
            }

            boolean stillBound = (dig == ceiling);
            long[] child = solve(idx + 1, stillBound, nextBegun, nextLast,
                                 nextRise, nextFall, nextTotal, numDigits, len, cache);
            for (int k = 0; k < 4; k++) bucket[k] += child[k];
        }

        return bucket;
    }

    private long countBelow(long upperBound) {
        if (upperBound <= 0) return 0;

        List<Integer> extracted = new ArrayList<>();
        long rem = upperBound;

        while (rem > 0) {
            extracted.add((int) (rem % 10));
            rem /= 10;
        }

        Collections.reverse(extracted);

        int len       = extracted.size();
        int[] numDigits = new int[len];
        for (int i = 0; i < len; i++) numDigits[i] = extracted.get(i);

        HashMap<Integer, long[]> cache = new HashMap<>();
        long[] counts = solve(0, true, false, 10, true, true, 0, numDigits, len, cache);

        long goodCount    = counts[2] + counts[3];
        long sumGoodCount = counts[1] + counts[3];
        long bothCount    = counts[3];

        return goodCount + sumGoodCount - bothCount;
    }

    public long countFancy(long leftBound, long rightBound) {
        return countBelow(rightBound) - countBelow(leftBound - 1);
    }
}