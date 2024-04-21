
object HW7_2_Won extends App{

  class Biguint(xs: List[Int]) {
    val x = xs

    def this() = this(0::Nil)

    def this(s: String) = this({
      def convert(s: String): List[Int] = {
        if (s.isEmpty) Nil else convert(s.tail) ::: List((s.head - '0'))
      }; convert(s)
    })

    def print() = {
      println(this.x)
    }

    def +(other:Biguint): Biguint = {
      def inner(other: List[Int], thisList: List[Int], carry: Int): List[Int] = {
        if (other.isEmpty && thisList.isEmpty) if(carry == 0) Nil else 1::Nil
        else if (other.isEmpty) ((thisList.head + carry) % 10)::thisList.tail
        else if (thisList.isEmpty) ((other.head + carry) % 10)::other.tail
        else ((other.head + thisList.head + carry) % 10) :: inner(other.tail, thisList.tail,
          if((other.head + thisList.head + carry) >= 10) 1 else 0)
      }

      new Biguint(inner(other.x, this.x, 0))
    }
  }
  val test1 = new Biguint(1::2::3::4::Nil)
  val test2 = new Biguint(2::4::6::8:: Nil)
  val test3 = new Biguint(3::5::7::9::11::13:: Nil)

  (test1+test2).print()
  (test1+test3).print()
  (test2+test3).print()


}
