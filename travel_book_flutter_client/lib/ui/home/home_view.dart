import 'package:flutter/material.dart';
import 'package:travel_book_flutter_client/ui/home/calender_overview_grid.dart';

class HomeView extends StatefulWidget {
  const HomeView({super.key});

  @override
  State<HomeView> createState() => _HomeViewState();
}

class _HomeViewState extends State<HomeView> {
  @override
  Widget build(BuildContext context) {
    return CalenderOverviewGrid();
  }
}
