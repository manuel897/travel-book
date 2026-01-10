import 'package:flutter/material.dart';
import 'package:timeline_tile/timeline_tile.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';
import 'package:travel_book_flutter_client/utils/date_utils.dart';

/// Detailed view of a round trip booking
class BookingDetailsView extends StatelessWidget {
  final BookingModel booking;

  const BookingDetailsView({super.key, required this.booking});

  @override
  Widget build(BuildContext context) {
    const keyTextStyle = TextStyle(color: Colors.grey);
    const valueTextStyle = TextStyle(fontWeight: FontWeight.bold);
    return Column(children: [
      Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          Expanded(
            child: Padding(
              padding: const EdgeInsets.all(8.0),
              child: Align(
                alignment: Alignment.centerLeft,
                child: IconButton.outlined(
                  color: Theme.of(context).colorScheme.primary,
                  icon: const Icon(Icons.arrow_back_rounded),
                  onPressed: () => Navigator.pop(context),
                ),
              ),
            ),
          ),
          Text(
            booking.title,
            style: Theme.of(context).textTheme.titleLarge,
          ),
          const Expanded(
            child: SizedBox(),
          ),
        ],
      ),
      SingleChildScrollView(
          child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Card(
          color: Theme.of(context).colorScheme.secondaryContainer,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            children: [
              TimelineTile(
                alignment: TimelineAlign.center,
                endChild: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                      alignment: Alignment.centerLeft,
                      child: Text(booking.departure.toUpperCase())),
                ),
                startChild: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                      alignment: Alignment.centerRight,
                      child: Text(formatDateTime(booking.startDate))),
                ),
                isFirst: true,
              ),
              TimelineTile(
                alignment: TimelineAlign.center,
                endChild: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                      alignment: Alignment.centerLeft,
                      child: Text(booking.arrival.toUpperCase())),
                ),
              ),
              TimelineTile(
                alignment: TimelineAlign.center,
                endChild: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                      alignment: Alignment.centerLeft,
                      child: Text(booking.departure.toUpperCase())),
                ),
                startChild: Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Align(
                      alignment: Alignment.centerRight,
                      child: Text(formatDateTime(booking.endDate))),
                ),
                isLast: true,
              ),
              Divider(
                height: 24,
                thickness: 1,
                indent: 16,
                endIndent: 16,
                color: Colors.grey.withAlpha(100),
              ),
              Padding(
                padding: const EdgeInsets.all(8.0),
                child: Table(
                  columnWidths: const <int, TableColumnWidth>{
                    0: IntrinsicColumnWidth(),
                    1: IntrinsicColumnWidth(),
                    // 2: FixedColumnWidth(64),
                  },
                  children: [
                    TableRow(
                      children: <Widget>[
                        Text(
                          "DETAILS",
                          style: Theme.of(context).textTheme.titleMedium,
                        ),
                        Container()
                      ],
                    ),
                    TableRow(
                      children: <Widget>[
                        const Text(
                          "Notes ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.notes ?? "-",
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: <Widget>[
                        const Text(
                          "Driver A ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.firstDriverName,
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: [
                        const Text(
                          "Driver B ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.secondDriverName ?? "-",
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: [
                        const Text(
                          "Number Plate ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.numberPlate,
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: [
                        const Text(
                          "Planned Distance ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.plannedDistance != null
                              ? "${booking.initialQuote.toString()} ${booking.distanceUnit}"
                              : "-",
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: [
                        const Text(
                          "Initial Quote ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.initialQuote != null
                              ? booking.initialQuote.toString()
                              : "-",
                          style: valueTextStyle,
                        )
                      ],
                    ),
                    TableRow(
                      children: [
                        const Text(
                          "Last Modified ",
                          style: keyTextStyle,
                        ),
                        Text(
                          booking.lastModifiedAt.toString(),
                          style: valueTextStyle,
                        )
                      ],
                    )
                  ],
                ),
              ),
            ],
          ),
        ),
      )),
    ]);
  }
}
