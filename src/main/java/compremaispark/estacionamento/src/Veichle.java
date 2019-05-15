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
public abstract class Veichle {
    private int numRodas; 
    private String cor; 
    private String nome;
    private boolean especial; 
    
    public Veichle() {
      
    }
    public Veichle(int numRodas, String cor, String nome, boolean especial) {
      this.numRodas = numRodas;
      this.cor = cor;
      this.nome = nome; 
      this.especial = especial;
    }
    
    public int getNumRodas() {
      return this.numRodas; 
    }
    public String getCor() {
      return this.cor;
    }
    public String getNome() {
      return this.nome;
    }
    public boolean getEspecial() {
      return this.especial;
    }
    
    public void setNumRodas( int n) {
       this.numRodas = n; 
    }
    public void setCor(String s) {
       this.cor = s;
    }
    public void setNome(String s) {
       this.nome = s;
    }
    public void setEspecial(boolean b) {
       this.especial = b;
    }
    @Override
    public String toString() {
      return "Tipo: " + this.nome + "\n"
      + "Rodas: " + this.numRodas + "\n"
      + "Especial? " + this.especial + "\n";
    }
    @Override
    public boolean equals(Object o) {
      if(!(o instanceof Veichle)) return false;
      Veichle v = (Veichle) o;
      return this.nome.equals(v.getNome()) && this.cor.equals(v.getCor())
       && this.numRodas == v.getNumRodas() && this.especial == v.getEspecial();
    } 
  
  }
