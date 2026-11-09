# Вариант 17. Языковая школа

`LanguageSchool` добавляет курсы, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `LanguageSchool`
- `LanguageSchool` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `Course` — базовый класс:
  - `EnglishCourse`
    - `CancelledEnglishCourse` — ломает `start()`
  - `GermanCourse`
  - `FrenchCourse`
- `ShiftWorker` — интерфейс:
  - `Teacher`
  - `Manager` — кидает в `handle()` и `clean()`
