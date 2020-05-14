package algorithms.sorting

object ShellSort extends SortingAlgorithm {
  override def sort[T <% Ordered[T]](source: Array[T]): Array[T] = {

    var numberOfSublists = source.size /2
    println("numberOfSublists::"+numberOfSublists)
    while (numberOfSublists > 0) {


        insertionSort(source,  numberOfSublists)

      numberOfSublists = numberOfSublists /2
      println("numberOfSublists::"+numberOfSublists)
    }

    def insertionSort(source: Array[T], gap : Int): Unit = {
      for (i <- 0 until  source.size) {

        var j = i
        val valueToInsert = source(i)
        while (j >= gap && source(j - gap) > valueToInsert) {
          source(j) = source(j - gap)
          j -=  gap
        }
        source(j) = valueToInsert
        println(s"ShellSort:Source after pass: $i ${source.mkString(",")}")
      }
    }
 source
  }

  override val info: String =
    """
      | 1.  O(n^ 3/2) complexity
      | 2.  O(1) extra space
      | 3.  It is adaptive: O(n log n) when the list is almost soted.
      | 4. Uses Insetion sort.
    """.stripMargin
  override val steps: String =
    """
      | 1. Divide the list in x sub arrays
      |     for ex 0, 0+x, 0+ 2x, 0 + tx<-- First sub array
      |     1, 1+ x, 1 + 2x , 1+ tx <<-- second sub array
      |     x-1, 2x-1, tx-1 <<-xth sub array
      | 2. Sort each sub array using Insetion sort
      | 3. Reduce the steps to x /2 and repeat the same.
      | 4. Reduce the steps till steps is >1
    """.stripMargin
}