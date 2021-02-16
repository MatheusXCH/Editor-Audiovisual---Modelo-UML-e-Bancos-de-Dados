package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Nacional extends Nacionalidade implements Serializable{
	private static final long serialVersionUID = 3115572956064082012L;
	
	private String estado;
	private String pais = "Brasil";
	
	
	public double cambio(double dinheiro) {
		return dinheiro*1;
	}
	
}
