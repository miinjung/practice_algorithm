/*
문자열
크로아티아 알파

출처 : 백준
*/

fun main(args: Array<String>){
    val str = "ljes=njak"
    var result = solution_alpha(str)
    print(result)
}

fun solution_alpha(str : String): Int {
    var seperate_str = str.split("").toMutableList()

    var answer = seperate_str.size

    for(i in seperate_str.indices){
        if(seperate_str[i].equals("="))
            answer--
        else if(seperate_str[i].equals(""))
            answer--
        else if(seperate_str[i].equals("-"))
            answer--
        else if(seperate_str[i].equals("d") && i<seperate_str.lastIndex){
            if(seperate_str[i+1].equals("z"))
                answer--
        }
        else if(seperate_str[i].equals("j") && i>0){
            if(seperate_str[i-1].equals("l") || seperate_str[i-1].equals("n"))
                answer--
        }
    }

    return answer
}