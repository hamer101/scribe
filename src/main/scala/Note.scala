package notes

class Note(var title: String, var priority: Int, var contents: String) {
  def setPriority(priority: Int): Unit = {
    this.priority = priority
  }
}