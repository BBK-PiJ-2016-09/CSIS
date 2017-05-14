package strategy

// TODO

case class TextEditor(formatter: TextFormatter) {
  def publishText(s: String): Unit = {
    print(formatter.format(s));
  }
}
