-- Functions
CREATE ALIAS lo_get AS 'byte[] lo_get(byte[] image) {return image;}';

-- Insertion
insert into mobile (mobile_id, brand, model, os, screen_size, display_resolution, display_technology, ram, storage_capacity, chipset_model, camera_resolution, sim_card_slot, battery, color, release_year, relevant) values
('honor508128black', 'honor', '50', 'android', '6.67', '1920x2100', 'IPS', 8, 128, 'Qualcom', '48', '2', 4100, 'black', '2021', 2026),
('pocox3pro8256green', 'poco', 'x3pro', 'android', '6.67', '1920x2100', 'IPS', 8, 256, 'Qualcom', '48', '2', 5000, 'green', '2022', 2027);

insert into mobile_full (mobile_id, type, os_version, processor_clock_frequency, cores_number, technical_process, housing_material, sim_format, length, width, height, weight, main_cameras_number, built_in_flash, automatic_focus, optical_stabilization, main_camera, main_camera_aperture, front_camera, front_camera_resolution, front_camera_aperture, gps, glonass, beidou, edge, hspa, hspa_plus, lte, five_g, bluetooth, bluetooth_version, audio_output, audio_output_version, wifi, wifi_version, connection, nfc, battery_type, charge_time) values
('honor508128black', 'smartphone', '10', 2700, 4, 14, 'plastic', 'nano', 180, 70, 8, 150, 2, true, true, true, true, 'f/1.9', true, '22', 'f/2.8', true, true, false, true, true, true, true, true, true, '3.1', true, '3.5 jack', true, '801.1', true, false, 'li-on', '4 hours'),
('pocox3pro8256green', 'smartphone', '10', 2700, 4, 14, 'plastic', 'nano', 180, 70, 8, 150, 2, true, true, true, true, 'f/1.9', true, '22', 'f/2.8', true, true, false, true, true, true, true, true, true, '3.1', true, '3.5 jack', true, '801.1', true, false, 'li-on', '4 hours');

insert into mobile_image (mobile_id, main, image) values ('honor508128black', 1, FILE_READ('classpath:img/sample-phone.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('honor508128black', 2, FILE_READ('classpath:img/sample-phone-2.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('honor508128black', 2, FILE_READ('classpath:img/sample-phone-3.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 1, FILE_READ('classpath:img/sample-phone-2.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 2, FILE_READ('classpath:img/sample-phone-3.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 2, FILE_READ('classpath:img/sample-phone.jpeg'));

-- shops

INSERT INTO shop(name) VALUES
('Beacon'),
('21Vek'),
('5 элемент'),
('TTN'),
('7745.by'),
('sila.by'),
('EVROSET'),
('ТехноМир');

-- offers

insert into offers (mobile_id, shop_id, price) values
('honor508128black', 1, 2405.8),
('honor508128black', 2, 2306.4),
('honor508128black', 3, 2105.4),
('honor508128black', 5, 2306.4),
('honor508128black', 6, 2405.2),
('pocox3pro8256green', 1, 2435.2),
('pocox3pro8256green', 3, 2785.3),
('pocox3pro8256green', 4, 2786.3),
('pocox3pro8256green', 7, 2900.3),
('pocox3pro8256green', 8, 2910.4);

-- tasks
INSERT INTO task (building, city, comment, email, first_name, flat, floor, last_name, phone_number, porch, street, state) VALUES
('187', 'Samsun', 'I want to swim', 'email@email.com', 'Bill', 4, 5, 'trump', '+123456789', 1, 'Main street', 1),
('187', 'Samsun', 'I want to swim', 'email@email.com', 'Bill', 4, 5, 'trump', '+123456789', 1, 'Main street', 1),
('40', 'Istanbul', 'I want a pizza', 'is.email@email.com', 'Tarik', 23, 4, 'Erdogan', '+122222222', 2, 'Central street', 1),
('40', 'Istanbul', 'I want a pizza', 'is.email@email.com', 'Tarik', 23, 4, 'Erdogan', '+122222222', 2, 'Central street', 1),
('12', 'Mercin', 'I want a car', 'mercin@email.com', 'Steve', 2, 1, 'Lill', '+133333333', 1, 'Second street', 1),
('12', 'Mercin', 'I want a car', 'mercin@email.com', 'Steve', 2, 1, 'Lill', '+133333333', 1, 'Second street', 1),
('12', 'Mercin', 'I want a car', 'mercin@email.com', 'Steve', 2, 1, 'Lill', '+133333333', 1, 'Second street', 1),
('100', 'Bursa', 'I want a flat', 'bursa@email.com', 'Vlad', 34, 7, 'Dracula', '+144444444', 2, 'Transelvania street', 1),
('11', 'Ankara', 'I want money', 'ankara@email.com', 'Vsevolod', 56, 4, 'Ivanov', '+14555555', 2, 'Main street', 0);

INSERT INTO orders (task_id, mobile_id, price, count, registered_date, shop_id) VALUES
(1, 'honor508128black', 2405.8, 1, '2022-02-02', 1),
(1, 'pocox3pro8256green', 2435.2, 2, '2022-02-02', 1),
(2, 'pocox3pro8256green', 2785.3, 2, '2022-02-02', 3),
(2, 'honor508128black', 2105.4, 1, '2022-02-02', 3),
(3, 'honor508128black', 2405.2, 3, '2022-02-02', 6),
(4, 'pocox3pro8256green', 2910.4, 1, '2022-02-02', 8),
(5, 'pocox3pro8256green', 2900.3, 2, '2022-03-02', 7),
(6, 'honor508128black', 2306.4, 3, '2022-03-03', 5),
(7, 'honor508128black', 2405.8, 3, '2022-03-03', 1),
(8, 'pocox3pro8256green', 2435.2, 2, '2022-04-03', 1),
(8, 'honor508128black', 2405.8, 2, '2022-04-03', 1),
(9, 'pocox3pro8256green', 2435.2, 2, '2022-04-03', 1),
(9, 'honor508128black', 2405.8, 2, '2022-04-03', 1);