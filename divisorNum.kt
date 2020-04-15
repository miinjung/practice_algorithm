/*
나눠지는 숫자 정렬 문제

출처 : 프로그래머스
 */

fun main(args: Array<String>){
    val array = intArrayOf(5,9,7,10)
    val divisor = 5
    var result = solution(array,divisor)

    print(result.joinToString())
}

fun solution(arr: IntArray, divisor: Int): IntArray {
    var answer = mutableListOf<Int>()

    for(i in arr.indices){
        if(arr[i]%divisor == 0){
            answer.add(arr[i])
        }
    }
    if(answer.isEmpty())
        answer.add(-1)
    answer.sort()

    return answer.toIntArray()
}