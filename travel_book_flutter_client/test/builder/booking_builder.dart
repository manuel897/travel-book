import 'package:travel_book_flutter_client/data/booking/booking.dart';

Booking buildBooking() => Booking(
    name: '',
    numberPlate: '',
    departure: '',
    arrival: '',
    unitLength: DistanceUnit.km,
    startTime: DateTime(0),
    finishTime: DateTime(0),
    bookingStatusId: BookingStatus.enquiry,
    creatorId: '',
    lastModifiedAt: DateTime(0));
