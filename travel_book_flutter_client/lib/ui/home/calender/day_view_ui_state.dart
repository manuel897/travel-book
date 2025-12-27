import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

part 'day_view_ui_state.freezed.dart';

@freezed
class DayViewUiState with _$DayViewUiState {
  const factory DayViewUiState(
      {required DateTime selectedDate,
      required List<BookingModel> bookingsSearchResult}) = _DayViewUiState;
}
