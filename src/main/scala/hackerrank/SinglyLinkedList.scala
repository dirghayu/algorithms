package hackerrank

object ABCD {
  def main(args: Array[String]) {

    val head = new SinglyLinkedList()

    val seq = Seq(3, 4, 3,2, 6, 1, 2 , 6)

    for (s<- seq) {
      val headItem = s
      head.insertNode(headItem)
    }

    println("Before")
    printSinglyLinkedList(head.head, "")
    val res = distinct(head.head)
    println("After")

    printSinglyLinkedList(res, "")
  }
  class SinglyLinkedListNode(var data: Int, var next: SinglyLinkedListNode = null) {
  }

  class SinglyLinkedList(var head: SinglyLinkedListNode = null, var tail: SinglyLinkedListNode = null) {
    def insertNode(nodeData: Int) = {
      val node = new SinglyLinkedListNode(nodeData)

      if (this.head == null) {
        this.head = node
      } else {
        this.tail.next = node
      }

      this.tail = node
    }
  }

  def printSinglyLinkedList(head: SinglyLinkedListNode, sep: String) = {
    var node = head

    while (node != null) {
      println(node.data)

      node = node.next

      if (node != null) {
        println(sep)
      }
    }
  }

  def distinct(head: SinglyLinkedListNode): SinglyLinkedListNode = {

    def distinct(head: SinglyLinkedListNode, previous : SinglyLinkedListNode, seq: scala.collection.immutable.Set[Int], res: SinglyLinkedList): SinglyLinkedList ={
      if(head == null) {
        res
      } else
      if(seq.contains(head.data)){
          previous.next = head.next
        distinct(head.next, head, seq + head.data, res)
      } else {
        res.insertNode(head.data)
        distinct(head.next, head, seq + head.data, res)
      }

    }
    val list = distinct(head, null, scala.collection.immutable.Set.empty[Int], new SinglyLinkedList())
    return list.head
  }
}