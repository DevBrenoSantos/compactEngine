package compressorImages;

public class MainTeste {
    public static void main(String[] args) {
        String inputImagePath = "./images/testImages/11834815.png";
        String compressedFilePath = "./images/compressedImages/imagemComprimida.txt";
        String outputImagePath = "./images/decompressedImages/ImagemDescomprimida.png";

        // Compressão
        Compressor compressor = new Compressor();
        compressor.compressImage(inputImagePath, compressedFilePath);
        System.out.println("Imagem comprimida com sucesso!");

        // Descompressão
        Decompressor decompressor = new Decompressor();
        decompressor.decompressImage(compressedFilePath, outputImagePath);
        System.out.println("Imagem descomprimida com sucesso!");
    }
}
