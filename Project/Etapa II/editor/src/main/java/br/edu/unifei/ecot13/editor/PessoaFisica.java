package br.edu.unifei.ecot13.editor;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class PessoaFisica extends Cliente {
	private static final long serialVersionUID = -1600245345397735464L;
	
	private int cpf;
	
	/*
	public PessoaFisica (Nacionalidade nacionalidade) {
		super(nacionalidade);
	}
	*/
}
