package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Editor implements Serializable{
	private static final long serialVersionUID = -4345304493821994812L;
	
	@Id
	private String nome;
	private int idade;
	private String portfolio;
	
	@ManyToOne
	private Estudio estudio;
	@ManyToMany
	private List<Equipamento> equipUtilizados = new ArrayList<>();
	@ManyToMany
	private List<Video> produzVideo = new ArrayList<>();
}
