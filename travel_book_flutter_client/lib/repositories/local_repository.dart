import 'package:shared_preferences/shared_preferences.dart';

class LocalRepository {
  Future<void> deleteValue({required String key}) async {
    final SharedPreferencesAsync prefs = SharedPreferencesAsync();

    await prefs.remove(key);
  }

  Future<String?> findStringValue({required String key}) async {
    final SharedPreferencesAsync prefs = SharedPreferencesAsync();

    return prefs.getString(key);
  }

  Future<void> save(Map<String, String> keyValuePair) async {
    final SharedPreferencesAsync prefs = SharedPreferencesAsync();

    keyValuePair.forEach((k, v) async {
      await prefs.setString(k, v);
    });
  }
}
