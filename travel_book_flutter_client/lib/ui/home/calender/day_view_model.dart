import 'package:flutter/cupertino.dart';
import 'package:travel_book_flutter_client/data/booking/booking_repository.dart';
import 'package:travel_book_flutter_client/ui/home/calender/day_view_ui_state.dart';
import 'package:travel_book_flutter_client/utils/booking_mapper.dart';

class DayViewModel extends ChangeNotifier {
  final BookingRepository _bookingRepository;
  final ValueNotifier<DayViewUiState?> _state;

  ValueNotifier<DayViewUiState?> get state => _state;

  DayViewModel(
      {required BookingRepository bookingRepository,
      required DateTime selectedDate})
      : _bookingRepository = bookingRepository,
        _state = ValueNotifier(DayViewUiState(
            selectedDate: selectedDate, bookingsSearchResult: []));

  Future<void> onChangeSelectedDate(DateTime date) async {
    final bookingList =
        (await _bookingRepository.findBookingsInRange(start: date))
            .map((b) => BookingMapper().createBookingModel(b))
            .toList();

    _state.value = _state.value
        ?.copyWith(selectedDate: date, bookingsSearchResult: bookingList);
  }
}
