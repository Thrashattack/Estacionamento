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
import java.util.*;
public class GridLayoutAdmin extends JFrame {
    private JPanel painelTexto, painelOpcoes;
    private JButton buttonRelatorio1, buttonRelatorio2, buttonRelatorio3, buttonRelatorio4; 
    private JLabel labelOptions;


    public GridLayoutAdmin(Estacionamento estacionamento) {
        painelTexto = new JPanel(new GridLayout(1,1));
        painelOpcoes = new JPanel(new GridLayout(2, 2));

        buttonRelatorio1 = new JButton("Tempo medio de permanencia de veiculos normais");
        buttonRelatorio2 = new JButton("Tempo medio de permanencia de Carros Especiais");
        buttonRelatorio3 = new JButton("Estatisticas de Moto Entregadores");
        buttonRelatorio4 = new JButton("Estatisticas de Caminhoes Entregadores");

        labelOptions = new JLabel("Selecione o relatorio administrativo que deseja:");

        painelTexto.add(labelOptions);
        painelOpcoes.add(buttonRelatorio1);
        painelOpcoes.add(buttonRelatorio2);
        painelOpcoes.add(buttonRelatorio3);
        painelOpcoes.add(buttonRelatorio4);

        this.setLayout(new BorderLayout());
        this.getContentPane().add(painelTexto, BorderLayout.NORTH);
        this.getContentPane().add(painelOpcoes, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Painel Administrtivo");
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        actionListener(estacionamento);

    } 

    public void actionListener(Estacionamento estacionamento) {
        Map<Veichle, Long> temposIn = estacionamento.getTemposEntrada();
        Map<Veichle, Long> temposOut =  estacionamento.getTemposSaida(); 

        buttonRelatorio1.addActionListener(e -> {            
            JOptionPane.showMessageDialog(
                this,
                RelatoriosEstacionamento.tempoMedioDePermanenciaNormais(temposIn, temposOut));
        });
        buttonRelatorio2.addActionListener(e -> {            
            JOptionPane.showMessageDialog(
                this,
                RelatoriosEstacionamento.tempoMedioDePermanenciaPneIdosos(temposIn, temposOut));
        });
        buttonRelatorio3.addActionListener(e -> {            
            JOptionPane.showMessageDialog(
                this,
                RelatoriosEstacionamento.statusMotoEntregadores(temposIn, temposOut));
        });
        buttonRelatorio4.addActionListener(e -> {            
            JOptionPane.showMessageDialog(
                this,
                RelatoriosEstacionamento.statusCaminhoesEntregadores(temposIn, temposOut));
        });
    }

}
