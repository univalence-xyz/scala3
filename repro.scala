case class Id1[A](x: A)
case class Id2[A](y: A)

type IdAll[A] = Id1[A] | Id2[A]

sealed trait Adt[A]
case class Con1[B >: Id1[A], A](x: A) extends Adt[B]
case class Con2[B >: Id2[A], A](x: A) extends Adt[B]

def test[A, T >: IdAll[A]](expr: Adt[T]): A = {
  expr match
    case Con1(x) => x
    case Con2(x) => x
}

@main def run(): Unit = {
  val result = test[Int, IdAll[Int] | Id2[String]](Con2())
  println(result)
}
