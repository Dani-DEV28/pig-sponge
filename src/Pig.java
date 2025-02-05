// import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Pig {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    /*
    * Create a method "pigLatin" that takes a string consisting of one or more 
    * all-lowercase words separated by spaces. It should return a new string 
    * converted to "pig Latin," where each word has its first letter moved to 
    * the back and the letters "ay" are added to the end of the word. However, 
    * words starting with a vowel (a, e, i, o, or u) should not be altered.
    *
    * Examples:
    *
    * pigLatin("something")  should return "omethingsay"
    * pigLatin("awesome")    should return "awesome" (words starting with a vowel should not be altered)
    * pigLatin("latin is a hard language")  should return "atinlay is a ardhay anguagelay"
    * pigLatin("y")  should return "yay"
    * pigLatin("e")   should return "e"
    */
    public static void main(String[] args) {
        // Test cases
        assertEqual(1, pigLatin("something"), "omethingsay");
        assertEqual(2, pigLatin("awesome"), "awesome");
        assertEqual(3, pigLatin("latin is a hard language"), "atinlay is a ardhay anguagelay");
        assertEqual(4, pigLatin("y"), "yay");
        assertEqual(5, pigLatin("e"), "e");
    }

    // Implement your solution here!
    public static String pigLatin(String sentence) {
        if(sentence.contains(" ")){
            List<String> sentenceArray = Arrays.asList(sentence.split(" "));
            sentence = modLogic(sentenceArray);
        }else{
            sentence = modLogic(sentence);
        }

        return sentence;
    }

    public static String modLogic(String sentence){
        char saveFirstLetter = sentence.charAt(0);

        if(!VOWELS.contains(saveFirstLetter)){
            sentence = sentence.substring(1) + saveFirstLetter + "ay";
        }

        return sentence;
    }

    public static String modLogic(List<String> sentence){

        for(int i = 0; i < sentence.size(); i++){
            char saveFirstLetter = sentence.get(i).charAt(0);

            if(!VOWELS.contains(saveFirstLetter)){
                String modWord = sentence.get(i).substring(1) + saveFirstLetter + "ay";
                sentence.set(i, modWord);
            }
        }

        String finalLine = "";

        for(String word: sentence){
            finalLine += word + " ";
        }

        return finalLine.substring(0, finalLine.length()-1);
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
  
  