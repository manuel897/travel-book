import 'package:flutter/material.dart';

/// Base palette
const Color _pacificCyan = Color(0xFF0091AD);
const Color _deepMocha = Color(0xFF443730);
const Color _sandyBrown = Color(0xFFF4A259);
const Color _hotFuchsia = Color(0xFFFF3366);
const Color _fern = Color(0xFF607744);

const ColorScheme darkColorScheme = ColorScheme(
  brightness: Brightness.dark,

  // Brand / primary
  primary: _pacificCyan,
  onPrimary: Colors.black,

  primaryContainer: Color(0xFF003E4A),
  onPrimaryContainer: Color(0xFF9BE7F3),

  // Secondary (support / success-like)
  secondary: _fern,
  onSecondary: Colors.black,

  secondaryContainer: Color(0xFF2F3A22),
  onSecondaryContainer: Color(0xFFD6E3C3),

  // Accent
  tertiary: _sandyBrown,
  onTertiary: Colors.black,

  tertiaryContainer: Color(0xFF4E2F10),
  onTertiaryContainer: Color(0xFFFFD9B8),
  
  surface: Color(0xFF1A1714),
  onSurface: Color(0xFFE8E2DE),

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
