import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int last = people.length - 1;
        int start = 0;
        Arrays.sort(people);
        while(last >= start){
            if(people[last] + people[start]> limit)
                last--;
            else {
                last--;
                start++;
            }
            answer++;
        }
        return answer;
    }
}