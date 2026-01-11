import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/calender_tile.dart';

import '../core/shared.dart';

class CalenderOverviewGrid extends StatefulWidget {
  const CalenderOverviewGrid({super.key});

  @override
  State<CalenderOverviewGrid> createState() => _CalenderOverviewGridState();
}

class _CalenderOverviewGridState extends State<CalenderOverviewGrid> {
  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    return GridView.builder(
      primary: false,
      padding: const EdgeInsets.all(20),
      itemCount: screenSize.width > maxMobileScreenSize ? 35 : 20,
      itemBuilder: (_, i) => CalenderTile(pos: i),
      gridDelegate:
          const SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 7),
    );
  }
}
