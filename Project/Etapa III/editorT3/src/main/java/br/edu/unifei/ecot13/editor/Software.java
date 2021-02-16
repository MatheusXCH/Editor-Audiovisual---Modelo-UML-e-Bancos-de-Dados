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
public class Software implements Serializable{
	private static final long serialVersionUID = 8322027177033344533L;
	
	@Id
	private String nome;
	private String desenvolvedora;
	private Boolean isPago;
	
	@Relationship(type = "FAZPARTE", direction = Relationship.OUTGOING)
	private List<Equipamento> equipamentos = new ArrayList<>();
}
