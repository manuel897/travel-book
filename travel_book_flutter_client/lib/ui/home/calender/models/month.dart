enum Month {
  jan("January", 1),
  feb("February", 2),
  mar("March", 3),
  apr("April", 4),
  may("May", 5),
  jun("June", 6),
  jul("July", 7),
  aug("August", 8),
  sep("September", 9),
  oct("October", 10),
  nov("November", 11),
  dec("December", 12);

  final String label;
  final int intVal;

  const Month(this.label, this.intVal);

  static Month fromCode(int code) {
    final m = Month.values.where((e) => e.intVal == code).firstOrNull;
    if (m == null) {
      throw Exception("Could not parse month code: $code");
    }
    return m;
  }
}
