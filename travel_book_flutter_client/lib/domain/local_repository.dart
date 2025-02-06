abstract class LocalRepository {
  void save(Map<String, String> keyValuePair);

  void deleteValue({required String key});
}
