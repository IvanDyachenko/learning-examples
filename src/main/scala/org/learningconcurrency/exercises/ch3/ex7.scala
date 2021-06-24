package org.learningconcurrency
package exercises
package ch3

import scala.collection._

/** Implement a SyncConcurrentMap class that extends the Map interface
  * from the scala.collection.concurrent package. Use the synchronized
  * statement to protect the state of the concurrent map.
  */

object Ex7 extends App {

  class SyncConcurrentMap[A, B] extends scala.collection.concurrent.Map[A, B] {

    private val m = mutable.Map.empty[A, B]

    override def putIfAbsent(k: A, v: B): Option[B] = ???

    def replace(k: A, oldvalue: B, newvalue: B): Boolean = ???

    def remove(k: A, v: B): Boolean = ???

    override def replace(k: A, v: B): Option[B] = ???

    override def +=(kv: (A, B)): SyncConcurrentMap.this.type = ???

    override def -=(key: A): SyncConcurrentMap.this.type = ???

    override def get(key: A): Option[B] = ???

    override def iterator: scala.Iterator[(A, B)] = ???
  }

  val m = new SyncConcurrentMap[Int, String]()

  import org.learningconcurrency.ch2.thread

  val t = (1 to 100).map((i) =>
    thread {
      (1 to 100).foreach { (k) =>
        {
          val v = s"${Thread.currentThread().getName}"
          m.put(k, v)
          log(s"-> ($k,$v)")
        }
      }
    }
  )

  Thread.sleep(100)

  for ((k, v) <- m) {
    log(s"<- ($k,$v)")
  }

  t.foreach(_.join)

}
