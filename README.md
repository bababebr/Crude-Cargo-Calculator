# Основные особенности

Приложение поможет посчитать коллчичество груза на борту танкера.

На данный момент реализовано:
  - Поддежка таблиц 6A, 6B, 54A, 54B.
  - Возможность быстро настроить приложение для своего судна (В демонстрационной версии используются калибровочные таблицы танкера типа Suezmax).
  - Учет дифферента при расчете груза.
  - Расчет объема TOV, GOV, GSV в Bbls и m3.
  - Расчет веса в LT, MT.

# Дополнительный инструментарий
  - Конвертация температуры из C в F и обратно.
  - Расчет API, Density, Specific gravity и их конвертация.

TODO:
  - Автоматическая генерация Ullage репорта.
  - Разработка графического интерфейса.

# Примеры запросов
## Типы груза

Endpoint POST "{{baseurl}}/cargo" принимает JSON в формате:

`{
    "name": "LSC",
    "type": "CRUDE",
    "api": {
        "api": 61.4
    },
    "temperature": {
        "celsius" : 43
    }
}`

![addCargo](https://github.com/bababebr/Crude-Cargo-Calculator/assets/116110720/5966b78c-1c2e-4348-84d3-970dbc79f342)

Получить все типы груза можно по ендпоинту GET /cargo/all

![getAllCargo](https://github.com/bababebr/Crude-Cargo-Calculator/assets/116110720/623705d0-5d1d-4a23-a40f-743cda390d65)

Результат: 

![getAllCargo result](https://github.com/bababebr/Crude-Cargo-Calculator/assets/116110720/d85fcaea-5e78-493d-9a55-39f80c2de258)

## Расчет ullage report`a

Endpoint GET /report/tank принмает массив json в формате:
`[ {
    "tankName":"3P",
    "ullage": 152,
    "trim": 0,
    "table": "Table6A"
}]`
Где   "tankName" - номер грузового танка из БД,
      "ullage" - пустота в см,
      "trim" - диффирент судна,
      "table" - номер ASTM таблицы для расчета.

Пример: Расчитать кол-во груза в для груза LSC в танках (3P, 3S, 4P, 4S, 6P, 6S)
`[ {
    "tankName":"3P",
    "ullage": 152,
    "trim": 0,
    "table": "Table6A"
},
{
    "tankName":"3S",
    "ullage": 151,
    "trim": 0,
    "table": "Table6A"
},
{
    "tankName":"4P",
    "ullage": 140,
    "trim": 0,
    "table": "Table6A"
},
{
    "tankName":"4S",
    "ullage": 143,
    "trim": 0,
    "table": "Table6A"
},
{
    "tankName":"6P",
    "ullage": 752,
    "trim": 0,
    "table": "Table6A"
},
{
    "tankName":"6S",
    "ullage": 757,
    "trim": 0,
    "table": "Table6A"
}
]`

![calcUllage](https://github.com/bababebr/Crude-Cargo-Calculator/assets/116110720/4d33201f-31d6-46e5-ac43-0b46a801e218)

Результат: 

![calcUllage result](https://github.com/bababebr/Crude-Cargo-Calculator/assets/116110720/b941a3c4-5608-4b8a-9bf6-19846b7b7992)


