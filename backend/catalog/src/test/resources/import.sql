-- Functions
CREATE ALIAS lo_get AS 'byte[] lo_get(byte[] image) {return image;}';

-- Insertion
insert into mobile (mobile_id, brand, model, os, screen_size, display_resolution, display_technology, ram, storage_capacity, chipset_model, camera_resolution, sim_card_slot, battery, color, release_year, relevant) values
('honor508128black', 'honor', '50', 'android', '6.67', '1920x2100', 'IPS', 8, 128, 'Qualcom', '48', '2', 4100, 'black', '2021', 2026),
('pocox3pro8256green', 'poco', 'x3pro', 'android', '6.67', '1920x2100', 'IPS', 8, 256, 'Qualcom', '48', '2', 5000, 'green', '2022', 2027);

insert into mobile_full (mobile_id, type, os_version, processor_clock_frequency, cores_number, technical_process, housing_material, sim_format, length, width, height, weight, main_cameras_number, built_in_flash, automatic_focus, optical_stabilization, main_camera, main_camera_aperture, front_camera, front_camera_resolution, front_camera_aperture, gps, glonass, beidou, edge, hspa, hspa_plus, lte, five_g, bluetooth, bluetooth_version, audio_output, audio_output_version, wifi, wifi_version, connection, nfc, battery_type, charge_time) values
('honor508128black', 'smartphone', '10', 2700, 4, 14, 'plastic', 'nano', 180, 70, 8, 150, 2, true, true, true, true, 'f/1.9', true, '22', 'f/2.8', true, true, false, true, true, true, true, true, true, '3.1', true, '3.5 jack', true, '801.1', true, false, 'li-on', '4 hours'),
('pocox3pro8256green', 'smartphone', '10', 2700, 4, 14, 'plastic', 'nano', 180, 70, 8, 150, 2, true, true, true, true, 'f/1.9', true, '22', 'f/2.8', true, true, false, true, true, true, true, true, true, '3.1', true, '3.5 jack', true, '801.1', true, false, 'li-on', '4 hours');

-- insert mobile helpers
insert into mobile (mobile_id, brand, relevant) values
('removed', 'removed', 0);

insert into mobile_full (mobile_id) values
('removed');

