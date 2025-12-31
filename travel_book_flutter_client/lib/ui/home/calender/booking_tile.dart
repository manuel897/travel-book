import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

class BookingTile extends StatelessWidget {
  final BookingModel booking;

  const BookingTile({super.key, required this.booking});

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Theme.of(context).colorScheme.secondaryContainer,
      child: Expanded(
        child: Padding(
          padding: const EdgeInsets.only(left: 8.0, right: 0.8),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              Text(
                booking.departure,
                style: Theme.of(context).textTheme.titleMedium,
              ),
              const Text("-"),
              Text(
                booking.arrival,
                style: Theme.of(context).textTheme.titleMedium,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
