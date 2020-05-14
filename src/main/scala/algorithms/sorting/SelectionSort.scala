package algorithms.sorting

/**
  * Created by dirghayu on 19-09-2016.
  */
object SelectionSort extends SortingAlgorithm{
  override def sort[T <% Ordered[T]](source: Array[T]): Array[T] = {
    for(i <- 0 to source.size-1){

      var smallest = source(i)
      var smallestLoc = i
      for(j<- i to source.size-1){
        if( source(j) < smallest)
          {
            smallest = source(j)
            smallestLoc = j
          }
      }
      val temp = source(i)
      source(i)= smallest
      source(smallestLoc) = temp
    }

    source
  }

  override val info: String =
    """
      | 1. O(n^2) comparisions.
      | 2. O(n) swaps <- Number of swaps are less.
      | 3. O(1) extra space
      | 4. Not stable.
    """.stripMargin
  override val steps: String =
    """
      | Find smallest number and swap with i th element.
      |
    """.stripMargin
}
