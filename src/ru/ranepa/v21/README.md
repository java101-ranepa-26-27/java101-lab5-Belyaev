# Вариант 21. Доставка воды

`WaterDelivery` добавляет бутыли, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `WaterDelivery`
- `WaterDelivery` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `Bottle` — базовый класс:
  - `StillBottle`
    - `LeakingBottle` — ломает `deliver()`
  - `SparklingBottle`
  - `MineralBottle`
- `ShiftWorker` — интерфейс:
  - `Courier`
  - `Manager` — кидает в `handle()` и `clean()`
