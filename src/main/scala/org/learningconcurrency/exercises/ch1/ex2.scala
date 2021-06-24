package org.learningconcurrency
package exercises
package ch1

object Ex2a extends App {

  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] = a.flatMap(a => b.map(a -> _))

}

object Ex2b extends App {

  def fuse[A, B](a: Option[A], b: Option[B]): Option[(A, B)] =
    for {
      a <- a
      b <- b
    } yield (a, b)

}
