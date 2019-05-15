# Gerenciador de Estacionamento Teste

    RF-01• Um Veículo possui uma placa, cor e quantidade de rodas. Além disso, um veículo pode ser um carro, uma moto,
	bicicleta ou um caminhão.
    RF-02• O Estacionamento possui vagas para 5 carros, 2 caminhões, 7 motos e 10 bicicletas. Das 5 vagas reservadas para carros,
	duas são separadas para deficientes e idosos. Das 7 para motos, 2 são reservadas para entregadores do Mercado Compre Muito Mais.
	Das 2 para caminhões, 1 está reservada para desembarque e embarque de mercadorias.
    RF-03• Um veículo precisa ser um veículo para idosos/deficientes para acessar as vagas de idosos. Uma moto precisa ser uma moto
	de entregadores para acessar as vagas de entregadores. Um caminhão de desembarque apenas pode acessar as vagas de caminhões de
	desembarque. Veículos certificados para idosos/deficientes, entregadores e caminhões de desembarque de mercadorias não pagam
	taxas.
    RF-04• Seu sistema deve permitir a entrada e saída de veículos no estacionamento, gerenciando sua utilização.
	Seu sistema deve bloquear a entrada de um veículo no estacionamento caso não existam vagas para ele, o deixando automaticamente
	na fila de espera.
    RF-05• Seu sistema deve permitir colocar veículos na lista de espera. 
    RF-06• Para cada veículo você deve guardar a hora de entrada e a hora de saída. Ao sair, um veículo paga a taxa de saída.
	Seu sistema deve calcular esta taxa e guardar a quantidade total de valor recebido.
    RF-07• Seu sistema deve gerar um relatório com a quantidade média de tempo gasta por veículos no estacionamento,
	sem incluir entregadores e caminhões de desembarque.
    RF-08• Seu sistema deve gerar um relatório sobre as entradas e saídas de entregadores.
    RF-09• Seus sistema deve gerar um relatório sobre as entradas e saídas de caminhões de desembarque.
    RF-10• Seu sistema deve gerar um relatório sobre o tempo médio utilizado por deficientes e idosos.
    RF-11• Sempre que um veículo sair, um veículo compatível deve ser convocado da lista de espera.
    RF-12• Senhor Compre Muito Mais ainda é muito supersticioso, e exigiu que caso uma placa que termine com 12 saia do
	estacionamento, um veículo da fila de espera será convocado apenas após a saída do próximo veículo. Por isso, pode ocorrer de
	um veículo sair e entrarem dois ou mais.
    RF-13• Você deve criar um manual de utilização do sistema e definir como o sistema gráfico chama e interage com o seu.
