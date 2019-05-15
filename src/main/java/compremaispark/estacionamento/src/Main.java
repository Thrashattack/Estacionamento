/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compremaispark.estacionamento.src;

/**
 *
 * @author Unknow
 */
import java.util.*;
import java.text.DateFormat; 
import java.text.SimpleDateFormat;


public class Main {
  private static Estacionamento compreMaisPark;  
  private static final Scanner in = new Scanner(System.in);
  private static final DateFormat simple = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss:SSS 'GMT' Z");
  public static void main(String [] args) {
    compreMaisPark = new Estacionamento();
       
    for(;;) {
    for(int i=0; i<=150; i++) 
    
     System.out.println("****************************************************"); 
      System.out.println("Seja bem vindo ao Estacionamento Compre Mais Park!");
      System.out.println("________________________________________________");
      System.out.println("|Carro & Caminhao: R$ 1.00 + R$ 1.00 por hora|||");
      System.out.println("|Motos: R$ 0.50 + R$ 1.00 por hora||||||||||||||");
      System.out.println("|Bicicleta: R$ 1.00 por hora||||||||||||||||||||");
      System.out.println("________________________________________________\n\n");
      System.out.println("\t\tEscolha sua opcao:\n\n");
      System.out.println("________________________________");
      System.out.println("1 - TUTORIAL (RECOMENDADO)     |");
      System.out.println("2 - Entrada de Veiculos        |");
      System.out.println("3 - Saida de Veiculo           |");
      System.out.println("4 - Administrativo             |");
      System.out.println("5 - Sair                       |");
      System.out.println("--------------------------------");
      
      System.out.println("\n\n\n");
      System.out.println("\n\n\n");
      try {
        switch(in.nextInt()) {
            case 1: 
            tutorial();
            break;
            case 2:
            entrada();
            break;
            case 3:
            saida();
            break;
            case 4:
            admin();
            break;
            case 5:
            System.exit(0);            
            default:
            break;
        }
      } catch(InputMismatchException e) {
          System.out.println("Opa! Digite um numero das opçoes!");
          in.nextLine();

      }
    }
    
  }
  
  public static void tutorial() {
      for(int i=0; i<=150; i++) 
        System.out.println();
      in.nextLine();  
      System.out.println("O Estacionamento aceita Carros, Motos Bicicletas e Caminhoes.");
      System.out.println("Para estacionar utilize a opçao 1 do menu. Para retirar a opçao 2.");
      System.out.println("Ao estacionar sera solicitado o tipo do veiculo. O sistema aceitara:"); 
      System.out.println("CARRO , MOTO, CAMINHAO e BIKE. Em maiusculo!"); 
      System.out.println("Caso seja isdoso ou PNE digite CARRO ESPECIAL.");
      System.out.println("Caso seja um de nossos colaboradores, digite MOTO ESPECIAL ou CAMINHAO ESPECIAL.");
      System.out.println("Veiculos especiais nao pagam taxas.");
      System.out.println("Ao terminar a entrada do veiculo, você sera informado do número da sua vaga.");
      System.out.println("Anote bem! pois esse e o código para retirar o veiculo!");
      System.out.println("Para retirar o veiculo, e necessario informar o número da vaga e tambem");
      System.out.println("o tipo do veiculo. Seguindo a mesma regra da entrada (CARRO, MOTO, CAMINHAO ESPECIAL, etc...)");
      System.out.println("O valor da taxa de estacionamento sera dado na hora da retirada."); 
      System.out.println("Caso não haja espaço para seu tipo de veículo, você será colocado em uma fila de espera.      Assim que um veículo do mesmo tipo que o seu sair, você será convocado.      Apenas Carros Especiais e Motos Especiais podem estacionar em todas as vagas. Caminhoes especiais so podem estacionar na sua respectiva vaga."); 
      System.out.println("Tenha boas compras!"); 
      System.out.println();
      System.out.println("Digite OK para retornar ao menu:");
      String ok = in.nextLine();
        
    
  }
  
