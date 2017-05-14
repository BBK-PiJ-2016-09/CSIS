object Hammurabi {
  def printIntroductoryMessage() {

    println(
      """Congratulations, you are the newest ruler of ancient Samaria, elected
for a ten year term of office. Your duties are to dispense food, direct
farming, and buy and sell land as needed to support your people. Watch
out for rat infestations and the plague! Grain is the general currency,
measured in bushels. The following will help you in your decisions:

 * Each person needs at least 20 bushels of grain per year to survive.

 * Each person can farm at most 10 acres of land.

 * It takes 2 bushels of grain to farm an acre of land.

 * The market price for land fluctuates yearly.

Rule wisely and you will be showered with appreciation at the end of
your term. Rule poorly and you will be kicked out of office!
 """)
  };

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That’s not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def askHowMuchLandToBuy(bushels: Int, price: Int) = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }

  def askHowMuchLandToSell(acresOwned: Int) = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell > acresOwned) {
      println("O Great Hammurabi, we have but " + acresOwned + " acres")
      acresToSell = readInt("How many acres will you sell? ")
    }
    acresToSell
  }

  def askHowMuchGrainToFeed(bushels: Int) = {
      var grainToFeed = readInt("How much grain (bushels) will you feed to the people? ")
    while(grainToFeed > bushels){
      println("O Great Hammurabi, we have but " + bushels + " bushels ")
      grainToFeed = readInt("How much grain (bushels) will you feed to the people? ")
    }
    grainToFeed
  }

  def askHowManyAcresToPlant(acresOwned: Int) = {
    var acresToPlant = readInt("How many acres should we plant? ")
    while(acresToPlant > acresOwned){
      println("O Great Hammurabi, we have but " + acresOwned + " acres ")
      acresToPlant = readInt("How many acres should we plant? ")
    }
    acresToPlant
  }

  def applyPlague(population: Int): Int ={
    val r = new scala.util.Random
    if(r.nextFloat() < 0.15){
      return scala.math.round(population/2)
    }
    return 0
  }


  def feedThePeople(population: Int, bushels: Int): Int ={
    var bushelsDebt = scala.math.max((population * 20) - bushels, 0)
    return scala.math.round(bushelsDebt.toFloat / 20)
  }

  def calculateImmigrants(acresOwned: Int, bushelsInStorage: Int, population: Int): Int ={
    return scala.math.round((20 * acresOwned + bushelsInStorage)/((100 * population)+1))
  }

  def calculateHarvest(): Int ={
    val r = new scala.util.Random
    return ((1 + r.nextInt( (8 - 1) + 1 )))
  }

  def applyRats(bushels: Int): Int ={
    val r = new scala.util.Random
    if(r.nextFloat() < 0.4){
      return scala.math.round(bushels * (scala.math.max(r.nextFloat() /3, 0.1))).toInt
    }
    return  0
  }

  def generateRandomPrice(): Int = {
    val r = new scala.util.Random
    return ((1 + r.nextInt( (23 - 17) + 1 )))

  }
  def hammurabi(): Unit = {
    var starved = 0            // how many people starved
    var immigrants = 5         // how many people came to the city
    var population = 100
    var harvest = 3000          // total bushels harvested
    var bushelsPerAcre = 3      // amount harvested for each acre planted
    var rats_ate = 200          // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19       // each acre costs this many bushels
    var plagueDeaths = 0
    var acres = 0

    for(year <- 1 to 10){
      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      if(acresToBuy == 0){
        var acresToSell = askHowMuchLandToSell(acresOwned)
        bushelsInStorage = bushelsInStorage + (acresToSell * pricePerAcre)
        acresOwned = acresOwned - acresToSell
      } else {
        acresOwned = acresOwned + acresToBuy
        bushelsInStorage = bushelsInStorage - acresToBuy * pricePerAcre
      }
      acresOwned = acresOwned + acresToBuy

      var grainToFeed = askHowMuchGrainToFeed(bushelsInStorage)
      bushelsInStorage = bushelsInStorage - grainToFeed

      var acresToPlant = askHowManyAcresToPlant(acresOwned)
      acresOwned = acresOwned - acresToPlant

      var deadByPlague = applyPlague(population)
      plagueDeaths = plagueDeaths + deadByPlague

      population = population - plagueDeaths
      var starvedThisYear = feedThePeople(population, grainToFeed)
      starved = starved + starvedThisYear
      if(starved > (population*0.45)){
        println("You killed too many people your greatness!\nyou have been brutally murdered by republicans ")
        sys.exit(0)
      }

      immigrants = immigrants + calculateImmigrants(acresOwned, bushelsInStorage, population)

      var bushelsPerAcre = calculateHarvest()
      var harvested = bushelsPerAcre * acresToPlant
      bushelsInStorage = bushelsInStorage + (bushelsPerAcre * acresToPlant)

      var bushelsEatenByRats = applyRats(bushelsInStorage)
      bushelsInStorage = bushelsInStorage - bushelsEatenByRats
      rats_ate = rats_ate + bushelsEatenByRats

      pricePerAcre = generateRandomPrice()

      println(
        """
          |O great Hammurabi!
          |You are in year """ + year + """ of your ten year rule.
          |In the previous year """ + starvedThisYear +""" people starved to death.
          |In the previous year """ + immigrants + """ people entered the kingdom.
          |The population is now """ + population + """ .
          |We harvested """ + harvested + """bushels at """ + bushelsPerAcre  + """ bushels per acre.
          |Rats destroyed """ + bushelsEatenByRats + """bushels, leaving """ + bushelsInStorage + """ bushels in storage.
          |The city owns """ + acresOwned + """ acres of land.
          |Land is currently worth """ + pricePerAcre + """ bushels per acre.
          |There were """ + deadByPlague +""" deaths from the plague.
        """.stripMargin)
    }
    printIntroductoryMessage();
  }
}
Hammurabi.hammurabi