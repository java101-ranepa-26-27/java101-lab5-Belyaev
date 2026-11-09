# Вариант 1. Кофейня

`CoffeeShop` добавляет напитки, ведёт сотрудников, печатает отчёт, считает статистику, выгружает CSV и рассылает письма. Все объекты и сотрудники хранятся в статической `Database`, а `ReportPrinter` различает типы через `instanceof`.

**Схема классов**

- `Main` → `CoffeeShop`
- `CoffeeShop` использует:
  - `Database` — статические списки и `HashMap` по имени
  - `ReportPrinter` — `instanceof` по типам
  - `EmailService`
  - `CsvExporter`
- `Drink` — базовый класс:
  - `Coffee`
    - `DecafCoffee` — ломает `brew()`
  - `Tea`
  - `Cocoa`
- `ShiftWorker` — интерфейс:
  - `Barista`
  - `Manager` — кидает в `handle()` и `clean()`
