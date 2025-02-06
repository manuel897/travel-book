import 'package:travel_book_flutter_client/domain/user/login_user.dart';

class UserController {
  final UserLogin _userLogin;

  UserController({required UserLogin userLogin}) : _userLogin = userLogin;

  void onOpenApp() {
    _userLogin();
  }
}
