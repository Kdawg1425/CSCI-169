
object HW8P1Won extends App{
  def my_reduce[T <: AnyRef](f:(T, T)=> T, xs:List[T]): T = {
    xs match {
      case y::Nil => y
      case y::ys => f(y, my_reduce(f,ys))
    }
  }

  def xs = "Hello"::" "::"World"::"!"::Nil

  def concatenate(s1:String, s2:String):String = s1 + s2

  println(my_reduce(concatenate, xs))
}
