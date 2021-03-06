/**
 * @author Surya Suravarapu
 */

object GameOfLife {
  def buildBoard(liveCells:List[Tuple2[Int, Int]], sideWidth:Int):Array[Array[Boolean]] = {
    val board = new Array[Array[Boolean]](sideWidth, sideWidth)
    liveCells foreach (arg => board(arg._1)(arg._2) = true)
    board
  }

  def generationalChange(board:Array[Array[Boolean]]):Array[Array[Boolean]] = {
    val newBoard = new Array[Array[Boolean]](board.length, board.length)
    for (row <- 0 until board.length; col <- 0 until board.length) {
      val lives = computeLives(board, row, col)
      newBoard(row)(col) = if (lives == 3 && !board(row)(col)) true
        else if ((lives <= 1 || lives >= 4) && board(row)(col)) false
        else board(row)(col)
    }
    newBoard
  }

  def computeLives(board:Array[Array[Boolean]], currentRow:Int, currentColumn:Int):Int = {
    var lives:Int = 0
    for (i <- Math.max(0, currentRow - 1) to Math.min(board.length - 1, currentRow + 1);
         j <- Math.max(0, currentColumn - 1) to Math.min(board.length - 1, currentColumn + 1)) {
      if ((i != currentRow || j != currentColumn) && board(i)(j)) {
          lives += 1
      }
    }
    lives
  }

  def printBoard(board:Array[Array[Boolean]]) = {
    println
    board.foreach {i =>
      i.foreach { j =>
        if (j) print("*") else print(".")
      }
      println
    }
  }

  def main(args: Array[String]) = {
    var board = buildBoard(List((1,1), (1,2), (2,1), (3,4), (4,3), (4,4)), 6)
    printBoard(board)
    for (period <- 1 to 2) {
      board = generationalChange(board)
      printBoard(board)
    }
  }  
}
