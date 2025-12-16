import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/data/booking/booking_repository.dart';
import 'package:travel_book_flutter_client/ui/home/home_ui_state.dart';

class HomeViewModel extends ChangeNotifier {
  final BookingRepository bookingRepository;

  HomeViewModel(this.bookingRepository) {
    final today = DateTime.now();
    _state = HomeUiState(startDate: today, endDate: _getLastDayOfMonth(today));
  }

  HomeUiState? _state;

  HomeUiState? get state => _state;

  /// Get rows to display in the calender list view based on the
  List<DataRow> getCalenderRows({required DateTime startDate}) {
    final daysOfMonthCount = DateTimeRange(
            start: DateTime(startDate.year, startDate.month),
            end: DateTime(startDate.year, startDate.month + 1))
        .duration
        .inDays;
    final today = DateTime.now();
    final isCurrentMonthSelected =
        today.month == startDate.month && today.year == startDate.year;
    final List<DataRow> rows = [];

    for (var i = 1; i <= daysOfMonthCount; i++) {
      final date = DateTime(startDate.year, startDate.month, i);

      rows.add(DataRow(
          color: WidgetStateProperty.resolveWith<Color?>((Set<WidgetState> s) {
            if (isCurrentMonthSelected && i == today.day) {
              return Colors.grey;
            }

            // no color by default
            return null;
          }),
          cells: [
            DataCell(
              Text("${date.day}/${date.month}/${date.year}"),
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

  onChangeStartDate(DateTime startDate) {
    _state = _state?.copyWith(
        startDate: startDate, endDate: _getLastDayOfMonth(startDate));
    notifyListeners();
  }

  /// Returns last day of [day]'s month.
  DateTime _getLastDayOfMonth(DateTime day) {
    final firstDayOfNextMonth = DateTime(day.year, day.month + 1);
    return firstDayOfNextMonth.subtract(Duration(days: 1));
  }
}
