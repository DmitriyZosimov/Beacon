INSERT INTO shop_logo(logo) VALUES
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/21vek.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/5element.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/ttn.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/7745by.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/silaby.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/evroset.jpeg')),
 (FILE_READ('/home/dmitriy_zosimov/work/BEACON/Beacon/backend/shop/src/test/resources/img/technomir.jpeg'));

INSERT INTO shop(name, description, logo_id)
VALUES ('21Vek', 'Гарантия 12 месяцев. Код товара 7.556.886. Без выходных. Собственная курьерская служба. Цена без рассрочки. Более 1 000 000 товаров. Мы работаем для Вас с 2004 года!', 1),
('5 элемент', 'Гарантия 12 месяцев. Код: 198068. Рассрочка 5 месяцев. Рассрочка на 5 месяцев по карте халва. Базовый кредит до 60 месяцев. 20 лет на рынке. Более 100 000 товаров. Самовывоз из любого розничного магазина сети.', 2),
('TTN', 'Гарантия 12 месяцев. Более 15 лет на рынке. Более 3000 моделей товаров. Самовывоз в центре минска. Быстрая доставка. Работаем по всей РБ(до подъезда, в отдаленные пункты доставляем до 7 дней) Есть гидрогелевые пленки, стекла, чехлы. Обрежем сим. WebMoney.', 3),
('7745.by', 'Гарантия 12 месяцев. Более 152000 товаров готово к отгрузке! Код товара 764972. Удобный самовывоз. Безналичный расчет. Оплата через терминал.', 4),
('sila.by', 'Гарантия 12 месяцев. (Код товара: 132505) Рассрочка до 6 мес. | Карты рассрочек: Халва, Карта покупок, Smart карта, Черепаха, Магнит, КартаFUN, Карта рассрочки Приорбанка | 32 Магазина в РБ | Удобный самовывоз из магазинов.', 5),
('EVROSET', 'Гарантия 36 месяцев. Наличные, ЕРИП. Рассрочка: Халва, Карта Покупок, карта FUN. Система Trade-in. Стекло, чехол со скидкой', 6),
('ТехноМир', 'Гарантия 12 месяцев. Грамотная консультация. Самовывоз в центре Минска. Доставляем по всей РБ(до подъезда, в некоторые города доставка до 7 дней) В продаже есть противоударные пленки на все модели, а также стёкла, чехлы. Работаем без выходных. Обрежем sim. Webmoney', 7);

INSERT INTO working_hours(close, open) VALUES
('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'),
('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'),
('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'),
('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('15:00:00', '10:00:00'),
('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('19:00:00', '10:00:00'), ('15:00:00', '10:00:00'),
('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'),
('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00'), ('21:00:00', '09:00:00');

INSERT INTO shop_working_hours_mapping(shop_id, working_hours_id, working_hours_map_key) VALUES
(1, 1, 'MONDAY'), (1, 2, 'TUESDAY'), (1, 3, 'WEDNESDAY'), (1, 4, 'THURSDAY'), (1, 5, 'FRIDAY'), (1, 6, 'SATURDAY'), (1, 7, 'SUNDAY'),
(2, 8, 'MONDAY'), (2, 9, 'TUESDAY'), (2, 10, 'WEDNESDAY'), (2, 11, 'THURSDAY'), (2, 12, 'FRIDAY'), (2, 13, 'SATURDAY'), (2, 14, 'SUNDAY'),
(3, 15, 'MONDAY'), (3, 16, 'TUESDAY'), (3, 17, 'WEDNESDAY'), (3, 18, 'THURSDAY'), (3, 19, 'FRIDAY'),
(4, 20, 'MONDAY'), (4, 21, 'TUESDAY'), (4, 22, 'WEDNESDAY'), (4, 23, 'THURSDAY'), (4, 24, 'FRIDAY'), (4, 25, 'SATURDAY'),
(5, 26, 'MONDAY'), (5, 27, 'TUESDAY'), (5, 28, 'WEDNESDAY'), (5, 29, 'THURSDAY'), (5, 30, 'FRIDAY'), (5, 31, 'SATURDAY'),
(6, 32, 'MONDAY'), (6, 33, 'TUESDAY'), (6, 34, 'WEDNESDAY'), (6, 35, 'THURSDAY'), (6, 36, 'FRIDAY'), (6, 37, 'SATURDAY'), (6, 38, 'SUNDAY'),
(7, 39, 'MONDAY'), (7, 40, 'TUESDAY'), (7, 41, 'WEDNESDAY'), (7, 42, 'THURSDAY'), (7, 43, 'FRIDAY'), (7, 44, 'SATURDAY'), (7, 45, 'SUNDAY');

INSERT INTO shops_payment_methods(shop_id, payment_method) VALUES
(1, 'CASH'), (1, 'DEBIT_CARD'), (1, 'CREDIT_CARD'), (1, 'MOBILE_PAYMENT'), (1, 'ELECTRONIC_BANK_TRANSFER'),
(2, 'CASH'), (2, 'DEBIT_CARD'), (2, 'CREDIT_CARD'), (2, 'MOBILE_PAYMENT'), (1, 'ELECTRONIC_BANK_TRANSFER'),
(3, 'CASH'), (3, 'DEBIT_CARD'), (3, 'CREDIT_CARD'), (3, 'MOBILE_PAYMENT'),
(4, 'CASH'), (4, 'DEBIT_CARD'), (4, 'CREDIT_CARD'), (4, 'ELECTRONIC_BANK_TRANSFER'),
(5, 'CASH'), (5, 'DEBIT_CARD'), (5, 'CREDIT_CARD'),
(6, 'CASH'), (6, 'DEBIT_CARD'), (6, 'CREDIT_CARD'),
(7, 'CASH'), (7, 'DEBIT_CARD'), (7, 'CREDIT_CARD'), (7, 'MOBILE_PAYMENT'), (7, 'ELECTRONIC_BANK_TRANSFER');