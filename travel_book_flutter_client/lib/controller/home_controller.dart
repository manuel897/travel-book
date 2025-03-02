import 'package:travel_book_flutter_client/domain/user/login_user.dart';

class UserController {
  final LoginUser _userLogin;

  UserController({required LoginUser userLogin}) : _userLogin = userLogin;

  void onOpenApp() {
    _userLogin();
  }
}
