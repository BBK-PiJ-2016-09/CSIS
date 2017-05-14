package decorator

class Cheese(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Cheese"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 20.72
  }
}
