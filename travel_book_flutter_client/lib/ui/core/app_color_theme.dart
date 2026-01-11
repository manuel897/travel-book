import 'package:flutter/material.dart';

/// https://coolors.co/222632-8f8f49-333645-76809b-9bdef1-595779-c99eff-fc9861-fdd86e-c09dee
/// Base palette
const Color _pacificCyan = Color(0xFF0091AD);
const surface = Color.fromARGB(255, 51, 54, 69);
const Color _darkGrey = Color.fromARGB(255, 34, 38, 50);
const Color _sandyBrown = Color(0xFFF4A259);
const Color _hotFuchsia = Color(0xFFFF3366);

const Color confirmed = Color.fromARGB(255, 143, 143, 73);
const Color danger = Color.fromARGB(255, 252, 152, 97);
const Color warning = Color.fromARGB(255, 253, 216, 110);

const ColorScheme darkColorScheme = ColorScheme(
  brightness: Brightness.dark,

  // Brand / primary
  primary: Color.fromARGB(255, 118, 128, 155),
  onPrimary: Colors.black,

  primaryContainer: Colors.orange,
  onPrimaryContainer: Color(0xFF9BE7F3),

  // Secondary (support / success-like)
  secondary: Colors.orange,
  onSecondary: Colors.black,

  secondaryContainer: surface,
  onSecondaryContainer: Colors.black,

  // Accent
  tertiary: _sandyBrown,
  onTertiary: Colors.black,

  tertiaryContainer: Color(0xFF4E2F10),
  onTertiaryContainer: Color(0xFFFFD9B8),

  surface: _darkGrey,
  onSurface: Colors.white,

  surfaceTint: _pacificCyan,

  inverseSurface: Color(0xFFE8E2DE),
  onInverseSurface: Color(0xFF1A1714),
  inversePrimary: Color(0xFF5FD1E6),

  // Error (hot fuchsia works great in dark mode)
  error: _hotFuchsia,
  onError: Colors.black,

  errorContainer: Color(0xFF5A1125),
  onErrorContainer: Color(0xFFFFB3C7),

  // Outlines & dividers
  outline: Color(0xFF8A817C),
  outlineVariant: Color(0xFF3A332E),

  // Elevation helpers
  shadow: Colors.black,
  scrim: Colors.black,
);

const String _fontFamily = 'Inter'; // or 'Roboto', 'SF Pro', etc.

const TextTheme professionalTextTheme = TextTheme(
  // Display (very large text, rare use)
  displayLarge: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 57,
    fontWeight: FontWeight.w700,
    letterSpacing: -0.25,
  ),
  displayMedium: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 45,
    fontWeight: FontWeight.w600,
  ),
  displaySmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 36,
    fontWeight: FontWeight.w600,
  ),

  // Headlines (page titles, dialogs)
  headlineLarge: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 32,
    fontWeight: FontWeight.w700,
  ),
  headlineMedium: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 28,
    fontWeight: FontWeight.w600,
  ),
  headlineSmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 24,
    fontWeight: FontWeight.w600,
  ),

  // Titles (sections, cards, app bars)
  titleLarge: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 20,
    fontWeight: FontWeight.w600,
  ),
  titleMedium: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 16,
    fontWeight: FontWeight.w600,
    letterSpacing: 0.15,
    color: Colors.grey,
  ),
  titleSmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 14,
    fontWeight: FontWeight.w500,
    letterSpacing: 0.1,
    color: Colors.grey,
  ),

  // Body (main reading text)
  bodyLarge: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 16,
    fontWeight: FontWeight.w400,
    height: 1.5,
  ),
  bodyMedium: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 14,
    fontWeight: FontWeight.w400,
    height: 1.45,
  ),
  bodySmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 12,
    fontWeight: FontWeight.w400,
    height: 1.4,
  ),

  // Labels (buttons, chips, captions)
  labelLarge: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 14,
    fontWeight: FontWeight.w600,
    letterSpacing: 0.1,
  ),
  labelMedium: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 12,
    fontWeight: FontWeight.w500,
    letterSpacing: 0.5,
  ),
  labelSmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 11,
    fontWeight: FontWeight.w500,
    letterSpacing: 0.5,
  ),
);
