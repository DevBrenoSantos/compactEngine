package compressorImages;

public class MainTeste {
    public static void main(String[] args) {
        // Caminhos dos arquivos
        String inputImagePath = "./images/testImages/11834815.png";
        String compressedFilePath = "./images/compressedImages/imagemComprimida.txt";
        String outputImagePath = "./images/decompressedImages/ImagemDescomprimida.png";

        // Compressão
        Compressor compressor = new Compressor();
        compressor.compressImage(inputImagePath, compressedFilePath);

        // Descompressão
        Decompressor decompressor = new Decompressor();
        decompressor.decompressImage(compressedFilePath, outputImagePath);

        // Cálculo da entropia total
        System.out.println("Entropia total da imagem original: " + EntropyCalculator.getTotalEntropy(inputImagePath));
        System.out.println("Entropia total da imagem descomprimida: " + EntropyCalculator.getTotalEntropy(outputImagePath));

        System.out.println("\n");
        
        // Cálculo da entropia média
        System.out.println("Entropia média da imagem original: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));
        System.out.println("Entropia média da imagem descomprimida: " + EntropyCalculator.getEntropyImageAverage(outputImagePath));
        
        System.out.println("\n");

        // Cálculo da entropia por canal
        System.out.println("Entropia da imagem original por canal: \n");
        EntropyCalculator.calculate(inputImagePath);

        System.out.println("Entropia da imagem descomprimida por canal: \n");
        EntropyCalculator.calculate(outputImagePath);


    }
}
