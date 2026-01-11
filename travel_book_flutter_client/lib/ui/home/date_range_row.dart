import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/utils/date_utils.dart';

class DateRangeRow extends StatelessWidget {
  final DateTime startDate;
  final DateTime endDate;

  const DateRangeRow({
    super.key,
    required this.startDate,
    required this.endDate,
  });

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        // End date on the left
        Text(
          formatDate(startDate),
          style: Theme.of(context).textTheme.titleLarge,
        ),

        Text(
          "-",
          style: Theme.of(context).textTheme.titleLarge,
        ),

        // Start date on the right
        Text(
          formatDate(endDate),
          style: Theme.of(context).textTheme.titleLarge,
        ),
      ],
    );
  }
}
