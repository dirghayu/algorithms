package algorithms

/**
  * Created by dirghayu on 28-09-2016.
  */
object CommonManager extends App{

  def OutputMostCommonManager(count: Int) = {
    val uniqueEmployees = count
    val firstSelectedEmployee = readLine()
    val secondSelectedEmployee = readLine()


   val employeRelations: IndexedSeq[(String, String)] = for(i<- 1 to uniqueEmployees-1) yield {
     val line: Array[String] = readLine().split(" ")
     (line(1),line(0))
   }

    val relationMap = employeRelations.toMap
    var firstManager = Option(firstSelectedEmployee)
    var commonManagerFound = false
    while(firstManager.isDefined && !commonManagerFound){

      println(firstManager)
      var secondManager = Option(secondSelectedEmployee)
      while(secondManager.isDefined && !commonManagerFound ){

        println(firstManager,secondManager)
        if(secondManager == firstManager){
          commonManagerFound = true
        }
        else{
          secondManager = relationMap.get(secondManager.get)
        }

      }
      println("Inner while loop over")
      firstManager = relationMap.get(firstManager.get)

    }
    println(firstManager.getOrElse(""))

  }

  val r = readInt
  OutputMostCommonManager(r)
}
