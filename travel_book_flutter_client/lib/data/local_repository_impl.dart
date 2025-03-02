import 'package:travel_book_flutter_client/domain/local_repository.dart';
import 'package:universal_html/html.dart' as html;

class LocalRepositoryImpl implements LocalRepository {
  final html.Storage _localStorage = html.window.localStorage;

  @override
  void deleteValue({required String key}) {
    _localStorage.remove(key);
  }

  @override
  void save(Map<String, String> keyValuePair) {
    keyValuePair.forEach((k, v) {
      _localStorage[k] = v;
    });
  }
}
