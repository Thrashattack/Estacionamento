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
import javax.swing.*;
import java.awt.*;

public class GridLayoutSaida extends JFrame {
    private JPanel painelTexto, painelOpcoes, painelForm;
    private JButton buttonMoto, buttonCarro, buttonBike,
     buttonCaminhao, buttonMotoE, buttonCarroE, buttonCaminhaoE,
     buttonCancelar, buttonOk, buttonVoltar;
    private JLabel labelNumVaga, labelOpcoes;
    private JTextField fieldNumVaga;
    private String instance;

    public GridLayoutSaida(Estacionamento estacionamento) {
        super("Saida de Veiculo");
        instance = new String("");
        painelTexto = new JPanel(new GridLayout(1, 1));
        painelOpcoes = new JPanel(new GridLayout(2, 1));
        painelForm = new JPanel(new GridLayout(2, 2));

        buttonMoto = new JButton("MOTO");
        buttonCarro = new JButton("CARRO");
        buttonCaminhao = new JButton("CAMINHAO");
        buttonBike = new JButton("BIKE");
        buttonMotoE = new JButton("MOTO ESPECIAL");
        buttonCarroE = new JButton("CARRO ESPECIAL");
        buttonCaminhaoE = new JButton("CAMINHAO ESPECIAL");
        buttonVoltar = new JButton("Voltar");
        buttonCancelar = new JButton("Cancelar");
        buttonOk = new JButton("Ok");

        labelNumVaga = new JLabel("Insira o Numero de sua vaga:");
        labelOpcoes = new JLabel("Selecione o tipo do veiculo que deseja retirar:");

        fieldNumVaga = new JTextField();
        
        painelForm.setVisible(false);

       
        painelForm.add(labelNumVaga);
        painelForm.add(fieldNumVaga);
        painelForm.add(buttonOk);
        painelForm.add(buttonCancelar);

        painelTexto.add(labelOpcoes);

        painelOpcoes.add(buttonMoto);
        painelOpcoes.add(buttonCarro);
        painelOpcoes.add(buttonBike);
        painelOpcoes.add(buttonCaminhao);
        painelOpcoes.add(buttonCaminhaoE);
        painelOpcoes.add(buttonMotoE);
        painelOpcoes.add(buttonCarroE);
        painelOpcoes.add(buttonVoltar);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(painelTexto, BorderLayout.NORTH);
        this.getContentPane().add(painelOpcoes, BorderLayout.CENTER);
        this.getContentPane().add(painelForm, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Retirada de Veiculo");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        actionListener(estacionamento);
    }

    public void actionListener(Estacionamento estacionamento) {
        buttonMoto.addActionListener(e -> {
            this.instance = "MOTO";
            painelForm.setVisible(true);
        });
        
        
        buttonCarro.addActionListener(e -> {
            this.instance = "CARRO";
            painelForm.setVisible(true);
        });

        buttonBike.addActionListener(e -> {
            this.instance = "BIKE";
            painelForm.setVisible(true);
        });


        buttonCaminhao.addActionListener(e -> {
            this.instance = "CAMINHAO";
            painelForm.setVisible(true);
        });
        buttonMotoE.addActionListener(e-> {
            this.instance = "MOTO ESPECIAL";
            painelForm.setVisible(true);
        });

        buttonCarroE.addActionListener(e -> {
            this.instance = "CARRO ESPECIAL";
            painelForm.setVisible(true);
        });
        buttonCaminhaoE.addActionListener(e -> {
            this.instance = "CAMINHAO ESPECIAL";
            painelForm.setVisible(true);
        });
        buttonVoltar.addActionListener(e -> {
            this.dispose();
        });
        buttonCancelar.addActionListener(e -> {
            painelForm.setVisible(false);
        });

        buttonOk.addActionListener(e -> {
            int numVaga= 0;
            String message;
            int in;

            try {
                numVaga = Integer.parseInt(fieldNumVaga.getText());
            } catch(Exception f) {
                JOptionPane.showMessageDialog(this, "Insira um numero de vaga valido!!!");
                return;
            }
            Veichle ve = estacionamento.getVeichle(numVaga, this.instance);
            if(ve instanceof Bicicleta) 
                message = estacionamento.saida(numVaga);
            message = estacionamento.saida(numVaga, this.instance); 
            
            JOptionPane.showMessageDialog(this, message);
            
            if (message.contains("vaga vazia")) return;
            Double taxa = estacionamento.calculaTaxa(ve);
            if (!(taxa == 0.0)) {
                String recebido = JOptionPane.showInputDialog(this, "Total Devido: " + 
                taxa + "\nInsira o valor que deixou honestamente na caixinha: ");

                while(Double.parseDouble(recebido) < taxa) {                
                    recebido = JOptionPane.showInputDialog(this, "Total Devido: " + 
                    taxa + "\nInsira o valor correto: ");
                }
            }
            JOptionPane.showMessageDialog(this, "Veiculo Liberado!");

            Veichle v = estacionamento.consultaFilaDeEspera(this.instance);
            if(v.equals(null)) return;

            JOptionPane.showMessageDialog(this, "Existem veiculos na fila de espera!\n Convocando agora...");
            try {
                switch(this.instance) {
                    case "CARRO":
                        in = estacionamento.entrada((Carro)v);
                        JOptionPane.showMessageDialog(this, "Parabens! Seu Carro de cor "+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + "\n"+
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    case "MOTO":
                        in = estacionamento.entrada((Moto) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Sua Moto de cor "+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    case "CAMINHAO":
                        in = estacionamento.entrada((Caminhao) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Seu Caminhao de cor"+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    case "BIKE":
                        in = estacionamento.entrada((Bicicleta) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Sua Bike de cor"+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break; 
                    case "CARRO ESPECIAL":
                        in = estacionamento.entrada((Carro) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Seu Carro de cor "+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    case "CAMINHAO ESPECIAL":
                        in = estacionamento.entrada((Caminhao) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Seu Caminhao de cor "+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    case "MOTO ESPECIAL":
                        in = estacionamento.entrada((Moto) v);
                        JOptionPane.showMessageDialog(this, "Parabens! Sua Moto de cor "+ v.getCor() +" foi estacionado\n"+
                        "Anote bem o numero da sua vaga: " + in + 
                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                        "Boas Compras!");
                    break;
                    default:
                        JOptionPane.showMessageDialog(this, "ERRO");    
                }
                
            } catch(VagasEsgotadasException ex) {
                JOptionPane.showMessageDialog(this, "No momento estamos sem vagas para seu veiculo\n"+
                        "Assim que uma vaga for liberad para seu tipo de veiculos, nos o avisaremos" + 
                        "No momento voce ja esta na fila de espera (Novamente)!\n" +
                        "Obrigado pela compreensao!");
            }            
            this.dispose();
            
        });

    }
}
