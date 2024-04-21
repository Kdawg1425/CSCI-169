object HW9P2Won extends App{
  def negs(value:Int):Boolean  = value<0//The set of negative integers

  def set1(value:Int):Boolean = value==1// {1}

  //Is 7 in negs?
  negs(7)
  def contains(set: Int=>Boolean , value: Int ):Boolean = {//This gives us a more natural-feeling way to test membership in a set
    set(value)
  }

  contains(negs, 7)

  def complement(set: Int=>Boolean): Int=>Boolean = {//Returns a set
    def ret_set(value:Int):Boolean  ={
      !contains(set, value)
    }
    ret_set
  }

  //Is 7 in the complement of negs?? //function call
  //complement(negs)(7) //Works!  But less human-readable
  contains(complement(negs), 7)

  def complement2(set: Int=>Boolean): Int=>Boolean = {//Using an anonymous function
    (value:Int) => {
      ! contains(set, value)
    }

  }
  //Union
  def union(set1:Int=>Boolean, set2:Int=>Boolean ): Int=>Boolean = {//Returns a set
    (value:Int) => {
      contains(set1, value) || contains(set2, value)
    }
  }

  //Intersection
  def intersection(set1:Int=>Boolean, set2:Int=>Boolean ): Int=>Boolean = {//Returns a set
    (value:Int) => {
      contains(set1, value) && contains(set2, value)
    }
  }
  //Difference
  def difference(set1:Int=>Boolean, set2:Int=>Boolean ): Int=>Boolean = {//Returns a set
    (value:Int) => {
      contains(set1, value) && !contains(set2, value)
    }
  }
  def settee = union(negs, set1)

  //"factory" function that creates and returns singleton sets
  def singleton(value: Int): Int=>Boolean = {
    (x:Int)=> value==x
  }

  //Problem 1
  def setlist(xs:List[Int]):Int=>Boolean = {
    (x: Int) => {
      if(xs.isEmpty) false
      else if(xs.head == x) true else setlist(xs.tail)(x)
    }
  }

  //Problem 2
  def filter(s: Int=>Boolean, p:Int=>Boolean): Int=>Boolean = {
    (x: Int) => {
      intersection(s,p)(x)
    }
  }

  //Problem 3
  def forall(s:Int=>Boolean, p:Int=>Boolean):Boolean = {
    def inner(i: Int): Boolean = {
      if(i > 1000) true
      else if(s(i)) if (p(i)) inner(i+1) else false else inner(i+1)
    }
    inner(-1000)
  }


  def xs = 1::2::3::4::5::Nil
  def ys = 2::4::6::8::Nil
  def p (x: Int):Boolean = x % 2 == 0

  println(setlist(xs)(2))
  println(setlist(xs)(3))

  println(contains(filter(setlist(xs),p), 2))
  println(contains(filter(setlist(xs),p), 3))

  println(forall(setlist(xs),p))
  println(forall(setlist(ys),p))
}
