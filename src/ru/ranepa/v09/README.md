# Вариант 9. Боулинг-клуб

`BowlingClub` добавляет дорожки, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `BowlingClub`
- `BowlingClub` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `Lane` — базовый класс:
  - `StandardLane`
    - `BrokenLane` — ломает `play()`
  - `VIPLane`
  - `KidsLane`
- `ShiftWorker` — интерфейс:
  - `Instructor`
  - `Manager` — кидает в `handle()` и `clean()`
