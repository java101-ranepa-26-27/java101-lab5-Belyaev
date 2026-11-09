# Вариант 5. Прачечная

`Laundry` добавляет изделия, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `Laundry`
- `Laundry` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `LaundryItem` — базовый класс:
  - `Shirt`
    - `DelicateShirt` — ломает `wash()`
  - `Coat`
  - `Blanket`
- `ShiftWorker` — интерфейс:
  - `Washer`
  - `Manager` — кидает в `handle()` и `clean()`
