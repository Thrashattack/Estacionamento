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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutEntrada extends JFrame {
    private JPanel painelTexto, painelOpcoes, painelForm;
    private JButton buttonMoto, buttonCarro, buttonBike,
     buttonCaminhao, buttonMotoE, buttonCarroE, buttonCaminhaoE,
     buttonCancelar, buttonOk, buttonVoltar;
    private JLabel labelOpcoes, labelPlaca, labelCor, labelNumRodas;
    private JTextField fieldCor, fieldPlaca, fieldNumRodas;
    private String instance;
    

    public GridLayoutEntrada(Estacionamento estacionamento) {
        super("Entrada de Veiculo");
         instance = "";
         painelTexto = new JPanel(new GridLayout(1, 1));
         painelOpcoes = new JPanel(new GridLayout(2, 1));
         painelForm = new JPanel(new GridLayout(4, 2));

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
         
         labelOpcoes = new JLabel("\t\tSELECIONE O TIPO DE VEICULO QUE DESEJA ESTACIONAR");
         labelCor = new JLabel ("Insira a Cor do Veiculo:");
         labelPlaca = new JLabel("Insira a Placa do Veiculo:");
         labelNumRodas = new JLabel("Insira o numero de Rodas:");

         fieldCor = new JTextField();
         fieldNumRodas = new JTextField();
         fieldPlaca = new JTextField();
         

         painelForm.setVisible(false);
         
         painelForm.add(labelCor);
         painelForm.add(fieldCor);
         painelForm.add(labelNumRodas);
         painelForm.add(fieldNumRodas);
         painelForm.add(labelPlaca);
         painelForm.add(fieldPlaca);
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
         this.setTitle("Cadastro de Veiculo");
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


        buttonOk.addActionListener((ActionEvent e) -> {
            String placa = fieldPlaca.getText();
            String cor = fieldCor.getText();
            int numRodas = 0;
            int in;
            if (placa.equals("")) {
                JOptionPane.showMessageDialog(GridLayoutEntrada.this, "A placa e obrigatoria!!");
                return;
            }
            try {
                numRodas = Integer.parseInt(fieldNumRodas.getText());
            } catch (NumberFormatException f) {
                JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Digite um numero de rodas valido!");
                return;
            }
            try {
                switch (GridLayoutEntrada.this.instance) {
                    case "CARRO":
                        in = estacionamento.entrada(new Carro(numRodas, cor, "CARRO", false, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Seu Carro foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in + "\n"+
                                        "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "MOTO":
                        in = estacionamento.entrada(new Moto(numRodas, cor, "MOTO", false, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Sua Moto foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "CAMINHAO":
                        in = estacionamento.entrada(new Caminhao(numRodas, cor, "CAMINHAO", false, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Seu Caminhao foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "BIKE":
                        in = estacionamento.entrada(new Bicicleta(numRodas, cor, "BIKE"));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Sua Bike foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "CARRO ESPECIAL":
                        in = estacionamento.entrada(new Carro(numRodas, cor, "CARRO", true, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Seu Carro foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "CAMINHAO ESPECIAL":
                        in = estacionamento.entrada(new Caminhao(numRodas, cor, "CAMINHAO", true, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Seu Caminhao foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    case "MOTO ESPECIAL":
                        in = estacionamento.entrada(new Moto(numRodas, cor, "MOTO", true, placa));
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "Parabens! Sua Moto foi estacionado\n"+
                                "Anote bem o numero da sua vaga: " + in +
                                "Este e o numero que voce usara para retirar o veiculo!\n" +
                                        "Boas Compras!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(GridLayoutEntrada.this, "ERRO");
                }
            } catch (VagasEsgotadasException ex) {
                JOptionPane.showMessageDialog(GridLayoutEntrada.this, "No momento estamos sem vagas para seu veiculo\n"+
                        "Assim que uma vaga for liberad para seu tipo de veiculos, nos o avisaremos" +
                        "No momento voce ja esta na fila de espera!\n" +
                        "Obrigado pela compreensao!" + ex.getMessage());
            }
            GridLayoutEntrada.this.dispose();
        });

    }
}
