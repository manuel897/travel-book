import 'package:flutter/material.dart';

class DayTile extends StatelessWidget {
  final int day;
  final bool isSelected;

  const DayTile({super.key, required this.day, this.isSelected = false});

  @override
  Widget build(BuildContext context) {
    return GridTile(
      child: Container(
        margin: const EdgeInsets.all(2.0),
        padding: const EdgeInsets.all(2.0),
        color: isSelected ? Colors.teal[500] : Colors.teal[100],
        child: Center(
            child: Text(
          day.toString(),
          style: const TextStyle(fontSize: 20),
        )),
      ),
    );
  }
}
