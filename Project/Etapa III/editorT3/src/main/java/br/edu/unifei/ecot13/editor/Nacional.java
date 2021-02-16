package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class Nacional extends Nacionalidade implements Serializable{
	private static final long serialVersionUID = 3115572956064082012L;
	
	private String estado;
	private String pais = "Brasil";
	
	public double cambio(Double dinheiro) {
		return dinheiro*1;
	}
	
}
