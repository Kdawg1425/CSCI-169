object HW5Won extends App {

  def is_prime(x:Int):Boolean = {
    def primeCheck(i: Int):Boolean = {
      if(i < 2) true
      else if(x % i == 0) false
      else primeCheck(i-1)
    }
    if(primeCheck(x-1)) true
    else false
  }

  println(is_prime(11))
  println(is_prime(10))

  println()

  def  add_fth(f:Int => Int, x:Int):Int = {
    if(x < 1) 0
    else x + add_fth(f,f(x))
  }

  def sub3(x:Int):Int = x -3

  println(add_fth(sub3, 15))
  println()

  def apply_combine(f: Int=>Int, x:Int, g:(Int,Int) => Int):Int = {
    if(x==1) f(1)
    else g(f(x),apply_combine(f,x-1,g))
  }

  def add(x:Int, y:Int):Int = x + y
  def square(x:Int):Int = x * x
  def multi(x:Int, y:Int):Int = x * y
  def ident(x:Int):Int = x

  println(apply_combine(square,2,add))
  println(apply_combine(ident,2,multi))
}
