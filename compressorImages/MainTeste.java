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
    }
}
