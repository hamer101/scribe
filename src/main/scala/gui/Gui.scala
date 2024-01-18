package gui

import calendar._
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.{Label, ScrollPane}
import javafx.scene.layout.{VBox}
import javafx.stage.Stage

object Gui extends Application {
  val myPlanCalendar = new PlanCalendar
  myPlanCalendar.load()

  override def start(primaryStage: Stage): Unit = {
    primaryStage.setTitle("Note Display")

    val root = new VBox()
    root.setSpacing(10)

    myPlanCalendar.entries.foreach { entry =>
      val entryLabel = new Label(s"From ${entry.sdatetime} to ${entry.enddatetime}:")

      val notesVBox = new VBox()
      entry.notes.foreach { note =>
        val noteLabel = new Label(s"${note.title} [${note.priority}]: ${note.contents}")
        notesVBox.getChildren.add(noteLabel)
      }

      val entryScrollPane = new ScrollPane(notesVBox)
      entryScrollPane.setFitToHeight(true)
      entryScrollPane.setFitToWidth(true)

      root.getChildren.add(entryLabel)
      root.getChildren.add(entryScrollPane)
    }

    val scene = new Scene(root, 400, 600)

    primaryStage.setScene(scene)
    primaryStage.show()

  }
}
