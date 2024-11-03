package compressorImages;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class EntropyCalculator {
    // Calcula e imprime na tela a entropia da imagem por canal
    public static void calculate(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            System.out.println("Entropia do canal vermelho: " + calculateEntropy(image, "R"));
            System.out.println("Entropia do canal verde: " + calculateEntropy(image, "G"));
            System.out.println("Entropia do canal azul: " + calculateEntropy(image, "B"));   
            System.out.println("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calcula a entropia de um canal específico da imagem
    private static double calculateEntropy(BufferedImage image, String channel) {
        // Mapeia a frequência de cada valor de cor
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int width = image.getWidth();
        int height = image.getHeight();
        int totalPixels = width * height;

        // Conta a frequência de cada valor de cor
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int value;
                if (channel.equals("R")) {
                    value = (rgb >> 16) & 0xFF; // Canal Red
                } else if (channel.equals("G")) {
                    value = (rgb >> 8) & 0xFF;  // Canal Green
                } else {
                    value = rgb & 0xFF;         // Canal Blue
                }
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
            }
        }

        // Calcula a entropia
        double entropy = 0.0;
        for (int frequency : frequencyMap.values()) {
            double probability = (double) frequency / totalPixels;
            entropy -= probability * (Math.log(probability) / Math.log(2)); // log base 2
        }

        return entropy;
    }

    // Calcula a entropia total da imagem
    private static double calculateTotalEntropy(BufferedImage image) {
        // Mapeia a frequência de cada combinação (R, G, B)
        Map<String, Integer> frequencyMap = new HashMap<>();
        int width = image.getWidth();
        int height = image.getHeight();
        int totalPixels = width * height;

        // Contar frequências das combinações (R, G, B)
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb = image.getRGB(x, y);
                int red = (rgb >> 16) & 0xFF;
                int green = (rgb >> 8) & 0xFF;
                int blue = rgb & 0xFF;

                // Cria uma chave para a combinação (R, G, B)
                String key = red + "," + green + "," + blue;
                frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
            }
        }

        // Calcular a entropia total
        double entropy = 0.0;
        for (int frequency : frequencyMap.values()) {
            double probability = (double) frequency / totalPixels;
            entropy -= probability * (Math.log(probability) / Math.log(2)); // log base 2
        }
        return entropy;
    }

    // Retorna a entropia total da imagem
    public static double getTotalEntropy(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            return calculateTotalEntropy(image);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Calcula e retorna a entropia da imagem e retorna o valor médio
    public static double getEntropyImageAverage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            double redEntropy = calculateEntropy(image, "R");
            double greenEntropy = calculateEntropy(image, "G");
            double blueEntropy = calculateEntropy(image, "B");
            return (redEntropy + greenEntropy + blueEntropy) / 3;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Retorna a entropia de um canal específico da imagem
    public static double getEntropyChannel(String imagePath, String channel) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            return calculateEntropy(image, channel);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
