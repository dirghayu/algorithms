package algorithms.sorting

object MergeSort{
   val info: String =
    """
      | 1. Divide and conquer algorithm
      | 2. Used with linked list more than random access Lists.
      | 3. Stable
      | 4. O(n) extra space required for list.
      | 5. O(log n) extra space for linked list
      | 6. O( n log n) time complexity
      | 7. Does 0.5 log(n) to log(n) comprisions
      | 8. Does log(n) to 1.5 log(n) swaps
      | 9. When space is not concern Merge sort is excellent choice.
    """.stripMargin

   val steps: String =
     """
       | 1. divide the list in 2 halves
       | 2. Sort the two halves and then merge it.
     """.stripMargin

   def sort[T <% Ordered[T]](source: List[T]): List[T] = {

    def split(input: List[T]):(List[T], List[T]) = input.splitAt(input.size/2)

    def merge(first: List[T], second: List[T]): List[T] = {
      (first, second) match  {
        case (Nil, y) => y
        case (x, Nil) => x
        case (xs :: x, ys :: y)  =>
          if(xs< ys)
            xs :: merge(x, second)
          else
            ys :: merge(y, first)
      }

    }
     if(source.size/2 != 0 ){
       val (l, r) = split(source)

       merge(sort(l), sort(r))
     }else{
       source
     }

  }
}
