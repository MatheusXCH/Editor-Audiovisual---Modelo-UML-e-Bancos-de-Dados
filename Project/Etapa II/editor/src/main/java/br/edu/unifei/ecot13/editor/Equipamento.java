package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Equipamento implements Serializable{
	private static final long serialVersionUID = 7450575457294360678L;
	
	@Id
	private int numSerie;
	private String tipoEquipamento;
	private String marca;
	
	@ManyToMany
	private List<Software> softwares = new ArrayList<>();
}
