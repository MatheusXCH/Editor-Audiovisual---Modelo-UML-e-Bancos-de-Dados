package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Comercial extends Video implements Serializable{
	private static final long serialVersionUID = -6829884359141105585L;
	
	private String canal;
	private String plataforma;
	
	@Override
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}
