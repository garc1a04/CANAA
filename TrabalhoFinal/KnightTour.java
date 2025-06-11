package TrabalhoFinal;

public class KnightTour {

    static final int N = 8;

    static int[] moveLinha = {2, 1, -1, -2, -2, -1, 1, 2}; 
    static int[] moveColuna = {1, 2, 2, 1, -1, -2, -2, -1}; 


    public static void main(String[] args) {
        int[][] tabuleiro = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tabuleiro[i][j] = -1;

        int linhaInicial = 0;
        int colunaInicial = 0;
        tabuleiro[linhaInicial][colunaInicial] = 0;

        if (resolverPasseio(linhaInicial, colunaInicial, 1, tabuleiro)) {
            imprimirTabuleiro(tabuleiro);
            
        } else {
            System.out.println("Nenhuma solução encontrada.");
        }
    }

    public static boolean resolverPasseio(int linha, int coluna, int numMovimento, int[][] tabuleiro) {
    	
        if (numMovimento == (N * N)) {
            return true;
        }
        
        for (int i = 0; i < 8; i++) {
            int proxLinha = linha + moveLinha[i];
            int proxColuna = coluna + moveColuna[i];

            if (posicaoValida(proxLinha, proxColuna, tabuleiro)) {
                tabuleiro[proxLinha][proxColuna] = numMovimento; 
                //imprimirTabuleiro(tabuleiro);
                
                if (resolverPasseio(proxLinha, proxColuna, numMovimento + 1, tabuleiro)) {
                    return true;
                } else {
                    tabuleiro[proxLinha][proxColuna] = -1;
                }
            }
        }

        
        return false;
    }

    public static boolean posicaoValida(int linha, int coluna, int[][] tabuleiro) {
        return (linha >= 0 && linha < N && coluna >= 0 && coluna < N && tabuleiro[linha][coluna] == -1);
    }

    public static void imprimirTabuleiro(int[][] tabuleiro) {
        System.out.println("Solução encontrada!");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
