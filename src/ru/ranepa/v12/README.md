# Вариант 12. Пивоварня

`BreweryWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `BreweryWorkflow`
- `BreweryWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, BeerBatch>`
- `BeerBatch` — интерфейс:
  - `AbstractBeerBatch`
    - `BasicBeerBatch`
      - `ArchivedBeerBatch` — ломает `process()`
    - `PremiumBeerBatch`
- `Actor` — интерфейс:
  - `Brewer` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
