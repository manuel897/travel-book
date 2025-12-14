import 'package:flutter/material.dart';

enum AppSection {
  home("Home", "/home", Icons.calendar_month_sharp),
  user("User", "/user", Icons.account_box_sharp),
  notifications("notifications", "/notifications", Icons.message_sharp);

  final String label;
  final String path;
  final IconData icon;

  const AppSection(this.label, this.path, this.icon);
}
