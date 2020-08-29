
fun main(args: Array<String>){
    val str = "JEROEN"
    var result = solution_alpha(str)
    print(result)
}
fun solution(name: String): Int {
    var alphabet : List<Char> = listOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')
    var answer = 0
    var index = 0
    var move_horizontal = name.length - 1
    var start = -1
    var last = -1
    var temp = 0
    val length = name.length
    if(length == 0)
        return 0
    for(i in 0 until length){
        index = alphabet.indexOf(name.get(i))
        if(index == 0) {
            if(start == -1)
                start = i
            last = i
        }
        if((index != 0 || i == length - 1) && start != -1 ){
            temp = caculate_move(start, last, length)
            if(move_horizontal > temp)
                move_horizontal = temp
            start = -1
        }
        answer += min(index,26 - index)
    }
        answer += move_horizontal
    return answer
}
fun caculate_move(start : Int, last : Int, length : Int) : Int{
    if(start == 0 && last == length - 1)
        return 0;
    else if(start == 0)
        return length - last
    else if(last == length - 1)
        return start - 1
    else
        return (start - 1) * 2 + length - last - 1
}
fun min(num1 : Int, num2 : Int) : Int{
    if(num1 < num2)
        return num1
    else
        return num2
}