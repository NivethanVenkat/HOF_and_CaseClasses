package logics

class CaseClasses_1 (_name:String, _duration:String, _octave:Int) extends Serializable {
  val name = _name
  val duration = _duration
  val octave = _octave

  override def equals(other: Any): Boolean = other match {
    case that: CaseClasses_1 =>
      (that canEqual this) &&
        name == that.name &&
        duration == that.duration &&
        octave == that.octave
    case _ => false
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[CaseClasses_1]

  override def hashCode(): Int = {
    val state = Seq(name, duration, octave)
    state.map(_.hashCode()).foldLeft(0)((a,b) => 31 * a + b)
  }

  override def toString = s"logics.CaseClasses_1($name,$duration,$octave)"

  def copy(name: String = name, duration: String = duration, octave: Int = octave): CaseClasses_1 =
    new CaseClasses_1(name, duration, octave)

  object CaseClasses_1 {

    def main(args: Array[String]): Unit = {
      // Constructor that allows the omission of the `new` keyword
      def apply(name: String, duration: String, octave: Int): CaseClasses_1 =
        new CaseClasses_1(name, duration, octave)

      // Extractor for pattern matching
      def unapply(note: CaseClasses_1): Option[(String, String, Int)] =
        if (note eq null) None
        else Some((note.name, note.duration, note.octave))

      val c3 = new CaseClasses_1("C", "Quarter", 3)
      println(c3.toString)
    }

  }
}
