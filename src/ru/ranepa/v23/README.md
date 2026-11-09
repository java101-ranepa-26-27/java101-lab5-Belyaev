# Вариант 23. Пекарня

Статический `BakeryItemUtils` создаёт объекты, меняет статусы, считает цену по типу и печатает список. Сам `BakeryItem` — анемичные данные с публичными полями, а сотрудники образуют отдельную иерархию.

**Схема классов**

- `Main` → `BakeryItemUtils` (static)
- `BakeryItemUtils` использует:
  - `BakeryItemStore` — статический `HashMap`
  - `Notifier`
  - `if/else` по `kind`
- `BakeryItem` — данные без поведения
- `Employee` — абстрактный класс:
  - `Clerk`
    - `Trainee` — ломает `work()`
  - `Supervisor`
- `Actor` — интерфейс:
  - `Clerk`
  - `Supervisor` — кидает в `serve()` и `clean()`
