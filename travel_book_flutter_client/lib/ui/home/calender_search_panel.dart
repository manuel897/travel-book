import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/home_view_model.dart';

import 'calender/models/month.dart';

class CalenderSearchPanel extends StatefulWidget {
  final HomeViewModel homeViewModel;

  const CalenderSearchPanel({super.key, required this.homeViewModel});

  @override
  State<CalenderSearchPanel> createState() => _CalenderSearchPanelState();
}

class _CalenderSearchPanelState extends State<CalenderSearchPanel> {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    var monthCode = widget.homeViewModel.state.value?.startDate.month;
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Card(
        color: Theme.of(context).colorScheme.secondaryContainer,
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Form(
            key: _formKey,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceAround,
              children: [
                DropdownMenu<Month>(
                    onSelected: (m) => widget.homeViewModel.onChangeMonth(m),
                    initialSelection:
                        monthCode != null ? Month.fromCode(monthCode) : null,
                    label: const Text("Month"),
                    dropdownMenuEntries: Month.values
                        .map((m) => DropdownMenuEntry(label: m.label, value: m))
                        .toList()),
                DropdownMenu<int>(
                    onSelected: (y) => widget.homeViewModel.onChangeYear(y),
                    initialSelection:
                        widget.homeViewModel.state.value?.startDate.year,
                    label: const Text("Year"),
                    dropdownMenuEntries: List<int>.generate(10, (i) => 2025 + i)
                        .map((y) =>
                            DropdownMenuEntry(value: y, label: y.toString()))
                        .toList())
              ],
            ),
          ),
        ),
      ),
    );
  }
}
