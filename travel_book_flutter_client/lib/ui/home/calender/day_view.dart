import 'package:flutter/material.dart';

class DayView extends StatelessWidget {
  final DateTime day;

  const DayView({super.key, required this.day});

  @override
  Widget build(BuildContext context) {
    return Column(children: [
      OutlinedButton(
          onPressed: () => Navigator.pop(context),
          child: const Text("Back to Home")),
      Text(day.toString()),
      Card()
    ]);
  }
}
