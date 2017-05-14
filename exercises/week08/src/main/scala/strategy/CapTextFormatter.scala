package strategy

// TODO

case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): String = {
    return text.toUpperCase();
  }
}
