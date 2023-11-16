import note._
import calendar._
import com.github.nscala_time.time.Imports._
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
  println("Hello world!")
  println(msg)


  var myNote1: NoteInterface = new Note("Importante", 5, "myNote1.")
  val myNote2: NoteInterface = new Note("Muji importante", 4, "myNote2.")
  val myNote3: NoteInterface = new Note("Tärkeä", 3, "myNote3.")
  val myNote4: NoteInterface = new Note("Tärkempi", 2, "myNote4.")
  var myNote5: NoteInterface = new Note("Tärkein", 1, "myNote5.")
  
  myNote1 = new ImageAppendix(myNote1, "/path/to/image1", "Text for image 1")
  myNote5 = new QuoteAppendix(myNote5, "Carthago delenda est", "Cato the Elder", "Roman senate discussion")
  myNote5 = new ImageAppendix(myNote5, "/path/to/image5", "Text for image 5")

  // println(myNote1.title)      // "Important Note"
  // println(myNote1.priority)   // 1
  // println(myNote1.contents)

  myNote5.display

  var myPlanCalendar = new PlanCalendar
  myPlanCalendar.load()
  myPlanCalendar.save()

  var myPlanEntry = new PlanCalEntry(DateTime.now(), DateTime.now() + (1.hours + 10.minutes + 5.seconds))
  myPlanEntry.addNote(myNote1)
  myPlanEntry.addNote(myNote2)
  myPlanEntry.addNote(myNote3)
  myPlanEntry.addNote(myNote5)
  myPlanEntry.addNote(myNote4)
  myPlanCalendar.addEntry(myPlanEntry)
  myPlanCalendar.display
}