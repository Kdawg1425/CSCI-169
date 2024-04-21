object HW9P1Won extends App {
  def cond(con: Boolean): (=> Any, => Any) => Any = {
    def inner(x: => Any, y: => Any): Any = {
      if (con) x else y
    }

    inner
  }

  def square(value: Int) = value * value

  println(cond(5<8)({println("execute first expression"); square(2)},
    {println("execute second expression"); 4+3*2}))

  println(cond(8<5)({println("execute first expression"); square(2)},
    {println("execute second expression"); 4+3*2}))
}



