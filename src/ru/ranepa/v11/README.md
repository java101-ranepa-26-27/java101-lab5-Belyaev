# Вариант 11. Типография

Статический `PublicationUtils` создаёт объекты, меняет статусы, считает цену по типу и печатает список. Сам `Publication` — анемичные данные с публичными полями, а сотрудники образуют отдельную иерархию.

**Схема классов**

- `Main` → `PublicationUtils` (static)
- `PublicationUtils` использует:
  - `PublicationStore` — статический `HashMap`
  - `Notifier`
  - `if/else` по `kind`
- `Publication` — данные без поведения
- `Employee` — абстрактный класс:
  - `Clerk`
    - `Trainee` — ломает `work()`
  - `Supervisor`
- `Actor` — интерфейс:
  - `Clerk`
  - `Supervisor` — кидает в `serve()` и `clean()`
