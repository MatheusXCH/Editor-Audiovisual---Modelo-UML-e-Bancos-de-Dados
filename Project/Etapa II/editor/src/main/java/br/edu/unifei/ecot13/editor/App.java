package br.edu.unifei.ecot13.editor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("editorPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		//Clientes, Solicitacoes e Produtora
				Estrangeiro e = new Estrangeiro();
				e.setIdioma("Inglês");
				e.setMoeda(Moeda.DOLAR_US);
				e.setPais("Estados Unidos");
				
				Nacional n = new Nacional();
				n.setEstado("São Paulo");
				
				Empresa empresa1  = new Empresa();
				empresa1.setNacionalidade(e);
				empresa1.setNome("EMP Films");
				empresa1.setDinheiro(2000);
				empresa1.setDinheiro(empresa1.convReal());//converte dolar->real
				empresa1.setCnpj(123456789);
				
				PessoaFisica pessoa1 = new PessoaFisica();
				pessoa1.setNacionalidade(n);
				pessoa1.setNome("João");
				pessoa1.setDinheiro(1000);
				pessoa1.setCpf(444888444);
				
				Produtora produtora1 = new Produtora();
				produtora1.setNome("P1 Entertainment");
				produtora1.setCnpj(9899834);
				
				Solicitacao s1 = new Solicitacao();
				s1.setContrato(1);
				s1.setCliente(empresa1);
				s1.setProdutora(produtora1);
				s1.setValor(1700);
				s1.setNomeVideo("'As Redes Sociais'");
				s1.setDataInicio("07/2020");
				s1.setPrazoFinal("08/2020");
				empresa1.getSolicitacao().add(s1);
				
				Solicitacao s2 = new Solicitacao();
				s2.setCliente(empresa1);
				s2.setProdutora(produtora1);
				s2.setContrato(2);
				s2.setNomeVideo("'Meu Melhor Amigo'");
				s2.setValor(3600);
				s2.setDataInicio("07/2020");
				s2.setPrazoFinal("04/2021");
				empresa1.getSolicitacao().add(s2);
				
				Solicitacao s3 = new Solicitacao();
				s3.setCliente(pessoa1);
				s3.setProdutora(produtora1);
				s3.setContrato(3);
				s3.setNomeVideo("'Conheça a BR Produções'");
				s3.setValor(800);
				s3.setDataInicio("07/2020");
				s3.setPrazoFinal("10/2020");
				pessoa1.getSolicitacao().add(s3);
				
				produtora1.getSolicitacoes().add(s1);
				produtora1.getSolicitacoes().add(s2);
				produtora1.getSolicitacoes().add(s3);
				
				//Estudios, Editores e Equipamentos
				Equipamento equip1 = new Equipamento();
				equip1.setNumSerie(10293847);
				equip1.setTipoEquipamento("MacBook");
				equip1.setMarca("Apple");
				
				Equipamento equip2 = new Equipamento();
				equip2.setNumSerie(85940321);
				equip2.setTipoEquipamento("Mesa de Som");
				equip2.setMarca("Yamaha");
				
				Editor editor1 = new Editor();
				editor1.setNome("José");
				editor1.setIdade(22);
				editor1.setPortfolio("A5 Studios");
				editor1.getEquipUtilizados().add(equip1);
				editor1.getEquipUtilizados().add(equip2);
				
				Editor editor2 = new Editor();
				editor2.setNome("Lucas");
				editor2.setIdade(27);
				editor2.setPortfolio("A5 Studios");
				editor2.getEquipUtilizados().add(equip1);
				editor2.getEquipUtilizados().add(equip2);
				
				Editor editor3 = new Editor();
				editor3.setNome("Marcos");
				editor3.setIdade(34);
				editor3.setPortfolio("F6 Studios");
				editor3.getEquipUtilizados().add(equip1);
				editor3.getEquipUtilizados().add(equip2);
				
				Estudio estudio1 = new Estudio();
				estudio1.setCnpj(888999777);
				estudio1.setNome("P1 Studios");
				estudio1.setLocalizacao("São Paulo");
				editor1.setEstudio(estudio1);
				editor2.setEstudio(estudio1);
				editor3.setEstudio(estudio1);
				estudio1.getEditores().add(editor1);
				estudio1.getEditores().add(editor2);
				estudio1.getEditores().add(editor3);
				estudio1.getEquipamentos().add(equip1);
				estudio1.getEquipamentos().add(equip2);
				produtora1.getEstudios().add(estudio1);
				
				//Softwares
				EdicaoVideo soft1 = new EdicaoVideo();
				soft1.setNome("Adobe Premiere");
				soft1.setDesenvolvedora("Adobe");
				soft1.setPago(true);
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
				plugin1.setPago(false);
				plugin1.getEquipamentos().add(equip1);
				soft1.getPlugins().add(plugin1);
				
				EdicaoImagem soft2 = new EdicaoImagem();
				soft2.setNome("Adobe Photoshop");
				soft2.setDesenvolvedora("Adobe");
				soft2.setPago(true);
				soft2.setBrilho(50);
				soft2.setContraste(50);
				soft2.getEquipamentos().add(equip1);
				soft2.getTipoCorte().add(Corte.CORRIGIR);
				soft2.getTipoCorte().add(Corte.LIVRE);
				soft2.getTipoCorte().add(Corte.RETANGULAR);
				soft2.getTipoCorte().add(Corte.ROTACIONAR);
				
				EdicaoAudio soft3 = new EdicaoAudio();
				soft3.setNome("Adobe Audition");
				soft3.setDesenvolvedora("Adobe");
				soft3.setPago(true);
				soft3.setVolume(100);
				soft3.getEquipamentos().add(equip1);
				soft3.getMixagem().add(Mixagem.CROSSFADE);
				soft3.getMixagem().add(Mixagem.EQUALIZACAO);
				soft3.getMixagem().add(Mixagem.MODULACAO);
				soft3.getMixagem().add(Mixagem.REDUZIR_RUIDO);
				
				equip1.getSoftwares().add(soft1);
				equip1.getSoftwares().add(soft2);
				equip1.getSoftwares().add(soft3);
				equip1.getSoftwares().add(plugin1);//Macbook possui todos os softwares da Adobe
				
				//Videos
				Comercial video1 = new Comercial();
				video1.setNome(s3.getNomeVideo());
				video1.setCodigo(1);
				video1.setFormato("WMV");
				video1.setDuracao(15);
				video1.setCanal("BR Produções");
				video1.setPlataforma("YouTube");
				editor1.getProduzVideo().add(video1);// José faz o Comercial
				
				CurtaMetragem video2 = new CurtaMetragem();
				video2.setNome(s1.getNomeVideo());
				video2.setCodigo(2);
				video2.setFormato("MKV");
				video2.setDuracao(32);
				video2.setDiretor("Júlio");
				video2.setRoteirista("Adriano");
				video2.setIntencao("Educacional");
				video2.setMeioDistribuicao("Redes Sociais");
				editor2.getProduzVideo().add(video2); //Lucas faz o Curta
				
				LongaMetragem video3 = new LongaMetragem();
				video3.setNome(s2.getNomeVideo());
				video3.setCodigo(3);
				video3.setFormato("BD");
				video3.setDuracao(110);
				video3.setDiretor("Amanda");
				video3.setRoteirista("Bianca");
				editor1.getProduzVideo().add(video3);
				editor2.getProduzVideo().add(video3);
				editor3.getProduzVideo().add(video3);//Os 3 editores fazem o Longa
				
				
				//PERSISTÊNCIAS:
				em.persist(e);
				em.persist(n);
				em.persist(s1);
				em.persist(s2);
				em.persist(s3);
				em.persist(video1);
				em.persist(video2);
				em.persist(video3);
				em.persist(empresa1);
				em.persist(pessoa1);
				em.persist(produtora1);
				em.persist(equip1);
				em.persist(equip2);
				em.persist(editor1);
				em.persist(editor2);
				em.persist(editor3);
				em.persist(estudio1);
				em.persist(soft1);
				em.persist(plugin1);
				em.persist(soft2);
				em.persist(soft3);
				
				
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}