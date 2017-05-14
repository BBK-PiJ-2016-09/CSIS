package decorator

class GreenOlives(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Green Olives"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 5.47
  }
}
