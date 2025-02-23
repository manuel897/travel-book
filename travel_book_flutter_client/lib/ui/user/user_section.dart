import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:travel_book_flutter_client/ui/user_state_notifier.dart';

class UserSection extends StatelessWidget {
  const UserSection({super.key});

  @override
  Widget build(BuildContext context) {
    final UserStateNotifier state = context.select((UserStateNotifier s) => s);

    return ValueListenableBuilder(
      valueListenable: state,
      builder: (_, userState, __) => Text(
        userState.isLoggedIn ? "user is logged in" : "user is not logged in",
      ),
    );
  }
}
