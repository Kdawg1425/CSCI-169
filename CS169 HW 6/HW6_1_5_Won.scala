object HW6_1_5_Won extends App{

  def add(x:Int, y:Int) = x+y
  def multi(x:Int, y:Int): Int = x*y

  //Problem 1
  def reduce(f:(Int,Int)=>Int, xs:List[Int]):Int = {
    if(xs.tail == Nil) xs.head
    else f(xs.head, reduce(f,xs.tail))
  }

  def ls = 7::2::5::1::Nil

  println(reduce(add,ls))
  println(reduce(multi,ls))
  println()

  def xs = 3::8::1::5::Nil
  def ys = 12::6::23::1::8::4::Nil

  //Problem 2
  def combine(f:(Int,Int)=>Int, xs:List[Int], ys:List[Int]): List[Int] = {
    if(xs.isEmpty || ys.isEmpty) Nil
    else f(xs.head,ys.head)::combine(f,xs.tail,ys.tail)
  }

  println(combine(add,xs,ys))
  println(combine(multi,xs,ys))
  println()

  //Problem 3
  def reduce_curry(f:(Int,Int)=>Int): List[Int]=>Int = {
    def inner(xs:List[Int]): Int = {
      if(xs.tail == Nil) xs.head
      else f(xs.head, inner(xs.tail))
    }
    inner
  }

  println(reduce_curry(add)(ls))
  println(reduce_curry(multi)(ls))
  println()

  //Problem 4
  def combine_curry(f:(Int,Int) => Int): (List[Int],List[Int])=>List[Int]  = {
    def inner(xs:List[Int], ys:List[Int]): List[Int] ={
      if(xs.isEmpty || ys.isEmpty) Nil
      else f(xs.head,ys.head)::inner(xs.tail,ys.tail)
    }
    inner
  }

  println(combine_curry(add)(xs,ys))
  println(combine_curry(multi)(xs,ys))
  println()

  //Problem 5
  def combine_curry2(f:(Int,Int) => Int): List[Int]=>List[Int]=>List[Int] = {
    def inner(xs:List[Int]): List[Int] => List[Int] = {
      def innerinner(ys:List[Int]): List[Int] = {
        if(xs.isEmpty || ys.isEmpty) Nil
        else f(xs.head,ys.head)::inner(xs.tail)(ys.tail)
      }
      innerinner
    }
    inner
  }

  println(combine_curry2(add)(xs)(ys))
  println(combine_curry2(multi)(xs)(ys))
  println()

}
