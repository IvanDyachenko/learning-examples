package org.learningconcurrency
package exercises
package ch2

object Ex3 extends App {

  class SyncVar[T] {

    private var empty: Boolean = true

    private var x: T = null.asInstanceOf[T]

    def get(): T = ???

    def put(x: T): Unit = ???

  }

}
