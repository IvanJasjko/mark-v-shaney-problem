package markvshaneyij

import scala.collection.mutable
import scala.util.Random

class MarkovGen(corpus: List[(String, String)]) {

  val random = new Random()

  def makeChain(sentLength: Int): String = {
    val start_pairs = for (pair <- corpus if pair._1.contains(".")) yield pair._2

    val chain = mutable.MutableList(start_pairs(random.nextInt(start_pairs.length)))


    // This is not very Scala-y
    var counter = 0
    var sentCount = 0

    while (sentCount < sentLength) {
      val word = nextLink(chain(counter))

      chain += word
      counter += 1

      if (word.contains("."))
        sentCount += 1
      }

    chain.mkString(" ")

    }

  private def nextLink(word: String): String = {
    val outcomes = for (i <- corpus if word == i._1) yield i._2
    outcomes(random.nextInt(outcomes.length))

  }
}
