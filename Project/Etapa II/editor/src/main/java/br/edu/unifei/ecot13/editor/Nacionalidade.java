package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Nacionalidade implements Serializable{
	private static final long serialVersionUID = -5113940167221752690L;
	
	@Id
	@GeneratedValue
	private int codigoNacionalidade;
	private String pais;
	
	
	public abstract double cambio(double dinheiro);
	
}
