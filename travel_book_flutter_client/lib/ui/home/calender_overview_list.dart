import 'package:flutter/material.dart';

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
    return Expanded(
      child: SingleChildScrollView(
          child: Column(
        children: [
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