  public static void entrada() {    
    in.nextLine();
    for(int i=0; i<=150; i++) 
        System.out.println(); 
    
    System.out.println("Legal! Vamos estacionar... ");
    System.out.println("Digite o tipo do veiculo: (MOTO, CARRO, CAMINHAO, BIKE, MOTO ESPECIAL, CARRO ESPECIAL, CAMINHAO ESPECIAL) ");
    String tipo = in.nextLine();
    switch(tipo.toUpperCase()) {
        case "MOTO": case "CARRO": case "CAMINHAO": 
            System.out.println("Digite a placa: ");
            String placa = in.nextLine();
            System.out.println("Digite a Cor: ");
            String cor = in.nextLine();
            System.out.println("Digite o numero de rodas: ");
            int numRodas = in.nextInt();
            in.nextLine();
            switch(numRodas) {
                case 2: case 3:
                    Moto moto = new Moto(numRodas, cor, tipo, false, placa);
                    try {
                        int numVaga = compreMaisPark.entrada(moto);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa" + moto.getPlaca() +
                         "foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                case 4: 
                    Carro carro = new Carro(numRodas, cor, tipo, false, placa);
                    try {
                        int numVaga = compreMaisPark.entrada(carro);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa "+ carro.getPlaca() +
                        " foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                case 5: case 6: case 7:
                case 8: case 9: case 10:
                    Caminhao truck = new Caminhao(numRodas, cor, tipo, false, placa);
                    try {
                        int numVaga = compreMaisPark.entrada(truck);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa "+ truck.getPlaca() +
                        "foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");                        
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                default:
                    System.out.println("Numero de rodas nao suportado :D");
                    System.out.println("Retornar (S/N)");
                    if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                        return;
                    }
                break;
            }
        break;
        case "MOTO ESPECIAL": case "CARRO ESPECIAL": case "CAMINHAO ESPECIAL":
            System.out.println("Digite a placa: ");
            String placaE = in.nextLine();
            System.out.println("Digite a Cor: ");
            String corE = in.nextLine();
            System.out.println("Digite o número de rodas: ");
            int numRodasE = in.nextInt();
            in.nextLine();
            switch(numRodasE) {
                case 2: case 3:
                    Moto moto = new Moto(numRodasE, corE, tipo, true, placaE);
                    try {
                        int numVaga = compreMaisPark.entrada(moto);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa "+ moto.getPlaca() + "foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                case 4: 
                    Carro carro = new Carro(numRodasE, corE, tipo, true, placaE);
                    try {
                        int numVaga = compreMaisPark.entrada(carro);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa " + carro.getPlaca() +
                        "foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                case 5: case 6: case 7:
                case 8: case 9: case 10:
                    Caminhao truck = new Caminhao(numRodasE, corE, tipo, true, placaE);
                    try {
                        int numVaga = compreMaisPark.entrada(truck);
                        Long time = System.currentTimeMillis();
                        System.out.println("Parabens! Seu veiculo de placa " + truck.getPlaca() +
                        " foi estacionado. ");
                        System.out.println("Data & Hora: " + simple.format(new Date(time)));
                        System.out.println("NUMERO DA VAGA: " + numVaga);
                        System.out.println("ANOTE BEM!!!!!!");
                        System.out.println("Retornar (S/N)");                        
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }

                    } catch(VagasEsgotadasException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Retornar (S/N)");
                        if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                            return;
                        }
                    }
                break;
                default:
                    System.out.println("Numero de rodas nao suportado :D");
                    System.out.println("Retornar (S/N)");
                    if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                        return;
                    }
                break;
            }
        break;
        case "BIKE":
            System.out.println("Digite a cor da sua Bike Maneira:");
            String cor2 = in.nextLine();
            Bicicleta bike = new Bicicleta(2, cor2, tipo);
                try {
                    int numVaga = compreMaisPark.entrada(bike);
                    Long time = System.currentTimeMillis();
                    System.out.println("Parabens! Sua bike de cor "+ bike.getCor() +"foi estacionada. ");
                    System.out.println("Data & Hora: " + simple.format(new Date(time)));
                    System.out.println("NUMERO DA VAGA: " + numVaga);
                    System.out.println("ANOTE BEM!!!!!!");
                    System.out.println("Retornar (S/N)");                        
                    if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                        return;
                    }

                } catch(VagasEsgotadasException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Retornar (S/N)");
                    if(in.nextLine().equals("s") || in.nextLine().equals("S")) {
                        return;
                    }
                }
        break;
        default:
            System.out.println("Tipo desconhecido :D");
            System.out.println("Retornar (S/N)");
            if(in.nextLine().equals("s") || in.nextLine().equals("S")) 
                return;
            
        break;

    }
    
  }
  
  public static void saida() {
    for(int i=0; i<=150; i++) 
    System.out.println(); 

      System.out.println("Esta na hora de Vazar! " );
      System.out.println("Digite o número de sua vaga :");
      int numVaga = in.nextInt();
      in.nextLine();
      System.out.println("Digite o tipo do veiculo (Seguindo os padrões da entrada) :");
      String tipo = in.nextLine();
      Veichle v = compreMaisPark.getVeichle(numVaga, tipo); 

      Double taxa =  v == null || tipo.equals("MOTO ESPECIAL") || tipo.equals("CARRO ESPECIAL")
      || tipo.equals("CAMINHAO ESPECIAL") ? 0.00 : compreMaisPark.calculaTaxa(v);

      System.out.println("Sua taxa total : " + taxa);
      if (taxa != 0.00) {
        System.out.println("Digite o valor que você deixou honestamente na caixinha ao lado (com centavos):");
        if(in.nextDouble() >=  taxa) {
            in.nextLine();
            if (tipo.equals("BIKE")) {
                String msg =  compreMaisPark.saida(numVaga);
                System.out.println(msg);
                if(msg.contains("vaga vazia")) {    
                    in.nextLine();
                    return;
                }
            }
            String msg =  compreMaisPark.saida(numVaga, tipo);
            System.out.println(msg);
            if(msg.contains("vaga vazia")) {    
                in.nextLine();
                return; 
            }
            System.out.println("Continuar (S)");
            in.nextLine();
            for(int i=0; i<=150; i++) 
                System.out.println(); 
            System.out.println("Consultando fila de espera para " + tipo);
            try {
                Veichle veiculo = compreMaisPark.consultaFilaDeEspera(tipo);
                if (veiculo == null) {
                    System.out.println("Sem " + tipo + " na fila");
                    in.nextLine();
                    return;
                }
                else if (tipo.equals("CARRO")) {
                    Carro car = (Carro)veiculo;
                    System.out.println("Chamando carro de placa " + car.getPlaca() + " da fila de espera...");
                    int num = compreMaisPark.entrada(car);
                    in.nextLine();
                    Long time = System.currentTimeMillis();
                    System.out.println("Parabens! Seu veiculo de placa " + car.getPlaca() +"foi estacionado. ");
                    System.out.println("Data & Hora: " + simple.format(new Date(time)));
                    System.out.println("NUMERO DA VAGA: " + numVaga);
                    System.out.println("ANOTE BEM!!!!!!");
                    System.out.println("Retornar (S/N)");
                    String s = in.nextLine();                        
                    if(s.equals("s") || s.equals("S")) {
                        return;
                    }
                } 
                else if (tipo.equals("MOTO")) {
                    Moto moto = (Moto)veiculo;
                    System.out.println("Chamando Moto de placa " + moto.getPlaca() + " da fila de espera...");
                    int num = compreMaisPark.entrada(moto);
                    in.nextLine();
                    Long time = System.currentTimeMillis();
                    System.out.println("Parabens! Seu veiculo de placa " + moto.getPlaca() +"foi estacionado. ");
                    System.out.println("Data & Hora: " + simple.format(new Date(time)));
                    System.out.println("NUMERO DA VAGA: " + numVaga);
                    System.out.println("ANOTE BEM!!!!!!");
                    System.out.println("Retornar (S/N)");
                    String s = in.nextLine();                        
                    if(s.equals("s") || s.equals("S")) {
                        return;
                    }
                }
                else if (tipo.equals("CAMINHAO")) {
                    Caminhao truck = (Caminhao)veiculo;
                    System.out.println("Chamando Caminhao de placa " + truck.getPlaca() + " da fila de espera...");
                    int num = compreMaisPark.entrada(truck);
                    in.nextLine();
                    Long time = System.currentTimeMillis();
                    System.out.println("Parabens! Seu veiculo de placa " + truck.getPlaca() +"foi estacionado. ");
                    System.out.println("Data & Hora: " + simple.format(new Date(time)));
                    System.out.println("NUMERO DA VAGA: " + numVaga);
                    System.out.println("ANOTE BEM!!!!!!");
                    System.out.println("Retornar (S/N)");
                    String s = in.nextLine();                        
                    if(s.equals("s") || s.equals("S")) {
                        return;
                    }
                }
                else {
                    Bicicleta bike = (Bicicleta)veiculo;
                    System.out.println("Chamando Bicicleta de cor " + bike.getCor() + " da fila de espera...");
                    int num = compreMaisPark.entrada(bike);
                    in.nextLine();
                    Long time = System.currentTimeMillis();
                    System.out.println("Parabens! Ssua bike de cor " + bike.getCor() +"foi estacionado. ");
                    System.out.println("Data & Hora: " + simple.format(new Date(time)));
                    System.out.println("NUMERO DA VAGA: " + numVaga);
                    System.out.println("ANOTE BEM!!!!!!");
                    System.out.println("Retornar (S/N)");
                    String s = in.nextLine();                        
                    if(s.equals("s") || s.equals("S")) {
                        return;
                    }
                } 
            } catch( RuntimeException e) {
                System.out.println(e.getMessage());
                in.nextLine();
            }
        } else {
            System.out.println("Valor Inferior ao valor da Taxa!");
            System.out.println("Continuar (S)");
            return;
        }
    } else {
        System.out.println("Continuar (S)");
        in.nextLine();
        for(int i=0; i<=150; i++) 
            System.out.println();
        
        String saida = compreMaisPark.saida(numVaga, tipo);
        if (saida.contains("vaga vazia")) {
            in.nextLine();
            return;
        }      
        System.out.println("Consultando fila de espera para " + tipo);
            Veichle veiculo = compreMaisPark.consultaFilaDeEspera(tipo);
            if (veiculo == null) {
                System.out.println("Sem " + tipo + " na fila");
                in.nextLine();
                return;
            }
            else if (tipo.equals("CARRO ESPECIAL")) {
                Carro car = (Carro)veiculo;
                System.out.println("Chamando carro de placa " + car.getPlaca() + " da fila de espera...");
                int num = compreMaisPark.entrada(car);
                in.nextLine();
                Long time = System.currentTimeMillis();
                System.out.println("Parabens! Seu veiculo de placa " + car.getPlaca() +"foi estacionado. ");
                System.out.println("Data & Hora: " + simple.format(new Date(time)));
                System.out.println("NUMERO DA VAGA: " + numVaga);
                System.out.println("ANOTE BEM!!!!!!");
                System.out.println("Retornar (S/N)");
                String s = in.nextLine();                        
                if(s.equals("s") || s.equals("S")) {
                    return;
                }
            }
            else if (tipo.equals("MOTO ESPECIAL")){
                Moto moto = (Moto)veiculo;
                System.out.println("Chamando Moto de placa " + moto.getPlaca() + " da fila de espera...");
                int num = compreMaisPark.entrada(moto);
                in.nextLine();
                Long time = System.currentTimeMillis();
                System.out.println("Parabens! Seu veiculo de placa " + moto.getPlaca() +"foi estacionado. ");
                System.out.println("Data & Hora: " + simple.format(new Date(time)));
                System.out.println("NUMERO DA VAGA: " + numVaga);
                System.out.println("ANOTE BEM!!!!!!");
                System.out.println("Retornar (S/N)");
                String s = in.nextLine();                        
                if(s.equals("s") || s.equals("S")) {
                    return;
                }
            }
            else {
                Caminhao truck = (Caminhao)veiculo;
                System.out.println("Chamando Caminhao de placa " + truck.getPlaca() + " da fila de espera...");
                int num = compreMaisPark.entrada(truck);
                in.nextLine();
                Long time = System.currentTimeMillis();
                System.out.println("Parabens! Seu veiculo de placa " + truck.getPlaca() +"foi estacionado. ");
                System.out.println("Data & Hora: " + simple.format(new Date(time)));
                System.out.println("NUMERO DA VAGA: " + numVaga);
                System.out.println("ANOTE BEM!!!!!!");
                System.out.println("Retornar (S/N)");
                String s = in.nextLine();                        
                if(s.equals("s") || s.equals("S")) {
                    return;
                }
            }
    }

    
  }

  public static void admin() {
      for(int i=0; i<=150; i++)
        System.out.println();
      in.nextLine();
      System.out.println("Insira o numero do Relatorio que deseja acessar: ");
      System.out.println("1 - Relatorio de Tempo medio de permanencia de veiculos (Carro, Moto, Bike, Caminhao");
      System.out.println("2 - Relatorio de Tempo medio de permanencia de veiculos especiais (Carros Idosos e PNE");
      System.out.println("3 - Status de Moto Entregadores");
      System.out.println("4 - Status de Caminhoes Entregadores");
      System.out.println("5 - Retornar");
      int relatorio = in.nextInt();
      in.nextLine();
      switch(relatorio) {
          case 1: 
          System.out.println(
              RelatoriosEstacionamento.tempoMedioDePermanenciaNormais(
                  compreMaisPark.getTemposEntrada(), compreMaisPark.getTemposSaida()));
          in.nextLine();
          return;
          case 2:
          System.out.println(
              RelatoriosEstacionamento.tempoMedioDePermanenciaPneIdosos(
                  compreMaisPark.getTemposEntrada(), compreMaisPark.getTemposSaida()));
          in.nextLine();
          return;
          case 3:
          System.out.println(
              RelatoriosEstacionamento.statusMotoEntregadores(
                  compreMaisPark.getTemposEntrada(), compreMaisPark.getTemposSaida()));
          in.nextLine();
          return;
          case 4: 
          System.out.println(
              RelatoriosEstacionamento.statusCaminhoesEntregadores(
                  compreMaisPark.getTemposEntrada(), compreMaisPark.getTemposSaida()));
          in.nextLine();
          return;
          default:
      }


  }
}
