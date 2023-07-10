INSERT INTO shop(name, description)
VALUES ('21Vek', 'Гарантия 12 месяцев. Код товара 7.556.886. Без выходных. Собственная курьерская служба. Цена без рассрочки. Более 1 000 000 товаров. Мы работаем для Вас с 2004 года!'),
('5 элемент', 'Гарантия 12 месяцев. Код: 198068. Рассрочка 5 месяцев. Рассрочка на 5 месяцев по карте халва. Базовый кредит до 60 месяцев. 20 лет на рынке. Более 100 000 товаров. Самовывоз из любого розничного магазина сети.'),
('TTN', 'Гарантия 12 месяцев. Более 15 лет на рынке. Более 3000 моделей товаров. Самовывоз в центре минска. Быстрая доставка. Работаем по всей РБ(до подъезда, в отдаленные пункты доставляем до 7 дней) Есть гидрогелевые пленки, стекла, чехлы. Обрежем сим. WebMoney.'),
('7745.by', 'Гарантия 12 месяцев. Более 152000 товаров готово к отгрузке! Код товара 764972. Удобный самовывоз. Безналичный расчет. Оплата через терминал.'),
('sila.by', 'Гарантия 12 месяцев. (Код товара: 132505) Рассрочка до 6 мес. | Карты рассрочек: Халва, Карта покупок, Smart карта, Черепаха, Магнит, КартаFUN, Карта рассрочки Приорбанка | 32 Магазина в РБ | Удобный самовывоз из магазинов.'),
('EVROSET', 'Гарантия 36 месяцев. Наличные, ЕРИП. Рассрочка: Халва, Карта Покупок, карта FUN. Система Trade-in. Стекло, чехол со скидкой'),
('ТехноМир', 'Гарантия 12 месяцев. Грамотная консультация. Самовывоз в центре Минска. Доставляем по всей РБ(до подъезда, в некоторые города доставка до 7 дней) В продаже есть противоударные пленки на все модели, а также стёкла, чехлы. Работаем без выходных. Обрежем sim. Webmoney');

INSERT INTO shop_logo(logo, shop_id) VALUES
 (FILE_READ('classpath:img/beacon-small-logo.png'), 1),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 2),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 3),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 4),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 5),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 6),
 (FILE_READ('classpath:img/beacon-small-logo.png'), 7);
-- working_hours
-- first
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
-- second
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
-- third
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
-- fourth
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '15:00:00', '10:00:00';
-- fifth
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '19:00:00', '10:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '15:00:00', '10:00:00';
-- sixth
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
-- seventh
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';
INSERT INTO working_hours(id, close, open) SELECT nextval('hilo_working_hours_seq'), '21:00:00', '09:00:00';

select * from working_hours;

INSERT INTO shop_working_hours_mapping(shop_id, working_hours_id, working_hours_map_key) VALUES
(1, 1, 'MONDAY'), (1, 8, 'TUESDAY'), (1, 15, 'WEDNESDAY'), (1, 22, 'THURSDAY'), (1, 29, 'FRIDAY'), (1, 36, 'SATURDAY'), (1, 43, 'SUNDAY'),
(2, 50, 'MONDAY'), (2, 57, 'TUESDAY'), (2, 64, 'WEDNESDAY'), (2, 71, 'THURSDAY'), (2, 78, 'FRIDAY'), (2, 85, 'SATURDAY'), (2, 92, 'SUNDAY'),
(3, 99, 'MONDAY'), (3, 106, 'TUESDAY'), (3, 113, 'WEDNESDAY'), (3, 120, 'THURSDAY'), (3, 127, 'FRIDAY'),
(4, 134, 'MONDAY'), (4, 141, 'TUESDAY'), (4, 148, 'WEDNESDAY'), (4, 155, 'THURSDAY'), (4, 162, 'FRIDAY'), (4, 169, 'SATURDAY'),
(5, 176, 'MONDAY'), (5, 183, 'TUESDAY'), (5, 190, 'WEDNESDAY'), (5, 197, 'THURSDAY'), (5, 204, 'FRIDAY'), (5, 211, 'SATURDAY'),
(6, 218, 'MONDAY'), (6, 225, 'TUESDAY'), (6, 232, 'WEDNESDAY'), (6, 239, 'THURSDAY'), (6, 246, 'FRIDAY'), (6, 253, 'SATURDAY'), (6, 260, 'SUNDAY'),
(7, 267, 'MONDAY'), (7, 274, 'TUESDAY'), (7, 281, 'WEDNESDAY'), (7, 288, 'THURSDAY'), (7, 295, 'FRIDAY'), (7, 302, 'SATURDAY'), (7, 309, 'SUNDAY');

INSERT INTO shops_payment_methods(shop_id, payment_method) VALUES
(1, 'CASH'), (1, 'DEBIT_CARD'), (1, 'CREDIT_CARD'), (1, 'MOBILE_PAYMENT'), (1, 'ELECTRONIC_BANK_TRANSFER'),
(2, 'CASH'), (2, 'DEBIT_CARD'), (2, 'CREDIT_CARD'), (2, 'MOBILE_PAYMENT'), (1, 'ELECTRONIC_BANK_TRANSFER'),
(3, 'CASH'), (3, 'DEBIT_CARD'), (3, 'CREDIT_CARD'), (3, 'MOBILE_PAYMENT'),
(4, 'CASH'), (4, 'DEBIT_CARD'), (4, 'CREDIT_CARD'), (4, 'ELECTRONIC_BANK_TRANSFER'),
(5, 'CASH'), (5, 'DEBIT_CARD'), (5, 'CREDIT_CARD'),
(6, 'CASH'), (6, 'DEBIT_CARD'), (6, 'CREDIT_CARD'),
(7, 'CASH'), (7, 'DEBIT_CARD'), (7, 'CREDIT_CARD'), (7, 'MOBILE_PAYMENT'), (7, 'ELECTRONIC_BANK_TRANSFER');
