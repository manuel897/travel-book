import 'dart:collection';

import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/data/booking/booking_repository.dart';
import 'package:travel_book_flutter_client/ui/home/home_ui_state.dart';

import '../../data/booking/booking.dart';
import '../booking/booking_model.dart';

class HomeViewModel extends ChangeNotifier {
  final BookingRepository bookingRepository;
  final ValueNotifier<HomeUiState?> _state;

  ValueNotifier<HomeUiState?> get state => _state;

  HomeViewModel(this.bookingRepository)
      : _state = ValueNotifier(HomeUiState(
          startDate: DateTime.now(),
          bookingsSearchResult: [],
        ));

  /// Get rows to display in the calender list view based on the
  List<DataRow> getCalenderRows({
    required DateTime startDate,
    required DateTime endDate,
    required List<BookingModel> bookingList,
    required void Function(DateTime selectedDate) onSelectDate,
  }) {
    final daysOfStartMonthCount = DateTimeRange(
            start: DateTime(startDate.year, startDate.month),
            end: DateTime(startDate.year, startDate.month + 1))
        .duration
        .inDays;
    final today = DateTime.now();
    final isCurrentMonthSelected =
        today.month == startDate.month && today.year == startDate.year;

    final HashMap<DateTime, List<BookingModel>> bookingPerStartDate = HashMap();
    for (final b in bookingList) {
      final alreadyAddedBooking = bookingPerStartDate[b.startDate];

      if (alreadyAddedBooking != null && alreadyAddedBooking.isNotEmpty) {
        final bookingList = [...alreadyAddedBooking, b];
        bookingPerStartDate[b.startDate] = bookingList;
      }

      if (alreadyAddedBooking == null) {
        bookingPerStartDate[b.startDate] = [b];
      }
    }

    final List<DataRow> rows = [];

    for (var i = 1; i <= daysOfStartMonthCount; i++) {
      final date = DateTime(startDate.year, startDate.month, i);
      final bookingListForDay = bookingPerStartDate[date];
      final String bookingCellText =
          _getBookingDescription(bookingListForDay ?? []);
      rows.add(DataRow(
          onSelectChanged: (isSelected) {
            if (isSelected != null && isSelected) onSelectDate(date);
          },
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
            DataCell(Text(bookingCellText)),
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

  Future<void> onChangeStartDate(DateTime startDate) async {
    final daysOfStartMonthCount = DateTimeRange(
            start: DateTime(startDate.year, startDate.month),
            end: DateTime(startDate.year, startDate.month + 1))
        .duration
        .inDays;

    // Load bookingList in selected date range
    final List<BookingModel> bookingList =
        (await bookingRepository.findBookingsInRange(
      start: startDate,
      end: DateTime(startDate.year, startDate.month, daysOfStartMonthCount),
    ))
            .map((b) => _createBookingModel(b))
            .toList();

    _state.value = _state.value?.copyWith(
        startDate: startDate,
        endDate: _getLastDayOfMonth(startDate),
        bookingsSearchResult: bookingList);
    notifyListeners();
  }

  /// Returns last day of [day]'s month.
  DateTime _getLastDayOfMonth(DateTime day) {
    final firstDayOfNextMonth = DateTime(day.year, day.month + 1);
    return firstDayOfNextMonth.subtract(const Duration(days: 1));
  }

  /// Returns color to display appropriate to the status
  Color _getStatusColorOfbookingListtatusId(int statusId) {
    switch (statusId) {
      case 0:
        return Colors.yellow;
      case 1:
        return Colors.green;
      case 2:
        return Colors.red;
      default:
        return Colors.grey;
    }
  }

  BookingModel _createBookingModel(Booking b) {
    return BookingModel(
        startDate: b.startTime,
        endDate: b.finishTime,
        numberPlate: b.numberPlate,
        departure: b.departure,
        arrival: b.arrival,
        title: b.name,
        firstDriverName: b.firstDriveId ?? "TBD",
        secondDriverName: b.secondDriverId,
        lastModifiedAt: b.lastModifiedAt,
        currency: "X",
        distanceUnit: b.unitLength.name,
        stausColor:
            _getStatusColorOfbookingListtatusId(b.bookingStatusId.statusId),
        statusText: b.bookingStatusId.label);
  }

  /// Returns a summary of all [bookingList] as a string
  String _getBookingDescription(List<BookingModel> bookingList) {
    return "${bookingList.length} BOOKING(S) FOUND.";
  }
}
