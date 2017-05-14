package decorator

class Ham(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Ham"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 18.72
  }
}
