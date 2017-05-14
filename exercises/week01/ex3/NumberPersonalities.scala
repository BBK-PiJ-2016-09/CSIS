object NumberPersonalities {
  def isPrime(n: Int): Boolean = {
    for(i <- 2 to n -11){
      if((n%i) ==0){
        return false
      }
    }
    return true
  }

  def isHappy(n: Int): Boolean = {
    var digit =
      while
    var happyCycle = List(4, 16, 37, 58, 89, 145, 42, 20)
    if(happyCycle.contains()
  }

  def isTriangular(n: Int): Boolean = {
    var triangle = 1
    while(n > 0){
      n = n - triangle
      triangle = triangle + 1
    }
    return (n==0)
  }

  def isSquare(n: Int): Boolean = {
    var square = 1
    while(n > 0) {
      n = n - square
      square = square +2
    }
    return (n == 0)
  }


  def isSmug(n: Int): Boolean = {
    for(i <- 1 to scala.math.round(scala.math.sqrt(n)).toInt){
      if(scala.math.sqrt(n - (i*i)).toInt ==scala.math.sqrt(n - (i*i))){
        if((i*i) != n){
          return true
        }
      }

    }
    return false
  }

  def isHonest(n: Int): Boolean = {
    return !isDisHonest(n)
  }

  def isDisHonest(n: Int): Boolean = {
    for(i <- 1 to scala.math.round(scala.math.sqrt(n)).toInt){
      if((n/i) == i){
        if((i*i) != n){
          return true
        }
      }

    }
    return false
  }

  def isPronic(n: Int): Boolean = {
    for(i <- 1 to n){
      if((i*(i+1)) == n){
        return true
      }
    }
    return false
  }

  def isDeficient(n: Int): Boolean = {
    return sumOfPositiveDivisorsOf(n) < n
  }


  def isPerfect(n: Int): Boolean = {
    return sumOfPositiveDivisorsOf(n) == n

  }

  def isAbundant(n: Int): Boolean = {
    return sumOfPositiveDivisorsOf(n) > n
  }

  def sumOfPositiveDivisorsOf(n: Int): Int = {
    var sum = 0
    for(i <- 1 to n){
      if((n % i) == 0) {
        sum = sum +i
      }
    }
    return sum
  }

  def testNumber(number: Int): Unit ={
    println(isPrine)
  }
}