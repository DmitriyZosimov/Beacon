ALTER TABLE shop_logo RENAME COLUMN logo_id TO shop_id;

ALTER TABLE shop DROP COLUMN logo_id;

ALTER TABLE shop_logo ADD FOREIGN KEY (shop_id) REFERENCES shop(shop_id);