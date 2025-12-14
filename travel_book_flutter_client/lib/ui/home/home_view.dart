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
  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Placeholder(), // TODO filter
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
