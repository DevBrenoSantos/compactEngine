package compressorImages;

public class HuffmanNode implements Comparable<HuffmanNode> {
    int value;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }

    // Comparador para a fila de prioridade
    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}