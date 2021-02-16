package br.edu.unifei.ecot13.editor;

import java.io.Serializable;

import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@NodeEntity
public class CurtaMetragem extends Cinematografico implements Serializable{
	private static final long serialVersionUID = 8935325631799654114L;
	
	private static final Integer duracaoMax = 60;
	private String intencao;
	private String meioDistribuicao;
	
	@Override
	public void setDuracao(Integer duracao) {
		if(duracao <= duracaoMax) {
			this.duracao = duracao;
		}
	}
}
