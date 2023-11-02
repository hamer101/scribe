import notes.Note

// @main def hello: Unit = {
//   println("Hello world!")
//   println(msg)
//   println(myNote.title)      // "Important Note"
//   println(myNote.priority)   // 1
//   println(myNote.contents)   // "Remember to do something important"
// }

// val msg = "I was compiled by Scala 3. :)"
// val myNote = new Note("Important Note", 1, "Remember to do something important.")


object Scribe extends App {
  val msg = "I was compiled by Scala 3. :)"
  val myNote = new Note("Important Note", 1, "Remember to do something important.")
  println("Hello world!")
  println(msg)
  println(myNote.title)      // "Important Note"
  println(myNote.priority)   // 1
  println(myNote.contents)

}