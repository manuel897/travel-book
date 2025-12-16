import 'package:flutter/material.dart';

class DateRangeRow extends StatelessWidget {
  final DateTime startDate;
  final DateTime endDate;

  const DateRangeRow({
    super.key,
    required this.startDate,
    required this.endDate,
  });

  String _formatDate(DateTime date) {
    return "${date.day}/${date.month}/${date.year}";
  }

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        // End date on the left
        Text(
          _formatDate(endDate),
          style: Theme.of(context).textTheme.titleLarge,
        ),

        Text(
          "-",
          style: Theme.of(context).textTheme.titleLarge,
        ),

        // Start date on the right
        Text(
          _formatDate(startDate),
          style: Theme.of(context).textTheme.titleLarge,
        ),
      ],
    );
  }
}
