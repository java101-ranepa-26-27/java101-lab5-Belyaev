# Вариант 10. Кемпинг

Singleton `CampingSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `CampingSystem` (singleton, `getInstance`)
- `CampingSystem` использует:
  - `HashMap<name, CampingSpot>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `CampingSpot`
  - `CancelledCampingSpot` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Ranger`
  - `Manager` — кидает в `cancel()` и `clean()`
