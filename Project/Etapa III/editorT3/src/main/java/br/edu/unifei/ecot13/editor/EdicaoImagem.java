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
public class EdicaoImagem extends Software implements Serializable{
	private static final long serialVersionUID = 1460323964760874258L;
	
	private List<Corte> tipoCorte = new ArrayList<>();
	private Integer brilho;
	private Integer contraste;		
}
