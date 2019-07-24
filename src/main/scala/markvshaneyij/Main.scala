package markvshaneyij

object Main {

  def main(args: Array[String]): Unit = {

    val r = new TxtReader("text.txt")
    val corpus = r.getPairs()

    val g = new MarkovGen(corpus)
    println(g.makeChain(4))
  }
}
