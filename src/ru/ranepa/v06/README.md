# Вариант 6. Коворкинг

Singleton `CoworkingSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `CoworkingSystem` (singleton, `getInstance`)
- `CoworkingSystem` использует:
  - `HashMap<name, Workspace>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `Workspace`
  - `CancelledWorkspace` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Administrator`
  - `Manager` — кидает в `cancel()` и `clean()`
