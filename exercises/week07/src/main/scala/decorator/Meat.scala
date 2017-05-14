package decorator

class Meat(val pizza: Pizza) extends PizzaDecorator(pizza) {
  override def getDesc: String = {
    return pizza.getDesc + " Meat"
  }

  override def getPrice: Double = {
    return pizza.getPrice + 14.25
  }
}
