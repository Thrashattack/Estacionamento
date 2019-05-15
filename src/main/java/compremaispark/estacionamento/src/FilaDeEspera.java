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

public class FilaDeEspera<T> {

    private final Stack<T> carros;
    private final Stack<T> motos;
    private final Stack<T> bikes;
    private final Stack<T> trucks;
    private final Stack<T> carrosE;
    private final Stack<T> motosE;
    private final Stack<T> trucksE;
  
  public FilaDeEspera() {
    this.carros = new Stack<>();
    this.carrosE = new Stack<>();
    this.motos = new Stack<>();
    this.motosE = new Stack<>();
    this.trucks = new Stack<>();
    this.trucksE = new Stack<>();
    this.bikes = new Stack<>();
  }
  
  public boolean empty(String tipo) {
    switch(tipo) {
      case "CARRO": 
        return this.carros.isEmpty();
      case "MOTO": 
        return this.motos.isEmpty();
      case "BIKE": 
        return this.bikes.isEmpty();
      case "CAMINHAO": 
        return this.trucks.isEmpty();
      case "CARRO ESPECIAL": 
        return this.carrosE.isEmpty();
      case "MOTO ESPECIAL": 
        return this.motosE.isEmpty();
      case "CAMINHAO ESPECIAL": 
        return this.trucksE.isEmpty();
    }
    return true;
  }

  public Stack<T> getStack(String tipo) {
    switch(tipo) {
      case "CARRO":
        return this.carros;
      case "CARRO ESPECIAL":
        return this.carrosE;
      case "MOTO":
        return this.motos;
      case "MOTO ESPECIAL":
        return this.motosE;
      case "CAMINHAO":
        return this.trucks; 
      case "CAMINHAO ESPECIAL":
        return this.trucksE;
      case "BIKE":
        return this.bikes;
      default:
      return null;
    }
  }
}
