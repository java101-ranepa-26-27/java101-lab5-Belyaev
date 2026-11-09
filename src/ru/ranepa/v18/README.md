# Вариант 18. Танцевальная студия

Singleton `DanceStudioSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `DanceStudioSystem` (singleton, `getInstance`)
- `DanceStudioSystem` использует:
  - `HashMap<name, DanceClass>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `DanceClass`
  - `CancelledDanceClass` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Choreographer`
  - `Manager` — кидает в `cancel()` и `clean()`
