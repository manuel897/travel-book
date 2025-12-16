import 'package:travel_book_flutter_client/data/booking/booking.dart';
import 'package:travel_book_flutter_client/data/booking/booking_service.dart';

class BookingRepository {
  final BookingService _bookingService;

  BookingRepository({required BookingService bookingService})
      : _bookingService = bookingService;

  Future<List<Booking>> findBookingInRange(
      {required DateTime start, DateTime? end}) async {
    return _bookingService.findBookingInRange(start: start, end: end);
  }
}
