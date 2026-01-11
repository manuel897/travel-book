import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';
import 'package:travel_book_flutter_client/data/booking/booking_repository.dart';
import 'package:travel_book_flutter_client/data/booking/booking_service.dart';
import 'package:travel_book_flutter_client/ui/core/app_color_theme.dart';
import 'package:travel_book_flutter_client/ui/core/app_section.dart';
import 'package:travel_book_flutter_client/ui/core/scaffold_wIth_navigation.dart';
import 'package:travel_book_flutter_client/ui/home/home_view.dart';
import 'package:travel_book_flutter_client/ui/home/home_view_model.dart';
import 'package:travel_book_flutter_client/ui/user/user_view.dart';

void main() {
  // debugPaintSizeEnabled = true;
  runApp(MultiProvider(providers: [
    Provider(create: (context) => BookingService()),
    Provider(
        create: (context) => BookingRepository(bookingService: context.read())),
    ChangeNotifierProvider(
        create: (context) => HomeViewModel(bookingRepository: context.read())),
  ], child: MyApp()));
}

final _router = GoRouter(initialLocation: AppSection.home.path, routes: [
  ShellRoute(
      builder: (_, __, child) => ScaffoldWithNavigation(screen: child),
      routes: <RouteBase>[
        GoRoute(
          path: AppSection.home.path,
          builder: (context, _) => HomeView(
            viewModel: context.read(),
          ),
        ),
        GoRoute(
          path: AppSection.user.path,
          builder: (_, __) => const UserView(),
        ),
      ]),
]);

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp.router(
      title: 'Travel Book',
      themeMode: ThemeMode.dark,
      darkTheme: ThemeData(
          brightness: Brightness.dark,
          colorScheme: darkColorScheme,
          textTheme: professionalTextTheme,
          useMaterial3: true),
      routerConfig: _router,
    );
  }
}
