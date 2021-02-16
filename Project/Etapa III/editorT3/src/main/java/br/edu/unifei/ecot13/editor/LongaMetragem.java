package br.edu.unifei.ecot13.editor;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class LongaMetragem extends Cinematografico {
	private static final long serialVersionUID = -1540222217889045783L;
	
	private static final Integer duracaoMin = 61;

	@Override
	public void setDuracao(Integer duracao) {
		if(duracao >= duracaoMin) {
			this.duracao = duracao;
		}
	}
}
