class Solution {
    fun solution(numbers: String): Int {
        var answerList : MutableList<Int> = mutableListOf<Int>()
        lateinit var numList : MutableList<String>
        for(i in 1..numbers.length){
            numList = numbers.chunked(1).toMutableList()
            answerList.addAll(makeIndex(numList, mutableListOf<String>(),i))
        }
        return answerList.distinct().size
    }

    fun makeIndex(numList: MutableList<String>, num : MutableList<String>, n : Int) : MutableList<Int>{
        var resultList : MutableList<Int> = mutableListOf<Int>()
        var tmpList : MutableList<String> = mutableListOf()
        tmpList.addAll(numList)
        var tmp_num : MutableList<String> = mutableListOf()
        tmp_num.addAll(num)
        if(num.size == n){
            resultList.addAll(makeNum(num, ""))
            return resultList
        }
        for(i in 0 until numList.size){
            tmp_num.add(numList.get(i))
            tmpList.removeAt(i)
            resultList.addAll(makeIndex(tmpList, tmp_num, n))
            tmp_num.clear()
            tmp_num.addAll(num)
            tmpList.clear()
            tmpList.addAll(numList)
        }
        return resultList
    }

    fun makeNum(numList : MutableList<String>, num: String) : MutableList<Int>{
        var resultList : MutableList<Int> = mutableListOf<Int>()
        var word = ""
        if(numList.size == 0){
            checkPrime(num).let{
                if(it != -1) {
                    resultList.add(it)
                }
            }
            return resultList
        }
        while(numList.size > 0){
            word = num + numList.get(0)
            numList.removeAt(0)
            resultList.addAll(makeNum(numList, word))
        }
        return resultList
    }

    fun checkPrime(num : String) : Int{
        val check = num.toInt()
        if(check < 2)
            return -1
        for(i in 2 ..(check / 2)){
            if(check % i == 0)
                return -1
        }
        return check
    }
}

class BestSolution {
    lateinit var combNumbers : MutableList<Int>

    fun solution(numbers: String): Int {
        var answer = 0
        combNumbers = mutableListOf()

        temp(numbers,"")

        combNumbers.distinct().forEach {

            if(isPrime(it)){
                answer++
            }
        }
        return answer
    }

    fun temp(numbers:String,result:String){
        if(!result.isNullOrEmpty()){
            combNumbers.add(result.toInt())
        }

        if(numbers.isEmpty()){
            return
        }
        numbers.forEachIndexed { index, c ->
            temp((numbers.removeRange(index..index)),result+c)
        }


    }
    fun isPrime(num:Int):Boolean{

        if(num == 1 || num == 0 ){return false}
        for(i in 2..num/2){
            if(num%i == 0){
                return false
            }
        }
        return true
    }
}
