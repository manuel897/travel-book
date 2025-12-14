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
              final selection = await showDatePicker(
                  context: context,
                  firstDate: DateTime(2000),
                  lastDate: DateTime(3000),
                  helpText: "Select start date",
                  currentDate: widget.viewModel.state?.startDate != null
                      ? widget.viewModel.state!.startDate
                      : null,
                  initialDatePickerMode: DatePickerMode.year);

              if (selection != null) {
                widget.viewModel.onChangeStartDate(selection);
              }
            },
            child: const Text('Select start date')),
        // TODO filter
        ListenableBuilder(
          listenable: widget.viewModel,
          builder: (context, _) {
            final startDate = widget.viewModel.state?.startDate;
            final endDate = widget.viewModel.state?.endDate;
            return CalenderOverviewList(
              startDate: startDate,
              endDate: endDate,
              rows: startDate != null
                  ? widget.viewModel.getCalenderRows(startDate: startDate)
                  : [],
            );
          },
        ),
      ],
    );
  }
}
