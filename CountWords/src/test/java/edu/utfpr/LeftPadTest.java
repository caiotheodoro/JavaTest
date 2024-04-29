package edu.utfpr;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;



// #### Partição inválida 

// - padStr é nulo ou "" (vazio)
// - padSize é maior que o tamanho de padStr
// - padSize é -1

// #### Partição válida

// - padSize é 0
// - padSize é 1
// - str é nulo
// - padStr é nulo ou "" (vazio)
// - padSize é igual ao tamanho de padStr
// - padSize é um menor que o tamanho de padStr


// Temos então 18 casos de testee, contando com os limites.
public class LeftPadTest {
  @Test
  void teste_invalid_null_str() {
    assertThat(LeftPad.leftPad(null, 5, "*")).isEqualTo("*****");
  }

  @Test
  void teste_invalid_empty_padStr() {
    assertThat(LeftPad.leftPad("teste", 5, "")).isEqualTo(" teste");
  }

  @Test
  void teste_invalid_null_padStr() {
    assertThat(LeftPad.leftPad("teste", 5, null)).isEqualTo(" teste");
  }

  @Test
  void teste_invalid_padSize_zero() {
    assertThat(LeftPad.leftPad("teste", 0, "*")).isEqualTo("teste");
  }

  @Test
  void teste_invalid_padSize_negative() {
    assertThat(LeftPad.leftPad("teste", -1, "*")).isEqualTo("teste");
  }

  @Test
  void teste_invalid_padSize_greater_than_padStr() {
    assertThat(LeftPad.leftPad("teste", 5, "**")).isEqualTo("*teste");
  }

  @Test
  void teste_valid_null_str() {
    assertThat(LeftPad.leftPad(null, 5, "****")).isEqualTo("*****");
  }

  @Test
  void teste_valid_empty_padStr() {
    assertThat(LeftPad.leftPad("teste", 5, "")).isEqualTo(" teste");
  }

  @Test
  void teste_valid_padSize_equals_padStr() {
    assertThat(LeftPad.leftPad("teste", 4, "*")).isEqualTo("teste");
  }

  @Test
  void teste_valid_padSize_one() {
    assertThat(LeftPad.leftPad("teste", 1, "*")).isEqualTo("teste");
  }

  @Test
  void teste_valid_padSize_less_than_padStr() {
    assertThat(LeftPad.leftPad("teste", 3, "***")).isEqualTo("teste");
  }

  @Test
  void teste_valid_padSize_equals_str() {
    assertThat(LeftPad.leftPad("teste", 4, "*")).isEqualTo("teste");
  }

  @Test
  void teste_valid_padSize_greater_than_str() {
    assertThat(LeftPad.leftPad("teste", 6, "*")).isEqualTo("**teste");
  }

  @Test
  void teste_valid_padSize_greater_than_padStr() {
    assertThat(LeftPad.leftPad("teste", 6, "**")).isEqualTo("**teste");
  }

  @Test
  void teste_valid_general_case() {

    assertThat(LeftPad.leftPad("teste", 5, "*")).isEqualTo("*teste");
    assertThat(LeftPad.leftPad("teste", 6, "*")).isEqualTo("**teste");
    assertThat(LeftPad.leftPad("teste", 7, "*")).isEqualTo("***teste");
    assertThat(LeftPad.leftPad("teste", 8, "*")).isEqualTo("****teste");
    assertThat(LeftPad.leftPad("teste", 9, "*")).isEqualTo("*****teste");
   
  }
  

  
}
