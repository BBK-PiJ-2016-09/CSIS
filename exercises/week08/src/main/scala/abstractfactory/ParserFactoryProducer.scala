package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String): AbstractParserFactory = s match {
    case "NYCFactory" => new NYCFactory()
    case "LondonFactory" => new LondonFactory()
  }

  // TODO

}
