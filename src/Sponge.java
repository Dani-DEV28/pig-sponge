
import java.util.Arrays;
import java.util.List;

public class Sponge {

  /*
   * Create a method "spongeCase" that takes a string consisting of one or more words 
   * separated by spaces. It should return a new string converted to "sponge 
   * case," where each word starts with a lowercase letter, and then alternates 
   * between upper and lower case for each following letter in the word.
   *
   * Examples:
   *
   * spongeCase("spongebob")  should return "sPoNgEbOb"
   * spongeCase("Who are YOU calling A Pinhead")  should return "wHo aRe yOu cAlLiNg a pInHeAd"
   * spongeCase("WHAT is UP my dude")  should return "wHaT iS uP mY dUdE"
   * spongeCase("debí tirar más fotos") should return dEbÍ tIrAr mÁs fOtOs" (note the accents)
   * spongeCase("E")  should return "e"
   * spongeCase("e")  should return "e"
   * 
   * Hints:
   * There exist the following methods in java:
   * Character.toUpperCase() (e.g. Character.toUpperCase('f'))
   * Character.toLowerCase() (e.g. Character.toLowerCase('Q'))
   * .toCharArray() String method (e.g. myString.toCharArray())
   */
  public static void main(String[] args) {

    System.out.println(spongeCase("test"));
    // Test cases
    assertEqual(1, spongeCase("spongebob"), "sPoNgEbOb");
    assertEqual(2, spongeCase("Who are YOU calling A Pinhead"), "wHo aRe yOu cAlLiNg a pInHeAd");
    assertEqual(3, spongeCase("WHAT is UP my dude"), "wHaT iS uP mY dUdE");
    assertEqual(4, spongeCase("debí tirar más fotos"), "dEbÍ tIrAr mÁs fOtOs");
    assertEqual(5, spongeCase("E"), "e");
    assertEqual(6, spongeCase("e"), "e");
  }

  // Implement your solution here!
  public static String spongeCase(String sentence) {
    if(sentence.contains(" ")){
      List<String> sentenceArray = Arrays.asList(sentence.split(" "));
      return modLogic(sentenceArray);
    }else{
      return modLogic(sentence);
    }
  }

  public static String modLogic(List<String> sentence){
    String holderLine = "";

    for(String item: sentence){
      holderLine += modLogic(item) + " ";
    }

    holderLine = holderLine.substring(0, holderLine.length()-1);

    return holderLine;
  }

  public static String modLogic(String sentence){
    String holder = "";
    Character holderChar;
    String convert;

    for(int i = 0; i < sentence.length(); i++){
      if(i%2 == 0){
        holderChar = sentence.charAt(i);
        convert = holderChar.toString();
        convert = convert.toLowerCase();

        holder += convert;

      }else{
        holderChar = sentence.charAt(i);
        convert = holderChar.toString();
        convert = convert.toUpperCase();

        holder += convert;
      }
    }

    return holder;
  }


  // Method to help with testing, you do not need to read this.
  public static void assertEqual(int testNumber, String actual, String expected) {
    if (!expected.equals(actual)) {
      System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
    } else {
      System.out.println("Test " + testNumber + " passed!");
    }
  }
}