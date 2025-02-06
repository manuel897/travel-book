import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/data/local_repository_impl.dart';

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
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
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
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'Hello world',
            ),
            ElevatedButton(
              onPressed: () => _insertDummyData(),
              child: const Text('Add data'),
            ),
            ElevatedButton(
              onPressed: () => _removeDummyData(),
              child: const Text('Remove data'),
            )
          ],
        ),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }

  _insertDummyData() {
    final db = LocalRepositoryImpl();
    db.save({"day_1": "monday"});
  }

  _removeDummyData() {
    final db = LocalRepositoryImpl();
    db.deleteValue(key: "da y_1");
  }
}
