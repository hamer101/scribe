package notes
import notes.Note
import com.github.nscala_time.time.Imports._

trait CalEntry() {
  var notes: Set[Note]
}

class PlanCalEntry (var sdatetime: DateTime, var enddatetime: DateTime) extends CalEntry {
  var notes: Set[Note]

  def setInterval(sdatetime: DateTime, enddatetime: DateTime): Unit = {
    this.sdatetime = sdatetime
    this.enddatetime = enddatetime
  }
}

class EventCalEntry(var occurence: DateTime) extends CalEntry {
  def setOccurence(occurence: DateTime): Unit = {
    this.occurence = occurence
  }
}


abstract class Calendar {
  val savefile: String
  var entries: List[CalEntry]
  
  def createEntry(calEntry: CalEntry): Unit = {
    this.entries :+ calEntry
  }
  def load(savefile: String): Unit
  def save(): Unit
  def render(): Unit
}

class PlanCalendar(val savefile: String, var entries: List[PlanCalEntry]) extends Calendar

class EventCalendar(val savefile: String, var entries: List[EventCalEntry]) extends Calendar
