/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compremaispark.estacionamento.src;

/**
 *
 * @author Carlos Cunha
 */
public class Carro extends Veichle implements Emplacavel {
    private String placa; 
    
    public Carro(int numRodas, String cor, String nome, boolean especial, String placa) {
      super(numRodas, cor, nome, especial);
      this.placa = placa; 
    }
    @Override
    public String getPlaca() {
      return this.placa;
    }
    @Override
    public void setPlaca(String s) {
      this.placa = s;
    }
    
  }