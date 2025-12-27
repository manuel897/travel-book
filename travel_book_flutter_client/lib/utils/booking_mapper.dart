import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/data/booking/booking.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

class BookingMapper {
  BookingModel createBookingModel(Booking b) {
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
}
