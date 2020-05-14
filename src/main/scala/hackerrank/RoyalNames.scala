package hackerrank

/**
  * Created by dirghayu on 24-02-2017.
  */

object RoyalNames {

  val DESCENDING_ROMANS = Seq('M' ,'D', 'C', 'L' , 'X', 'V', 'I' )

  def getSortedList(names: Array[String]): Array[String] = {
    romanToInt("")
    def romanToInt(x: String):Int = {
      DESCENDING_ROMANS.foldLeft(0)((b: Int,a: Char)=>{
        println(b, a)
        0
      } )
      0
    }
    def romanLetterToInteger(roman : Char ): Int = roman match {
      case 'M' => 1000
      case 'D' => 500
      case 'C' => 100
      case 'L' => 50
      case 'X' => 10
      case 'V' => 5
      case 'I' => 1
   }

    val n: Array[(String, String)] = names.map(_.split(" ")).map(x=>(x(0),x(1))).sortBy(x=>(x._1,romanToInt(x._2)))
    n.map(x=>x._1+" "+x._2)
  }

  def main(args: Array[String]) {


    println (getSortedList(Array("Louis IX","Louis VIII")).mkString("\n"));
  }
}