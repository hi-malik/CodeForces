import java.util.*;
public class problem4a{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        func(n);
        // System.out.println("Print Here");
    }
    public static void func(int n){
        if(n % 2 == 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
