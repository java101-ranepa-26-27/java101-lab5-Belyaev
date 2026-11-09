# Вариант 2. Прокат велосипедов

Singleton `BikeRentalSystem` оформляет записи, считает стоимость по типу, ведёт сотрудников и закрывает день. Записи лежат в `HashMap` внутри singleton, а зависимости создаются прямо в нём.

**Схема классов**

- `Main` → `BikeRentalSystem` (singleton, `getInstance`)
- `BikeRentalSystem` использует:
  - `HashMap<name, Bike>` — записи
  - `List<Staff>`
  - `SmsGateway`
  - `Ledger`
- `Bike`
  - `CancelledBike` — ломает `confirm()`
- `Staff` — интерфейс:
  - `Mechanic`
  - `Manager` — кидает в `cancel()` и `clean()`
