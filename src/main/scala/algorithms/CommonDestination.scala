package algorithms

/**
  * Created by dirghayu on 28-09-2016.
  */
object
CommonDestination extends App{
  def OutputMostPopularDestination(count: Int) = {

    val destinations: IndexedSeq[String] = for(i<-1 to count) yield readLine()
    destinations.maxBy(x=>destinations.count(_==x))
  }


  val output = OutputMostPopularDestination(4)

  println(output)
}
