package builder

//TODO

object SedanCarBuilder extends CarBuilder {
  override def buildBodyStyle: Unit = ???

  override def buildPower: Unit = ???

  override def buildEngine: Unit = ???

  override def buildBreaks: Unit = ???

  override def buildSeats: Unit = ???

  override def buildWindows: Unit = ???

  override def buildFuelType: Unit = ???

  override def getCar: Car = {
    return new Car()
  }
}
