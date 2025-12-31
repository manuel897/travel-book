import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:travel_book_flutter_client/ui/core/app_section.dart';
import 'package:travel_book_flutter_client/ui/core/shared.dart';

class ScaffoldWithNavigation extends StatefulWidget {
  final Widget screen;

  const ScaffoldWithNavigation({super.key, required this.screen});

  @override
  State<ScaffoldWithNavigation> createState() => _ScaffoldWithNavigationState();
}

class _ScaffoldWithNavigationState extends State<ScaffoldWithNavigation> {
  AppSection _selectedAppSection = AppSection.home;

  @override
  Widget build(BuildContext context) {
    final screenSize = MediaQuery.of(context).size;

    return Scaffold(
        appBar: AppBar(
          backgroundColor: Theme.of(context).colorScheme.primary,
          title: Text(_selectedAppSection.label),
        ),
        body: Row(
          children: [
            if (screenSize.width > maxMobileScreenSize)
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
                selectedIndex: _selectedAppSection.index,
              ),
            Expanded(child: widget.screen),
          ],
        ),
        bottomNavigationBar: screenSize.width <= maxMobileScreenSize
            ? BottomNavigationBar(
                currentIndex: _selectedAppSection.index,
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
      _selectedAppSection = section;
    });
    context.go(section.path);
  }

  AppSection _getAppSection(int i) {
    assert(i < AppSection.values.length, "App section not found");

    return AppSection.values.firstWhere((e) => e.index == i);
  }
}
