import 'package:flutter/cupertino.dart';
import 'package:travel_book_flutter_client/ui/core/app_section.dart';

class NavigationState extends InheritedWidget {
  final AppSection selected;

  const NavigationState(
      {super.key, required super.child, required selectedSection})
      : selected = selectedSection;

  static NavigationState of(BuildContext context) {
    // This method looks for the nearest `MyState` widget ancestor.
    final result =
        context.dependOnInheritedWidgetOfExactType<NavigationState>();
    assert(result != null, "No NavigationState found in context");

    return result!;
  }

  @override
  // This method should return true if the old widget's data is different
  // from this widget's data. If true, any widgets that depend on this widget
  // by calling `of()` will be re-built.
  bool updateShouldNotify(NavigationState oldWidget) =>
      selected != oldWidget.selected;
}
