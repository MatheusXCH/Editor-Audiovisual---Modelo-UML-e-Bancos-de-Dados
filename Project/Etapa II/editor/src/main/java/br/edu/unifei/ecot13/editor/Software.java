package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public abstract class Software implements Serializable{
	private static final long serialVersionUID = 8322027177033344533L;
	
	@Id
	private String nome;
	private String desenvolvedora;
	private boolean isPago;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Equipamento> equipamentos = new ArrayList<>();
}
