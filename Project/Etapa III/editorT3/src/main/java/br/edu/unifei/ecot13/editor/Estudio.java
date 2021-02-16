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
public class Estudio implements Serializable{
	private static final long serialVersionUID = 6836864591776419183L;
	
	@Id
	private Integer cnpj;
	private String nome;
	private String localizacao;
	
	@Relationship(type = "EMPREGA", direction = Relationship.OUTGOING)
	private List<Editor> editores = new ArrayList<>();

	@Relationship(type = "POSSUI", direction = Relationship.OUTGOING)
	private List<Equipamento> equipamentos = new ArrayList<>();
}
