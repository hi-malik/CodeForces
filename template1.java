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
}