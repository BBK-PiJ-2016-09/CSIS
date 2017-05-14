package strategy

//TODO
case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): String = {
    return text.toLowerCase();

  }
}
