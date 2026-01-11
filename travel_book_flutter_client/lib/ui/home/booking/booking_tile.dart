import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';
import 'package:travel_book_flutter_client/ui/home/booking/booking_details_view.dart';

class BookingTile extends StatelessWidget {
  final BookingModel booking;

  const BookingTile({super.key, required this.booking});

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        Navigator.push(
            context,
            MaterialPageRoute<void>(
              builder: (context) => BookingDetailsView(booking: booking),
            ));
      },
      child: Card(
        shape: RoundedRectangleBorder(
          borderRadius: BorderRadius.circular(12),
          side: BorderSide(
            width: 3,
            color: booking.statusColor.withAlpha(100),
          ),
        ),
        color: Theme.of(context).colorScheme.secondaryContainer,
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
