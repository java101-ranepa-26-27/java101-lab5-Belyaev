# Вариант 22. Магазин настольных игр

Singleton `BoardGameShopSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `BoardGameShopSystem` (singleton, `getInstance`)
- `BoardGameShopSystem` использует:
  - `HashMap<name, BoardGame>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `BoardGame`
  - `CancelledBoardGame` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Consultant`
  - `Manager` — кидает в `cancel()` и `clean()`
