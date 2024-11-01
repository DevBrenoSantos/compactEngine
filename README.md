# Compressor de Imagens com Algoritmo de Huffman

Este projeto é uma implementação de um compressor e descompressor de imagens que utiliza o algoritmo de Huffman para compactar imagens nos formatos BMP ou PNG, aplicando compressão nos três canais de cor (R, G, B). O programa também é capaz de descompactar a imagem a partir de um arquivo de texto comprimido, restaurando-a para o formato original.

## Tabela de Conteúdos

- [Introdução](/README.md#introdução)
- [Funcionamento](/README.md#funcionamento)
- [Estrutura do Projeto](/README.md#estrutura-do-projeto)
- [Requisitos](/README.md#requisitos)
- [Uso](/README.md#uso)
- [Exemplos de Compressão e Descompressão](/README.md#exemplo-de-compressão-e-descompressão)
- [Limitações](/README.md#limitações)
- [Licença](/README.md#licença)

## Introdução

Este projeto tem como objetivo explorar a aplicação do algoritmo de Huffman para compressão de imagens, uma técnica eficaz que reduz o espaço de armazenamento ao representar os valores RGB de cada pixel com códigos binários de tamanhos variáveis. Com este programa, você pode comprimir imagens e descomprimir o arquivo para restaurar a imagem original.

## Funcionamento

O projeto consiste em duas fases principais:

1. **Compressão:** A imagem é analisada e, para cada canal de cor (R, G e B), calcula-se a frequência de cada valor (0-255). Essas frequências são usadas para criar três árvores de Huffman independentes. O arquivo de saída inclui as dimensões da imagem, as frequências de cada canal e os dados comprimidos em uma sequência de bits.
2. **DEscompressão:** O programa lê o arquivo compactado, reconstrói as árvores de Huffman com base nas frequências e decodifica os dados binários para restaurar a imagem original.

## Estrutura do Projeto

- **HuffmanNode:** Classe para os nós da árvore de Huffman, contendo valor e frequência.
- **Compressor:** Classe responsável pela compressão da imagem. Extrai as frequências RGB, constrói as árvores de Huffman e gera o arquivo compactado.
- **Decompressor:** Classe responsável pela descompressão. Lê o arquivo comprimido, reconstrói as árvores e recupera os dados da imagem.

## Requisitos

- Java 8 ou superior

## Uso

### Compressão

Execute o método ```compressImage``` da classe ```Compressor``` passando a imagem que deseja compactar. O programa gerará um arquivo de texto com as dimensões, frequências e dados comprimidos da imagem.

### Descompressão

Execute o método ```decompressImage``` da classe ```Decompressor```, passando o arquivo comprimido gerado anteriormente. A imagem restaurada será salva no local especificado.

## Exemplo de Compressão e Descompressão

## Limitações

- O programa lida apenas com imagens BMP e PNG.
- A eficiência da compressão depende da redundância de cores na imagem.
- Imagens com muita variação de cor podem não ser significativamente comprimidas.
  
## Licença

Este projeto é licenciado sob a [MIT License](/LICENSE.txt).
