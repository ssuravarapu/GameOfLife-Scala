
/**
 * @author Surya Suravarapu
 */

object Game {

  def main(args: Array[String]) {

    val board = Array(Array("-", "-", "-", "-", "-"),
      Array("-", "-", "-", "-", "-"),
      Array("-", "*", "*", "*", "-"),
      Array("-", "-", "-", "-", "-"),
      Array("-", "-", "-", "-", "-"))

    board.foreach {i =>
      i.foreach { j =>
        print (j)  
      }
      println
    }

    for (i <- 0 until board.length) {
      for (j <- 0 until board.length) {
        println(computeLives(board, i, j))
      }
    }
  }

  def computeLives(board:Array[Array[String]], currentRow:Int, currentColumn:Int):Int = {
    var lives:Int = 0
    println
    println("(" + currentRow + ", " + currentColumn + ")")
    for (i <- Math.max(0, currentRow - 1) to Math.min(board.length - 1, currentRow + 1)) {
      for (j <- Math.max(0, currentColumn - 1) to Math.min(board.length - 1, currentColumn + 1)) {
        if (j == currentColumn && i == currentRow)
          print("!")
        else {
          print (board(i)(j))
          if (board(i)(j) == "*")
            lives = lives + 1
        }
      }
      println
    }
    lives
  }
}