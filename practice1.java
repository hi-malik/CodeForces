import java.util.*;
public class practice1{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if(n % 2 == 0 && n > 2){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        // System.out.println("Print Here");
    }
}

