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
public class EdicaoAudio extends Software implements Serializable{
	private static final long serialVersionUID = -5543825214875069834L;
	
	@ElementCollection(targetClass = Mixagem.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="tipo_mixagem")
	@Column(name="mixagem")
	private List<Mixagem> mixagem = new ArrayList<>();
	private int volume;
	
}
