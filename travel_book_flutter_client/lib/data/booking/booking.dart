import 'package:freezed_annotation/freezed_annotation.dart';

part 'booking.freezed.dart';

@freezed
class Booking with _$Booking {
  const factory Booking({
    int? externalId,
    required String name,
    String? notes,
    required String numberPlate,
    required String departure,
    required String arrival,
    double? plannedDistance,
    required DistanceUnit unitLength,
    required DateTime startTime,
    required DateTime finishTime,
    required BookingStatus bookingStatusId,
    String? firstDriveId,
    String? secondDriverId,
    required String creatorId,
    required DateTime lastModifiedAt,
    double? initialQuote,
  }) = _Booking;
}

enum BookingStatus {
  enquiry(statusId: 0, label: "enquiry"),
  confirmed(statusId: 1, label: "confirmed"),
  rejected(statusId: 2, label: "rejected");

  const BookingStatus({required this.statusId, required this.label});

  final int statusId;
  final String label;
}

enum DistanceUnit {
  km;
}
