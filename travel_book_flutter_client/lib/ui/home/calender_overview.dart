import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/day_tile.dart';

class CalenderOverview extends StatefulWidget {
  const CalenderOverview({super.key});

  @override
  State<CalenderOverview> createState() => _CalenderOverviewState();
}

class _CalenderOverviewState extends State<CalenderOverview> {
  @override
  Widget build(BuildContext context) {
    return GridView.builder(
      primary: false,
      padding: const EdgeInsets.all(20),
      itemCount: 30,
      itemBuilder: (_, i) => DayTile(day: i + 1),
      gridDelegate:
          const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 7),
    );
  }
}
