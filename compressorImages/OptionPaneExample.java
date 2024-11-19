package compressorImages;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class OptionPaneExample {
    public static void main(String[] args) {
        
        // Criação da janela principal
        JFrame frame = new JFrame("Exemplo de JOptionPane");
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
                String[] options = {"Compressão", "Descompressão", "Calculo de entropia total"};
                
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
                    case 0:
                        String inputImagePath = windowFileSelect(frame);
                        System.out.println("Caminho da imagem: "+inputImagePath);

                        int random = new Random().nextInt(1000);
                        String compressedFilePath = "./images/compressedImages/imagemComprimida"+ random +".txt";

                        System.out.println("Comprimindo imagem...");
                        
                        Compressor compressor = new Compressor();
                        compressor.compressImage(inputImagePath, compressedFilePath);
                        
                        String msg = "Imagem comprimida salva em: "+compressedFilePath;
                        windowMsg(msg, frame);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(frame, "Função 2 executada");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(frame, "Função 3 executada");
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Nenhuma função selecionada");
                        break;
                }
            }
        });

        // Exibir a janela principal
        frame.setVisible(true);
         
    }
    public static String windowFileSelect(JFrame frame){
        JFileChooser fileChooser = new JFileChooser();
                        fileChooser.setDialogTitle("Selecione um arquivo");
                        // Definindo um diretório padrão para a janela aparecer 
                        fileChooser.setCurrentDirectory(new File("../images/testimages"));
                        int result = fileChooser.showOpenDialog(frame);
                        if (result == JFileChooser.APPROVE_OPTION){
                            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                            return filePath;
                        }
                        else{
                            JOptionPane.showMessageDialog(frame,"opção de arquivo inválida !");
                            return "";
                        }
    }
    public static void windowMsg(String msg, JFrame frame){
        JOptionPane.showMessageDialog(frame, msg, "Compressão e Descompressão", JOptionPane.INFORMATION_MESSAGE);
    }
}
