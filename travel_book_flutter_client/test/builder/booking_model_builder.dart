import 'dart:ui';

import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

BookingModel buildBookingModel({DateTime? startDate}) => BookingModel(
    startDate: startDate ?? DateTime(0),
    endDate: DateTime(0),
    numberPlate: '',
    departure: '',
    arrival: '',
    title: '',
    firstDriverName: '',
    lastModifiedAt: DateTime(0),
    currency: '',
    distanceUnit: '',
    stausColor: const Color(0),
    statusText: '');
