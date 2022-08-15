// So in the question they mention an lawn of 200m long and 1m width, now gave tents size in an array like [5, 10,2] etc,
// Now we need to place those tents in a way that they took minimum space

// Conditions are - all tents width is 1m
// You have place a tent in a way that the space in forward and backward is equal or more than it's size
// Means if I place 10 m long a tent I must leave free space 10 m forward and backward minimum

// But here is a twist like there is two tents size 10 m and 2 m so we need to leave free space of 10 m forward and backward for 10 m long tent but for 2 m long tent the space can be adjusted in that 10m free spcace
// Like 10 +10(tent) + 8+2+2(tent) +2

// those tents which are in the first or last like the side ones for them no need to leave free space on forward (for first) backward ( for last)
import java.util.*;
class fun2{
    public static void main(String[] args){
        int[] tents = {5, 10, 2};
        System.out.println(getMinSpace(tents));
    }
    public static int getMinSpace(int[] tents){
        int totalSpace = 0;
        for(int i = 0; i < tents.length; i++){
            totalSpace += tents[i];
        }
        int[] left = new int[tents.length];
        int[] right = new int[tents.length];
        left[0] = tents[0];
        right[tents.length - 1] = tents[tents.length - 1];
        for(int i = 1; i < tents.length; i++){
            left[i] = left[i - 1] + tents[i];
        }
        for(int i = tents.length - 2; i >= 0; i--){
            right[i] = right[i + 1] + tents[i];
        }
        int minSpace = Integer.MAX_VALUE;
        for(int i = 0; i < tents.length; i++){
            int space = Math.min(left[i], right[i]);
            if(space >= tents[i]){
                minSpace = Math.min(minSpace, space - tents[i]);
            }
        }
        return totalSpace - minSpace;
    }
}