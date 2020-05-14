package algorithms.tree.tree

/**
  * Created by dirghayu on 20-09-2016.
  */
 case class Tree (x: Int, l: Tree = null, r: Tree = null )
object Tree extends App{


  def solution(tree: Tree ): Int = {

    case class Res( left: Int, right: Int, max: Int)
    def height(t : Tree ): Res =
     {
       val leftRes = if(t.l != null) Some(height(t.l)) else None
       val rightRes = if(t.r != null) Some(height(t.r)) else None
       val leftH = leftRes.map(_.left).getOrElse(0)+1
       val rightH = rightRes.map(_.right).getOrElse(0)+1
       val max = Math.max(leftH, rightH)
       val res = Res(left = leftH , right = rightH, max)

       res
     }
    height(tree).max
  }
  def amplitude(t: Tree ): Int= {

    case class Res(max: Int, min: Int , maxDiff : Int)
    def amplitudeRec(t : Tree ): Res =
    {
      val leftRes = if(t.l != null) Some(amplitudeRec(t.l)) else None
      val rightRes = if(t.r != null) Some(amplitudeRec(t.r)) else None

      val leftMax = List(leftRes.map(_.max),Some(t.x)).flatten.max
      val rightMax = List(rightRes.map(_.max),Some(t.x)).flatten.max

      val leftMin = List(leftRes.map(_.min),Some(t.x)).flatten.min
      val rightMin = List(rightRes.map(_.min),Some(t.x)).flatten.min

      println(s"lefDIFF:: $leftMax $leftMin, right::$rightMax $rightMin x:${t.x}")
      val leftDiff = leftMax - leftMin
      val rightDiff = rightMax - rightMin


      val res =if(leftDiff > rightDiff)
        Res(max = leftMax, min = leftMin, maxDiff = leftDiff)
      else
        Res(max = rightMax, min = rightMin, maxDiff = rightDiff)
      res
    }
    amplitudeRec(t).maxDiff
  }

  def visibleNodes(t: Tree ): Int= {

    def visibleRec(node: Tree)( nodeVisible: Boolean): Int ={

      val currentLeft = node.l
      val currentRight = node.r
      val isLeftVisible  = currentLeft != null && currentLeft.x >= t.x && node.x < currentLeft.x
      val isRightVisible  = currentRight != null && currentRight.x >= t.x && node.x < currentRight.x

      val leftList = if(isLeftVisible) 1 else 0
      val rightList = if(isRightVisible) 1 else 0

      val leftRes = if(node.l!= null) visibleRec(node.l)(isLeftVisible) else 0
      val rightRes = if(node.r!= null) visibleRec(node.r)(isRightVisible) else 0


      val visibleChild = isLeftVisible | isRightVisible

      val res = leftRes + rightRes + leftList + rightList

      res
    }
    visibleRec(t)(false)+1
  }

}