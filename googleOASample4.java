There are some processes that need to be executed. Amount of load that process causes on a server that runs it, is being represented by a single integer. Total load caused on a swerver is the sum of the loads of all the processes that run on that server. You have at your disposal two servers, on which mentioned processes can be run. Your goal is to distribute given processes between those two servers in such a way that, absolute difference of their loads will be minimized.

Given an array of n integers, of which represents loads caused by successive processes, return the minimum absolute difference of server loads.

Example 1:
Input : [1, 2, 3, 4, 5]
Output : 1
Explanation : We can distribute the processes [1, 4] to the first server and [2, 3, 5] to the second one, so that their total loads will be 5 and 10, respectively, and the difference of their loads will be equal to 1.

class Solution{
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(minimumDifference(arr));
    }
    public static int minimumDifference(int[] loads) {
        int total = 0;
        for(int load : loads){
            total += load;
        }
        int n = loads.length;
        int[][] dp = new int[n + 1][total + 1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= total; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(loads[i - 1] <= j){
                    dp[i][j] = Math.max(loads[i - 1] + dp[i - 1][j - loads[i - 1]], dp[i - 1][j]);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= total / 2; i++){
            min = Math.min(min, Math.abs(total - 2 * dp[n][i]));
        }
        return min;
    }
}