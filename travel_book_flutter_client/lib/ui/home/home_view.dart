import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:travel_book_flutter_client/ui/home/calender/day_view.dart';
import 'package:travel_book_flutter_client/ui/home/calender/day_view_model.dart';
import 'package:travel_book_flutter_client/ui/home/calender_overview_list.dart';
import 'package:travel_book_flutter_client/ui/home/home_view_model.dart';

class HomeView extends StatefulWidget {
  final HomeViewModel viewModel;

  const HomeView({super.key, required this.viewModel});

  @override
  State<HomeView> createState() => _HomeViewState();
}

class _HomeViewState extends State<HomeView> {
  @override
  void initState() {
    super.initState();
    widget.viewModel.onChangeStartDate(DateTime.now());
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        OutlinedButton(
            onPressed: () async {
              final selection = await showDatePicker(
                  context: context,
                  firstDate: DateTime(2000),
                  lastDate: DateTime(3000),
                  helpText: "Select start date",
                  currentDate: widget.viewModel.state.value?.startDate,
                  initialDatePickerMode: DatePickerMode.year);

              if (selection != null) {
                widget.viewModel.onChangeStartDate(selection);
              }
            },
            child: const Text('Select start date')),
        ListenableBuilder(
          listenable: widget.viewModel.state,
          builder: (context, _) {
            final startDate = widget.viewModel.state.value?.startDate;
            final endDate = widget.viewModel.state.value?.endDate;
            final bookings =
                widget.viewModel.state.value?.bookingsSearchResult ?? [];
            print('$startDate - $endDate with ${bookings.length} length');
            return CalenderOverviewList(
              startDate: startDate,
              endDate: endDate,
              rows: startDate != null && endDate != null
                  ? widget.viewModel.getCalenderRows(
                      startDate: startDate,
                      endDate: endDate,
                      bookingList: bookings,
                      onSelectDate: (selectedDate) {
                        Navigator.push(
                            context,
                            MaterialPageRoute<void>(
                              builder: (context) => DayView(
                                day: selectedDate,
                                // TODO get booking repo here
                                dayViewModel: DayViewModel(
                                    bookingRepository: context.read(),
                                    selectedDate: selectedDate),
                              ),
                            ));
                        // TODO open details page
                      })
                  : [],
            );
          },
        ),
      ],
    );
  }
}
