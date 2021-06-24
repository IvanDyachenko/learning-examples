package org.learningconcurrency
package exercises
package ch1

object Ex3a extends App {

  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = {
    @annotation.tailrec
    def go(xs: Seq[T]): Boolean = xs match {
      case x :: xs => pred(x) && go(xs)
      case _       => true
    }

    go(xs)
  }

}

object Ex3b extends App {

  def check[T](xs: Seq[T])(pred: T => Boolean): Boolean = xs.exists(pred)

}
