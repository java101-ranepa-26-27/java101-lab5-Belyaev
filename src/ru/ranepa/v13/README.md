# Вариант 13. Ферма

`Farm` добавляет животные, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `Farm`
- `Farm` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `Animal` — базовый класс:
  - `Cow`
    - `SickCow` — ломает `produce()`
  - `Chicken`
  - `Goat`
- `ShiftWorker` — интерфейс:
  - `Farmer`
  - `Manager` — кидает в `handle()` и `clean()`
