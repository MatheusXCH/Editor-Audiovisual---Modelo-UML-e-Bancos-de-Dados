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
public class Equipamento implements Serializable{
	private static final long serialVersionUID = 7450575457294360678L;
	
	@Id
	private Integer numSerie;
	private String tipoEquipamento;
	private String marca;
	
	@Relationship(type = "EMBARCA", direction = Relationship.OUTGOING)
	private List<Software> softwares = new ArrayList<>();
}
