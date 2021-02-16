package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class EdicaoAudio extends Software implements Serializable{
	private static final long serialVersionUID = -5543825214875069834L;
	
	private List<Mixagem> mixagem = new ArrayList<>();
	private Integer volume;
	
}
