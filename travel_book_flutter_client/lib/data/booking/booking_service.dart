import 'package:travel_book_flutter_client/data/booking/booking.dart';

class BookingService {
  Future<List<Booking>> findBy({required DateTime start, DateTime? end}) async {
    final now = DateTime.now();
    final today = DateTime(now.year, now.month, now.day);

    /// TODO remove placeholder
    final booking = Booking(
        name: "xyz - trip to place b",
        numberPlate: "ab 123",
        departure: 'place a',
        arrival: 'place b',
        unitLength: DistanceUnit.km,
        startTime: today,
        finishTime: today.add(const Duration(days: 3)),
        bookingStatusId: BookingStatus.confirmed,
        creatorId: 'creator a',
        lastModifiedAt: DateTime.now());
    final booking2 = Booking(
        name: "abc - trip to place d",
        numberPlate: "ba 123",
        departure: 'place c',
        arrival: 'place d',
        unitLength: DistanceUnit.km,
        startTime: today,
        finishTime: today.add(const Duration(days: 3)),
        bookingStatusId: BookingStatus.enquiry,
        creatorId: 'creator a',
        lastModifiedAt: DateTime.now());
    final booking3 = Booking(
        name: "abc - trip to place d",
        numberPlate: "ba 123",
        departure: 'place c',
        arrival: 'place d',
        unitLength: DistanceUnit.km,
        startTime: today,
        finishTime: today.add(const Duration(days: 3)),
        bookingStatusId: BookingStatus.rejected,
        creatorId: 'creator a',
        lastModifiedAt: DateTime.now());
    return [booking, booking2, booking3];
  }
}
