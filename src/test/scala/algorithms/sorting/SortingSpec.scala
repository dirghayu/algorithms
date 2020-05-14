//package algorithms.sorting
//
//import org.scalatest.{FlatSpec, Matchers}
//
//
//class SortingSpec extends FlatSpec with Matchers{
//
//  "BubbleSort" should "sort the array" in {
//    testSorting(BubbleSort)
//  }
//"InsertionSort" should "sort the array" in {
//    testSorting(InsertionSort)
//  }
//  "SelectionSort" should "sort the array" in {
//    testSorting(SelectionSort)
//  }
//  "ShellSort" should "sort the array" in {
//    testSorting(ShellSort)
//  }
//  "HeapSort" should "sort the array" in {
//    testSorting(HeapSort)
//  }
//
//def testSorting(sortingAlgo: SortingAlgorithm) = {
//  sortingAlgo.sort(Array.empty[Int]) shouldBe Array()
////  sortingAlgo.sort(Array(1)) shouldBe Array(1)
////  sortingAlgo.sort(Array(2, 1)) shouldBe Array(1,2)
////  sortingAlgo.sort(Array(3,2,1)) shouldBe Array(1,2,3)
//  sortingAlgo.sort(Array(3,82, 9, 7 ,4 ,29 ,15, 81, 47)) shouldBe Array(3, 4,7,9,15, 29,47, 81, 82)
////  sortingAlgo.sort(Array(1240 , 350,3,82, 9, 7 ,4, 900 , 100, 91,29 ,15, 81,200, 47)) shouldBe Array(3, 4,7,9,15, 29,47, 81, 82, 91, 100,200, 350, 900, 1240)
////  sortingAlgo.sort(Array(3,82, 9, 7 ,4 ,29 ,15, 47)) shouldBe Array(3, 4,7,9,15, 29,47,  82)
////  sortingAlgo.sort(Array("hello", "A", "morning")) shouldBe Array("A", "hello","morning")
//}
//
//  "MergeSort" should "Sort the list" in {
//    MergeSort.sort(List(1,2)) shouldBe List(1,2)
//    MergeSort.sort(List(2,1)) shouldBe List(1,2)
//    MergeSort.sort(List(2,1,3)) shouldBe List(1,2,3)
//    MergeSort.sort(List(1,3,2)) shouldBe List(1,2,3)
//    MergeSort.sort(List(1,2,3)) shouldBe List(1,2,3)
//    MergeSort.sort(List(1240 , 350,3,82, 9, 7 ,4, 900 , 100, 91,29 ,15, 81,200, 47)) shouldBe List(3, 4,7,9,15, 29,47, 81, 82, 91, 100,200, 350, 900, 1240)
//  }
//  }
