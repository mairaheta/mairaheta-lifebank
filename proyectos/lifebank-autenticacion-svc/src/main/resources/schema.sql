
DROP TABLE IF EXISTS usr_usuario;
CREATE TABLE usr_usuario(
	usr_id INT PRIMARY KEY,
	usr_id_cliente INT NOT NULL,
	usr_usuario VARCHAR(15) NOT NULL,
	usr_contrasenia CLOB NOT NULL,
	usr_nombre VARCHAR(200) NOT NULL,
	usr_estado VARCHAR(1) NOT NULL,
	usr_intentos INT NULL,
	usr_creado_por VARCHAR(25) NULL,
	usr_fecha_creado DATE NULL,
	usr_modificado_por VARCHAR(25) NULL,
	usr_fecha_modificado DATE NULL
);

DROP TABLE IF EXISTS tkn_token;
CREATE TABLE tkn_token (
	tkn_id  INT PRIMARY KEY ,
	tkn_id_usuario INT NOT NULL,
    tkn_token   CLOB NOT NULL,
    tkn_firma    VARCHAR(25) NOT NULL,
	tkn_ip    VARCHAR(15) NOT NULL,
	tkn_estado    VARCHAR(1) NOT NULL,
	tkn_creado_por VARCHAR(25) NULL,
	tkn_fecha_creado DATE NULL,
	tkn_modificado_por VARCHAR(25) NULL,
	tkn_fecha_modificado DATE NULL
);

DROP TABLE IF EXISTS log_logs;
CREATE TABLE log_logs (
	log_id  INT PRIMARY KEY ,
    log_id_usuario INT NOT NULL,
	log_id_cliente INT NOT NULL,
	log_servicio    VARCHAR(50) NOT NULL,
	log_solicitud   CLOB NOT NULL,
	log_creado_por VARCHAR(25) NULL,
	log_fecha_creado DATE NULL
);
