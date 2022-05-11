/**
 * https://leetcode.com/problems/delete-and-earn/submissions/
 * 
 * Using a dp[n+1] array
 * 
 * time: O(n)
 * space: O(n)
 */
class Problem25Approach1 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        
        for(int num: nums){
            max = Math.max(max, num);
        }
        
        int[] arr = new int[max+1];
        
        for(int num: nums){
            arr[num] += num;
        }
        
        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = arr[1];
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);   
        }
        
        return dp[dp.length-1];
    }
}

/**
 * Using 2 variables only
 * 
 * time: O(n) + O(max(n)), n: no. elements in nums
 * space: O(max(n))
 * 
 */
class Problem25Approach2 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // initial processing of data
        int max = 0;
        
        for(int num: nums){         // time: O(n) + O(max(n)), n: no. elements in nums
            max = Math.max(max, num);
        }
        
        int[] arr = new int[max+1];
        for(int num: nums){         // space: O(max(n))
            arr[num] += num;
        }
        
        //dp start
        int notChoose = arr[0];
        int choose = arr[1];
        
        for(int i = 2; i < arr.length; i++){
            int temp = notChoose;
            notChoose = Math.max(notChoose, choose);
            choose = arr[i] + temp;
        }
        
        return Math.max(choose, notChoose);
    }
}