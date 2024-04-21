object HW8P2Won extends App{
  val t = Leaf.insert(4).insert(8).insert(7)
  val t2 = Leaf.insert(8).insert(7).insert(4)
  val t3 = Leaf.insert(2).insert(6).insert(4)
  val t4 = Leaf.insert(3).insert(2).insert(1).insert(4).insert(5).insert(6)
  //println(t member 8)//t.member(8)
  //println( t equals t2)
  //println(t.toString)
  //println(t2.toString)

  //Homework test
  println(t.toString)
  println(t2.toString)
  println(t3.toString)
  println(t4.toString)
  println(t3.depth)
  println(t4.depth)
  println(t2.max)
  println(t3.max)
  println(t.exactsubtree(t2))
  println(t.exactsubtree(t3))

}
abstract class BSTree{ //Can't be instantiated - can't make an object of type BSTree.
  def member(x: Int): Boolean//Tells us if x is in the BSTree
  def insert(x: Int): BSTree
  //creates a new tree that is the same as this one, but with x added
  //def isLeaf:Boolean//We'll use pattern matching instead of using isLeaf
  def equals(other:BSTree):Boolean

  def depth:Int

  def max:Int

  def exactsubtree(that:BSTree):Boolean
}

//Case in front of child classes lets us do pattern matching; need for both Leaf and Node
case object Leaf extends BSTree{
  override def toString = "."
  def member(x: Int): Boolean = false
  //def isLeaf:Boolean = true
  def insert(x: Int): BSTree = new Node(x, Leaf, Leaf)
  def equals(other:BSTree):Boolean = {
    other match{
      case Leaf => true
      case Node(_, _, _)=> false  //_ is a "wild card" or "don't care"
      //case _=>false //Like a default case
    }
  }
  def depth:Int = 0
  def max:Int = -1
  def exactsubtree(that:BSTree):Boolean = {
    that match {
      case Leaf => true
      case Node(_, _, _)=> false
    }
  }
}

case class Node(value:Int, left:BSTree, right:BSTree) extends BSTree{
  override def toString = "{"+ left.toString + value.toString + right.toString  +"}"//What goes between {} if I want the string representation
  //of everything in my tree between the {}
  def member(x: Int): Boolean = {
    if(x== value) true
    else if (x<value) left member x//left.member(x)//recurse left
    else right member x//right.member(x)//recurse right
  }
  //def isLeaf:Boolean = false
  def insert(x: Int): BSTree = {//Return a COPY of the tree with x added
    if(x<value) new Node(value, left insert x, right)//left.insert(x)//recurse left - need to build our copy!
    else if (x>value) new Node(value, left, right insert x)//right.insert(x)//recurse right
    else new Node(value, left, right)//this would also work//Don't add the value, it's already there.
  }
  def equals(other:BSTree):Boolean = {//What do we want to check first?
    other match{
      case Leaf => false  //if(other.isLeaf)
      case Node(v, l, r) => (value==v) && (left equals l) && (right equals r) //All 3 parts must match
    }
  }

  def depth:Int ={
    if (left.depth > right.depth) 1 + left.depth
    else 1 + right.depth
  }

  def max:Int = {
    if(left.max > right.max) if(value < left.max) left.max else value
    else if (value < right.max) right.max else value
  }

  def exactsubtree(that:BSTree):Boolean = {
    that match{
      case Leaf => false
      case Node(_, l, r)  =>  (left exactsubtree  l) &&  (right exactsubtree  r)
    }
  }

}