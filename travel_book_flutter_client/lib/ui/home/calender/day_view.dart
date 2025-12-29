import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/calender/booking_tile.dart';
import 'package:travel_book_flutter_client/ui/home/calender/day_view_model.dart';

class DayView extends StatefulWidget {
  final DateTime day;
  final DayViewModel dayViewModel;

  DayView({super.key, required this.day, required this.dayViewModel});

  @override
  State<DayView> createState() => _DayViewState();
}

class _DayViewState extends State<DayView> {
  @override
  void initState() {
    super.initState();
    widget.dayViewModel.onChangeSelectedDate(widget.day);
  }

  @override
  Widget build(BuildContext context) {
    return Column(children: [
      OutlinedButton(
          onPressed: () => Navigator.pop(context),
          child: const Text("Back to Home")),
      Text(widget.day.toString()),
      ListenableBuilder(
          listenable: widget.dayViewModel.state,
          builder: (context, _) {
            return LayoutBuilder(builder: (context, constraints) {
              return SingleChildScrollView(
                  child: ConstrainedBox(
                constraints: BoxConstraints(minWidth: constraints.maxWidth),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    ...(widget.dayViewModel.state.value?.bookingsSearchResult ??
                            [])
                        .map((b) {
                      return Container(
                        constraints:
                            BoxConstraints(maxWidth: constraints.maxWidth),
                        child: SizedBox(
                          height: 70,
                          // width: constraints.maxWidth,
                          child: BookingTile(
                            booking: b,
                          ),
                        ),
                      );
                    }),
                  ],
                ),
              ));
            });
          }),
    ]);
  }
}
