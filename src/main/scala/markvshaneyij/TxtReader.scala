package markvshaneyij

import scala.io.Source

class TxtReader(file: String) {

  private def readFile(filename: String = file): List[String] = {
    val file = Source.fromResource(filename)
    val fileContents = file.getLines.mkString.split(" ")
    file.close()
    fileContents.map(_.trim).toList
  }

  def getPairs(filename: String = file): List[(String, String)] = {

    val words = readFile().zipWithIndex

    words.dropRight(1) map { case (item, index) => (item, words(index + 1)._1) }
  }

}