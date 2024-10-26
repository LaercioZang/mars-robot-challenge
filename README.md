# Mars Robot Challenge
![Mars Rover](https://upload.wikimedia.org/wikipedia/commons/5/5c/MSL_Artist_Concept_%28PIA14164_crop%29.jpg) <!-- Adicione um link de imagem relevante -->

Um time de robôs da NASA foi designado para explorar um terreno em Marte. Este terreno, que é retangular, deve ser navegado pelos robôs de forma que suas câmeras acopladas possam obter uma visão completa da região, enviando as imagens de volta à Terra.

## Descrição do Projeto

A posição de cada robô é representada por coordenadas cartesianas (x, y) e uma letra que indica a orientação: `NORTH`, `SOUTH`, `EAST`, ou `WEST`. Para simplificar a navegação, a região marciana foi subdividida em sub-regiões retangulares. Uma posição válida de um robô é, por exemplo, `(0, 0, N)`, significando que o robô está posicionado no canto inferior esquerdo do terreno, voltado para o Norte.

Para controlar cada robô, a NASA envia uma string de comandos, que pode conter as letras:

- **L**: Rotacionar 90 graus à esquerda
- **R**: Rotacionar 90 graus à direita
- **M**: Mover uma posição para frente

Assumimos que o robô se movimenta para o **NORTE** em relação ao eixo `y`. Um passo para o NORTE da posição `(x,y)` resulta na nova posição `(x, y+1)`. Por exemplo, se o robô está na posição `(0,0,N)` e recebe o comando `"MML"`, ele se moverá para a posição `(0,2,W)`.

## Funcionalidades

- Inicializa um terreno de 5x5 posições
- O robô inicia na coordenada `(0,0,N)`
- Permite enviar um comando e retornar a posição final do robô
- O robô não pode se mover para fora da área especificada
- Não guarda o estado do robô para consulta posterior

## Instalação

Para instalar e executar o projeto, siga estas etapas:

### Pré-requisitos

- **Java 11** ou superior
- **Maven** 3.6.3 ou superior
- **Docker** (opcional para execução em contêiner)

### Passos para Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu_usuario/mars-robot-exploration.git
   cd mars-robot-exploration
2. **Compile o projeto usando Maven**:
   ```bash
    mvn clean install
3. **Execute o servidor localmente**:
   ```bash
    mvn spring-boot:run
4. **(Opcional) Execute o projeto usando Docker**:
   - Construa a imagem Docker e Execute o contêiner::
   ```bash
   docker build -t mars-robot-exploration
   docker run -p 8080:8080 mars-robot-exploration
   
  ### Como Usar
  1. **Inicie o servidor (se não estiver usando Docker)**:
     ```bash
       mvn spring-boot:run
  2. **Envie comandos ao robô**:
     - Movimento com rotação para a direita:
     ```bash
        curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
   Saída esperada: (2, 0, S)


