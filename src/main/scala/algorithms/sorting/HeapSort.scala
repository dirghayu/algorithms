package algorithms.sorting

import scala.annotation.tailrec

/**
  * Created by dirghayu on 21-09-2016.
  */
object HeapSort extends SortingAlgorithm{
  override val info: String =
    """
      | 1. O(1) extra space with tail Recursion.
      | 2. O(n log n) time
      | 3. 
    """.stripMargin
  override val steps: String = """"""

  override def sort[T <% Ordered[T]](source: Array[T]): Array[T] = {
    def children(i: Int, heapSize: Int) = {
      val leftChild = i * 2 + 1
      leftChild to leftChild + 1 takeWhile (_ < heapSize)
    }

    def numberOfLeaves(heapSize: Int) = (heapSize +1) /2

    @tailrec
    def maxHeap(i: Int, size: Int): Unit = {

      val childrenOfI = children(i , size)

      if(childrenOfI nonEmpty){
        val current = source(i)

        val biggestChild = childrenOfI max (Ordering by source.apply)

        if(current < source(biggestChild)) {
          SortingAlgorithm.swap(i , biggestChild )(source)
          printTree
          maxHeap(biggestChild, size)
        }
      }

    }

    for(i<- source.indices.reverse drop numberOfLeaves(source.size)){
      maxHeap(i, source.size)
    }

    for(i<- (0 until source.size).reverse){

      SortingAlgorithm.swap(0,i)(source)
      maxHeap(0, i)
    }

    def printTree = {
      var n = 0

      var cnt = 0
      for((e,i)<- source.zipWithIndex) {

        print(s"${source(i)}\t")
        cnt +=1
        if(Math.pow(2, n)== cnt){
          println()
          n += 1
          cnt = 0
        }
      }
      println
    }
    source
  }


}
