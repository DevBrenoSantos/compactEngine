package compressorImages;

import java.io.File;
import java.io.FileFilter;
import java.util.Random;
import java.util.Scanner;

public class MainTeste {
    static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
            do {
                switch (Menu()) {
                    case 1 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho da imagem que deseja comprimir: ");
                        String inputImagePath = input.nextLine();

                        int random = new Random().nextInt(1000);
                        String compressedFilePath = "./images/compressedImages/imagemComprimida"+ random +".txt";

                        System.out.println("Comprimindo imagem...");
                        
                        Compressor compressor = new Compressor();
                        compressor.compressImage(inputImagePath, compressedFilePath);

                        System.out.println("Imagem comprimida salva em: " + compressedFilePath);                        
                    }
                    case 2 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho do arquivo que deseja descomprimir: ");
                        String compressedFilePath = input.nextLine();

                        int random = new Random().nextInt(1000);
                        String outputImagePath = "./images/decompressedImages/ImagemDescomprimida"+ random +".png";

                        System.out.println("Descomprimindo imagem...");
                        
                        Decompressor decompressor = new Decompressor();
                        decompressor.decompressImage(compressedFilePath, outputImagePath);

                        System.out.println("Imagem descomprimida salva em: " + outputImagePath);
                    }
                    case 3 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho da imagem que deseja calcular a entropia total: ");
                        String inputImagePath = input.nextLine();

                        System.out.println("Entropia total da imagem: " + EntropyCalculator.getTotalEntropy(inputImagePath));
                    }
                    case 4 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho da imagem que deseja calcular a entropia média: ");
                        String inputImagePath = input.nextLine();

                        System.out.println("Entropia média da imagem: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));
                    }
                    case 5 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho da imagem que deseja calcular a entropia por canal: ");
                        String inputImagePath = input.nextLine();

                        System.out.println("Entropia da imagem por canal: \n");
                        EntropyCalculator.calculate(inputImagePath);
                    }
                    case 6 -> {
                        input.nextLine();
                        System.out.println("Digite o caminho da imagem que deseja analisar: ");
                        String inputImagePath = input.nextLine();

                        int random = new Random().nextInt(1000);
                        String compressedFilePath = "./images/compressedImages/imagemComprimida"+ random +".txt";
                        String outputImagePath = "./images/decompressedImages/ImagemDescomprimida"+ random +".png";

                        System.out.println("Comprimindo imagem...");
                        Compressor compressor = new Compressor();
                        compressor.compressImage(inputImagePath, compressedFilePath);

                        System.out.println("Imagem comprimida salva em: " + compressedFilePath);

                        System.out.println("Descomprimindo imagem...");
                        Decompressor decompressor = new Decompressor();
                        decompressor.decompressImage(compressedFilePath, outputImagePath);

                        System.out.println("Imagem descomprimida salva em: " + outputImagePath);

                        System.out.println("Entropia total da imagem: " + EntropyCalculator.getTotalEntropy(inputImagePath));

                        System.out.println("Entropia média da imagem: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));

                        System.out.println("Entropia da imagem por canal: \n");
                        EntropyCalculator.calculate(inputImagePath);
                    }
                    case 7 -> {
                        input.nextLine();

                        File f = new File("images/testImages");

                        File[] files = f.listFiles(new FileFilter() {
                            @Override
                            public boolean accept(File pathname) {
                                return pathname.isFile();
                            }
                        });

                        for (int i = 1; i <= files.length; i++) {
                            String inputImagePath = "images/testImages/image"+i+".png";
                        

                            int random = new Random().nextInt(1000);
                            String compressedFilePath = "./images/compressedImages/imagemComprimida"+ random +".txt";
                            String outputImagePath = "./images/decompressedImages/ImagemDescomprimida"+ random +".png";

                            System.out.println("Comprimindo imagem...");
                            Compressor compressor = new Compressor();
                            compressor.compressImage(inputImagePath, compressedFilePath);

                            System.out.println("Imagem comprimida salva em: " + compressedFilePath);

                            System.out.println("Descomprimindo imagem...");
                            Decompressor decompressor = new Decompressor();
                            decompressor.decompressImage(compressedFilePath, outputImagePath);

                            System.out.println("Imagem descomprimida salva em: " + outputImagePath);

                            System.out.println("Entropia total da imagem: " + EntropyCalculator.getTotalEntropy(inputImagePath));

                            System.out.println("Entropia média da imagem: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));

                            System.out.println("Entropia da imagem por canal: \n");
                            EntropyCalculator.calculate(inputImagePath);
                        }
                    }
                    case 9 -> {
                        System.out.println("Saindo...");
                        System.exit(0);
                    }
            
                    default -> {
                        System.out.println("Opção inválida");
                    }
            }} while (true);

            // // Caminhos dos arquivos
            // String inputImagePath = "./images/testImages/11834815.png";
            // String compressedFilePath = "./images/compressedImages/imagemComprimida.txt";
            // String outputImagePath = "./images/decompressedImages/ImagemDescomprimida.png";
    
            // // Compressão
            // Compressor compressor = new Compressor();
            // compressor.compressImage(inputImagePath, compressedFilePath);
    
            // // Descompressão
            // Decompressor decompressor = new Decompressor();
            // decompressor.decompressImage(compressedFilePath, outputImagePath);
    
            // // Cálculo da entropia total
            // System.out.println("Entropia total da imagem original: " + EntropyCalculator.getTotalEntropy(inputImagePath));
            // System.out.println("Entropia total da imagem descomprimida: " + EntropyCalculator.getTotalEntropy(outputImagePath));
    
            // System.out.println("\n");
            
            // // Cálculo da entropia média
            // System.out.println("Entropia média da imagem original: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));
            // System.out.println("Entropia média da imagem descomprimida: " + EntropyCalculator.getEntropyImageAverage(outputImagePath));
            
            // System.out.println("\n");
    
            // // Cálculo da entropia por canal
            // System.out.println("Entropia da imagem original por canal: \n");
            // EntropyCalculator.calculate(inputImagePath);
    
            // System.out.println("Entropia da imagem descomprimida por canal: \n");
            // EntropyCalculator.calculate(outputImagePath); 
}

    public static int Menu() {
        System.out.println("1 - Compressão");
        System.out.println("2 - Descompressão");
        System.out.println("3 - Cálculo da entropia total");
        System.out.println("4 - Cálculo da entropia média");
        System.out.println("5 - Cálculo da entropia por canal");
        System.out.println("6 - Todas as opções acima para uma imagem");
        System.out.println("7 - Todas as opções acima para todas as imagens");
        System.out.println("9 - Sair");
    
        int opcao = input.nextInt();
        return opcao;
    }
}
