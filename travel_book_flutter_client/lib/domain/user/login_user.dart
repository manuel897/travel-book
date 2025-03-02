import 'package:travel_book_flutter_client/domain/user/user_presenter.dart';
import 'package:travel_book_flutter_client/domain/user/user_repository.dart';

class LoginUser {
  final UserRepository _userRepository;
  final UserPresenter _userPresenter;

  LoginUser(
      {required UserRepository userRepository,
      required UserPresenter userPresenter})
      : _userRepository = userRepository,
        _userPresenter = userPresenter;

  call() async {
    final isLoggedIn = await _userRepository.isUserLoggedIn();

    if (isLoggedIn) {
      _userPresenter.presentUserIsLoggedIn();
    }

    if (!isLoggedIn) {
      _userPresenter.presentUserNotLoggedIn();
    }
  }
}
