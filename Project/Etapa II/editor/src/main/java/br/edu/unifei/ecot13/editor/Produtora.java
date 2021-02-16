package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Produtora implements Serializable{
	private static final long serialVersionUID = -200579865586685582L;
	
	@Id
	private int cnpj;
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Solicitacao> solicitacoes = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL)
	private List<Estudio> estudios = new ArrayList<>();
}
