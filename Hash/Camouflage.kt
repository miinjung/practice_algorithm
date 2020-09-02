import java.util.HashMap

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        var clothesList : HashMap<String, Int?> = HashMap<String, Int?>()
        for(cloth in clothes){
            if(clothesList.containsKey(cloth[1])) {
                clothesList.set(cloth[1], clothesList.get(cloth[1])!! + 1)
            else
                clothesList.put(cloth[1], 2)
        }
        clothesList.values.forEach{
            answer *= it
        }
        return answer - 1
    }
}