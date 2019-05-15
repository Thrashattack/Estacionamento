/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compremaispark.estacionamento.src;


import java.util.*;

/**
 *
 * @author Carlos Cunha
 */
public class Estacionamento {
  
  //Objetos da classe
  private final Map<String,Veichle> vagas; 
  private final Map<Veichle,Long> temposDeEntrada;
  private final Map<Veichle,Long> temposDeSaida;
  private final FilaDeEspera<Veichle> filaDeEspera;
  private Double totalRecebido; // BigDecimal é uma implementaçao melhor
  //Variaveis de número de vagas ocupadas por tipo de veículo
  private int numVagasCarrosEspeciais, numVagasCarros, numVagasMotosEspeciais, numVagasMotos,
  numVagasBicicletas, numVagasCaminhoesEspeciais, numVagasCaminhoes;
  //Mensagens
  private final String vagaVazia;
  private final String veiculoRemovido;
  
  //Constantes de capacidade do Estacionamento
  private enum Capacidade {MAX_NUM_CARROS(5), MAX_NUM_MOTOS(5), MAX_NUM_CAMINHOES(1),
  MAX_NUM_BICICLETA(10), MAX_NUM_CARROS_ESPECIAIS(2), MAX_NUM_MOTO_ENTREGADORES(2),
  MAX_NUM_CAMINHOES_DESEMBARQUE(1);  
    public int valorCapacidade;
    Capacidade(int valor) {
        this.valorCapacidade = valor;
    }    
    public int getValor() {
        return this.valorCapacidade;
    }    

  };
  //Constantes de Chaves do Map vagas
  private enum TipoVeiculo { BIKE("BIKE"), MOTO("MOTO"), CARRO("CARRO"),
  CAMINHAO("CAMINHAO"), CARRO_ESPECIAL("CARRO ESPECIAL"), MOTO_ESPECIAL("MOTO ESPECIAL"),
  CAMINHAO_ESPECIAL("CAMINHAO ESPECIAL");
    public String tipo;
    TipoVeiculo(String tipo) {
        this.tipo = tipo;
    }
    public String getValor() {
        return this.tipo;
    }    
  };   
    
  
  
  //Construtor 
  public Estacionamento () {
    this.vagas = new HashMap<>();
    this.temposDeEntrada = new HashMap<>();
    this.temposDeSaida = new HashMap<>();
    this.filaDeEspera = new FilaDeEspera();
    this.totalRecebido = 0.00;
    this.numVagasCaminhoes = 0;
    this.numVagasCaminhoesEspeciais = 0;
    this.numVagasBicicletas = 0;
    this.numVagasMotosEspeciais = 0;
    this.numVagasMotos = 0;
    this.numVagasCarros = 0;
    this.numVagasCarrosEspeciais = 0;
    this.vagaVazia = "Tipo de veiculo inexistente ou vaga vazia !!\n\tATENCAO\n Nao nos responsabilizamos por terceiros se passando por você!";
    this.veiculoRemovido = "Veiculo removido com sucesso, Obrigado por utilizar o nosso sistema!\nVolte Sempre *-* !";

  }
  
  /**
     * @param c
  * @method entrada 
  * @return int "O número da vaga ou VagasEsgotadasException em caso de lista de espera"
  **/
  public int entrada(Carro c) throws VagasEsgotadasException {
    if (c.getEspecial()) { //caso carro especial
      if(this.numVagasCarrosEspeciais == Capacidade.MAX_NUM_CARROS_ESPECIAIS.getValor()) {
        if(this.numVagasCarros == Capacidade.MAX_NUM_CARROS.getValor()) { // exceçao de vagas esgotads
          this.filaDeEspera.getStack(TipoVeiculo.CARRO_ESPECIAL.getValor()).push(c); // insere na o carro na fila de carros especiais
          throw new VagasEsgotadasException(); 
        }
        else {
          this.vagas.put(TipoVeiculo.CARRO_ESPECIAL.getValor() + (++this.numVagasCarros + 10), c); // insere o carro no mapa e incrementa o número de carros
          this.temposDeEntrada.put(c, System.currentTimeMillis()); // cadastra o tempo de entrada 
          return this.numVagasCarros + 10; // caso carro especial estacionado em vaga normal 
        }
      } else {
        this.vagas.put(TipoVeiculo.CARRO_ESPECIAL.getValor() + ++this.numVagasCarrosEspeciais, c);
        this.temposDeEntrada.put(c, System.currentTimeMillis());
        return this.numVagasCarrosEspeciais;
      }
    } else if(this.numVagasCarros == Capacidade.MAX_NUM_CARROS.getValor()) {
        this.filaDeEspera.getStack(TipoVeiculo.CARRO.getValor()).push(c);
        throw new VagasEsgotadasException();
      } else {
        this.vagas.put(TipoVeiculo.CARRO.getValor() + ++this.numVagasCarros, c);
        this.temposDeEntrada.put(c, System.currentTimeMillis());
        return this.numVagasCarros;
      }
  }
  
