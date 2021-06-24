package org.learningconcurrency
package exercises
package ch2

import scala.collection.mutable

object Ex8 extends App {

  class PriorityTaskPool {

    implicit val ord: Ordering[(Int, () => Unit)] = Ordering.by(_._1)

    private val tasks = mutable.PriorityQueue[(Int, () => Unit)]()

    def asynchronous(priority: Int)(task: => Unit): Unit = ???

    object Worker extends Thread {

      def poll() = ???

      override def run() = ???
    }

    Worker.start()

  }

  val tasks = new PriorityTaskPool

  (1 to 10).foreach((i) => {
    val a = (Math.random * 1000).toInt
    tasks.asynchronous(a)({ log(s"<- $a") })
  })

  Thread.sleep(10000)

}
