import java.util.*

/*
2019 카카오 인턴 코딩테스트 1번
인형 뽑기 문제
 */


    fun main(args: Array<String>){
        val board = arrayOf(intArrayOf(0,0,0,0,0),intArrayOf(0,0,1,0,3),intArrayOf(0,2,5,0,1),intArrayOf(4,2,4,4,2),intArrayOf(3,5,1,3,1))
        val moves = intArrayOf(1,5,3,5,1,2,1,4)
        var result = 0 // 답 4
        result = solution_1(board,moves)

        print(result)
    }
    fun solution_1(board: Array<IntArray>, moves: IntArray): Int {
        val bucket = mutableListOf<Int>()
        var answer = 0

        for(move in 0 until moves.size) {
            for (i in 0 until board[0].size) {
                if (board[i][moves[move]-1] != 0) {
                    if (bucket.isEmpty()) {
                        bucket.add(board[i][moves[move]-1])
                    }else{
                        if(bucket.last() == board[i][moves[move]-1]){
                            answer++
                            bucket.removeAt(bucket.lastIndex)
                        }else {
                            bucket.add(board[i][moves[move]-1])
                        }
                    }
                    board[i][moves[move]-1]=0
                    break
                }
            }
        }
        return answer*2
    }
