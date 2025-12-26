import 'package:travel_book_flutter_client/data/booking/booking.dart';
import 'package:travel_book_flutter_client/data/booking/booking_repository.dart';

class BookingRepositoryDummy implements BookingRepository {
  @override
  Future<List<Booking>> findBookingsInRange(
      {required DateTime start, DateTime? end}) async {
    return [];
  }
}
