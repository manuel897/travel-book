import 'package:travel_book_flutter_client/ui/home/calender/models/month.dart';

String formatDate(DateTime date) {
  return "${date.day}/${date.month}/${date.year}";
}

String formatDateTime(DateTime date) {
  final Month m = Month.fromCode(date.month);
  return "${date.day} ${m.label} ${date.year} ${date.hour}:${date.minute}";
}
