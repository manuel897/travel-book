import 'package:travel_book_flutter_client/domain/user/user_presenter.dart';
import 'package:travel_book_flutter_client/domain/user/user_repository.dart';

class UserLogin {
  final UserRepository _userRepository;
  final UserPresenter _userPresenter;

  UserLogin(
      {required UserRepository userRepository,
      required UserPresenter userPresenter})
      : _userRepository = userRepository,
        _userPresenter = userPresenter;

  call() {
    if (_userRepository.isUserLoggedIn()) {
      _userPresenter.presentUserIsLoggedIn();
    }

    if (!_userRepository.isUserLoggedIn()) {
      _userPresenter.presentLoginScreen();
    }
  }
}
