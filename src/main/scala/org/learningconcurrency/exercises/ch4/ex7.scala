package org.learningconcurrency
package exercises
package ch4

/** Implement the IMap class, which represents a single-assignment map:
  *
  * class IMap[K, V] {
  *   def update(k: K, v: V): Unit
  *   def apply(k: K): Future[V]
  * }
  *
  * Pairs of keys and values can be added to the IMap object,
  * but they can never be removed or modified.
  *
  * A specific key can be assigned only once,
  * and subsequent calls to update with that key results in an exception.
  *
  * Calling apply with a specific key returns a future,
  * which is completed after that key is inserted into the map.
  *
  * In addition to futures and promises, you may use the scala.collection.concurrent.Map class.
  */

import java.util.concurrent.ConcurrentHashMap

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future, Promise}

object Ex7 extends App {

  class IMap[K, V] {

    import scala.collection.convert.decorateAsScala._

    private val m = new ConcurrentHashMap[K, Promise[V]]().asScala

    private def createPromise(v: V) = ???

    private def createEmptyPromise(k: K): Promise[V] = ???

    def update(k: K, v: V): Unit = ???

    def apply(k: K): Future[V] = ???

  }

  //test

  import org.learningconcurrency.ch2._

  val m = new IMap[Int, String]()

  (1 to 100).map((i) =>
    thread {
      m.update(1, Thread.currentThread().getName)
    }
  )

  (1 to 100).map((i) =>
    thread {
      val l = Await.result(m(1), Duration.Inf)
      log(l)
    }
  )

}
