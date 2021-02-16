package br.edu.unifei.ecot13.editor;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class PessoaFisica extends Cliente {
	private static final long serialVersionUID = -1600245345397735464L;
	
	private Integer cpf;
	
	/*
	public PessoaFisica (Nacionalidade nacionalidade) {
		super(nacionalidade);
	}
	*/
}
