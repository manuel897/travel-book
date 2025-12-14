import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/calender_overview_list.dart';
import 'package:travel_book_flutter_client/ui/home/home_view_model.dart';

class HomeView extends StatefulWidget {
  final HomeViewModel viewModel;

  const HomeView({super.key, required this.viewModel});

  @override
  State<HomeView> createState() => _HomeViewState();
}

class _HomeViewState extends State<HomeView> {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        OutlinedButton(
            onPressed: () async {
              final year = await showDatePicker(
                  context: context,
                  firstDate: DateTime(2000),
                  lastDate: DateTime(3000),
                  helpText: "Select start year",
                  currentDate: widget.viewModel.state?.selectedYear != null
                      ? DateTime(widget.viewModel.state!.selectedYear)
                      : null,
                  initialDatePickerMode: DatePickerMode.year);

              if (year != null) widget.viewModel.onChangeYear(year.year);
            },
            child: const Text('Select year')),
        // TODO filter
        ListenableBuilder(
          listenable: widget.viewModel,
          builder: (context, _) {
            final year = widget.viewModel.state?.selectedYear;
            final month = widget.viewModel.state?.selectedMonth;
            return CalenderOverviewList(
              rows: month != null && year != null
                  ? widget.viewModel.getCalenderRows(year: year, month: month)
                  : [],
            );
          },
        ),
      ],
    );
  }
}
