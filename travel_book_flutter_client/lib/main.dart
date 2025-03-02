import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:travel_book_flutter_client/data/local_repository_impl.dart';
import 'package:travel_book_flutter_client/data/user_repository_impl.dart';
import 'package:travel_book_flutter_client/domain/local_repository.dart';
import 'package:travel_book_flutter_client/domain/user/login_user.dart';
import 'package:travel_book_flutter_client/domain/user/user_presenter.dart';
import 'package:travel_book_flutter_client/domain/user/user_repository.dart';
import 'package:travel_book_flutter_client/ui/user_presenter_impl.dart';
import 'package:travel_book_flutter_client/ui/user_state.dart';
import 'package:travel_book_flutter_client/ui/user_state_notifier.dart';

void main() {
  runApp(MultiProvider(
    providers: [
      // -- repositories --
      Provider<LocalRepository>(create: (_) => LocalRepositoryImpl()),
      Provider<UserRepository>(create: (_) => UserRepositoryImpl()),

      ChangeNotifierProvider(
          create: (_) => UserStateNotifier(
                const UserState(isLoggedIn: false),
              ))
    ],
    child: const MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  final ColorScheme c = const ColorScheme(
    brightness: Brightness.dark, // Change to Brightness.dark for dark mode
    primary: Color(0xFF595959), // A vibrant blue
    onPrimary: Colors.red, // Text/icon color on primary
    secondary: Color(0xFFFF9500), // A warm orange
    onSecondary: Colors.green, // Text/icon color on secondary

    // surface: Color(0xFF4B4B4A),
    surface: Color(0xFFCACDC5),
    onSurface: Color(0xFF04090D), // Text/icon color on surface
    error: Color(0xFFFF3B30), // A bold red for errors
    onError: Colors.white, // Text/icon color on error
  );

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Travel Book',
      theme: ThemeData(
        colorScheme: c,
        useMaterial3: true,
      ),
      home: MultiProvider(providers: [
        // -- presenters --
        Provider<UserPresenter>(
          create: (ctx) => UserPresenterImpl(
            context: ctx,
            userStateNotifier: ctx.read(),
          ),
        ),

        /// -- use cases --
        Provider(
          create: (ctx) => LoginUser(
            userRepository: ctx.read(),
            userPresenter: ctx.read(),
          ),
        )
      ], child: const MyHomePage(title: 'Flutter Demo Home Page')),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    final loginUser = context.read<LoginUser>();

    return Scaffold(
        body: FutureBuilder(
            future: loginUser(),
            builder: (_, __) {
              return const Text("Loading");
            }) // This trailing comma makes auto-formatting nicer for build methods.
        );
  }
}
