package algorithms.sorting


object BubbleSort extends SortingAlgorithm{
  def sort[T <% Ordered[T]](source:Array[T]):Array[T]= {
    val array = source
    for{
        i<- 0 to source.size
        j <- i+1 to source.size -1
      }{
        if(array(i) > array.apply(j)){
          SortingAlgorithm.swap(i, j)(array)
        }
      }
    array

  }




  override val info: String =
    """
      | 1. O(n^2) comparisions.
      | 2. O(n) when almost nearly sorted.
      | 3. higher overhead than Insetion sort.
      | 4. Most simple and straighforward.
    """.stripMargin
  override val steps: String =
    """
      | 1. for each i th number compare the number with jth number, swap the numbers if they are not in required soted order.
      | 2. Do the above steps n times.
    """.stripMargin
}
