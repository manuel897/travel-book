import 'dart:ui';

import 'package:freezed_annotation/freezed_annotation.dart';

part 'booking_model.freezed.dart';

@freezed
class BookingModel with _$BookingModel {
  const factory BookingModel({
    required DateTime startDate,
    required DateTime endDate,
    required String numberPlate,
    required String departure,
    required String arrival,
    required String title,
    String? description,
    required String firstDriverName,
    String? secondDriverName,
    required DateTime lastModifiedAt,
    double? initialQuote,
    double? plannedDistance,
    required String currency,
    required String distanceUnit,
    required Color statusColor,
    required String statusText,
  }) = _BookingModel;
}
