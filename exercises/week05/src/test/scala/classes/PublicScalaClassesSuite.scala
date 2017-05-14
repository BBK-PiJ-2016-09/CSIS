package classes

import classes._
import org.scalatest.FunSuite

class PublicScalaClassesSuite extends FunSuite {
  test("[1] A counter inc and dec should not change the value") {
    assert(new Counter(1).dec.inc.count == 1)
  }
  test("[2] A counter dec dec dec should be the value -3") {
    assert(new Counter(1).dec.dec.dec.count == -2)
  }
  test("[3] A counter dec dec dec should be dec(3)") {
    assert(new Counter(1).dec.dec.dec.count == new Counter(1).dec(3).count)
  }
  test("[4] A person with name and surname should be the same as person with 'name surname'"){
    assert(Person("enric", "serra") == Person("enric serra"))
  }

  test("[5] A Director should have a complete name"){
    val eastwood = new Director("Clint", "Eastwood", 1930)

    assert(eastwood.name == "Clint Eastwood")
  }
  test("[6] Clint eastwood should be older than Mc Tiernan"){
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    assert(Director.older(mcTiernan, eastwood) == eastwood)
  }

  test("[7] Clint eastwood should be older when releasing gran torino than McTiernan when releasing predator"){
    val eastwood = new Director("Clint", "Eastwood", 1930)
    val mcTiernan = new Director("John", "McTiernan", 1951)
    val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
    val predator = new Film("Predator", 1987, 7.9, mcTiernan)
    assert(Film.oldestDirectorAtTheTime(granTorino, predator) == eastwood)
  }
  test("[8] Memento should have higher rating than the dark knight, but unfortunately it doesn't"){
    val nolan = new Director("Christopher", "Nolan", 1970)
    val memento = new Film("Memento", 2000, 8.5, nolan)
    val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
    assert(Film.highestRating(darkKnight, memento) == darkKnight)
  }
}