import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/repositories/local_repository.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Travel Book',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Travel Book Home Page'),
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
  Widget build(BuildContext context) {
    var screenSize = MediaQuery.of(context).size;
    var orientation = MediaQuery.of(context).orientation;

    return Scaffold(
        body: LayoutBuilder(
          builder: (context, _) {
            return (screenSize.width > 600)
                ? Row(
                    children: <Widget>[
                      NavigationRail(
                        destinations: const <NavigationRailDestination>[
                          NavigationRailDestination(
                            icon: Icon(Icons.calendar_month_sharp),
                            label: Text('Calender'),
                          ),
                          NavigationRailDestination(
                            icon: Icon(Icons.account_box),
                            label: Text('User'),
                          )
                        ],
                        selectedIndex: 0,
                        onDestinationSelected: (i) {
                          // TODO: navigate to screen go_router
                        },
                      ),
                      const VerticalDivider(
                        thickness: 1,
                        width: 1,
                      ),
                      const Placeholder(),
                    ],
                  )
                : Placeholder();
          },
        ),
        bottomNavigationBar: screenSize.width <= 600
            ? BottomNavigationBar(
                currentIndex: 0,
                items: const <BottomNavigationBarItem>[
                  BottomNavigationBarItem(
                    icon: Icon(Icons.calendar_month_sharp),
                    label: 'Calender',
                  ),
                  BottomNavigationBarItem(
                    icon: Icon(Icons.account_box),
                    label: 'User',
                  ),
                ],
              )
            : null);
  }

  _insertDummyData() {
    final db = LocalRepository();
    db.save({"day_1": "monday"});
  }

  _removeDummyData() {
    final db = LocalRepository();
    db.deleteValue(key: "day_1");
  }
}