  //Overload
  public int entrada(Moto m) throws VagasEsgotadasException {
  if (m.getEspecial()) { 
      if(this.numVagasMotosEspeciais == Capacidade.MAX_NUM_MOTO_ENTREGADORES.getValor()) {
        if(this.numVagasMotos == Capacidade.MAX_NUM_MOTOS.getValor()) {
          this.filaDeEspera.getStack(TipoVeiculo.MOTO.getValor()).push(m);
          throw new VagasEsgotadasException();
        }
        else {
          this.vagas.put(TipoVeiculo.MOTO_ESPECIAL.getValor() + (++this.numVagasMotos + 10), m);
          this.temposDeEntrada.put(m, System.currentTimeMillis());
          return this.numVagasMotos + 10;    
        }
      } else {
        this.vagas.put(TipoVeiculo.MOTO_ESPECIAL.getValor() + ++this.numVagasMotosEspeciais, m);
        this.temposDeEntrada.put(m, System.currentTimeMillis());
        return this.numVagasMotosEspeciais;
      }
    } else if(this.numVagasMotos == Capacidade.MAX_NUM_MOTOS.getValor()) {
        this.filaDeEspera.getStack(TipoVeiculo.MOTO.getValor()).push(m);
        throw new VagasEsgotadasException();
      } else {
        this.vagas.put(TipoVeiculo.MOTO.getValor() + ++this.numVagasMotos, m);
        this.temposDeEntrada.put(m, System.currentTimeMillis());
        return this.numVagasMotos;
      }
  }
  public int entrada(Bicicleta b) throws VagasEsgotadasException {
    if(this.numVagasBicicletas == Capacidade.MAX_NUM_BICICLETA.getValor()) {
      this.filaDeEspera.getStack(TipoVeiculo.BIKE.getValor()).push(b);
      throw new VagasEsgotadasException();
    } else {
      this.vagas.put(TipoVeiculo.BIKE.getValor() + ++this.numVagasBicicletas, b);
        this.temposDeEntrada.put(b, System.currentTimeMillis());
        return this.numVagasBicicletas;
    }
  }
  public int entrada(Caminhao t) throws VagasEsgotadasException {
   if(t.getEspecial()) {
     if(this.numVagasCaminhoesEspeciais == Capacidade.MAX_NUM_CAMINHOES_DESEMBARQUE.getValor()) {
       this.filaDeEspera.getStack(TipoVeiculo.CAMINHAO_ESPECIAL.getValor()).push(t);
       throw new VagasEsgotadasException();
     } else {
       this.vagas.put(TipoVeiculo.CAMINHAO_ESPECIAL.getValor() + ++this.numVagasCaminhoesEspeciais, t);
        this.temposDeEntrada.put(t, System.currentTimeMillis());
        return this.numVagasCaminhoesEspeciais;
     }
   } else if(this.numVagasCaminhoes == Capacidade.MAX_NUM_CAMINHOES.getValor()) {
       this.filaDeEspera.getStack(TipoVeiculo.CAMINHAO.getValor()).push(t);
       throw new VagasEsgotadasException();
     } else {
       this.vagas.put(TipoVeiculo.CAMINHAO.getValor() + ++this.numVagasCaminhoes, t);
        this.temposDeEntrada.put(t, System.currentTimeMillis());
       return this.numVagasCaminhoes;
     }
  }
  
