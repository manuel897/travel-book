import 'package:flutter/cupertino.dart';
import 'package:travel_book_flutter_client/ui/user_state.dart';

class UserStateNotifier extends ValueNotifier<UserState> {
  UserStateNotifier(super.state);

  void setIsUserLoggedIn(bool isLoggedIn) {
    value = value.copyWith(isLoggedIn: isLoggedIn);
  }
}
