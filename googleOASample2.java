You are given an array of N integers a1, a2, ..., aN (consider 1-based indexing). You are also given an integer S. In one operation, you can pick a subarray of size S & increment each array value by 1. You can perform this operation at most M times. You are required to maximize the minimum value among all the array elements. Find the minimum value after performing the described operation at most M times. 

S subarray is the sequence of consecutive elements of the array

Input format:-

The first line contains T denoting the number of test cases. 
The first line of each test case contains three space-separated integers N, S & M 
The second line of each test case contains N space-separated integers denoting array elements (a1, a2, ..., aN)

Output format:-
For each test case, print the required answer in a new line. 

Sample Input 1:-
1
6 5 2
1 2 3 4 5 6
Sample Output 1:-
4

Hint :-
Use segment tree to find out the current minimum number in the array then find (S-1 length subaaray in both side) if the minimum is in left then increase the left part otherwise in the right part. 
Think 
1 2 3 4 5 6
minimum is 1
s - 1 length expect 1 is the right part [2] so increase right part now array becomes
1 -> 2 3 3 4 5 6
again minimum is 1 idx so s - 1 length expect 1 is right part [2] so now array will be
2 -> 3 4 3 4 5 6
3 -> 4 5 3 4 5 6
4 -> 4 5 4 5 5 6
5 -> 4 6 5 6 5 6
so answer is 4


import java.util.*;
class google2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int S = sc.nextInt();
            int M = sc.nextInt();
            int[] A = new int[N];
            for(int i=0;i<N;i++){
                A[i] = sc.nextInt();
            }
            System.out.println(solve(A,S,M));
        }
    }
    public static int solve(int[] A, int S, int M){
        int N = A.length;
        int[] seg = new int[4*N];
        build(A,seg,0,N-1,1);
        int ans = 0;
        while(M-->0){
            int min = query(seg,0,N-1,1,0,N-1);
            int idx = find(A,min);
            int left = idx - S + 1;
            int right = idx + S - 1;
            if(left<0){
                right -= left;
                left = 0;
            }
            if(right>=N){
                left -= (right - N + 1);
                right = N - 1;
            }
            int leftMin = query(seg,0,N-1,1,left,idx);
            int rightMin = query(seg,0,N-1,1,idx,right);
            if(leftMin<rightMin){
                update(seg,0,N-1,1,left,idx,1);
            }
            else{
                update(seg,0,N-1,1,idx,right,1);
            }
            ans = Math.max(ans,query(seg,0,N-1,1,0,N-1));
        }
        return ans;
    }
    public static int find(int[] A, int min){
        for(int i=0;i<A.length;i++){
            if(A[i]==min){
                return i;
            }
        }
        return -1;
    }
    public static void build(int[] A, int[] seg, int low, int high, int pos){
        if(low==high){
            seg[pos] = A[low];
            return;
        }
        int mid = (low+high)/2;
        build(A,seg,low,mid,2*pos);
        build(A,seg,mid+1,high,2*pos+1);
        seg[pos] = Math.min(seg[2*pos],seg[2*pos+1]);
    }
    public static int query(int[] seg, int low, int high, int pos, int l, int r){
        if(low>r || high<l){
            return Integer.MAX_VALUE;
        }
        if(low>=l && high<=r){
            return seg[pos];
        }
        int mid = (low+high)/2;
        int left = query(seg,low,mid,2*pos,l,r);
        int right = query(seg,mid+1,high,2*pos+1,l,r);
        return Math.min(left,right);
    }
    public static void update(int[] seg, int low, int high, int pos, int l, int r, int val){
        if(low>r || high<l){
            return;
        }
        if(low==high){
            seg[pos] += val;
            return;
        }
        int mid = (low+high)/2;
        update(seg,low,mid,2*pos,l,r,val);
        update(seg,mid+1,high,2*pos+1,l,r,val);
        seg[pos] = Math.min(seg[2*pos],seg[2*pos+1]);
    }
}
