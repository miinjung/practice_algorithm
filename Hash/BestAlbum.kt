import java.util.HashMap

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer: MutableList<Int> = mutableListOf<Int>()
        var genreList: HashMap<String, Int> = HashMap<String, Int>()
        var tempList: MutableList<Triple<String, Int, Int>> = mutableListOf<Triple<String, Int, Int>>()
        var index = 0
        var count = 0
        for (i in 0 until genres.size) {
            if (genreList.containsKey(genres[i]))
                genreList.set(genres[i], genreList.get(genres[i])!! + plays[i])
            else
                genreList.put(genres[i], plays[i])
            tempList.add(Triple(genres[i], plays[i], i))
        }
        tempList = tempList.sortedBy { it.third }.asReversed().sortedBy { it.second }.asReversed().toMutableList()
        genreList.toList().sortedBy { (_, value) -> value }.asReversed().toMap().forEach { k, v ->
            index = 0
            count = 0
            while (index < tempList.size && count < 2) {
                if (tempList[index].first.equals(k)) {
                    answer.add(tempList[index].third)
                    count++
                }
                index++
            }
        }
        return answer.toIntArray()
    }
}

class BestSolution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        return genres.indices.groupBy { genres[it] }
                .toList()
                .sortedByDescending { it.second.sumBy { plays[it] } }
                .map { it.second.sortedByDescending { plays[it] }.take(2) }
                .flatten()
                .toIntArray()
    }
}