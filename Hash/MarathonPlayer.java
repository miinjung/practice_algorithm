import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i = 0; i < completion.length; i++)
            if(!participant[i].equals(completion[i]))
                return participant[i];
        return participant[participant.length - 1];
    }
}

class HashSolution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> list = new HashMap<String,Integer>();
        for(String element : completion){
            if(list.containsKey(element))
                list.replace(element, list.get(element) + 1);
            else
                list.put(element, 1);
        }
        for(String element : participant){
            if(list.containsKey(element)){
                if(list.get(element) == 0)
                    return element;
                else
                    list.replace(element, list.get(element) - 1);
            }
            else
                return element;
        }
        return "";
    }
}
