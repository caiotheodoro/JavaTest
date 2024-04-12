package edu.utfpr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.Test;

public class IdentifierTest {
  @Test
  public void testNullString() {
      Identifier identifier = new Identifier();

      String s = null;

      assertThrows(NullPointerException.class, () -> {
          identifier.validateIdentifier(s);
      });
  }
    @Test
    public void testEmptyString() {
        Identifier identifier = new Identifier();

        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            identifier.validateIdentifier("");
        });
    }
    @Test
    public void testOneDigitNumber() {
      Identifier identifier = new Identifier();

      String s = "1";
      boolean result = identifier.validateIdentifier(s);
      assertEquals(false, result);
  }
    @Test
    public void testOneDigitString() {
      Identifier identifier = new Identifier();

      String s = "a";
      boolean result = identifier.validateIdentifier(s);
      assertEquals(true, result);
  }
  @Test
  public void testOneDigitSpecial() { //caso de teste sem especificacao
    Identifier identifier = new Identifier();

    String s = "-";
    boolean result = identifier.validateIdentifier(s);
    assertEquals(false, result);
}
  @Test
  public void testOneDigitStringUtf8() { //caso de teste sem especificacao
    Identifier identifier = new Identifier();

    String s = "á";
    boolean result = identifier.validateIdentifier(s);
    assertEquals(false, result);
}
@Test
public void testStringWithSpecialUtf8Characters() { //caso de teste sem especificacao
  Identifier identifier = new Identifier();

  String s = "testá";
  boolean result = identifier.validateIdentifier(s);
  assertEquals(false, result);
}

public void testStringWithSpecialCharacters() { //caso de teste sem especificacao
  Identifier identifier = new Identifier();

  String s = "test-";
  boolean result = identifier.validateIdentifier(s);
  assertEquals(false, result);
}

    @Test
    public void testValid() {
      Identifier identifier = new Identifier();
      Random random = new Random();
      int count = 30;
      int minLength = 1;
      int maxLength = 5;
      String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

      for (int i = 0; i < count; i++) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'a'));

        for (int j = 1; j < length; j++) {
          sb.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        String s = sb.toString();
        boolean result = identifier.validateIdentifier(s);
        assertEquals(true, result);
      }
    }
    @Test void testValidNotStartingWithUtf8() {
      Identifier identifier = new Identifier();
      Random random = new Random();
      int count = 30;
      int minLength = 1;
      int maxLength = 4;
      String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789áéíóúãõâêîôûàèìòùç";

      for (int i = 0; i < count; i++) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'a'));

        for (int j = 1; j < length; j++) {
          sb.append(validChars.charAt(random.nextInt(validChars.length())));
        }
        String s =  "a".concat(sb.toString());
        System.out.println(s);
        boolean result = identifier.validateIdentifier(s);
        assertEquals(false, result);
      }
    }
    @Test void testValidStartingWithUtf8() {
      Identifier identifier = new Identifier();
      Random random = new Random();
      int count = 30;
      int minLength = 1;
      int maxLength = 4;
      String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789áéíóúãõâêîôûàèìòùç";

      for (int i = 0; i < count; i++) {
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'a'));

        for (int j = 1; j < length; j++) {
          sb.append(validChars.charAt(random.nextInt(validChars.length())));
        }
        String s =  "á".concat(sb.toString());
        System.out.println(s);
        boolean result = identifier.validateIdentifier(s);
        assertEquals(false, result);
      }
    }
    @Test
    public void testOnlyNumbers() {
        Identifier identifier = new Identifier();
        boolean result = identifier.validateIdentifier("123");
        assertEquals(false, result);
    }
    @Test
    public void test5Digit() {
        Identifier identifier = new Identifier();
        boolean result = identifier.validateIdentifier("abcde");
        assertEquals(true, result);
    }
    @Test
    public void test6Digit() {
        Identifier identifier = new Identifier();
        boolean result = identifier.validateIdentifier("abcdef");
        assertEquals(true, result);
    }
    @Test
    public void test7Digit() {
      Identifier identifier = new Identifier();
      Random random = new Random();
      int count = 30;
      int maxLength = 7;
      String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

      for (int i = 0; i < count; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) (random.nextInt(26) + 'a'));

        for (int j = 1; j < maxLength; j++) {
          sb.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        String s = sb.toString();
        boolean result = identifier.validateIdentifier(s);
        assertEquals(false, result);
      }
    }
}