package decorator

class SimplyNonVegPizza extends Pizza {
  def getDesc: String = {
    return "NON VEG"
  }

  def getPrice: Double = {
    return 350
  }
}
