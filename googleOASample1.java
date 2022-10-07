Given an array A consisting of N distinct integers & another array B consisting of M Integers(not necessary distinct). You need to find the minimum number of elements to be added so that A becomes sub-sequence of B, we can add elements at any Postion in array B.

A subsequence is a sequence that can be derivered by deleting some or no elements from the sequence without changing the order of the remaining elements.

We deifne array A elements are distinct if Ai != Aj, i != j, 1 <= i , j <= N (Considering 1-based indexing).

Input Format :-
First line contain the no of test cases test

For each test case:
First line will contain two space-separated integers N & M 
The next line contain N space-seperated distinct integers, denoting the array elements(Ai) of array A 
The next line contain M space-seperated distinct integers, denoting the array elements(Bi) of array B

Output format :- 
Output the minimum no of elements to be added in array B  so that array A becomes sub-sequence of B. For each test case output the answer in a new line. 

Sample Input 1:- 
1
5 6
1 2 3 4 5
2 5 6 4 9 12

Sample Output 1 :-
3

Explanation :-
We need to add minimum of 3 elements to array B, so that array A becomes sub-sequence of B.
We need to add element 1 in start of B and element 3, 4 between 2 and 5 in array B. New array B will be [1,2,3,4,5,6,4,9,12] and array A will besome sub-sequence of B.



import java.util.*;
class google1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[M];
            for(int i=0;i<N;i++){
                A[i] = sc.nextInt();
            }
            for(int i=0;i<M;i++){
                B[i] = sc.nextInt();
            }
            System.out.println(solve(A,B));
        }
    }
    public static int solve(int[] A, int[] B){
        int N = A.length;
        int M = B.length;
        int[][] dp = new int[N+1][M+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(A[i-1]==B[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return N-dp[N][M];
    }
}