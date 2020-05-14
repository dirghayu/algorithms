//package hackerrank
//
//object MaximumDiff {
//  def main(args: Array[String]): Unit = {
//   val res =  maxDifference(Array(2,3,10, 2, 4, 8, 1))
//    println("res: " + res)
//  }
//
//  def maxDifference(a: Array[Int]): Int = {
//
//
//    def maxDifference(a: List[Int]): Int = {
//
//      a match {
//        case a :: Nil=>
//          println("a::")
//          0
//        case a :: b =>
//
//          val maxDiffCurrent = (b.max - a).abs
//          val maxDiffSub = maxDifference(b);
//          println(s"a::$a b:: $b ")
//          println(s"maxDiffCurrent::$maxDiffCurrent maxDiffSub:: $maxDiffSub ")
//          if(maxDiffCurrent > maxDiffSub) maxDiffCurrent else maxDiffSub
//
//      }
//    }
//
//    maxDifference(a.toList)
//  }
//}
