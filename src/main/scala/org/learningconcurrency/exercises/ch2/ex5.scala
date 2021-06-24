package org.learningconcurrency
package exercises
package ch2

object Ex5 extends App {

  class SyncVar[T] {

    private var empty: Boolean = true

    private var x: T = null.asInstanceOf[T]

    def isEmpty = ???

    def nonEmpty = ???

    def getWait(): T = ???

    def putWait(x: T): Unit = ???

  }

  import org.learningconcurrency.ch2.thread

  val syncVar = new SyncVar[Int]

  val producer = thread {
    var x = 0
    while (x < 15) {
      syncVar.putWait(x)
      x = x + 1
    }
  }

  val consumer = thread {
    var x = -1
    while (x < 14) {
      x = syncVar.getWait
      log(s"get: $x")
    }
  }

  producer.join()
  consumer.join()

}
