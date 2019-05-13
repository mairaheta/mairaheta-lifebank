package com.lifebank.model.entity;

import lombok.Data;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "usr_usuario")
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_id")		
	private Integer id;		

	@Column(name = "usr_id_cliente")
	private Integer id_client;

	@Column(name = "usr_usuario")
	private String user;
	
	@Column(name="usr_contrasenia") 
    @Lob
	private String password;
	
	@Column(name = "usr_nombre")
	private String name;
	
	@Column(name = "usr_estado")
	private String status;
	
	@Column(name = "usr_intentos")
	private Integer attempts;
	
	@Column(name="usr_fecha_creado")
	private Date created_date;
	
	@Column(name="usr_creado_por")
	private String created_by;
	
	@Column(name="usr_fecha_modificado")
	private Date modified_date;
	
	@Column(name="usr_modificado_por")
	private String modified_by;
}
