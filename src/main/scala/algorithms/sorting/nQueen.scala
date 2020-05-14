package algorithms.sorting

/**
  * Created by dirghayu on 18-02-2017.
  */

object Nqueen {
  type Queen = (Int, Int)
  type Solutions = List[List[Queen]]


  def _insert_node_into_singlylinkedlist(head: LinkedListNode, value: String): LinkedListNode = {
    var head_copy: LinkedListNode = head
    if (head_copy == null) {
      head_copy = new LinkedListNode(value);
    }
    else {
      var end: LinkedListNode = head;
      while (end.next != null) {
        end = end.next;
      }
      var node: LinkedListNode = new LinkedListNode(value);
      end.next = node;
    }
    return head_copy;
  }

  class LinkedListNode(node_value: String) {
    var value: String = node_value
    var next: LinkedListNode = null

    override def toString = "value::" + value
  }

  //  def main(args: Array[String]): Unit = {
  //    var _list_size:Int = Console.readInt
  //    var _list:LinkedListNode = null;
  //    val _list_i:Int = 0
  //    for(_list_i <- 1 to _list_size) {
  //      val _list_item = readLine()
  //
  //      _list = _insert_node_into_singlylinkedlist(_list, _list_item);
  //    }
  //
  //    var _sublist_size:Int = Console.readInt
  //    var _sublist:LinkedListNode = null;
  //    val _sublist_i:Int = 0
  //    for(_sublist_i <- 1 to _sublist_size) {
  //      val _sublist_item = readLine()
  //
  //      _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
  //    }
  //
  //    val res =         find(_list, _sublist)
  //    println(res)
  //
  //
  //  }

  def find(list: LinkedListNode, sublist: LinkedListNode): Int = {

    def contains(list: LinkedListNode, subList: LinkedListNode): Boolean = {
      val res = subList match {
        case null => true
        case l if (l.value == list.value) =>
          contains(list.next, l.next)
        case l if (l.value != list.value) =>
          false
      }
      res
    }
    def findRec(node: LinkedListNode)(index: Int): Int = {
      if (node == null) -1
      else if (contains(node, sublist)) index
      else findRec(node.next)(index + 1)
    }
    findRec(list)(0)
  }


//  def LookAndSay(start: String, n: Int): String = {
//
//
//    def recLookAndSay(index: Int): String = {
//
//    }
//
//  }

    def main(args: Array[String]): Unit = {


      println(convert(7792875))
    }


  def convert(in: Long): String = {
    val mod7 = in % 7
    val div7 = in / 7
    val arr = List("0","a","t","l","s","i","n")

    if(div7==0) ""+arr(mod7.toInt)
    else ""+convert(div7)+ arr(mod7.toInt)
  }
}