insert into mobile_image (mobile_id, main, image) values ('honor508128black', 1, FILE_READ('classpath:img/sample-phone.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('honor508128black', 2, FILE_READ('classpath:img/sample-phone-2.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('honor508128black', 2, FILE_READ('classpath:img/sample-phone-3.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 1, FILE_READ('classpath:img/sample-phone-2.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 2, FILE_READ('classpath:img/sample-phone-3.jpeg'));
insert into mobile_image (mobile_id, main, image) values ('pocox3pro8256green', 2, FILE_READ('classpath:img/sample-phone.jpeg'));

-- Computer
insert into laptop (computer_id, brand, model, sub_model, serial_id, release_year, type, processor_platform, processor, processor_model, processor_number, processor_thread_number, processor_clock_frequency, processor_max_clock_frequency, processor_tdp, case_material, case_color, lid_material, lid_color, case_lighting, width, length, height, weight, screen_size, screen_resolution, refresh_rate, display_technology, display_brightness, screen_cover, sensor_display, display_characteristics, ram_type, ram_clock_frequency, ram, ram_max, ram_max_slots, ram_free_slots, storage_type, storage_capacity, storage_slots, storage_interface_type, odd, discrete_coprocessor, graphics_model, graphics_capacity, graphics_characteristics, camera, camera_resolution, microphone, microphone_number, dynamic_number, numpad, keyboard_lighting, keyboard_lighting_color, touchpad, nfc, bluetooth, bluetooth_version, lan, lan_version, wifi, wifi_version, usb, usb_number, typec, typecnumber, vga, vga_version, hdmi, hdmi_version, jack, jack_number, energy_capacity, work_time, typeccharge, os, os_type, relevant) values
('lenovo82jf0082rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0082rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0083rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0083rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0084rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0084rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0086rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0086rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0085rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0085rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0087rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0087rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0088rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0088rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00889rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00889rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00890rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00890rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00891rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00891rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00892rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00892rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00893rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00893rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00894rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00894rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00895rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00895rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00896rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00896rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00897rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00897rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00898rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00898rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00899rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00899rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf00800rk', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf00800rk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, false, null, 2021),
('lenovo82jf0064ru', 'Lenovo', 'Legion 5 Pro', '16ITH6', '82jf0064ru', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, true, 'Windows 11', 2021),
('lenovo82sb00kytx', 'Lenovo', 'IdeaPad Gaming 3', '15ARH7', '82sb00kytx', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, true, 'Windows 11', 2021),
('lenovo82rn00c3', 'Lenovo', 'IdeaPad 3', '15ABA7', '82rn00c3', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, true, 'Windows 11', 2021),
('lenovo82rn00aqrk', 'Lenovo', 'IdeaPad 3', '15ABA7', '82rn00aqrk', '2021', 1, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 11400H', 6, 12, 2700, 4500, 45, 'metal', 'white', 'aluminium', 'white, grey', true, 356, 264.2, 26.15, 2300, 16.0, '2500x1600', 165, 'IPS', 500, 'matte', false, '100% sRGB, Dolby Vision, HDR 400, DC dimmer', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, 'Boost Clock 1485 MHz, TGP 95W', true, 1, true, 2, 2, true, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 4, true, 1, false, null, true, '1 (2.1)', true, 1, 80, null, true, true, 'Windows 11', 2021),
('hp6y7x3ea', 'HP', 'Victus', '15-fa0129nw', '6Y7X3EA', '2022', 1, 'Intel Alder Lake (2020)', 'Intel Core i5', 'Intel Core i5 12450H', 8, 12, 2000, 4400, 65, 'plastic', 'grey', 'plastic', 'grey', false, 357.9, 255, 23.5, 2290, 15.6, '1920x1080', 144, 'IPS', 250, 'matte', false, 'NTSC 45%', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 1, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, null, true, 1, true, 3, 2, true, true, null, true, false, true, '5.0', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 2, true, 1, false, null, true, '1 (2.1)', true, 1, 70, null, false, true, 'Windows 11', 2022),
('hp68y11ua', 'HP', 'Victus', '15-fa0032dx', '68Y11UA', '2022', 1, 'Intel Alder Lake (2020)', 'Intel Core i7', 'Intel Core i7 12650H', 8, 12, 2000, 4400, 65, 'plastic', 'grey', 'plastic', 'grey', false, 357.9, 255, 23.5, 2290, 15.6, '1920x1080', 144, 'IPS', 250, 'matte', false, 'NTSC 45%', 'DDR4', 3200, 16, 32, 2, 0, 'SSD', 512, 1, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050 Ti', 4, null, true, 1, true, 3, 2, true, true, null, true, false, true, '5.0', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 2, true, 1, false, null, true, '1 (2.1)', true, 1, 70, null, false, true, 'Windows 11', 2022),
('asusg513ichn094', 'ASUS', 'ROG', 'Strix G15', 'G513IC-HN094', '2021', 1, 'AMD Renoir (2020)', 'AMD Ryzen 7', 'AMD Ryzen 7 4800H', 8, 16, 2900, 4200, 54, 'plastic', 'dark-grey', 'aluminium', 'dark-grey', true, 355, 260, 27.6, 2020, 15.6, '1920x1080', 144, 'IPS', null, 'matte', false, 'sRGB: 62.5%, IPS-level', 'DDR4', 3200, 16, 32, 2, null, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050', 4, 'With ROG Boost up to 1840MHz at 80W', false, null, true, 2, 2, false, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 3, true, 1, false, null, true, '1 (2.0b)', true, 1, 56, null, true, false, null, 2022),
('asusg513iceb73', 'ASUS', 'ROG', 'Strix G15', 'G513IC-EB73', '2021', 1, 'AMD Renoir (2020)', 'AMD Ryzen 7', 'AMD Ryzen 7 4800H', 8, 16, 2900, 4200, 54, 'plastic', 'dark-grey', 'aluminium', 'dark-grey', true, 355, 260, 27.6, 2020, 15.6, '1920x1080', 144, 'IPS', null, 'matte', false, 'sRGB: 62.5%, IPS-level', 'DDR4', 3200, 8, 16, 2, null, 'SSD', 512, 2, 'PCIe', false, true, 'NVIDIA GeForce RTX 3050', 4, 'With ROG Boost up to 1840MHz at 80W', false, null, true, 2, 2, false, true, null, true, false, true, '5.1', true, '1 Gbit', true, '802.11ax(Wi-Fi 6)', true, 3, true, 1, false, null, true, '1 (2.0b)', true, 1, 56, null, true, false, null, 2022),
('applez1240001t', 'Apple', 'MacBook Air', '13', 'Z1240001T', '2020', 2, 'Apple Silicon (2020)', 'Apple M1', 'Apple M1', 8, null, 3200, null, null, 'metal', 'grey', 'aluminium', 'grey', true, 304.1, 212.4, 16.1, 1290, 13.3, '2560x1600', 60, 'IPS', 400, 'glossy', false, '100% DCI-P3', null, null, 16, null, null, 0, 'SSD', 256, null, 'PCIe', false, false, null, null, null, true, 1, true, 3, 2, false, true, null, true, false, true, '5.0', false, null, true, '802.11ax(Wi-Fi 6)', false, null, true, 2, false, null, false, null, true, 1, 49.9, null, true, true, 'Mac OS', 2022),
('applemgn64', 'Apple', 'MacBook Air', '13', 'MGN63', '2020', 2, 'Apple Silicon (2020)', 'Apple M1', 'Apple M1', 8, null, 3200, null, null, 'metal', 'grey', 'aluminium', 'grey', true, 304.1, 212.4, 16.1, 1290, 13.3, '2560x1600', 60, 'IPS', 400, 'glossy', false, '100% DCI-P3', null, null, 16, null, null, 0, 'SSD', 256, null, 'PCIe', false, false, null, null, null, true, 1, true, 3, 2, false, true, null, true, false, true, '5.0', false, null, true, '802.11ax(Wi-Fi 6)', false, null, true, 2, false, null, false, null, true, 1, 49.9, null, true, true, 'Mac OS', 2022),
('horizontt52e4w', 'Horizont', '15', 'MAK4', 't52e4w', '2022', 0, 'Intel Tiger Lake (2020)', 'Intel Core i5', 'Intel Core i5 1155G7', 4, 8, 2500, 4500, 28, 'plastic', 'blue', 'aluminium', 'blue', false, 358, 244, 18.9, 1800, 15.6, '1920x1080', 60, 'IPS', 300, 'matte', false, null, 'DDR4', 3200, 8, null, null, null, 'SSD', 512, 1, 'PCIe', false, false, 'discrete', null, null, true, 2, true, null, 2, true, true, null, true, false, true, '5.1', false, null, true, '802.11ac(Wi-Fi 5)', true, 2, true, 1, false, null, true, '1 (2.1)', true, 1, 50, null, false, true, 'Windows 11', 2022),
('horizontt32e3w', 'Horizont', '15', 'MAK4', 'T32E3W', '2022', 0, 'Intel Tiger Lake (2020)', 'Intel Core i3', 'Intel Core i3 1115G4', 4, 8, 2500, 4500, 28, 'plastic', 'blue', 'aluminium', 'blue', false, 358, 244, 18.9, 1800, 15.6, '1920x1080', 60, 'IPS', 300, 'matte', false, null, 'DDR4', 3200, 8, null, null, null, 'SSD', 512, 1, 'PCIe', false, false, 'discrete', null, null, true, 2, true, null, 2, true, true, null, true, false, true, '5.1', false, null, true, '802.11ac(Wi-Fi 5)', true, 2, true, 1, false, null, true, '1 (2.1)', true, 1, 50, null, false, true, 'Windows 11', 2022);

insert into computer_image (computer_id, main, image) values
('lenovo82jf0082rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0082rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0082rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0083rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0083rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0083rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0084rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0084rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0084rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0085rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0085rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0085rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0086rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0086rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0086rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0087rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0087rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0087rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0088rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0088rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0088rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00889rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00889rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00889rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00890rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00890rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00890rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00891rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00891rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00891rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00892rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00892rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00892rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00893rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00893rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00893rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00894rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00894rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00894rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00895rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00895rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00895rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00896rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00896rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00896rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00897rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00897rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00897rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00898rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00898rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00898rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00899rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00899rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00899rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf00800rk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf00800rk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf00800rk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82jf0064ru', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82jf0064ru', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82jf0064ru', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82sb00kytx', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82sb00kytx', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82sb00kytx', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82rn00c3', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82rn00c3', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82rn00c3', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('lenovo82rn00aqrk', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('lenovo82rn00aqrk', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('lenovo82rn00aqrk', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('hp6y7x3ea', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('hp6y7x3ea', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('hp6y7x3ea', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('hp68y11ua', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('hp68y11ua', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('hp68y11ua', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('asusg513ichn094', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('asusg513ichn094', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('asusg513ichn094', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('asusg513iceb73', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('asusg513iceb73', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('asusg513iceb73', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('applez1240001t', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('applez1240001t', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('applez1240001t', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('applemgn64', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('applemgn64', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('applemgn64', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('horizontt32e3w', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('horizontt32e3w', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('horizontt32e3w', 2, FILE_READ('classpath:img/sample-phone-3.jpeg')),
('horizontt52e4w', 1, FILE_READ('classpath:img/sample-phone.jpeg')),
('horizontt52e4w', 2, FILE_READ('classpath:img/sample-phone-2.jpeg')),
('horizontt52e4w', 2, FILE_READ('classpath:img/sample-phone-3.jpeg'));

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