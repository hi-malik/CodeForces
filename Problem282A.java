import java.util.*;
public class Problem282A{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 0;
        while(n-- >= 1){
            String str = scn.next();
            if(str.charAt(0) == 'X'){
                if(str.charAt(1) == '+') count++;
                else if(str.charAt(1) == '-') count--;
            }
            else if(str.charAt(0) == '-'){
                --count;
            }
            else if(str.charAt(0) == '+'){
                ++count;
            }
        }
        System.out.println(count);
    }
}