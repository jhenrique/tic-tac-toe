# tic-tac-toe

API to play tic-tac-toe (Necessário java 1.8 instalado na máquina caso rodar o JAR)

As tecnlonologias utilizada foram o java, maven e spring boot.

A API possui duas rotas:

/api/game (POST)

Responsável pela criação do jogo, e tem o retorno do id do mesmo e o primeio a fazer a jogada, X ou O (Não é 0).

/api/game/movement (POST)

Responsável pelo movimento do jogador, ele recebe um Json como o abaixo:

{
  "id" : "GPTDSJBORAL2UEB4ESL94F8HOG",
  "player": "X",
  "position": {
      "x": 2,
      "y": 1
   }
}

Com "id" do jogo, "player" o jogador que está realizando a jogada e "position" a posição desejada.

- Lembrando que o tabuleiro é uma matriz, onde "x" é a linha e "y" a coluna. 

                                            (0,0)|(0,1)|(0,2)
                                            (1,0)|(1,1)|(1,2)
                                            (2,0)|(2,1)|(2,2)


Um exemplo de utilização que é o POSTMAN, selecionar o método POST,colocar o Json formatado 'RAW' e selecionar JSON(application/json).

Json com formatação errada irá retornar (Não foi possível ler as informações).


