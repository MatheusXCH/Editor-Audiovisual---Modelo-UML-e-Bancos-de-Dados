package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class Comercial extends Video implements Serializable{
	private static final long serialVersionUID = -6829884359141105585L;
	
	private String canal;
	private String plataforma;
	
	@Override
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
}
