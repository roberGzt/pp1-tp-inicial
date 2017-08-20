package dto;

import java.sql.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String mail;
	private Date fechaCumpleaņos;
	private TipoDeContactoDTO tipoDeContacto;
	private DomicilioDTO domicilio;

	public PersonaDTO(int idPersona, String nombre, String telefono)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public PersonaDTO(int idPersona, String nombre, String telefono, String mail, Date fechaCumpleaņos,
			TipoDeContactoDTO tipoDeContacto, DomicilioDTO domicilio) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaCumpleaņos = fechaCumpleaņos;
		this.tipoDeContacto = tipoDeContacto;
		this.domicilio = domicilio;
	}

	public PersonaDTO(String nombre, String telefono, String mail, Date fechaCumpleaņos,
			TipoDeContactoDTO tipoDeContacto, DomicilioDTO domicilio) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaCumpleaņos = fechaCumpleaņos;
		this.tipoDeContacto = tipoDeContacto;
		this.domicilio = domicilio;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaCumpleaņos() {
		return fechaCumpleaņos;
	}

	public void setFechaCumpleaņos(Date fechaCumpleaņos) {
		this.fechaCumpleaņos = fechaCumpleaņos;
	}

	public TipoDeContactoDTO getTipoDeContacto() {
		return tipoDeContacto;
	}

	public void setTipoDeContacto(TipoDeContactoDTO tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}

	public DomicilioDTO getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(DomicilioDTO domicilio) {
		this.domicilio = domicilio;
	}

	
		
}
