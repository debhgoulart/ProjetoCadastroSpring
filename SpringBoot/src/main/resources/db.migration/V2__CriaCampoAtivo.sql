ALTER TABLE usuarios ADD ativo number(1);

UPDATE usuarios SET ativo = 1;

ALTER TABLE usuarios ALTER COLUMN ativo not null;