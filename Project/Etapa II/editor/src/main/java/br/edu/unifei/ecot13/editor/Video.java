package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Video implements Serializable{
	private static final long serialVersionUID = 8901539977046203744L;
	
	@Id
	private int codigo;
	private String nome;
	private String formato;
	protected int duracao;
	
	public abstract void setDuracao(int duracao);
}
