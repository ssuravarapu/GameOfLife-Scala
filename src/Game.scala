
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
        computeLives(board.slice(Math.max(i - 1, 0), i + 2), board.length, i, j)
      }
    }
  }

  def computeLives(neighbors:Array[Array[String]], boardLength:Int, currentRow:Int, currentColumn:Int) = {
    println
    println("(" + currentRow + ", " + currentColumn + ")")
    for (i <- 0 until neighbors.length) {
      for (j <- Math.max(0, currentColumn - 1) to (Math.min(currentColumn + 1, boardLength - 1))) {
        print (neighbors(i)(j))
      }
      println  
    }
  }
}