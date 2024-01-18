// import scala.collection.mutable.Set

// abstract class DisplayStrategy {
//     val limit: Int
//     val scrollable: Boolean
//     def display: Unit
// }

// class LineDisplay(val limit: Int, val scrollable: Boolean) extends DisplayStrategy {
//     // override def display(): Unit = {
//     //     return "line"
//     // }
// }
// class PageDisplay(val limit: Int, val scrollable: Boolean) extends DisplayStrategy {
//     // override def display(): Unit = {
//     //     return "page"
//     // }
// }

// abstract class DisplayContext(var aDisplayStrategy: DisplayStrategy) {
//     var subscribers: Set[DisplaySubscriber]

//     def setDisplayStrategy(aDisplayStrategy: DisplayStrategy): Unit = {
//         this.aDisplayStrategy = aDisplayStrategy
//     }

//     def subscribe(subscriber: DisplaySubscriber): Unit = {
//         this.subscribers += subscriber
//     }

//     def unsubscribe(subscriber: DisplaySubscriber): Unit = {
//         this.subscribers -= subscriber
//     }

//     def displaySubscribers: Unit = {
//         this.subscribers.foreach(subscriber => subscriber.display(this.aDisplayStrategy))
//     }
// }

// trait DisplaySubscriber {
//     var header: String
//     var body: String
//     var footer: String
//     var width: Int
//     var length: Int

//     def display(aDisplayStrategy: DisplayStrategy): Unit
// }