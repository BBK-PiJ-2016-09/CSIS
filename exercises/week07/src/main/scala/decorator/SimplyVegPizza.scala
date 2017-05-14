package decorator

class SimplyVegPizza extends Pizza {
  def getDesc: String = {
    return "VEG"
  }

  def getPrice: Double = {
    return 230
  }
}
