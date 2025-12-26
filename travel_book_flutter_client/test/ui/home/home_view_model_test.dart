import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:travel_book_flutter_client/ui/home/home_view_model.dart';

import '../../builder/booking_model_builder.dart';
import '../../doubles/booking_repository_stub.dart';

void main() {
  group("HomeViewModel", () {
    BookingRepositoryStub bookingRepository = BookingRepositoryStub();
    HomeViewModel homeViewModel = HomeViewModel(bookingRepository);

    setUpAll(() {
      bookingRepository = BookingRepositoryStub();
    });

    group(".getCalenderRows()", () {
      setUp(() {
        homeViewModel = HomeViewModel(bookingRepository);
      });

      test("when start date is 1 Dec 2025 then 31 rows are returned", () {
        final result = homeViewModel.getCalenderRows(
            startDate: DateTime(2025, 12, 1),
            endDate: DateTime(0),
            bookingList: []);
        expect(result.length, 31);
      });

      test(
          "when start date is 1 Dec 2025 and 1 booking is exists for that day, then row of 1 Dec indicates 1 booking found",
          () {
        final result = homeViewModel.getCalenderRows(
            startDate: DateTime(2025, 12, 1),
            endDate: DateTime(0),
            bookingList: [buildBookingModel(startDate: DateTime(2025, 12, 1))]);

        final DataRow? dayRow = result
            .where((r) => (r.cells.first.child as Text).data == "1/12/2025")
            .firstOrNull;

        expect(dayRow?.cells.length, 3);
        expect((dayRow?.cells[2].child as Text).data, "1 BOOKING(S) FOUND.");
      });
    });
  });
}
