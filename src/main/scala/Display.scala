trait DisplayStrategyInterface {
    val limit: Int
    val scrollable: Boolean
    def display: Unit
}

class LineDisplay(var limit: Int, var scrollable: Boolean) extends DisplayStrategyInterface {
    def display(): Unit = {
        // Some shorthened display logic
    }
}
class PageDisplay(var limit: Int, var scrollable: Boolean) extends DisplayStrategyInterface {
    def display(): Unit = {
        // Some extended display logic
    }
}


class DisplayContext(var aDisplayStrategy: DisplayStrategyInterface) {
    def setDisplayStrategy(aDisplayStrategy: DisplayStrategyInterface): Unit = {
        this.aDisplayStrategy = aDisplayStrategy
    }

    def display: Unit = {
        this.aDisplayStrategy.display()
    }
}