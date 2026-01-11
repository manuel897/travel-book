import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:travel_book_flutter_client/ui/booking/booking_model.dart';

part 'home_ui_state.freezed.dart';

@freezed
class HomeUiState with _$HomeUiState {
  const factory HomeUiState(
      {required DateTime startDate,
      DateTime? endDate,
      required List<BookingModel> bookingsSearchResult}) = _HomeUiState;
}
