package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class EdicaoVideo extends Software implements Serializable{
	private static final long serialVersionUID = -7709203197044778946L;
	
	private List<Efeito> efeito = new ArrayList<>();

	private List<PosProcessamento> posProcessamento =  new ArrayList<PosProcessamento>();
	
	@Relationship(type = "PLUGIN", direction = Relationship.OUTGOING)
	private List<Software> plugins = new ArrayList<>();	
}
