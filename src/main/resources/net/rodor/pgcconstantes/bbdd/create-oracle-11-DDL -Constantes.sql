CREATE TABLE ZZConstantes(
clave VARCHAR2(20) NOT NULL ,
descripcion VARCHAR2(1024) NOT NULL ,
fechini TIMESTAMP NOT NULL ,
fechfin TIMESTAMP NOT NULL 
 
) 
LOGGING;
COMMENT ON TABLE ZZConstantes IS 'Dominio de constantes de la aplicación';
COMMENT ON COLUMN ZZConstantes.clave IS 'Clave del elemento';
COMMENT ON COLUMN ZZConstantes.descripcion IS 'Valor del elemento';
COMMENT ON COLUMN ZZConstantes.fechini IS 'fecha de inicio de validez del valor';
COMMENT ON COLUMN ZZConstantes.fechfin IS 'fecha de fin de validez del valor';

