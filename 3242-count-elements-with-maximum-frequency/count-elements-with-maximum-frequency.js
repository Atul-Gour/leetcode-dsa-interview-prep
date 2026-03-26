/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    const arr = new Array(101).fill(0);
    let maxFreq = 0;
    for( let num of nums ){
        arr[num]++;
        maxFreq = Math.max( maxFreq , arr[num] );
    }

    var ans = 0;

    for( let freq of arr ){
        if( freq == maxFreq ){
            ans += freq;
        }
    }

    return ans;
};