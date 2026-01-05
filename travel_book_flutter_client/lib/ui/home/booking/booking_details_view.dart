import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';
import 'package:travel_book_flutter_client/utils/date_utils.dart';

class BookingDetailsView extends StatelessWidget {
  final BookingModel booking;

  const BookingDetailsView({super.key, required this.booking});

  @override
  Widget build(BuildContext context) {
    return Column(children: [
      Padding(
        padding: const EdgeInsets.all(8.0),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.spaceAround,
          children: [
            Expanded(
              child: Align(
                alignment: Alignment.centerLeft,
                child: IconButton.outlined(
                  color: Theme.of(context).colorScheme.primary,
                  icon: const Icon(Icons.arrow_back_rounded),
                  onPressed: () => Navigator.pop(context),
                ),
              ),
            ),
            Text(
              formatDate(booking.startDate),
              style: Theme.of(context).textTheme.titleLarge,
            ),
            const Expanded(
              child: SizedBox(),
            ),
          ],
        ),
      ),
      SingleChildScrollView(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          SizedBox(
            height: 70,
            // width: constraints.maxWidth,
            child: Text(booking.departure),
          )
        ],
      )),
    ]);
  }
}
