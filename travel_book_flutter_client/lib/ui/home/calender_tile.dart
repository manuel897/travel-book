import 'package:flutter/widgets.dart';
import 'package:travel_book_flutter_client/ui/home/day_tile.dart';

/// The tile that determines what to display depending on its position in the [CalenderOverview].
class CalenderTile extends StatefulWidget {
  final int pos;

  const CalenderTile({super.key, required this.pos});

  @override
  State<CalenderTile> createState() => _CalenderTileState();
}

class _CalenderTileState extends State<CalenderTile> {
  Map<int, String> posMap = {
    0: "M",
    1: "T",
    2: "W",
    3: "T",
    4: "F",
    5: "S",
    6: "S",
  };

  @override
  Widget build(BuildContext context) {
    return DayTile(content: posMap[widget.pos] ?? "");
  }
}
