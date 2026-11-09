# Вариант 4. Груминг-салон

`GroomingSalonWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `GroomingSalonWorkflow`
- `GroomingSalonWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, Pet>`
- `Pet` — интерфейс:
  - `AbstractPet`
    - `BasicPet`
      - `ArchivedPet` — ломает `process()`
    - `PremiumPet`
- `Actor` — интерфейс:
  - `Groomer` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
