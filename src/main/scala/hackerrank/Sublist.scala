package hackerrank

/**
  * Created by dirghayu on 24-02-2017.
  */
import java.io.PrintWriter

object Solution {

  def totalCellsVisited(n: Int, m: Int): Int = {
    val TotalCellCount = m * n
    case class Position(x: Int, y: Int)
    val visited = Set()
    sealed trait Direction{
      def moveRight : Direction
    }
    case object Left extends Direction {
      override def moveRight: Direction = Up
    }
    case object Right extends Direction {
      override def moveRight: Direction = Down
    }
    case object Up extends Direction{
      override def moveRight: Direction = Right
    }
    case object Down extends Direction {
      override def moveRight: Direction = Left
    }

    def visitedCells(position: Position, facingDirectionL: Direction)(visited: Set[Position]): Set[Position]={
      def nextPosition(direction: Direction) : Option[Position]= {
        val pos = direction match {
          case Left => position.copy(x=position.x-1)
          case Right => position.copy(x=position.x+1)
          case Up =>  position.copy(y = position.y -1)
          case Down => position.copy(y = position.y + 1)
        }
        if(pos.x>=0 && pos.x< m && pos.y>=0 && pos.y<n && !visited.contains(pos)) Some(pos) else None
      }

      var cnt = 0
      var currentDirection = facingDirectionL
      var found = false
      var nextP: Option[Position]= None
      while(nextP.isEmpty && cnt<4) {
        nextP = nextPosition(currentDirection)
        currentDirection = currentDirection.moveRight
        cnt+=1

      }
      if(nextP.isEmpty) visited else visitedCells(nextP.get, currentDirection)(visited+ nextP.get)
    }


    visitedCells(Position(0,0), Right)(Set(Position(0,0))).size
  }


  def main(args: Array[String]) {
    println (totalCellsVisited(7,4));
  }
}