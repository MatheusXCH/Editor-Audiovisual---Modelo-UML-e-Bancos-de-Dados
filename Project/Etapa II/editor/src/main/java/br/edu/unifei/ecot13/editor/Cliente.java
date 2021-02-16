package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public abstract class Cliente implements Serializable{
	private static final long serialVersionUID = -1658280934974861578L;
	
	@Id
	private String nome;
	private double dinheiro;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Nacionalidade nacionalidade;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Solicitacao> solicitacao = new ArrayList<Solicitacao>();
	
	public double convReal() {
		return nacionalidade.cambio(dinheiro);
	}
	
}
