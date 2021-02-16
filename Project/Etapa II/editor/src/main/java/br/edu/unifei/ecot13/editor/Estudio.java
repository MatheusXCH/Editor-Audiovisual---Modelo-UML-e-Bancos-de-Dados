package br.edu.unifei.ecot13.editor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Estudio implements Serializable{
	private static final long serialVersionUID = 6836864591776419183L;
	
	@Id
	private int cnpj;
	private String nome;
	private String localizacao;
	
	@OneToMany
	private List<Editor> editores = new ArrayList<>();
	@OneToMany
	private List<Equipamento> equipamentos = new ArrayList<>();
}
