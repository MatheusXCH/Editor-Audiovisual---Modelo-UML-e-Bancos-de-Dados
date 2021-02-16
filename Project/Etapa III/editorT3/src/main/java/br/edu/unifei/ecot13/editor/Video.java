package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@Data
@NodeEntity
public class Video implements Serializable{
	private static final long serialVersionUID = 8901539977046203744L;
	
	@Id
	private Integer codigo;
	private String nome;
	private String formato;
	protected Integer duracao;
	
	//public abstract void setDuracao(int duracao);
}
