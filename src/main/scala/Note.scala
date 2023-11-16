package note

trait NoteInterface {

  val title: String
  val priority: Int
  val contents: String
  def display: Unit
}

abstract class AppendixWrapper extends NoteInterface {

  var wrappee: NoteInterface
  val title = wrappee.title
  val priority = wrappee.priority
  val contents = wrappee.contents
  def displayAppendix: Unit
  def display: Unit = {
    this.wrappee.display
    this.displayAppendix
  }
}

class ImageAppendix(var wrappee: NoteInterface, var imagefile: String, var alttext: String) extends AppendixWrapper {

  override def displayAppendix: Unit = {
    println(s"Reading an image from: ${this.imagefile}")
    println(s"${this.alttext}")
  }
}

class QuoteAppendix(var wrappee: NoteInterface, var quote: String, var author: String, var quotesource: String) extends AppendixWrapper {
  
  override def displayAppendix: Unit = {
    println(s"\"${this.quote}\"")
    println(s"~ ${this.author}, ${this.quotesource}")
  }
}

class Note(val title: String, val priority: Int, val contents: String) extends NoteInterface {
  def display: Unit = {
    println(s"${this.title} [${this.priority}]: ${this.contents}")
  }
}


