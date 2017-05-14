package decorator

class RomaTomatoes(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Roma Tomatoes"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 5.20
  }
}
