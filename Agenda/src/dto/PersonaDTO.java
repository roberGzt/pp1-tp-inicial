package dto;

import java.sql.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String mail;
	private Date fechaCumpleaņos;
	private String tipoDeContacto;

	public PersonaDTO(int idPersona, String nombre, String telefono)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public PersonaDTO(int idPersona, String nombre, String telefono, String mail, Date fechaCumpleaņos,
			String tipoDeContacto) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.fechaCumpleaņos = fechaCumpleaņos;
		this.tipoDeContacto = tipoDeContacto;
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

	public String getTipoDeContacto() {
		return tipoDeContacto;
	}

	public void setTipoDeContacto(String tipoDeContacto) {
		this.tipoDeContacto = tipoDeContacto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaDTO other = (PersonaDTO) obj;
		if (fechaCumpleaņos == null) {
			if (other.fechaCumpleaņos != null)
				return false;
		} else if (!fechaCumpleaņos.equals(other.fechaCumpleaņos))
			return false;
		if (idPersona != other.idPersona)
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (tipoDeContacto == null) {
			if (other.tipoDeContacto != null)
				return false;
		} else if (!tipoDeContacto.equals(other.tipoDeContacto))
			return false;
		return true;
	}
	
	
}
