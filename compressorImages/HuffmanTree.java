package compressorImages;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
    protected HuffmanNode root;
    private Map<Integer, String> codes = new HashMap<>();

    // Construção da árvore de Huffman
    public HuffmanTree(Map<Integer, Integer> frequencies) {
        // Fila de prioridade para armazenar os nós da árvore
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Construção da árvore
        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();
            HuffmanNode parent = new HuffmanNode(-1, left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;
            queue.add(parent);
        }

        // Geração dos códigos binários
        root = queue.poll();
        generateCodes(root, "");
    }

    // Gera os códigos binários a partir da árvore de Huffman
    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;
        if (node.value != -1) {
            codes.put(node.value, code);
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }

    // Retorna os códigos binários
    public Map<Integer, String> getCodes() {
        return codes;
    }

    // Adição da função getRoot para acessar o nó raiz
    public HuffmanNode getRoot() {
        return root;
    }
}
