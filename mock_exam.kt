/*
완전 탐색 문제
모의고사 문제

출처 : 프로그래머스
 */

fun main(args: Array<String>){
    val answer_1 = intArrayOf(1,2,3,4,5)
    val answer_2 = intArrayOf(1,3,2,4,2)
    var result = intArrayOf() // 답 1 / 답 1,2,3
    result = solution(answer_1)

    for(i in 0 until result.size){
        print("${result[i]},")
    }
}

fun solution(answers: IntArray): IntArray {
    var temp = 0
    var answer = mutableListOf<Int>()
    val tester_1 = getAnswer(intArrayOf(1,2,3,4,5),answers)
    val tester_2= getAnswer(intArrayOf(2,1,2,3,2,4,2,5),answers)
    val tester_3 = getAnswer(intArrayOf(3,3,1,1,2,2,4,4,5,5),answers)

   if(tester_1 == tester_2){
       answer.add(1)
       answer.add(2)
       temp = tester_1
   }else if(tester_1 > tester_2){
       answer.add(1)
       temp = tester_1
   }else{
       answer.add(2)
       temp = tester_2
   }

    if(temp == tester_3){
        answer.add(3)
    }else if(temp < tester_3){
        answer.clear()
        answer.add(3)
    }

    return answer.toIntArray()
}

fun getAnswer(tester : IntArray, answers: IntArray):Int{
    var answer = 0

    for(check in 0 until answers.size){
        if(answers[check] == tester[check%tester.size])
            answer++
    }
    return answer
}