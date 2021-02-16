package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class CurtaMetragem extends Cinematografico implements Serializable{
	private static final long serialVersionUID = 8935325631799654114L;
	
	private static final int duracaoMax = 60;
	private String intencao;
	private String meioDistribuicao;
	
	@Override
	public void setDuracao(int duracao) {
		if(duracao <= duracaoMax) {
			this.duracao = duracao;
		}
	}
}
