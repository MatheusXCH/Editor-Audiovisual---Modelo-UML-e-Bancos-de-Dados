package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Solicitacao implements Serializable{
	private static final long serialVersionUID = -4470909220035096584L;
	
	@Id
	private int contrato;
	private double valor;
	private String nomeVideo;
	private String dataInicio;
	private String prazoFinal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cliente cliente;
	@ManyToOne(cascade = CascadeType.ALL)
	private Produtora produtora;	
}
