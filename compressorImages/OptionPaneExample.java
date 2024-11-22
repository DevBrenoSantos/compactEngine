package compressorImages;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.io.FileFilter;

public class OptionPaneExample {
    public static void main(String[] args) {
        
        // Criação da janela principal
        JFrame frame = new JFrame("Compact Engine");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Botão para abrir o JOptionPane
        JButton button = new JButton("Selecionar Função");
        button.setBounds(100, 100, 200, 30);
        frame.add(button);
       
        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Opções do menu
                String[] options = {"Compressão", "Descompressão", "Calculo de entropia total","Cálculo da Entropia média", "Cálculo de entropia por canal", "Todas as opções para uma img", "Todas as opções para todas as img", "sair"};
                
                // Exibir o JOptionPane com as opções
                int choice = JOptionPane.showOptionDialog(frame,
                        "Selecione uma função para executar:",
                        "Menu de Funções",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                
                // Executar a função correspondente à escolha do usuário
                switch (choice) {
                    case 0 -> {
                        String inputImagePath = windowFileSelect(frame);
                        System.out.println("Caminho da imagem: "+inputImagePath);

                        int random = new Random().nextInt(1000);
                        String compressedFilePath = "../images/compressedImages/imagemComprimida"+ random +".txt";

                        System.out.println("Comprimindo imagem...");
                        
                        Compressor compressor = new Compressor();
                        compressor.compressImage(inputImagePath, compressedFilePath);
                        
                        String msg = "Imagem comprimida salva em: "+compressedFilePath;
                        windowMsg(msg, frame);
                        break;
                    }
                        case 1 -> {
                            
                            String compressedFilePath = windowFileSelect(frame);
    
                            int random = new Random().nextInt(1000);
                            String outputImagePath = "../images/descompactImages/ImagemDescomprimida"+ random +".png";
    
                            System.out.println("Descomprimindo imagem...");
                            
                            Decompressor decompressor = new Decompressor();
                            decompressor.decompressImage(compressedFilePath, outputImagePath);
    
                            
                            String msg = "Imagem Descomprimida salva em: "+ outputImagePath;
                            windowMsg(msg, frame);
                        }
                        case 2 -> {
                            
                            String inputImagePath = windowFileSelect(frame);
    
                            
                            String msg = "Entropia total da imagem: " + EntropyCalculator.getTotalEntropy(inputImagePath);
                            windowMsg(msg, frame);
                        }
                        case 3 -> {
                            
                            
                            String inputImagePath = windowFileSelect(frame);
    
                            String msg = "Entropia média da imagem: " + EntropyCalculator.getEntropyImageAverage(inputImagePath);
                            windowMsg(msg, frame);
                        }
                        case 4 -> {
                            
                            
                            String inputImagePath = windowFileSelect(frame);
    
                            System.out.println("Entropia da imagem por canal: \n");
                            String msg = "Entropia da imagem por canal \n"+EntropyCalculator.calculate(inputImagePath, true);
                            windowMsg(msg, frame);
                            
                        }
                        case 5 -> {
                            
                            
                            String inputImagePath = windowFileSelect(frame);
    
                            int random = new Random().nextInt(1000);
                            String compressedFilePath = "../images/CompactImages/imagemComprimida"+ random +".txt";
                            String outputImagePath = "../images/DescompactImages/ImagemDescomprimida"+ random +".png";
                            String msg = "Comprimindo Imagem...\nImagem comprimida salva em: "+compressedFilePath+"\nDescomprimindo imagem...\n"+"Imagem descomprimida salva em: "+outputImagePath+"\nEntropia total da Imagem: "+EntropyCalculator.getTotalEntropy(inputImagePath)+"\nEntropia média da imagem: "+EntropyCalculator.getEntropyImageAverage(inputImagePath)+"Entropia da imagem pro canal: "+EntropyCalculator.calculate(inputImagePath,true);
                            windowMsg(msg, frame);
    
                            // System.out.println("Comprimindo imagem...");
                            // Compressor compressor = new Compressor();
                            // compressor.compressImage(inputImagePath, compressedFilePath);
    
                            // System.out.println("Imagem comprimida salva em: " + compressedFilePath);
    
                            // System.out.println("Descomprimindo imagem...");
                            // Decompressor decompressor = new Decompressor();
                            // decompressor.decompressImage(compressedFilePath, outputImagePath);
    
                            // System.out.println("Imagem descomprimida salva em: " + outputImagePath);
    
                            // System.out.println("Entropia total da imagem: " + EntropyCalculator.getTotalEntropy(inputImagePath));
    
                            // System.out.println("Entropia média da imagem: " + EntropyCalculator.getEntropyImageAverage(inputImagePath));
    
                            // System.out.println("Entropia da imagem por canal: \n");
                            // EntropyCalculator.calculate(inputImagePath);
                        }
                        case 6 -> {
                            
    
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
                        case 7 -> {
                            System.out.println("Saindo...");
                            System.exit(0);
                        }
                
                        default -> {
                            System.out.println("Opção inválida");
                        }
                }
            }
        });

        // Exibir a janela principal
        frame.setVisible(true);
         
    }

    public static String windowFileSelect(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione um arquivo");
        // Definindo um diretório padrão para a janela aparecer
        fileChooser.setCurrentDirectory(new File("../images"));
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            return filePath;
        } else {
            JOptionPane.showMessageDialog(frame, "opção de arquivo inválida !");
            return "";
        }
    }

    public static void windowMsg(String msg, JFrame frame) {
        JOptionPane.showMessageDialog(frame, msg, "Compressão e Descompressão", JOptionPane.INFORMATION_MESSAGE);
    }
}
