-- create sequence for mobile_image table
CREATE SEQUENCE hilo_mobile_image_seq START with 1 INCREMENT BY 5;
SELECT setval('hilo_mobile_image_seq', (SELECT MAX(image_id) + 1 FROM mobile_image));

ALTER TABLE mobile_image ADD CONSTRAINT image_id_unique UNIQUE(image_id);
ALTER TABLE mobile_image ALTER COLUMN image_id DROP IDENTITY;
ALTER TABLE mobile_image ALTER COLUMN image_id SET DEFAULT nextval('hilo_mobile_image_seq');

-- create sequence for orders table
CREATE SEQUENCE hilo_order_seq START with 1 INCREMENT BY 5;
SELECT setval('hilo_order_seq', (SELECT MAX(order_id) + 1 FROM orders));

ALTER TABLE orders ADD CONSTRAINT order_id_unique UNIQUE(order_id);
ALTER TABLE orders ALTER COLUMN order_id DROP IDENTITY;
ALTER TABLE orders ALTER COLUMN order_id SET DEFAULT nextval('hilo_order_seq');
ALTER TABLE orders ALTER COLUMN shop_id SET NOT NULL;

-- create sequence for task table
CREATE SEQUENCE hilo_task_seq START with 1 INCREMENT BY 5;
SELECT setval('hilo_task_seq', (SELECT MAX(task_id) + 1 FROM task));

ALTER TABLE task ALTER COLUMN task_id DROP IDENTITY;
ALTER TABLE task ALTER COLUMN task_id SET DEFAULT nextval('hilo_task_seq');

-- create sequence for working_hours table
CREATE SEQUENCE hilo_task_seq START with 1 INCREMENT BY 7;
SELECT setval('hilo_working_hours_seq', (SELECT MAX(id) + 1 FROM working_hours));

ALTER TABLE working_hours ALTER COLUMN id DROP IDENTITY;
ALTER TABLE working_hours ALTER COLUMN id SET DEFAULT nextval('hilo_working_hours_seq');
