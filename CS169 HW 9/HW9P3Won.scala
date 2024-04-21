
object HW9P3Won extends App{
  def func1(x: Int):Boolean = x % 2 == 0
  def func2(x: Int):Boolean = x >= 0
  def func3(x: Int):Boolean = x == 2 || x == 88 || x == 444 || x == 1000
  def func4(x: Int):Boolean = x == 2 || x == 88 || x == 444 || x == 1001
  val set1 = new Set(func1)
  val set2 = new Set(func2)
  val set3 = new Set(func3)
  val set4 = new Set(func4)

  println(set1.contains(2))
  println(set1.contains(3))
  println()

  println((set1 \/ set2).contains(2))
  println((set1 \/ set2).contains(3))
  println((set1 \/ set2).contains(-1))
  println()

  println((set1 /\ set2).contains(2))
  println((set1 /\ set2).contains(3))
  println()

  println((set1 - set2).contains(2))
  println((set1 - set2).contains(-2))
  println()

  println(set1.filter(func2).contains(2))
  println(set1.filter(func2).contains(-2))
  println()

  println(set1.forall(func2))
  println(set3.forall(func3))
  println(set4.forall(func4))
  println()
}

class Set(f:Int=>Boolean){

  //the function f returns true for elements of the set and false for all other numbers

  def contains(elem: Int): Boolean = {
    f(elem)
  }

  //returns true if elem is in the set and false for all other numbers



  def \/ (t:Set):Set = {
    def inner(x: Int):Boolean = {
      contains(x) || t.contains(x)
    }
    new Set(inner)
  }

  //Returns the union of this set and t.



  def /\ (t:Set):Set = {
    def inner(x: Int):Boolean = {
      contains(x) && t.contains(x)
    }
    new Set(inner)
  }

  //Returns the intersection of this set and t



  def - (t:Set):Set = {
    def inner(x:Int): Boolean = {
      contains(x) && !t.contains(x)
    }
    new Set(inner)
  }

  //Returns the difference of this set and t



  def filter(p:Int=>Boolean):Set = {
    val pset = new Set(p)
    this /\ pset
  }

  // Returns a new set that consists of the elements of s that satisfy the predicate.



  def forall(p:Int=>Boolean):Boolean = {
    val pset = new Set(p)

    def inner(i: Int): Boolean = {
      if(i > 1000) true
      else if(f(i)) if (p(i)) inner(i+1) else false else inner(i+1)
    }
    inner(-1000)
  }

  //Returns true if the predicate is true for all elements of this set, and false otherwise.

  // In order to make it possible to implement this function, we will consider a predicate true for all integers if it is true for integers from -1000 to 1000.

}