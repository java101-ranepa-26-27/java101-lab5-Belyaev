# Вариант 8. Художественная галерея

`ArtGalleryWorkflow` создаёт заявки, назначает исполнителей, проводит их по статусам и считает итог. Зависимости он берёт через статический `ServiceLocator`, а типы заявок выбираются строкой.

**Схема классов**

- `Main` → `ArtGalleryWorkflow`
- `ArtGalleryWorkflow` использует:
  - `ServiceLocator` — статический доступ
  - `EmailGateway`
  - `AuditLog`
  - `HashMap<name, Exhibit>`
- `Exhibit` — интерфейс:
  - `AbstractExhibit`
    - `BasicExhibit`
      - `ArchivedExhibit` — ломает `process()`
    - `PremiumExhibit`
- `Actor` — интерфейс:
  - `Curator` — кидает в `escalate()`
  - `Bot` — кидает в `escalate()` и `comment()`
