//import java.util.concurrent.atomic.DoubleAccumulator
//
//import scala.collection.immutable.Stack
//
//object PawnPuzzle {
//
//
//}
//
//class Piece{
//
//  val Displacemnts = List(
//    ("N"-> (0, -3)),
//    ("NE"-> (2,-2)),
//    ("E"-> (3,0)),
//    ("SE"-> (2,2)),
//    ("S"-> (0, 3)),
//    ("SW"-> (-2,2)),
//    ("W"-> (-3,0))
//  )
//  def findPathToFillBoardFrom(x: Int, y: Int): List[Position] = {
//
//    val allPositions =
//      (for {
//        x <- 0 to Board.ROWS
//        y <- 0 to Board.COLS
//      }
//        yield{
//        Position(x,y)
//        }).toSet
//
//    def findPathToFillBoardFrom(currentPosition: Position,
//                                remainingPositions: Set[Position],
//                                accumulator: List[Position]):List[Position] ={
//      val it = Displacemnts.iterator
//      while(it.hasNext){
//        val nextPossibleDisplacement = it.next()._2
//        val nextCordinate =  currentPosition.add(nextPossibleDisplacement._1, nextPossibleDisplacement._2)
//       if(remainingPositions.contains(nextCordinate)) {
//        val filledPositions = findPathToFillBoardFrom(nextCordinate, remainingPositions - nextCordinate)
//
//         if(!filledPositions.isEmpty){
//          return filledPositions +
//         }
//       }
//      }
//    }
//
//  }
//}
//case class Position(x:Int, y:Int) {
//  def add(dx: Int, dy: Int): Position = {
//    Position(x + dx, y + dy)
//  }
//}
//
//object Board{
//  val ROWS = 10
//  val COLS = 10
//}