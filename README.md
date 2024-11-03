# Projeto de compressão de imagens com algoritmo de Huffman para canais RGB

<div styler="display: inline_block" align="center">
    <img align="center" src="https://img.shields.io/github/repo-size/DevBrenoSantos/compactEngine?style=for-the-badge">
    <img align="center" src="https://img.shields.io/github/languages/count/DevBrenoSantos/compactEngine?style=for-the-badge">
    <img align="center" src="https://img.shields.io/github/forks/DevBrenoSantos/compactEngine?style=for-the-badge">
</div> </br>

Este projeto é uma implementação de um compressor e descompressor de imagens que utiliza o algoritmo de Huffman para compactar imagens nos formatos BMP ou PNG, aplicando compressão nos três canais de cor (R, G, B), sendo capaz também de descompactar a imagem a partir de um arquivo de texto comprimido, restaurando-a para o formato original. O projeto agora inclui cálculo de entropia e análise de desempenho, proporcionando uma compreensão mais aprofundada do processo de compressão.

## 📜 Tabela de Conteúdos

- [Introdução](/README.md#introdução)
- [Funcionamento](/README.md#funcionamento)
- [Estrutura do Projeto](/README.md#estrutura-do-projeto)
- [Requisitos](/README.md#requisitos)
- [Uso](/README.md#uso)
- [Exemplos de Compressão e Descompressão](/README.md#avaliação-e-análise)
- [Limitações](/README.md#limitações)
- [Licença](/README.md#licença)

## Introdução

Este projeto tem como objetivo explorar a aplicação do algoritmo de Huffman para compressão e descompressão de imagens, uma técnica eficaz que reduz o espaço de armazenamento ao representar os valores RGB de cada pixel com códigos binários de tamanhos variáveis. Ao utilizar codificação de comprimento variável, a ferramenta reduz o tamanho do arquivo sem perda de qualidade. O projeto também inclui análise de entropia para avaliar o limite teórico de compressão, métricas de desempenho para medir a eficiência e ferramentas de visualização para ilustrar o processo de compressão em detalhes.

## 🔧  Funcionamento

O projeto consiste em quatro fases principais:

1. **Compressão:** A imagem é analisada e, para cada canal de cor (R, G e B), calcula-se a frequência de cada valor (0-255). Essas frequências são usadas para criar três árvores de Huffman independentes. O arquivo de saída inclui as dimensões da imagem, as frequências de cada canal e os dados comprimidos em uma sequência de bits.
2. **Descompressão:** O programa lê o arquivo compactado, reconstrói as árvores de Huffman com base nas frequências e decodifica os dados binários para restaurar a imagem original.
3. **Cálculo de Entropia:**
    - Entropia total e média da imagem
    - Entropia de cada canal separadamente
    - Comparações práticas entre a imagem original e pós procedimento de descompressão
4. **Análise de Desempenho:** Testes com múltiplas imagens de diferentes resoluções e tipos de conteúdo, avaliando:
    - Taxa de compressão
    - Tempo de compressão e descompressão
    - Entropia e sua relação com a eficiência da compressão

## Estrutura do Projeto

- **HuffmanNode:** Classe para os nós da árvore de Huffman, contendo valor e frequência.
- **Compressor:** Classe responsável pela compressão da imagem. Extrai as frequências RGB, constrói as árvores de Huffman e gera o arquivo compactado.
- **Decompressor:** Classe responsável pela descompressão. Lê o arquivo comprimido, reconstrói as árvores e recupera os dados da imagem.
- **EntropyCalculator:** Calcula a entropia média, total e a entropia por canal.

## 💻  Requisitos

- Java 8 ou superior

## Uso

### 📥 Compressão

Execute o método ```compressImage``` da classe ```Compressor``` passando a imagem que deseja compactar. O programa gerará um arquivo de texto com as dimensões, frequências e dados comprimidos da imagem.

### 📤 Descompressão

Execute o método ```decompressImage``` da classe ```Decompressor```, passando o arquivo comprimido gerado anteriormente. A imagem restaurada será salva no local especificado.

## 📊 Avaliação e Análise

### Cálculo de Entropia

**O que é 'Entropia'?**

A entropia é uma medida estatística que indica a quantidade média de "incerteza" ou "surpresa" de um conjunto de dados, e é útil para avaliar a eficiência de um algoritmo de compressão. Em compressão de imagens, a entropia nos dá uma ideia do limite teórico de compressão: quanto menor a entropia, mais facilmente os dados podem ser comprimidos.

1. **Entropia Total:** Calcula a entropia considerando o RGB como um símbolo combinado para cada pixel. Isso captura a "interdependência" entre os canais, ou seja, como as cores estão relacionadas entre si. *Este valor tende a ser mais preciso para imagens coloridas.*
2. **Entropia por Canal:** Calcula a entropia separadamente para Vermelho, Verde e Azul, fornecendo uma métrica comparativa em relação à entropia total. Esse método fornece uma estimativa, mas subestima a entropia real, já que cada canal é tratado como um conjunto isolado. *Uma aproximação mais rápida, mas que subestima a complexidade dos dados*

Para obter uma medida precisa da entropia e do limite teórico de compressão da imagem como um todo, é necessário calcular a entropia considerando cada (R, G, B) como uma unidade única. Isso reflete melhor a quantidade real de informação na imagem e dá uma estimativa mais fiel do potencial de compressão.

### Análise da Entropia

- Uma entropia baixa indica que a distribuição dos valores é menos complexa e há maior potencial de compressão.
- Uma entropia alta indica uma distribuição mais uniforme  dos valores, com menos potencial para compressão.

### Métricas de Desempenho

- **Taxa de Compressão:** Razão entre o tamanho do arquivo comprimido e o tamanho do arquivo original.
- **Tempo de Execução:** Mede o tempo das fases de compressão e descompressão.
- **Avaliação de qualidade:** Garante que não há perda de qualidade visual após a descompressão.

## Limitações

- O programa lida apenas com imagens BMP e PNG.
- A eficiência da compressão depende da redundância de cores na imagem.
- Imagens com muita variação de cor podem não ser significativamente comprimidas.
  
## 🔺 Licença

Este projeto é licenciado sob a [MIT License](/LICENSE.txt).
