package algorithms.sorting

object InsertionSort extends SortingAlgorithm{

  override def sort[T <% Ordered[T]](source: Array[T]): Array[T] = {

    for(i<- 1 to source.length-1) {

      var j =i
      val key = source(i)
      while(j>0 && source(j-1) > key) {
        source(j) = source(j-1)
        j -= 1
      }
        source(j) = key
      println(s"Source after pass: $i ${source.mkString(",")}" )
    }
    source
  }

  override val info: String =
    """
      | 1. O(n^2) worst case time complexity.
      | 2. O(n) when it is almost sorted.
      | 3. O(1) extra space complexity
      | 4. O(n^2) comparisions
      | 5. O(n^2) swaps. But in this improvised algorithm, it is not real swap happening. Real swap is done only n times at the end of
      |   inner loop. Inside inner loop it just shifts the elements to the right.
      | 6. Stable
      | 7. algorithm of choice when data is either nearly sorted or when dataset is small
      |
      |
    """.stripMargin
  override val steps: String =
    """
      | 1. for i 1 to n, pick i'th element and place it on the right position.
    """.stripMargin
}
