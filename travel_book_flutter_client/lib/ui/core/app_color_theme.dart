import 'package:flutter/material.dart';

/// Base palette
const Color _pacificCyan = Color(0xFF0091AD);
const Color _plumBark = Color.fromARGB(255, 160, 32, 240);
const Color _grey = Color.fromARGB(255, 74, 82, 90);
const Color _darkGrey = Color.fromARGB(255, 36, 39, 43);
const Color _deepMocha = Color(0xFF443730);
const Color _sandyBrown = Color(0xFFF4A259);
const Color _hotFuchsia = Color(0xFFFF3366);
const Color _fern = Color(0xFF607744);

const ColorScheme darkColorScheme = ColorScheme(
  brightness: Brightness.dark,

  // Brand / primary
  primary: _plumBark,
  onPrimary: Colors.black,

  primaryContainer: Color(0xFF003E4A),
  onPrimaryContainer: Color(0xFF9BE7F3),

  // Secondary (support / success-like)
  secondary: _fern,
  onSecondary: Colors.black,

  secondaryContainer: _grey,
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
  ),
  titleSmall: TextStyle(
    fontFamily: _fontFamily,
    fontSize: 14,
    fontWeight: FontWeight.w500,
    letterSpacing: 0.1,
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
