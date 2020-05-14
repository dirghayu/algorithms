package hackerrank

import scala.collection.SortedSet

object MaxMin {
  def main(args: Array[String]): Unit = {
    val res = maxMin(Array("push", "push", "push", "pop"), Array(1,2,3,1 ))
    println("res" + res)

    res.foreach(r=>println(r))
  }

  // Complete the maxMin function below.
  def maxMin(operations: Array[String], x: Array[Int]): Array[Long] = {

    case class Result(min: Int, max: Int, seq: Set[Int], product: Array[Long])

    val zero = Result(Int.MaxValue, Int.MinValue, SortedSet.empty[Int], Array.emptyLongArray)

    val res: Result = operations.zip(x).foldLeft(zero){ (resSet, op) =>
      op._1 match {
        case "push" =>

          val updatedSeq = resSet.seq + op._2
          println("Push:" + updatedSeq)
          val updatedMin = if(op._2 < resSet.min) {
            op._2
          } else {
            resSet.min
          }

          val updatedMax = if(op._2 > resSet.max) {
            op._2
          } else {
            resSet.max
          }
          val updatedArray: Array[Long] = resSet.product.:+ (updatedMin.toLong * updatedMax.toLong)
          println(s"updatedMin $updatedMin updatedMax: $updatedMax")
          println(s"updatedArray ${updatedArray.mkString}")
          Result(updatedMin, updatedMax, updatedSeq,  updatedArray)

        case "pop" =>
          val updatedSeq =  resSet.seq - op._2
          val updatedMin =  if(resSet.min == op._2 ){
            updatedSeq.min
          } else {
            resSet.min
          }

          val updatedMax =  if(resSet.max == op._2 ){
            updatedSeq.max
          } else {
            resSet.max
          }
          println(s"updatedMin $updatedMin updatedMax: $updatedMax")
          val updatedArray: Array[Long] = resSet.product.:+ (updatedMin.toLong * updatedMax.toLong)
          println(s"updatedArray ${updatedArray.mkString}")

          Result(updatedMin, updatedMax, updatedSeq, updatedArray)
      }
    }
    res.product
  }
}
