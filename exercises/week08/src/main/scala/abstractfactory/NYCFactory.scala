class NYCFactory extends AbstractParserFactory {
  def getParserInstance(s: String): XMLParser  = s match {
    case "NYCORDER" => new
  }
  def NYCOrderParser
}