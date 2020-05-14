//package hackerrank
//
//import hackerrank.MaximumDiff.maxDifference
//
//object ElectionWinner {
//  def main(args: Array[String]): Unit = {
//    val res =  electionWinner(Array("A", "B" , "A", "B", "C"))
//    println("res: " + res)
//  }
//  // Complete the electionWinner function below.
//  def electionWinner(votes: Array[String]): String = {
//
//    val res: (String, Array[String]) = votes.groupBy(a=>a).maxBy(a=>(a._2.size, a._1))
//    res._1
//  }
//}
