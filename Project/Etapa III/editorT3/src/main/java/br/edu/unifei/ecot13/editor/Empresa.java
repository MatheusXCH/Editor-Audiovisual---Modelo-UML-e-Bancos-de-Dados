package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class Empresa extends Cliente implements Serializable{
	private static final long serialVersionUID = 6465899839737393520L;
	private Integer cnpj;
	
	/*
	public Empresa (Nacionalidade nacionalidade) {
		super(nacionalidade);
	}
	*/
}
