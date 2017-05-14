package decorator

class Spinach(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Spinach"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 7.92
  }
}
