# Вариант 20. Ремонт техники

`RepairShopWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `RepairShopWorkflow`
- `RepairShopWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, Device>`
- `Device` — интерфейс:
  - `AbstractDevice`
    - `BasicDevice`
      - `ArchivedDevice` — ломает `process()`
    - `PremiumDevice`
- `Actor` — интерфейс:
  - `Technician` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
