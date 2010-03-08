
/**
 * @author Surya Suravarapu
 */

object Game {

  def main(args: Array[String]) {

//    val board = Array(
//      Array("-", "-", "-", "-", "-"),
//      Array("-", "-", "-", "-", "-"),
//      Array("-", "*", "*", "*", "-"),
//      Array("-", "-", "-", "-", "-"),
//      Array("-", "-", "-", "-", "-"))

    val board = Array(
      Array("-", "-", "-", "-", "-", "-"),
      Array("-", "*", "*", "-", "-", "-"),
      Array("-", "*", "-", "-", "-", "-"),
      Array("-", "-", "-", "-", "*", "-"),
      Array("-", "-", "-", "*", "*", "-"),
      Array("-", "-", "-", "-", "-", "-"))
        
    printBoard(board)

    for (loops <- 1 to 2) {
      for (i <- 0 until board.length) {
        for (j <- 0 until board.length) {
          val lives = computeLives(board, i, j)
          val cell = board (i)(j) match {
            case "-" => if (lives == 3) "*"
              else "-"
            case "*" => if (lives <= 1 || lives >= 4) "-"
              else if (lives == 2 || lives == 3) "*"
              else "*"
          }
          board(i)(j) = cell
        }
      }
      printBoard(board)
    }
  }

  def computeLives(board:Array[Array[String]], currentRow:Int, currentColumn:Int):Int = {
    var lives:Int = 0
    //println
    //println("(" + currentRow + ", " + currentColumn + ")")
    for (i <- Math.max(0, currentRow - 1) to Math.min(board.length - 1, currentRow + 1)) {
      for (j <- Math.max(0, currentColumn - 1) to Math.min(board.length - 1, currentColumn + 1)) {
        if (i != currentRow || j != currentColumn) {
          //print (board(i)(j))
          if (board(i)(j) == "*")
            lives = lives + 1
        }
      }
      //println
    }
    lives
  }

  def printBoard(board:Array[Array[String]]) = {
    println
    board.foreach {i =>
      i.foreach { j =>
        print (j)
      }
      println
    }
  }
}