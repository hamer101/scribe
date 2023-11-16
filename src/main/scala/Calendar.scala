package calendar

import note.{Note, NoteInterface}
import scala.collection.mutable.Set
import com.github.nscala_time.time.Imports._

abstract class CalEntry {

  var notes: Set[NoteInterface] = Set()
  def display: Unit
  def addNote(aNote: NoteInterface): Unit = {
    notes += aNote
  }
}

class PlanCalEntry(var sdatetime: DateTime, var enddatetime: DateTime) extends CalEntry {

  def setInterval(sdatetime: DateTime, enddatetime: DateTime): Unit = {
    this.sdatetime = sdatetime
    this.enddatetime = enddatetime
  }

  override def display: Unit = {

    println(s"From ${this.sdatetime} to ${this.enddatetime}:")
    this.notes.foreach(aNote => println(s"${aNote.display} \n # # # " ))
  }
}

class EventCalEntry(var occurence: DateTime) extends CalEntry {

  def setOccurence(occurence: DateTime): Unit = {
    this.occurence = occurence
  }

  override def display: Unit = {
    println(s"On ${this.occurence}:")
    this.notes.foreach(aNote => println(s"${aNote.display} \n # # # " ))
  }
}


abstract class Calendar[E <: CalEntry] {

  val savefile: String = "/default/save/location"
  var entries: Set[E]
  
  def addEntry(calEntry: E): Unit = {
    this.entries += calEntry
  }
  def load(): Unit
  def save(): Unit
  def display: Unit
}

class PlanCalendar extends Calendar[PlanCalEntry] {

  var entries: Set[PlanCalEntry] = Set()

  override def load(): Unit = {
    println(s"Loading PlanCalendar from ${this.savefile}.")
  }

  override def save(): Unit = {
    println(s"Saving PlanCalendar to ${this.savefile}.")
  }

  override def display: Unit = {
    println("Plans:")
    this.entries.foreach(entry => println(s"${entry.display} \n === === ==="))
  }
}

class EventCalendar extends Calendar[EventCalEntry] {

  var entries: Set[EventCalEntry] = Set()

  override def load(): Unit = {
    println(s"Loading EventCalendar from ${this.savefile}.")
  }

  override def save(): Unit = {
    println(s"Saving EventCalendar to ${this.savefile}.")
  }
  
  override def display: Unit = {
    println("Events:")
    this.entries.foreach(entry => println(s"${entry.display} \n === === ==="))
  }
}
