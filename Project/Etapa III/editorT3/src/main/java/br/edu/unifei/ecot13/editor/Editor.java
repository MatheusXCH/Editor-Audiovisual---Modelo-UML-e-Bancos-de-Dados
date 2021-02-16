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
public class Editor implements Serializable{
	private static final long serialVersionUID = -4345304493821994812L;
	
	@Id
	private String nome;
	private Integer idade;
	private String portfolio;
	
	@Relationship(type = "TRABALHA", direction = Relationship.OUTGOING)
	private Estudio estudio;

	@Relationship(type = "UTILIZA", direction = Relationship.OUTGOING)
	private List<Equipamento> equipUtilizados = new ArrayList<>();

	@Relationship(type = "PRODUZ", direction = Relationship.OUTGOING)
	private List<Video> produzVideo = new ArrayList<>();
}
