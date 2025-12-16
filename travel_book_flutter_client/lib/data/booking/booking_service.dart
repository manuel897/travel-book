import 'package:travel_book_flutter_client/data/booking/booking.dart';

class BookingService {
  Future<List<Booking>> findBookingInRange(
      {required DateTime start, DateTime? end}) async {
    /// placeholder
    final booking = Booking(
        name: "xyz - trip to place b",
        numberPlate: "ab 123",
        departure: 'placee a',
        arrival: 'place b',
        unitLength: DistanceUnit.km,
        startTime: DateTime.now(),
        finishTime: DateTime.now().add(const Duration(days: 3)),
        bookingStatusId: BookingStatus.enquiry,
        creatorId: 'creator a',
        lastModifiedAt: DateTime.now());
    return [booking];
  }
}
