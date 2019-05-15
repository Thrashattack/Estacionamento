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

public class VagasEsgotadasException extends RuntimeException {
  public VagasEsgotadasException() {
    super("As vagas para o seu tipo de veiculo estão esgotadas no momento!\nVoce foi colocado na lista de espera e assim que um veiculo do mesmo tipo que o seu,\nsair do estacionamento, você sera chamado.\n\tObrigado Pela Compreensao.\n");
  }
}
