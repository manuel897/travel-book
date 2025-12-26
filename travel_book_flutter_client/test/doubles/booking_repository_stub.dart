import 'package:travel_book_flutter_client/data/booking/booking.dart';

import 'booking_repository_dummy.dart';

class BookingRepositoryStub extends BookingRepositoryDummy {
  List<Booking>? bookingsResult;
  DateTime? bookingResultStartDateTime;

  @override
  Future<List<Booking>> findBookingsInRange(
      {required DateTime start, DateTime? end}) async {
    if (bookingsResult == null || bookingResultStartDateTime == null) return [];

    if (start != bookingResultStartDateTime) return [];

    return bookingsResult ?? [];
  }
}
