import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int position = -30001
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        for(int[] element : routes){
            if(element[0] > position){
                position = element[1];
                answer++;
            }
        }
        return answer;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int index = 0;
        int end_index = 0;
        int[] startList = new int[routes.length];
        int[] endList = new int[routes.length];
        int[] checkList = new int[routes.length * 2];
        for(int i = 0; i < routes.length; i++){
            startList[i] = routes[i][0];
            endList[i] = routes[i][1];
        }
        Arrays.sort(startList);
        Arrays.sort(endList);
        for(int element : startList){
            while(element > endList[end_index]){
                checkList[index++] = 1;
                end_index++;
            }
            checkList[index++] = 0;
        }
        checkList[index] = 1;
        for(int i = 1; i < routes.length * 2; i++){
            if(checkList[i-1] + checkList[i] == 1) {
                answer++;
                i++;
            }
        }
        return answer;
    }
}

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int state = 0;
        int start_index = 0;
        int end_index = 0;
        int[] startList = new int[routes.length];
        int[] endList = new int[routes.length];
        for(int i = 0; i < routes.length; i++){
            startList[i] = routes[i][0];
            endList[i] = routes[i][1];
        }
        Arrays.sort(startList);
        Arrays.sort(endList);
        if(startList[routes.length - 1] <= endList[0])
            return 1;
        for(int element : startList){
            if(element > endList[end_index]){
                state = 1;
                while(element > endList[end_index]){
                    end_index++;
                }
            }else{
                if(state == 1)
                    answer++;
                state = 0;
            }
        }
        if(state == 1)
            answer++;
        return answer;
    }
}