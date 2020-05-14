package algorithms.sorting

trait SortingAlgorithm {
  val info: String
  val steps: String
  def sort[T <% Ordered[T]](source:Array[T]):Array[T]
}

object SortingAlgorithm{
  def swap[T](i: Int, j: Int)(arr: Array[T]) = {
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }
}