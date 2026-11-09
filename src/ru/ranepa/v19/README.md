# Вариант 19. Фотостудия

Статический `ShootUtils` создаёт объекты, меняет статусы, считает цену по типу и печатает список. Сам `Shoot` — анемичные данные с публичными полями, а сотрудники образуют отдельную иерархию.

**Схема классов**

- `Main` → `ShootUtils` (static)
- `ShootUtils` использует:
  - `ShootStore` — статический `HashMap`
  - `Notifier`
  - `if/else` по `kind`
- `Shoot` — данные без поведения
- `Employee` — абстрактный класс:
  - `Clerk`
    - `Trainee` — ломает `work()`
  - `Supervisor`
- `Actor` — интерфейс:
  - `Clerk`
  - `Supervisor` — кидает в `serve()` и `clean()`
