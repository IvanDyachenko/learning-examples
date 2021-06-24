package org.learningconcurrency
package exercises
package ch1

object Ex1a extends App {

  def compose[A, B, C](g: B => C, f: A => B): A => C = (a: A) => g(f(a))

}

object Ex1b extends App {

  def compose[A, B, C](g: B => C, f: A => B): A => C = g compose f

}
