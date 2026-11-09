# Вариант 16. Автошкола

`DrivingSchoolWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `DrivingSchoolWorkflow`
- `DrivingSchoolWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, TrainingCar>`
- `TrainingCar` — интерфейс:
  - `AbstractTrainingCar`
    - `BasicTrainingCar`
      - `ArchivedTrainingCar` — ломает `process()`
    - `PremiumTrainingCar`
- `Actor` — интерфейс:
  - `Instructor` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
