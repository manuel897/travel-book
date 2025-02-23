import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/domain/navigation_presenter.dart';

class NavigationPresenterImpl implements NavigationPresenter {
  final BuildContext _context;

  NavigationPresenterImpl({required BuildContext context}) : _context = context;

  @override
  void presentLoginScreen() {
    // TODO: navigate to login screen
  }

  @override
  void presentDriverHomeScreen() {
    // TODO: implement presentDriverHomeScreen
  }
}
