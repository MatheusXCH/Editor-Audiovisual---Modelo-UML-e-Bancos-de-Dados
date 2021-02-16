package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Empresa extends Cliente implements Serializable{
	private static final long serialVersionUID = 6465899839737393520L;
	private int cnpj;
	
	/*
	public Empresa (Nacionalidade nacionalidade) {
		super(nacionalidade);
	}
	*/	
}
