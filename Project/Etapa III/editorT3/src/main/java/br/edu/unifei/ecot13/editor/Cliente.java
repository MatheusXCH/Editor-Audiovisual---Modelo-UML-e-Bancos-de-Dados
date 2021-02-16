package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Cliente implements Serializable{
	private static final long serialVersionUID = -1658280934974861578L;
	private Double dinheiro;
	@Id
	private String nome;
	@Relationship(type = "NASCIDO", direction = Relationship.OUTGOING)
	private Nacionalidade nacionalidade;
	@Relationship(type = "SOLICITA", direction = Relationship.OUTGOING)
	private List<Solicitacao> solicitacao = new ArrayList<Solicitacao>();
	
	/*
	public double convReal() {
		return nacionalidade.cambio(dinheiro);
	}
	*/
	
}
