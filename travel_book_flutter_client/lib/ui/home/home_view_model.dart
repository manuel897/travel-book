import 'package:flutter/material.dart';

class HomeViewModel {
  /// Get rows to display in the calender list view based on the
  List<DataRow> getCalenderRows({required int year, required int month}) {
    final daysOfMonth = DateTimeRange(
            start: DateTime(year, month), end: DateTime(year, month + 1))
        .duration
        .inDays;
    final today = DateTime.now();
    final isCurrentMonthSelected = today.month == month;
    final List<DataRow> rows = [];

    for (var i = 1; i <= daysOfMonth; i++) {
      final date = DateTime(year, month, i);

      rows.add(DataRow(
          color: WidgetStateProperty.resolveWith<Color?>((Set<WidgetState> s) {
            if (isCurrentMonthSelected && today.day == i) {
              return Colors.grey;
            }
          }),
          cells: [
            DataCell(
              Text(i.toString()),
            ),
            DataCell(Text(_getDayName(date.weekday))),
            const DataCell(Text("NO BOOKING FOUND.")),
          ]));
    }

    return rows;
  }

  String _getDayName(int weekday) {
    switch (weekday) {
      case 1:
        return "MON";
      case 2:
        return "TUE";
      case 3:
        return "WED";
      case 4:
        return "THU";
      case 5:
        return "FRI";
      case 6:
        return "SAT";
      case 7:
        return "SUN";
      default:
        return "-";
    }
  }
}
