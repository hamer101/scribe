import scala.collection.mutable.Set

abstract class DisplayStrategy {
    val limit: Int
    val scrollable: Boolean
    def display: Unit
}

class LineDisplay(var limit: Int, var scrollable: Boolean) extends DisplayStrategy {
    def display(): Unit = {
        // Some shorthened display logic
    }
}
class PageDisplay(var limit: Int, var scrollable: Boolean) extends DisplayStrategy {
    def display(): Unit = {
        // Some extended display logic
    }
}

class DisplayContext(var aDisplayStrategy: DisplayStrategy) {
    var subscribers: Set[DisplaySubscriber]

    def setDisplayStrategy(aDisplayStrategy: DisplayStrategy): Unit = {
        this.aDisplayStrategy = aDisplayStrategy
    }

    def subscribe(subscriber: DisplaySubscriber): {
        this.subscribers += subscriber
    }

    def unsubscribe(subscriber: DisplaySubscriber): {
        this.subscribers -= subscriber
    }

    def displaySubscribers: Unit = {
        this.subscribers.foreach(subscriber => subscriber.display(this.aDisplayStrategy)))
    }
}

trait DisplaySubscriber {
    var header: String
    var body: String
    var footer: String
    var width: Int
    var length: Int

    def display(aDisplayStrategy: DisplayStrategy)
}