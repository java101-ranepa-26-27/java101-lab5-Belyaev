# Вариант 3. Цветочный магазин

Статический `BouquetUtils` создаёт объекты, меняет статусы, считает цену по типу и печатает список. Сам `Bouquet` — анемичные данные с публичными полями, а сотрудники образуют отдельную иерархию.

**Схема классов**

- `Main` → `BouquetUtils` (static)
- `BouquetUtils` использует:
  - `BouquetStore` — статический `HashMap`
  - `Notifier`
  - `if/else` по `kind`
- `Bouquet` — данные без поведения
- `Employee` — абстрактный класс:
  - `Clerk`
    - `Trainee` — ломает `work()`
  - `Supervisor`
- `Actor` — интерфейс:
  - `Clerk`
  - `Supervisor` — кидает в `serve()` и `clean()`