  /**
     * @param numVagaMotorizado
     * @param tipo
   * @method saida
   * @return 0 - retirado, -1 - vaga vazia ou tipo inexistente"
   */
  public String saida (int numVagaMotorizado, String tipo) {    
    for(Map.Entry entry : vagas.entrySet()) {
      if(entry.getKey().equals(tipo+numVagaMotorizado)) {
        this.vagas.remove(entry.getKey()); // remove do mapa pela chave
        switch(tipo) {
          case "CARRO":
            this.temposDeSaida.put((Carro)entry.getValue(), System.currentTimeMillis());
            this.numVagasCarros--; 
            return this.veiculoRemovido;
          case "CARRO ESPECIAL":
            this.temposDeSaida.put((Carro)entry.getValue(), System.currentTimeMillis());
            if(numVagaMotorizado < 10) this.numVagasCarros--; // caso em vaga de carro normal
            else this.numVagasCarrosEspeciais--; 
            return this.veiculoRemovido;
          case "MOTO":
            this.temposDeSaida.put((Moto)entry.getValue(), System.currentTimeMillis());
            if(numVagaMotorizado < 10) this.numVagasMotos--;
            else this.numVagasMotosEspeciais--; 
            return this.veiculoRemovido;
          case "MOTO ESPECIAL":
            this.temposDeSaida.put((Moto)entry.getValue(), System.currentTimeMillis());
            this.numVagasMotosEspeciais--; 
            return this.veiculoRemovido;
          case "CAMINHAO":
            this.temposDeSaida.put((Caminhao)entry.getValue(), System.currentTimeMillis());
            this.numVagasCaminhoes--; 
            return this.veiculoRemovido;
          case "CAMINHAO ESPECIAL":
            this.temposDeSaida.put((Caminhao)entry.getValue(), System.currentTimeMillis());
            this.numVagasCaminhoesEspeciais--;
            return this.veiculoRemovido;
          case "BIKE":
            this.temposDeSaida.put((Bicicleta)entry.getValue(), System.currentTimeMillis());
            this.numVagasBicicletas--;
            return this.veiculoRemovido;
        }
      }
    }
    
    return this.vagaVazia;
  }
  //Overload
  public String saida(int numVagaBike) {
    if (numVagaBike > this.numVagasBicicletas)
        return this.vagaVazia;
         
    this.vagas.remove(TipoVeiculo.BIKE.getValor() + numVagaBike);    
    this.numVagasBicicletas--;
    return this.veiculoRemovido;
  }
  
  /**
     * @param tipo
   * @method consultaFilaDeEspera
   * @return Veichle "verifica se há veiculos do tipo esperando
   * e da entrada dos mesmos no estacionamento 
   * O veiculo - caso haja veículo do tipo aguardando, Null - caso não haja veículo do tipo esperando"
   * */
  public Veichle consultaFilaDeEspera(String tipo) {
    if(this.filaDeEspera.empty(tipo)) // caso fila de espera está vazia para o tipo informado
      return null;
    //caso veiculo que saiu seja moto ou carro MOTO e CARRO especial pode entrar
    if(tipo.equals(TipoVeiculo.MOTO.getValor())) {
      if(!this.filaDeEspera.getStack(TipoVeiculo.MOTO_ESPECIAL.getValor()).empty()) {
        int ultimo = this.filaDeEspera.getStack(TipoVeiculo.MOTO_ESPECIAL.getValor()).size()-1;
        return this.filaDeEspera.getStack(TipoVeiculo.MOTO_ESPECIAL.getValor()).remove(ultimo);
      }
    } else if(tipo.equals(TipoVeiculo.CARRO.getValor())) {
        if(!this.filaDeEspera.getStack(TipoVeiculo.CARRO_ESPECIAL.getValor()).empty()) {
          int ultimo = this.filaDeEspera.getStack(TipoVeiculo.CARRO_ESPECIAL.getValor()).size()-1;
          return this.filaDeEspera.getStack(TipoVeiculo.CARRO_ESPECIAL.getValor()).remove(ultimo);
        }
    }
    //Caso trivial
    int ultimo = this.filaDeEspera.getStack(tipo).size()-1;
    return this.filaDeEspera.getStack(tipo).remove(ultimo);
    
  }
  
  /**
     * @param numVaga
     * @param tipo
   * @method getVeichle
   * @return Veichle "o veículo"
   * */
  public Veichle getVeichle(int numVaga, String tipo) {
    String key = tipo+numVaga;
    return this.vagas.containsKey(key) ? this.vagas.get(key) : null;
  }
  
  /**
     * @param v
   * @method calculaTaxa
   * @return Double "a taxa"
   * */
  public Double calculaTaxa(Veichle v) {
    Long timeNow = System.currentTimeMillis();
    Long resultTime = timeNow - this.temposDeEntrada.get(v);
    Long horas = resultTime / 3600000;    
    if(v.getEspecial())
      return 0.0;
    if (v instanceof Carro || v instanceof Caminhao ) {
      Double taxa = horas + 1.00;
      this.totalRecebido += taxa;
      return taxa;
    } else if (v instanceof Moto) {
      double taxa = horas + 0.50;
      this.totalRecebido += taxa;
      return taxa;
    } else {
      this.totalRecebido += horas + 0.00;
      return horas + 0.00;
    }
  }

  /**
   * @method getTemposEntrada ()
   * @return HashMap<Veichle,Long> "mapa de tempos de entrada por veículo"
   */
  public Map getTemposEntrada() {
    return this.temposDeEntrada;
  }
  /**
   * @method getTemposSaida ()
   * @return HashMap<Veichle,Long> "mapa de tempos de saida por veículo"
   */
  public Map getTemposSaida() {
    return this.temposDeSaida;
  }
}
