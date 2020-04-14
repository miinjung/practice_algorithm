/*
가운데 글자 가져오 문제

출처 : 프로그래머스
 */

fun main(args: Array<String>){
    val str = "abcd"
    var result = solution(str)

    print(result)
}

fun solution(s: String): String {
    val seperate_str = s.split("")
    var answer = ""


    if(seperate_str.size%2 == 0){
        answer = seperate_str.get(seperate_str.size/2-1)+seperate_str.get(seperate_str.size/2)
    }else{
        answer = seperate_str.get(seperate_str.size/2)
    }

    return answer
}