package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@Data
@NodeEntity
public class Nacionalidade implements Serializable{
	private static final long serialVersionUID = -5113940167221752690L;
	
	@Id @GeneratedValue
	private Long codigoNacionalidade;
	private String pais;
	
	
	//public double cambio(double dinheiro);
	
}
