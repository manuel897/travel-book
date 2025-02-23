import 'package:travel_book_flutter_client/domain/navigation_presenter.dart'
    show NavigationPresenter;
import 'package:travel_book_flutter_client/domain/user/user_presenter.dart';
import 'package:travel_book_flutter_client/domain/user/user_repository.dart';

class UserLogin {
  final UserRepository _userRepository;
  final NavigationPresenter _navigationPresenter;
  final UserPresenter _userPresenter;

  UserLogin(
      {required UserRepository userRepository,
      required NavigationPresenter navigationPresenter,
      required UserPresenter userPresenter})
      : _userRepository = userRepository,
        _navigationPresenter = navigationPresenter,
        _userPresenter = userPresenter;

  call() {
    if (_userRepository.isUserLoggedIn()) {
      _userPresenter.presentUserIsLoggedIn();
      _navigationPresenter.presentDriverHomeScreen();
    }

    if (!_userRepository.isUserLoggedIn()) {
      _navigationPresenter.presentLoginScreen();
    }
  }
}
