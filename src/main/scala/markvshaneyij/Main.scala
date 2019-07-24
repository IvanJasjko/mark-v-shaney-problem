package markvshaneyij

object Main {

  def main(args: Array[String]): Unit = {
    val r = new TxtReader("text.txt")
    r.getPairs().foreach(println)
  }
}
