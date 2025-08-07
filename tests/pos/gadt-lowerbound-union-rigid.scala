case class Id2[A](y: A)

sealed trait Adt[A]
case class Con[A](x: A) extends Adt[Id2[A]]

def ok[A, T >: Id2[A]](e: Adt[T]): A = e match
  case Con(x) => x