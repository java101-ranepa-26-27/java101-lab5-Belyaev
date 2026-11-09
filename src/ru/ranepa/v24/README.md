# Вариант 24. Тату-салон

`TattooStudioWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `TattooStudioWorkflow`
- `TattooStudioWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, Tattoo>`
- `Tattoo` — интерфейс:
  - `AbstractTattoo`
    - `BasicTattoo`
      - `ArchivedTattoo` — ломает `process()`
    - `PremiumTattoo`
- `Actor` — интерфейс:
  - `TattooArtist` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
