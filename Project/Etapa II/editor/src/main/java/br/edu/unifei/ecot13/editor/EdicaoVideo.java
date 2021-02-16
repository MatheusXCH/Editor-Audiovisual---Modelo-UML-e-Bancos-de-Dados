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
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class EdicaoVideo extends Software implements Serializable{
	private static final long serialVersionUID = -7709203197044778946L;
	
	@ElementCollection(targetClass = Efeito.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="tipo_efeito")
	@Column(name="efeito")
	private List<Efeito> efeito = new ArrayList<>();
	
	@ElementCollection(targetClass = PosProcessamento.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="tipo_posProcessamento")
	@Column(name="posProcessamento")
	private List<PosProcessamento> posProcessamento =  new ArrayList<PosProcessamento>();
	
	@OneToMany
	private List<Software> plugins = new ArrayList<>();	
}
