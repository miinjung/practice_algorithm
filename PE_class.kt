/*
완전 탐색 문제
모의고사 문제

출처 : 프로그래머스
 */

fun main(args: Array<String>){
    val lost = intArrayOf(5,2,6,8)//3,1 > 1 > null
    val reserve = intArrayOf(4,2,5)//2,4 >
    var result = 0
    result = solution(10,lost,reserve)

    print(result)

}

fun solution(n: Int, lost: IntArray, reserve: IntArray): Int { // 풀이가 너무 더럽.....ㅠ
    var same = 0
    var answer_1 = n
    var answer_2 = n

    for(i in lost.indices){
        if(reserve.contains(lost[i])){
            reserve.set(reserve.indexOf(lost[i]),n+2)
            lost.set(i,n+2)
            same++
        }
    }

    var tmp_reserve = reserve.toMutableList()
    var tmp_lost = lost.toMutableList()


    lost.sort()
    for(i in lost.indices){
        if(tmp_reserve.contains(lost[i]-1))
            tmp_reserve.remove(lost[i]-1)
        else if(tmp_reserve.contains(lost[i]+1))
            tmp_reserve.remove(lost[i]+1)
        else
            answer_1--
    }
    answer_1+=same

    reserve.sort()
    for(i in reserve.indices){
        if(tmp_lost.contains(reserve[i]-1))
            tmp_lost.remove(reserve[i]-1)
        else if(tmp_lost.contains(reserve[i]+1))
            tmp_lost.remove(reserve[i]+1)
    }
    answer_2 = answer_2 - tmp_lost.size + same

    if(answer_1>answer_2)
        return answer_1
    else
        return answer_2
}

fun bset(n: Int, lost: IntArray, reserve: IntArray): Int { //인상깊게 본 답변

    var answer = n
    var lostSet = lost.toSet() - reserve.toSet()
    var reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

    for (i in lostSet) {
        when {
            i + 1 in reserveSet -> reserveSet.remove(i + 1)
            i - 1 in reserveSet -> reserveSet.remove(i - 1)
            else -> answer--
        }
    }
    return answer
}