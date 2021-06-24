package org.learningconcurrency
package exercises
package ch2

import scala.collection.mutable._

object Ex6 extends App {

  class SyncQueue[T](val n: Int) {

    private var syncQueue = Queue[T]()

    def getWait(): T = ???

    def putWait(x: T): Unit = ???

  }

  import org.learningconcurrency.ch2.thread

  val syncVar = new SyncQueue[Int](10)

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
      x = syncVar.getWait()
      log(s"get: $x")
    }
  }

  producer.join()
  consumer.join()

}
