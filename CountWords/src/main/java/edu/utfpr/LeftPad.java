package edu.utfpr;

public class LeftPad {
    public static String leftPad(final String str, final int size, String padStr) {
        String result = str; // iniciliza a variável result com o valor de str para facilitar a manipulação
        if (padStr == null || padStr.isEmpty()) {
            padStr = " "; // se padStr for nulo ou vazio, inicializa com um espaço (null ou vazio é tratado como se fosse um espaço em branco;)
        }
        if (str == null) { //pode ser null; se for, inicializa com uma string vazia
          result = "";
        }


        final int padSize = size - result.length(); // calcula o tamanho do padding necessário (considerando o tamanho da string)

        if (padSize == padStr.length()) { 
            return padStr.concat(result); // se o tamanho do padding for igual ao tamanho da string de padding, concatena o padding com a string
        }

        if (padSize <= 0) { // se o tamanho do padding for menor ou igual a zero, retorna a string original
            return result;
        }


        if (padSize < padStr.length()) { // se o tamanho do padding for menor que o tamanho da string de padding, concatena o padding com a string e corta o excesso
            return padStr.substring(0, padSize).concat(result);
        }

        final char[] padding = new char[padSize]; // cria um array de char com o tamanho do padding
        final char[] padChars = padStr.toCharArray(); // converte a string de padding em um array de char
        for (int i = 0; i < padSize; i++) { // preenche o array de char com os caracteres da string de padding
            padding[i] = padChars[i % padChars.length];
        }
        return new String(padding).concat(result); // retorna o padding concatenado com a string
    }
}
