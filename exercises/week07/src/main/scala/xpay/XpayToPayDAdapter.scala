package xpay

implicit class XpayToPayDAdapter(payD: PayD) extends Xpay {
  def getCreditCardNo(custCreditCardNo: String): String = {
    payD.getCustCardNo
  }
  def setCreditCardNo(creditCardNo: String): Unit = {
    payD.setCustCardNo(creditCardNo)
  }

  def getCustomerName: String  = {
    payD.getCardOwnerName
  }


  def setCustomerName(customerName: String): Unit = {
    payD.setCardOwnerName(customerName)
  }

  def getCardExpMonth: String = {
    payD.getCardExpMonthDate
  }

  def setCardExpMonth(cardExpMonth: String): Unit = {
    payD.setCardExpMonthDate(cardExpMonth)
  }

  def getCardExpYear: String = {
    payD.getCardExpMonthDate
  }

  def setCardExpYear(cardExpYear: String)

  def getCardCVVNo: Short = {
    payD.getCVVNo.toShort
  }

  def setCardCVVNo(cardCVVNo: Short): Unit = {
    payD.setCVVNo(cardCVVNo.toShort)
  }

  def getAmount: Double = {
    payD.getTotalAmount
  }

  def setAmount(amount: Double) = {
    payD.setTotalAmoun(amount)
  }
}
