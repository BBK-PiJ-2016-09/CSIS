package classes


case class Counter(count: Int = 0) {
  def inc(b: Int): Counter = {
    return new Counter(count + b)
  }
  def inc : Counter = {
    return new Counter(count + 1)
  }
  def dec(b: Int = 1) : Counter =  {
    return new Counter(count - b)
  }
  def dec : Counter =  {
    return new Counter(count - 1)
  }
  def adjust(adder: Adder) : Counter = {
    return new Counter(adder.add(count))
  }
}

class Adder(amount: Int) {
  def add(in: Int) : Int = in + amount
}

case class Person(firstname: String, lastname: String)

object Person  {
  def apply(name: String): Person = {
    return new Person(name.split(" ")(0), name.split(" ")(1))
  }
}

// Not converted to case because then inheritance can not be used

case class Director(firstname: String,
               lastname:String,
               yearOfBirth: Int){
  def name : String = {
    return firstname + " " + lastname
  }
}

object Director {
  def older(dir1: Director, dir2:Director): Director ={
    if (dir1.yearOfBirth <= dir2.yearOfBirth) {
      return dir1
    }
    return dir2
  }
}

case class Film(name: String, yearOfRelease: Int, imbdRating: Double, director: Director) {
  def directorsAge: Int = {
    return yearOfRelease - director.yearOfBirth
  }
  def isDirectedBy(candidateDirector: Director): Boolean = {
    return candidateDirector.name == director.name
  }
  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imbdRating: Double = this.imbdRating,
           director: Director = this.director): Film = {
    return new Film(name, yearOfRelease, imbdRating, director)
  }
}

object Film {
  def highestRating(film1: Film, film2: Film): Film = {
    if (film1.imbdRating > film2.imbdRating){
      return film1
    }
    return film2
  }
  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if(film1.directorsAge > film2.directorsAge) {
      return film1.director
    }
    return film2.director
  }
}