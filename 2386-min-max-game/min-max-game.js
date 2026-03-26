/**
 * @param {number[]} nums
 * @return {number}
 */
var minMaxGame = function(nums) {
    

    while( nums.length != 1 ){
        let n = nums.length;
        let arr = new Array(n/2);
        let min = true;

        let index = 0;

        for( let i = 0 ; i < n ; i += 2 ){
            if( min ){
                arr[index] = Math.min(nums[i] , nums[i+1]);
            }else{
                arr[index] = Math.max(nums[i] , nums[i+1]);
            }

            index++;
            min = !min;
        }

        nums = arr;
    }

    return nums[0];
};