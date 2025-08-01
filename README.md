# 🧩 Jogo de Sudoku em Java

Bem-vindo ao **Jogo de Sudoku em Java**! Este é um projeto simples, mas desafiador, que permite jogar Sudoku no terminal utilizando Java. Ele oferece um menu interativo para que você possa iniciar um novo jogo, inserir e remover números, verificar o status do jogo e muito mais.

## 📋 Funcionalidades

O jogo oferece um menu interativo com as seguintes opções:

1. **Iniciar Novo Jogo**: Exibe o tabuleiro inicial com números fixos.
2. **Colocar Número**: Insira um número em uma posição específica do tabuleiro.
3. **Remover Número**: Remova um número inserido pelo jogador (não removendo os números fixos).
4. **Verificar Jogo**: Mostra o tabuleiro atual.
5. **Verificar Status do Jogo**: Verifica se o jogo está completo, incompleto, com ou sem erros.
6. **Limpar**: Remove os números informados pelo jogador e mantém os números fixos.
7. **Finalizar Jogo**: Se o tabuleiro estiver completo e sem erros, o jogo é encerrado.


## 🚀 Como Rodar o Projeto

### Pré-requisitos

Certifique-se de ter o **Java 8** ou superior instalado na sua máquina. Para verificar se o Java está instalado, abra o terminal e execute:

```bash
java -version

Se o Java não estiver instalado, baixe e instale a partir [daqui](https://www.oracle.com/java/technologies/downloads/#java11).


Rodando o Jogo

1. Clone este repositório:

> git clone > https://github.com/lxfelicio/sudoku-java


2. Navegue até o diretório do projeto:

> cd sudoku-java


3. Compile o código:

> javac Sudoku.java


4. Execute o jogo:

> java Sudoku


---

## 💡 Como Funciona

O jogo é estruturado com uma matriz de 9x9, onde números fixos são predefinidos e os jogadores podem preencher as posições vazias. As regras do Sudoku são aplicadas, como a restrição de não permitir números duplicados em uma linha, coluna ou bloco 3x3.

Estrutura do Tabuleiro

O tabuleiro é representado por uma matriz 2D de números inteiros. Quando um número é fixo (predefinido no início), ele não pode ser alterado ou removido. O objetivo é preencher o tabuleiro de forma que todas as linhas, colunas e blocos 3x3 contenham os números de 1 a 9 sem repetições.


---

## 🛠️ Tecnologias Utilizadas

Java 8+: Linguagem de programação utilizada para implementar o jogo.

Terminal: Interface de usuário simplificada, com visualização do tabuleiro no terminal.


---

## ⚙️ Funcionalidades

1. Iniciar Novo Jogo

Inicia um novo jogo de Sudoku com um tabuleiro pré-definido. A partir do momento que o jogo começa, você pode interagir com ele.

2. Colocar Número

Permite que o jogador insira um número em uma posição especificada (linha e coluna), validando se a posição está disponível.

3. Remover Número

Permite remover um número inserido pelo jogador, mas não os números fixos. Caso o jogador tente remover um número fixo, o sistema avisa.

4. Verificar Jogo

Exibe o estado atual do tabuleiro. Ele mostra os números fixos e os números inseridos pelo jogador, com separações por blocos 3x3.

5. Verificar Status do Jogo

Verifica se o jogo está completo, incompleto, e se contém erros (conflitos entre números). A função valida se o Sudoku está correto de acordo com as regras.

6. Limpar

Limpa todos os números inseridos pelo jogador, mas mantém os números fixos intactos.

7. Finalizar Jogo

Verifica se o tabuleiro está completo e sem erros. Caso afirmativo, o jogo é finalizado e o jogador é parabenizado.


---

## 🧠 Autoria

Este projeto foi desenvolvido por **Laura Felício** como parte dos estudos em Java, POO, construção de aplicações lógicas via terminal e para a conclusão do desafio de projeto **“Criando o Jogo do Sudoku em Java”**, ministrado por José Luiz Abreu Cardoso Junior (https://github.com/juniorjrjl) e oferecido pela plataforma **DIO**.

> ⚠️ Este repositório tem fins didáticos e pode conter ajustes em andamento.  
> 💬 Contribuições, sugestões ou correções são bem-vindas via GitHub:
> 🔗 [https://github.com/lxfelicio/sudoku-java](https://github.com/lxfelicio/sudoku-java)

⌨️ Criado com 🎮, 🧩 e 💡 por [Laura Felício](https://github.com/lxfelicio)
