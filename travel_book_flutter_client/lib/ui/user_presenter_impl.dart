import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/domain/user/user_presenter.dart';
import 'package:travel_book_flutter_client/ui/user/login_page.dart';
import 'package:travel_book_flutter_client/ui/user_state_notifier.dart';

class UserPresenterImpl implements UserPresenter {
  final BuildContext _context;
  final UserStateNotifier _stateNotifier;

  UserPresenterImpl({
    required BuildContext context,
    required UserStateNotifier userStateNotifier,
  })  : _context = context,
        _stateNotifier = userStateNotifier;

  @override
  void presentUserIsLoggedIn() {
    _stateNotifier.setIsUserLoggedIn(false);

    showDialog(
      context: _context,
      builder: (_) => const Text("User is logged in!"),
    );
  }

  @override
  void presentUserNotLoggedIn() {
    Navigator.push(
      _context,
      MaterialPageRoute(builder: (context) => const LoginPage()),
    );
  }
}
