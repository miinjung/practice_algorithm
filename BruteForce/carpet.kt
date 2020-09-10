class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow
        var width = -1
        var height = -1
        for(i in 3..sum/2){
            if(sum % i == 0){
                width = i
                height = sum / i
                if(yellow == (width - 2) * (height - 2)){
                    if(width > height)
                        return intArrayOf(width,height)
                    else
                        return intArrayOf(height,width)
                }
            }
        }
        return intArrayOf()
    }
}

class BestSolution {
    fun solution(brown: Int, red: Int): IntArray {
        return (1..red)
                .filter { red % it == 0 }
                .first { brown == (red / it * 2) + (it * 2) + 4 }
                .let { intArrayOf(red / it + 2, it + 2) }
    }
}