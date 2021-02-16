package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Solicitacao implements Serializable{
	private static final long serialVersionUID = -4470909220035096584L;
	
	@Id
	private Integer contrato;
	private Double valor;
	private String nomeVideo;
	private String dataInicio;
	private String prazoFinal;
	
	@Relationship(type = "SALVA", direction = Relationship.OUTGOING)
	private Cliente cliente;
	
	@Relationship(type = "RECEBE", direction = Relationship.OUTGOING)
	private Produtora produtora;	
}
