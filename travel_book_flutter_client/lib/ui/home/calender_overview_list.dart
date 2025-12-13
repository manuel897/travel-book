import 'package:flutter/material.dart';

class CalenderOverviewList extends StatefulWidget {
  final List<DataRow> rows;

  const CalenderOverviewList({super.key, required this.rows});

  @override
  State<CalenderOverviewList> createState() => _CalenderOverviewListState();
}

class _CalenderOverviewListState extends State<CalenderOverviewList> {
  @override
  Widget build(BuildContext context) {
    return Expanded(
      child: SingleChildScrollView(
          child: DataTable(
        columns: const [
          DataColumn(label: Text("DATE")),
          DataColumn(label: Text("DAY")),
          DataColumn(label: Text("BOOKINGS")),
        ],
        rows: widget.rows,
      )),
    );
  }
}
