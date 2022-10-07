You are given a string that represents time in format hh:mm. Some of the digits are blank (represented by ?). Fill in ? such that the time represented by this string is the maximum possible. Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.

Example 1:
Input : "?4:5?"
Output : "14:59"

class Solution{
    public String maximumTime(String time) {
        char[] timeArray = time.toCharArray();
        if(timeArray[0] == '?'){
            if(timeArray[1] == '?' || timeArray[1] <= '3'){
                timeArray[0] = '2';
            }else{
                timeArray[0] = '1';
            }
        }
        if(timeArray[1] == '?'){
            if(timeArray[0] == '2'){
                timeArray[1] = '3';
            }else{
                timeArray[1] = '9';
            }
        }
        if(timeArray[3] == '?'){
            timeArray[3] = '5';
        }
        if(timeArray[4] == '?'){
            timeArray[4] = '9';
        }
        return new String(timeArray);
    }
}