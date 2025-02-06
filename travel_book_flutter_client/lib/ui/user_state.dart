class UserState {
  UserState({required bool isLoggedIn}) : _isLoggedIn = isLoggedIn;

  bool _isLoggedIn = false;

  bool get isLoggedIn => _isLoggedIn;

  UserState copyWith({required bool isLoggedIn}) =>
      UserState(isLoggedIn: isLoggedIn);
}
