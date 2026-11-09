# Вариант 14. Океанариум

Singleton `AquariumSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `AquariumSystem` (singleton, `getInstance`)
- `AquariumSystem` использует:
  - `HashMap<name, SeaCreature>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `SeaCreature`
  - `CancelledSeaCreature` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Aquarist`
  - `Manager` — кидает в `cancel()` и `clean()`
