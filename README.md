# Compressor de Imagens com Algoritmo de Huffman

Este projeto é uma implementação de um compressor e descompressor de imagens que utiliza o algoritmo de Huffman para compactar imagens nos formatos BMP ou PNG, aplicando compressão nos três canais de cor (R, G, B). O programa também é capaz de descompactar a imagem a partir de um arquivo de texto comprimido, restaurando-a para o formato original.

## Tabela de Conteúdos

- [Introdução](/README.md#introdução)
- [Funcionamento](/README.md#funcionamento)
- [Estrutura do Projeto](/README.md#estrutura-do-projeto)
- [Requisitos](/README.md#requisitos)
- [Instalação e Execução](/README.md#instalação-e-execução)
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
## Requisitos
## Instalação e Execução
## Uso
## Exemplo de Compressão e Descompressão
## Limitações
## Licença