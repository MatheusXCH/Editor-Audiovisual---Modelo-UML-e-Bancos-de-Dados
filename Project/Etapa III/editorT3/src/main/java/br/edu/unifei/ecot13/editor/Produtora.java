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
public class Produtora implements Serializable{
	private static final long serialVersionUID = -200579865586685582L;
	
	@Id
	private int cnpj;
	private String nome;
	
	@Relationship(type = "ARMAZENA", direction = Relationship.OUTGOING)
	private List<Solicitacao> solicitacoes = new ArrayList<>();
	
	@Relationship(type = "FORMADA", direction = Relationship.OUTGOING)
	private List<Estudio> estudios = new ArrayList<>();
}
