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
    final now = DateTime.now();
    return Column(
      children: [
        Placeholder(), // TODO filter
        CalenderOverviewList(
          rows: widget.viewModel
              .getCalenderRows(year: now.year, month: now.month),
        ),
      ],
    );
  }
}
