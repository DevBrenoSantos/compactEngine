package compressorImages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Decompressor {
    public void decompressImage(String inputFilePath, String outputImagePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String[] dimensions = reader.readLine().split(" ");
            int width = Integer.parseInt(dimensions[0]);
            int height = Integer.parseInt(dimensions[1]);

            // Frequências para reconstrução das árvores de Huffman
            reader.readLine(); // "RED"
            Map<Integer, Integer> redFrequency = parseFrequencies(reader.readLine());
            reader.readLine(); // "GREEN"
            Map<Integer, Integer> greenFrequency = parseFrequencies(reader.readLine());
            reader.readLine(); // "BLUE"
            Map<Integer, Integer> blueFrequency = parseFrequencies(reader.readLine());

            HuffmanTree redTree = new HuffmanTree(redFrequency);
            HuffmanTree greenTree = new HuffmanTree(greenFrequency);
            HuffmanTree blueTree = new HuffmanTree(blueFrequency);

            // Decodificação dos dados comprimidos
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int red = decodeColor(reader, redTree);
                    int green = decodeColor(reader, greenTree);
                    int blue = decodeColor(reader, blueTree);

                    int rgb = (red << 16) | (green << 8) | blue;
                    image.setRGB(x, y, rgb);
                }
            }

            ImageIO.write(image, "png", new File(outputImagePath));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Implementação da função parseFrequencies
    private Map<Integer, Integer> parseFrequencies(String frequencyData) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        
        // Remove caracteres indesejados, se houver
        frequencyData = frequencyData.replaceAll("[{} ]", "");
        String[] pairs = frequencyData.split(",");

        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            int value = Integer.parseInt(keyValue[0]);
            int frequency = Integer.parseInt(keyValue[1]);
            frequencies.put(value, frequency);
        }
        
        return frequencies;
    }

    // Implementação da função decodeColor
    private int decodeColor(BufferedReader reader, HuffmanTree tree) throws IOException {
        HuffmanNode currentNode = tree.getRoot();
        int bit;

        while (currentNode.left != null && currentNode.right != null) {
            bit = reader.read(); // Lê o próximo bit

            if (bit == '0') {
                currentNode = currentNode.left;
            } else if (bit == '1') {
                currentNode = currentNode.right;
            } else {
                throw new IOException("Formato inválido no arquivo compactado.");
            }
        }

        return currentNode.value;
    }
}
