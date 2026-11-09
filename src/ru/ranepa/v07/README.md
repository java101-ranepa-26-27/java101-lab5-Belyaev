# Вариант 7. Музыкальная школа

Статический `InstrumentUtils` создаёт объекты, меняет статусы, считает цену по типу и печатает список. Сам `Instrument` — анемичные данные с публичными полями, а сотрудники образуют отдельную иерархию.

**Схема классов**

- `Main` → `InstrumentUtils` (static)
- `InstrumentUtils` использует:
  - `InstrumentStore` — статический `HashMap`
  - `Notifier`
  - `if/else` по `kind`
- `Instrument` — данные без поведения
- `Employee` — абстрактный класс:
  - `Clerk`
    - `Trainee` — ломает `work()`
  - `Supervisor`
- `Actor` — интерфейс:
  - `Clerk`
  - `Supervisor` — кидает в `serve()` и `clean()`
