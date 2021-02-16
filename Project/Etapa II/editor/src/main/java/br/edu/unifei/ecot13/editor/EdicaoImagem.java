package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class EdicaoImagem extends Software implements Serializable{
	private static final long serialVersionUID = 1460323964760874258L;
	
	@ElementCollection(targetClass = Corte.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="tipo_corte")
	@Column(name="corte")
	private List<Corte> tipoCorte = new ArrayList<>();
	private int brilho;
	private int contraste;		
}
