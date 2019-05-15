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
public abstract class RelatoriosEstacionamento {
    public static String tempoMedioDePermanenciaNormais (Map<Veichle,Long> temposIn, Map<Veichle,Long> temposOut) {
        Long sum = new Long(0);
        int count = 0;
        try {
            for (Map.Entry<Veichle,Long> entryIn : temposIn.entrySet()) {
                if(!entryIn.getKey().getNome().equals("CARRO ESPECIAL")
                        && !entryIn.getKey().getNome().equals("MOTO ESPECIAL")
                        && !entryIn.getKey().getNome().equals("CAMINHAO ESPECIAL"))
                    for(Map.Entry<Veichle,Long> entryOut : temposOut.entrySet())
                        if(!entryOut.getKey().getNome().equals("CARRO ESPECIAL")
                                && !entryOut.getKey().getNome().equals("MOTO ESPECIAL")
                                && !entryOut.getKey().getNome().equals("CAMINHAO ESPECIAL")) {
                            if(entryIn.getKey().equals(entryOut.getKey())) {
                                count++;
                                sum += entryIn.getValue() - entryOut.getValue();
                            } 
                } 
            }
        } catch(Exception e) {
            return "Sem dados para gerar este relatório!";
        }
        if(sum.equals(new Long(0))) return "Sem dados para gerar este relatório!";          
        Long mediaMillis = sum / count;
        Long mediaHoras =  mediaMillis / 3600000;
        Long mediaMins =  mediaMillis / 360000;
        return "Veiculos normais gastam em media " + mediaHoras + " Horas e "
         + mediaMins + " minutos no estacionamento.\n";
    }

    public static String tempoMedioDePermanenciaPneIdosos (Map<Veichle,Long> temposIn, Map<Veichle,Long> temposOut) {
        Long sum = new Long(0);
        int count = 0;
        try {
            for(Map.Entry<Veichle,Long> entryIn : temposIn.entrySet())
                if(entryIn.getKey().getNome().equals("CARRO ESPECIAL"))
                    for(Map.Entry<Veichle,Long> entryOut : temposOut.entrySet()) 
                        if(entryOut.getKey().getNome().equals("CARRO ESPECIAL"))
                            if(entryIn.getKey().equals(entryOut.getKey())) {
                                count++;
                                sum += entryIn.getValue() - entryOut.getValue(); 
                            }
        } catch(Exception e) {
            return "Sem dados para gerar este relatório!";
        }
        if(sum.equals(new Long(0))) return "Sem dados para gerar este relatório!";           
        Long mediaMillis = sum / count;
        Long mediaHoras = mediaMillis / 3600000;
        Long mediaMins = mediaMillis / 360000;
        return "Veiculos de Idosos e PNE gastam em media " + mediaHoras + " Horas e "
         + mediaMins + " minutos no estacionamento.\n";
    }

    public static String statusMotoEntregadores (Map<Veichle,Long> temposIn, Map<Veichle,Long> temposOut) {
        Long sum = new Long(0);
        int count = 0; 
        try {       
            for(Map.Entry<Veichle,Long> entryIn : temposIn.entrySet())
                if(entryIn.getKey().getNome().equals("MOTO ESPECIAL"))
                    for(Map.Entry<Veichle,Long> entryOut : temposOut.entrySet()) 
                        if(entryOut.getKey().getNome().equals("MOTO ESPECIAL"))
                            if(entryIn.getKey().equals(entryOut.getKey())) {
                                count++;
                                sum += entryIn.getValue() - entryOut.getValue(); 
                            }
        } catch(Exception e) {
            return "Sem dados para gerar este relatório!";
        }
        if(sum.equals(new Long(0))) return "Sem dados para gerar este relatório!";            
        Long mediaMillis = sum / count;
        Long mediaHoras = mediaMillis / 3600000;
        Long mediaMins = mediaMillis / 360000;
        return "Veiculos de moto entregadores gastam em media " + mediaHoras + " Horas e "
         + mediaMins + " minutos no estacionamento.\n" 
         + "No total foram registradas " + count + "entradas e saidas de moto entregadores.";
    }
    public static String statusCaminhoesEntregadores (Map<Veichle,Long> temposIn, Map<Veichle,Long> temposOut) {
        Long sum = new Long(0);
        int count = 0;
        try {        
            for(Map.Entry<Veichle,Long> entryIn : temposIn.entrySet())
                if(entryIn.getKey().getNome().equals("CAMINHAO ESPECIAL"))
                    for(Map.Entry<Veichle,Long> entryOut : temposOut.entrySet()) 
                        if(entryOut.getKey().getNome().equals("CAMINHAO ESPECIAL"))
                            if(entryIn.getKey().equals(entryOut.getKey())) {
                                count++;
                                sum += entryIn.getValue() - entryOut.getValue(); 
                            }
        } catch(Exception e) {
            return "Sem dados para gerar este relatório!";
        }
        if(sum.equals(new Long(0))) return "Sem dados para gerar este relatório!";            
        Long mediaMillis = sum / count;
        Long mediaHoras = mediaMillis / 3600000;
        Long mediaMins = mediaMillis / 360000;
        return "Veiculos de Caminhoes Entregadores gastam em media " + mediaHoras + " Horas e "
         + mediaMins + " minutos no estacionamento.\n" 
         + "No total foram registradas " + count + "entradas e saidas de caminhoes entregadores.";
    }


}
