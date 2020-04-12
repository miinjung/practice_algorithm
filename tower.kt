/*
스택/큐
탑 문제

출처 : 프로그래머스
 */

fun main(args: Array<String>){
    val heights = intArrayOf(6,9,5,7,4)
    var result = solution_tower(heights)

    print(result.joinToString())
}

fun solution_tower(heights: IntArray): IntArray {
    var answer = Array(heights.size,{0})

    for(std in heights.size-1 downTo  1){
        for(i in std-1 downTo 0){
            if(heights.get(std)<heights.get(i)){
                answer.set(std,i+1)
                break
            }
        }
    }
    return answer.toIntArray()
}

fun solution_best(heights: IntArray): IntArray { //다른 사람 풀이
    var answer = intArrayOf()
    var stack: List<Int> = listOf()
    for ((i, h) in heights.withIndex()) {
        stack = stack.dropLastWhile {t -> heights[t] <= h }
        answer +=  (stack.lastOrNull() ?: -1) + 1
        stack += i
    }
    return answer
}