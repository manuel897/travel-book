import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:travel_book_flutter_client/ui/core/app_section.dart';

class ScaffoldWithNavigation extends StatefulWidget {
  final Widget screen;

  const ScaffoldWithNavigation({super.key, required this.screen});

  @override
  State<ScaffoldWithNavigation> createState() => _ScaffoldWithNavigationState();
}

class _ScaffoldWithNavigationState extends State<ScaffoldWithNavigation> {
  AppSection _selected = AppSection.home;

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    return Scaffold(
        body: Row(
          children: [
            if (screenSize.width > 600)
              NavigationRail(
                  onDestinationSelected: (i) => _openScreen(i, context),
                  destinations: <NavigationRailDestination>[
                    NavigationRailDestination(
                        icon: Icon(AppSection.home.icon),
                        label: Text(AppSection.home.label)),
                    NavigationRailDestination(
                        icon: Icon(AppSection.user.icon),
                        label: Text(AppSection.user.label)),
                  ],
                  selectedIndex: _selected.index),
            widget.screen,
          ],
        ),
        bottomNavigationBar: screenSize.width <= 600
            ? BottomNavigationBar(
                currentIndex: _selected.index,
                items: <BottomNavigationBarItem>[
                  BottomNavigationBarItem(
                    icon: Icon(AppSection.home.icon),
                    label: AppSection.home.label,
                  ),
                  BottomNavigationBarItem(
                    icon: Icon(AppSection.user.icon),
                    label: AppSection.user.label,
                  ),
                ],
                onTap: (i) {
                  _openScreen(i, context);
                },
              )
            : null);
  }

  void _openScreen(int i, BuildContext context) {
    final section = _getAppSection(i);
    setState(() {
      _selected = section;
    });
    context.go(section.path);
  }

  AppSection _getAppSection(int i) {
    assert(i < AppSection.values.length, "App section not found");

    return AppSection.values.firstWhere((e) => e.index == i);
  }
}
