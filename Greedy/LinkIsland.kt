fun main(args: Array<String>){
    val str = "JEROEN"
    var result = solution_alpha(str)
    print(result)
}

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        if(n == 1)
            return 0
        var sortList : MutableList<IntArray> = costs.sortedBy{it.get(2)}.toMutableList()
        var answer = sortList[0][2]
        var indexList : MutableList<Int> = mutableListOf(sortList[0][0], sortList[0][1])
        var index = 0
        sortList.removeAt(0)
        while(indexList.size < n){
            while(!(indexList.indexOf(sortList[index][0]) == -1).xor(indexList.indexOf(sortList[index][1]) == -1))
                index++
            if(indexList.indexOf(sortList[index][0]) == -1)
                indexList.add(sortList[index][0])
            else
                indexList.add(sortList[index][1])
            answer += sortList[index][2]
            sortList.removeAt(index)
            index = 0
        }
        return answer
    }
}