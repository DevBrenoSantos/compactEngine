package compressorImages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class Compressor {
    public void compressImage(String inputImagePath, String outputFilePath) {
        // Início da contagem do tempo de execução
        long startTime = System.currentTimeMillis();

        // Leitura da imagem
        try {
            BufferedImage image = ImageIO.read(new File(inputImagePath));

            // Mapas de frequência para cada canal de cor
            Map<Integer, Integer> redFrequency = new HashMap<>();
            Map<Integer, Integer> greenFrequency = new HashMap<>();
            Map<Integer, Integer> blueFrequency = new HashMap<>();

            // Dimensões da imagem
            int width = image.getWidth();
            int height = image.getHeight();

            // Extração das frequências dos valores de cor
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = image.getRGB(x, y);
                    int red = (rgb >> 16) & 0xff;
                    int green = (rgb >> 8) & 0xff;
                    int blue = rgb & 0xff;

                    // Atualização das frequências
                    redFrequency.put(red, redFrequency.getOrDefault(red, 0) + 1);
                    greenFrequency.put(green, greenFrequency.getOrDefault(green, 0) + 1);
                    blueFrequency.put(blue, blueFrequency.getOrDefault(blue, 0) + 1);
                }
            }

            // Criação das árvores de Huffman
            HuffmanTree redTree = new HuffmanTree(redFrequency);
            HuffmanTree greenTree = new HuffmanTree(greenFrequency);
            HuffmanTree blueTree = new HuffmanTree(blueFrequency);

            // Escrita das informações no arquivo de saída
            FileWriter writer = new FileWriter(outputFilePath);
            writer.write(width + " " + height + "\n");

            // Escrever frequências para reconstrução
            writer.write("RED\n" + redFrequency + "\n");
            writer.write("GREEN\n" + greenFrequency + "\n");
            writer.write("BLUE\n" + blueFrequency + "\n");

            // Compressão dos dados de cor e armazenamento no arquivo
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int rgb = image.getRGB(x, y);
                    int red = (rgb >> 16) & 0xff;
                    int green = (rgb >> 8) & 0xff;
                    int blue = rgb & 0xff;

                    // Escrita dos códigos binários
                    writer.write(redTree.getCodes().get(red));
                    writer.write(greenTree.getCodes().get(green));
                    writer.write(blueTree.getCodes().get(blue));
                }
            }
            writer.close();
            System.out.println("\nImagem comprimida com sucesso!\n");
            System.out.printf("""
                    ===============================
                    Informações da compressão:
                    ===============================
                    - Largura: %d pixels
                    - Altura: %d pixels
                    - Tamanho do arquivo comprimido: %d bytes
                    ===============================\n
                    """, width, height, new File(outputFilePath).length());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro na compressão da imagem.");
        }
        // Fim da contagem do tempo de execução
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução da compressão: " + (endTime - startTime) + "ms\n");
    }
}
