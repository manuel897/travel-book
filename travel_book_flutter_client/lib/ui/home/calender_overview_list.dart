import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/date_range_row.dart';

class CalenderOverviewList extends StatefulWidget {
  final DateTime? startDate;
  final DateTime? endDate;
  final List<DataRow> rows;

  const CalenderOverviewList(
      {super.key,
      required this.rows,
      required this.startDate,
      required this.endDate});

  @override
  State<CalenderOverviewList> createState() => _CalenderOverviewListState();
}

class _CalenderOverviewListState extends State<CalenderOverviewList> {
  @override
  Widget build(BuildContext context) {
    print('calnderOverviewViewModel.build()');
    final start = widget.startDate;
    final end = widget.endDate;

    return Expanded(
      child: SingleChildScrollView(
          child: Column(
        children: [
          if (start != null && end != null)
            DateRangeRow(startDate: start, endDate: end),
          DataTable(
            columns: const [
              DataColumn(label: Text("DATE")),
              DataColumn(label: Text("DAY")),
              DataColumn(label: Text("BOOKINGS")),
            ],
            rows: widget.rows,
          ),
        ],
      )),
    );
  }
}
