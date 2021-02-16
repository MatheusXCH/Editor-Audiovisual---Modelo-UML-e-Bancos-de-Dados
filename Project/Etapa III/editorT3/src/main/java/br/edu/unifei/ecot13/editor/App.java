package br.edu.unifei.ecot13.editor;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;

public class App {

	public static void main(String[] args) {
		Configuration conf = new Configuration.Builder()
				.uri("bolt://localhost")
				.credentials("neo4j", "neo4j")
				.connectionPoolSize(150)
				.build();
		
		SessionFactory fac 
			= new SessionFactory(conf, "br.edu.unifei.ecot13.editor");
		
		Session se = fac.openSession();
		Transaction tra;
			

		//Clientes, Solicitacoes e Produtora
				Estrangeiro e = new Estrangeiro();
				e.setIdioma("Ingles");
				e.setMoeda(Moeda.DOLAR_US);
				e.setPais("Estados Unidos");
				
				//Salva Estrangeiro
				tra = se.beginTransaction();
				se.save(e,1);
				tra.commit();
				
				Nacional n = new Nacional();
				n.setEstado("Sao Paulo");
				
				//Salva Nacional
				tra = se.beginTransaction();
				se.save(n,1);
				tra.commit();
				
				Empresa empresa1  = new Empresa();
				empresa1.setNacionalidade(e);
				empresa1.setDinheiro(10000.0);
				empresa1.setNome("EMP Films");
				//empresa1.setDinheiro(empresa1.convReal());//converte dolar->real
				empresa1.setCnpj(123456789);
				
				PessoaFisica pessoa1 = new PessoaFisica();
				pessoa1.setNacionalidade(n);
				pessoa1.setDinheiro(1000.0);
				pessoa1.setNome("Joao");
				pessoa1.setCpf(444888444);
				
				Produtora produtora1 = new Produtora();
				produtora1.setNome("P1 Entertainment");
				produtora1.setCnpj(9899834);
				
				Solicitacao s1 = new Solicitacao();
				s1.setContrato(1);
				s1.setCliente(empresa1);
				s1.setProdutora(produtora1);
				s1.setValor(1700.0);
				s1.setNomeVideo("'As Redes Sociais'");
				s1.setDataInicio("07/2020");
				s1.setPrazoFinal("08/2020");
				empresa1.getSolicitacao().add(s1);
				
				//Salva S1
				tra = se.beginTransaction();
				se.save(s1,1);
				tra.commit();
				
				Solicitacao s2 = new Solicitacao();
				s2.setCliente(empresa1);
				s2.setProdutora(produtora1);
				s2.setContrato(2);
				s2.setNomeVideo("'Meu Melhor Amigo'");
				s2.setValor(3600.0);
				s2.setDataInicio("07/2020");
				s2.setPrazoFinal("04/2021");
				empresa1.getSolicitacao().add(s2);
				
				//Salva Empresa1
				tra = se.beginTransaction();
				se.save(empresa1,1);
				tra.commit();
				
				//Salva S2
				tra = se.beginTransaction();
				se.save(s2,1);
				tra.commit();
				
				Solicitacao s3 = new Solicitacao();
				s3.setCliente(pessoa1);
				s3.setProdutora(produtora1);
				s3.setContrato(3);
				s3.setNomeVideo("'Conheca a BR Producoes'");
				s3.setValor(800.0);
				s3.setDataInicio("07/2020");
				s3.setPrazoFinal("10/2020");
				pessoa1.getSolicitacao().add(s3);
				
				//Salva Pessoa1
				tra = se.beginTransaction();
				se.save(pessoa1,1);
				tra.commit();
				
				//Salva S3
				tra = se.beginTransaction();
				se.save(s3,1);
				tra.commit();
				
				//Videos
				Comercial video1 = new Comercial();
				video1.setNome(s3.getNomeVideo());
				video1.setCodigo(1);
				video1.setFormato("WMV");
				video1.setDuracao(15);
				video1.setCanal("BR Producoes");
				video1.setPlataforma("YouTube");
				
				//Salva Video1
				tra = se.beginTransaction();
				se.save(video1,1);
				tra.commit();
				
				CurtaMetragem video2 = new CurtaMetragem();
				video2.setNome(s1.getNomeVideo());
				video2.setCodigo(2);
				video2.setFormato("MKV");
				video2.setDuracao(32);
				video2.setDiretor("Julio");
				video2.setRoteirista("Adriano");
				video2.setIntencao("Educacional");
				video2.setMeioDistribuicao("Redes Sociais");
				
				//Salva Video2
				tra = se.beginTransaction();
				se.save(video2,1);
				tra.commit();
				
				LongaMetragem video3 = new LongaMetragem();
				video3.setNome(s2.getNomeVideo());
				video3.setCodigo(3);
				video3.setFormato("BD");
				video3.setDuracao(110);
				video3.setDiretor("Amanda");
				video3.setRoteirista("Bianca");

				//Salva Video3
				tra = se.beginTransaction();
				se.save(video3,1);
				tra.commit();
				
				produtora1.getSolicitacoes().add(s1);
				produtora1.getSolicitacoes().add(s2);
				produtora1.getSolicitacoes().add(s3);
				
				//Salva Produtora1
				tra = se.beginTransaction();
				se.save(produtora1,1);
				tra.commit();
				
				//Estudios, Editores e Equipamentos
				Equipamento equip1 = new Equipamento();
				equip1.setNumSerie(10293847);
				equip1.setTipoEquipamento("MacBook");
				equip1.setMarca("Apple");
				
				//Salva Equip1
				tra = se.beginTransaction();
				se.save(equip1,1);
				tra.commit();
				
				Equipamento equip2 = new Equipamento();
				equip2.setNumSerie(85940321);
				equip2.setTipoEquipamento("Mesa de Som");
				equip2.setMarca("Yamaha");
				
				//Salva Equip2
				tra = se.beginTransaction();
				se.save(equip2,1);
				tra.commit();
				
				Editor editor1 = new Editor();
				editor1.setNome("Jose");
				editor1.setIdade(22);
				editor1.setPortfolio("A5 Studios");
				editor1.getEquipUtilizados().add(equip1);
				editor1.getEquipUtilizados().add(equip2);
				editor1.getProduzVideo().add(video3);
				editor1.getProduzVideo().add(video1);// Jose faz o Comercial
				
				//Salva Editor1
				tra = se.beginTransaction();
				se.save(editor1,1);
				tra.commit();
				
				Editor editor2 = new Editor();
				editor2.setNome("Lucas");
				editor2.setIdade(27);
				editor2.setPortfolio("A5 Studios");
				editor2.getEquipUtilizados().add(equip1);
				editor2.getEquipUtilizados().add(equip2);
				editor2.getProduzVideo().add(video3);
				editor2.getProduzVideo().add(video2); //Lucas faz o Curta
				
				//Salva Editor2
				tra = se.beginTransaction();
				se.save(editor2,1);
				tra.commit();
				
				Editor editor3 = new Editor();
				editor3.setNome("Marcos");
				editor3.setIdade(34);
				editor3.setPortfolio("F6 Studios");
				editor3.getEquipUtilizados().add(equip1);
				editor3.getEquipUtilizados().add(equip2);
				editor3.getProduzVideo().add(video3);//Os 3 editores fazem o Longa
				
				//Salva Editor3
				tra = se.beginTransaction();
				se.save(editor3,1);
				tra.commit();
				
				Estudio estudio1 = new Estudio();
				estudio1.setCnpj(888999777);
				estudio1.setNome("P1 Studios");
				estudio1.setLocalizacao("Sao Paulo");
				estudio1.getEditores().add(editor1);
				estudio1.getEditores().add(editor2);
				estudio1.getEditores().add(editor3);
				estudio1.getEquipamentos().add(equip1);
				estudio1.getEquipamentos().add(equip2);
				
				//Salva Estudio1
				tra = se.beginTransaction();
				se.save(estudio1,1);
				tra.commit();
				
				editor1.setEstudio(estudio1);
				editor2.setEstudio(estudio1);
				editor3.setEstudio(estudio1);
				
				//Atualiza Editores
				tra = se.beginTransaction();
				se.save(editor1,1);
				se.save(editor2,1);
				se.save(editor3,1);
				tra.commit();
			
				produtora1.getEstudios().add(estudio1);
				
				//Atualiza Produtora1
				tra = se.beginTransaction();
				se.save(produtora1,1);
				tra.commit();
				
				//Softwares
				EdicaoVideo soft1 = new EdicaoVideo();
				soft1.setNome("Adobe Premiere");
				soft1.setDesenvolvedora("Adobe");
				soft1.setIsPago(true);
				soft1.getEfeito().add(Efeito.CONVOLUCAO);
				soft1.getEfeito().add(Efeito.EXTRAIR);
				soft1.getEfeito().add(Efeito.DESFOQUE);
				soft1.getEfeito().add(Efeito.NITIDEZ);
				soft1.getEquipamentos().add(equip1);
				soft1.getPosProcessamento().add(PosProcessamento.CANAL_3D);
				soft1.getPosProcessamento().add(PosProcessamento.CORRECAO_CORES);
				soft1.getPosProcessamento().add(PosProcessamento.DISTORCER);
				soft1.getPosProcessamento().add(PosProcessamento.RUIDO_GRANULACAO);
				
				EdicaoVideo plugin1 = new EdicaoVideo();
				plugin1.setNome("Luminous");
				plugin1.setDesenvolvedora("PP Transitions");
				plugin1.setIsPago(false);
				plugin1.getEquipamentos().add(equip1);
				soft1.getPlugins().add(plugin1);
				
				//Salva Plugin1
				tra = se.beginTransaction();
				se.save(plugin1,1);
				tra.commit();
				
				//Salva Soft1
				tra = se.beginTransaction();
				se.save(soft1,1);
				tra.commit();
				
				EdicaoImagem soft2 = new EdicaoImagem();
				soft2.setNome("Adobe Photoshop");
				soft2.setDesenvolvedora("Adobe");
				soft2.setIsPago(true);
				soft2.setBrilho(50);
				soft2.setContraste(50);
				soft2.getEquipamentos().add(equip1);
				soft2.getTipoCorte().add(Corte.CORRIGIR);
				soft2.getTipoCorte().add(Corte.LIVRE);
				soft2.getTipoCorte().add(Corte.RETANGULAR);
				soft2.getTipoCorte().add(Corte.ROTACIONAR);
				
				//Salva Soft2
				tra = se.beginTransaction();
				se.save(soft2,1);
				tra.commit();
				
				EdicaoAudio soft3 = new EdicaoAudio();
				soft3.setNome("Adobe Audition");
				soft3.setDesenvolvedora("Adobe");
				soft3.setIsPago(true);
				soft3.setVolume(100);
				soft3.getEquipamentos().add(equip1);
				soft3.getMixagem().add(Mixagem.CROSSFADE);
				soft3.getMixagem().add(Mixagem.EQUALIZACAO);
				soft3.getMixagem().add(Mixagem.MODULACAO);
				soft3.getMixagem().add(Mixagem.REDUZIR_RUIDO);
				
				//Salva Soft3
				tra = se.beginTransaction();
				se.save(soft3,1);
				tra.commit();
				
				equip1.getSoftwares().add(soft1);
				equip1.getSoftwares().add(soft2);
				equip1.getSoftwares().add(soft3);
				equip1.getSoftwares().add(plugin1);//Macbook possui todos os softwares da Adobe
				
				//Atualiza Equip1
				tra = se.beginTransaction();
				se.save(equip1,1);
				tra.commit();
				
				/*
				//TRANSACTION SAVE
				tra = se.beginTransaction();
				se.save(e,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(n,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(s1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(s2,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(s3,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(video1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(video2,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(video3,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(empresa1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(pessoa1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(produtora1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(equip1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(equip2,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(editor1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(editor2,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(editor3,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(estudio1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(soft1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(plugin1,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(soft2,1);
				tra.commit();
				
				tra = se.beginTransaction();
				se.save(soft3,1);
				tra.commit();
				
				*/

			System.out.println(">>Transação foi fechada<<");
			fac.close();
			System.out.println(">>Fabrica foi fechada<<");
	}
}