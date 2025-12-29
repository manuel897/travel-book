import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

class BookingTile extends StatelessWidget {
  final BookingModel booking;

  BookingTile({super.key, required this.booking});

  @override
  Widget build(BuildContext context) {
    return Card(
      color: Colors.black38,
      child: Expanded(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          children: [
            Text(booking.departure),
            const Text("-"),
            Text(booking.arrival),
          ],
        ),
      ),
    );
  }
}
