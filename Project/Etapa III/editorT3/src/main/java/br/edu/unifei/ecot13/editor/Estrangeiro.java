package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class Estrangeiro extends Nacionalidade implements Serializable{
	private static final long serialVersionUID = 2257594702484908414L;
	
	private String idioma;

	private Moeda moeda;
	
	
	public double cambio(Double dinheiro) {
		if (moeda == Moeda.DOLAR_US) {
			return dinheiro*5;
		}
		else if (moeda == Moeda.EURO) {
			return dinheiro*6;
		}
		else if (moeda == Moeda.YEN) {
			return dinheiro*0.05;
		}
		else if (moeda == Moeda.PESO_AR) {
			return dinheiro*0.07;
		}else {
			return dinheiro*0; //entrada inv�lida
		}
	}
	
}
