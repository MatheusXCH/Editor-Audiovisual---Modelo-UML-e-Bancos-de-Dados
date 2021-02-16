package br.edu.unifei.ecot13.editor;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class LongaMetragem extends Cinematografico {
	private static final long serialVersionUID = -1540222217889045783L;
	
	private static final int duracaoMin = 61;

	@Override
	public void setDuracao(int duracao) {
		if(duracao >= duracaoMin) {
			this.duracao = duracao;
		}
	}
}
