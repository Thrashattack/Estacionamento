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
import javax.swing.*; 
import java.awt.*;

public class MainUi {
  private static final Estacionamento compreMaisPark = new Estacionamento();;  
  private static final Scanner in = new Scanner(System.in);
  private static final DateFormat simple = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss:SSS 'GMT' Z");

  public static void main(String [] args) {

    JFrame menuPrincipal = new JFrame("Compre Mais Park");    
    JPanel painelTexto = new JPanel(new GridLayout(1,1));
    JPanel painelBotoes = new JPanel(new GridLayout(2, 3));
    JTextArea welcome = new JTextArea("\tSeja bem vindo ao Estacionamento Compre Mais Park!\n"
    +"\t****************PRECOS**********************\n"
    +"\tCarro & Caminhao: R$ 1.00 + R$ 1.00 por hora\n"
    +"\tMotos: R$ 0.50 + R$ 1.00 por hora\n"
    +"\tBicicleta: R$ 1.00 por hora\n" +
    " \t********************************************\n");
    JButton botaoTutorial = new JButton("Tutorial (RECOMENDADO)");
    JButton botaoIn = new JButton("Entrada de Veiculo");
    JButton botaoOut = new JButton("Saida de Veiculo");
    JButton botaoAdm = new JButton("Administrativo");
    JButton botaoSair = new JButton("Sair");    

    welcome.setEditable(false);
    painelTexto.add(welcome);

    painelBotoes.add(botaoTutorial);
    painelBotoes.add(botaoIn);
    painelBotoes.add(botaoOut);
    painelBotoes.add(botaoAdm);
    painelBotoes.add(botaoSair);


    menuPrincipal.getContentPane().add(painelTexto, BorderLayout.NORTH);
    menuPrincipal.getContentPane().add(painelBotoes, BorderLayout.CENTER);    
    menuPrincipal.setSize(400, 400);
    menuPrincipal.setVisible(true);
    menuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    botaoTutorial.addActionListener(e -> {
        tutorial(menuPrincipal);
    });

    botaoIn.addActionListener(e -> {
        GridLayoutEntrada entering = new GridLayoutEntrada(compreMaisPark);
    });
    
    botaoOut.addActionListener(e -> {
        GridLayoutSaida out = new GridLayoutSaida(compreMaisPark);
    });
    
    botaoAdm.addActionListener(e -> {
        GridLayoutAdmin admin = new GridLayoutAdmin(compreMaisPark);
    });
    
    botaoSair.addActionListener(e -> {
        if(JOptionPane.showConfirmDialog(menuPrincipal,"Deseja Sair?", "Sair", JOptionPane.YES_NO_OPTION)==0)
            System.exit(0);        
    });


    
  }

  public static void tutorial(JFrame mainFrame) {
    JOptionPane.showMessageDialog(mainFrame, "O Estacionamento aceita Carros, Motos Bicicletas e Caminhoes.\n"+
    "Para estacionar utilize a opcao 1 do menu. Para retirar a opcao 2.\n"+
    "Ao estacionar sera solicitado o tipo do veiculo. O sistema aceitara:\n"+ 
    "CARRO , MOTO, CAMINHAO e BIKE\n"+ 
    "Caso seja isdoso ou PNE insira CARRO ESPECIAL.\n"+
    "Caso seja um de nossos colaboradores, insira MOTO ESPECIAL ou CAMINHAO ESPECIAL.\n"+
    "Veiculos especiais nao pagam taxas.\n"+
    "Ao terminar a entrada do veiculo, você sera informado do numero da sua vaga.\n"+
    "Anote bem! pois esse e o código para retirar o veiculo!\n"+
    "Para retirar o veiculo, e necessario informar o numero da vaga e tambem\n"+
    "o tipo do veiculo. Seguindo a mesma regra da entrada (CARRO, MOTO, CAMINHAO ESPECIAL, etc...)\n"+
    "O valor da taxa de estacionamento sera dado na hora da retirada.\n"+ 
    "Caso não haja espaco para seu tipo de veiculo, você sera colocado em uma fila de espera.\n"+
    "Assim que um veiculo do mesmo tipo que o seu sair, você sera convocado.\n"+
    "Apenas Carros Especiais e Motos Especiais podem estacionar em todas as vagas de carros e motos.\n"+
    "Caminhoes especiais so podem estacionar na sua respectiva vaga.\n"+ 
    "Tenha boas compras!\n"+
    "Pressione OK para retornar ao menu:\n");
      
  }
  
}
