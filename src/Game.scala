/**
 * @author Surya Suravarapu
 */

object Game {

  def main(args: Array[String]) {
    val board = Array(
      Array make (6, "."),
      Array(".", "*", "*", ".", ".", "."),
      Array(".", "*", ".", ".", ".", "."),
      Array(".", ".", ".", ".", "*", "."),
      Array(".", ".", ".", "*", "*", "."),
      Array make (6, "."))
        
    printBoard(board)

    for (period <- 1 to 2) {
      generationalChange(board)
      printBoard(board)
    }
  }

  def generationalChange(board:Array[Array[String]]):Array[Array[String]] = {
    val changes = scala.collection.mutable.Map.empty[Tuple2[Int, Int], String]
    for (i <- 0 until board.length) {
      for (j <- 0 until board.length) {
        val lives = computeLives(board, i, j)
        val cell = board (i)(j) match {
          case "." => if (lives == 3) "*"
            else board(i)(j)
          case "*" => if (lives <= 1 || lives >= 4) "."
            else board(i)(j)
        }
        changes + ((i, j) -> cell)
      }
    }
    changes foreach (m => board(m._1._1)(m._1._2) = m._2)
    board
  }

  def computeLives(board:Array[Array[String]], currentRow:Int, currentColumn:Int):Int = {
    var lives:Int = 0
    for (i <- Math.max(0, currentRow - 1) to Math.min(board.length - 1, currentRow + 1)) {
      for (j <- Math.max(0, currentColumn - 1) to Math.min(board.length - 1, currentColumn + 1)) {
        if (i != currentRow || j != currentColumn) {
          if (board(i)(j) == "*")
            lives = lives + 1
        }
      }
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
