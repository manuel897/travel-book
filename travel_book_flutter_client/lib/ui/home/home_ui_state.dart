import 'package:freezed_annotation/freezed_annotation.dart';

part 'home_ui_state.freezed.dart';

@freezed
class HomeUiState with _$HomeUiState {
  const factory HomeUiState(
      {required int selectedYear, required int selectedMonth}) = _HomeUiState;
}
