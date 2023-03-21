-- add relevant column in mobile table
ALTER TABLE public.mobile ADD COLUMN relevant INTEGER NOT NULL DEFAULT 1;