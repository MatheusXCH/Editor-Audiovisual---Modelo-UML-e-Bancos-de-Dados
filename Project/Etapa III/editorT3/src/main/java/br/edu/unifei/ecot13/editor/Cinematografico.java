package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class Cinematografico extends Video implements Serializable{
	private static final long serialVersionUID = -29971980520881369L;
	
	private String diretor;
	private String roteirista;
	
}
