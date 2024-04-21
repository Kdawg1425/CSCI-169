object HW7_1_3_4_Won extends App {
  def add(x:Int, y:Int) = x+y
  def multi(x:Int, y:Int): Int = x*y

  def ls = 7::2::5::1::Nil

  def xs = 3::8::1::5::Nil
  def ys = 12::6::23::1::8::4::Nil

  // Problem 1a
  def reduce_curry(f:(Int,Int)=>Int):List[Int]=>Int = {
    (xs:List[Int]) => {
      if(xs.tail == Nil) xs.head
      else f(xs.head, reduce_curry(f)(xs.tail))
    }
  }

  println(reduce_curry(add)(ls))
  println(reduce_curry(multi)(ls))
  println()


  // Problem 1b
  def combine_curry2(f:(Int,Int) => Int): List[Int]=>List[Int]=>List[Int] = {
    (xs:List[Int]) => {
      (ys:List[Int]) => {
        if(xs.isEmpty || ys.isEmpty) Nil
        else f(xs.head,ys.head)::combine_curry2(f)(xs.tail)(ys.tail)
      }
    }
  }

  println(combine_curry2(add)(xs)(ys))
  println(combine_curry2(multi)(xs)(ys))
  println()

  def findlast(xs:List[Int], x:Int): Int = {
    xs match {
      case Nil => -1
      case head::tail => if(findlast(tail, x) != -1) 1 + findlast(tail, x) else if (head == x) 0 else findlast(tail,x)
    }
  }

  def list1 = 1::2::3::1::2::Nil
  def list2 = 1::2::3::1::Nil

  println(findlast(list1, 1))
  println(findlast(list2, 1))
  println(findlast(list1, 4))
  println()


  def alternate(xs:List[Int], ys:List[Int]): List[Int] = {
    xs match {
      case Nil => ys
      case head::tail => head::alternate(ys,tail)
    }
  }

  def x = 1::2::3::4::Nil
  def y = 7::8::9::10::11::12::Nil

  println(alternate(x,y))
  println(alternate(y,x))
  println()

}
