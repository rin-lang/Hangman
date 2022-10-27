/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hangman;

import java.util.ArrayList;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 24rla
 */
public class HangManMethods {
        
    public static String randomWord(int difficulty){
        
        return "testwordforfun";
    }
    
    /*public static String[] separateLetters(String fullWord){
        String[] fullWordLetters = new String[fullWord.length()];
        for(int i = 0; i < fullWord.length(); i++){
            fullWordLetters[i] = fullWord.substring(0 + i, i + 1);
        }
        return fullWordLetters;
    }*/
    
   /* public static int guessesLeft(String guess, int tracker, String word){
        if(isItCorrect(guess, word) == true)
            return tracker--;
        return tracker;
    }*/
    
    
    //This method checks if the user inputed a proper letter, regardless of capitalization.
    //It checks if the input is in the given array of the english alphabet.
    //Returns true if it's a letter, false if it is not.
    public static boolean possibleGuesses(String userInput){
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", 
                                                                     "f", "g", "h", "i", "j", 
                                                                     "k", "l", "m", "n", "o",
                                                                     "p", "q", "r", "s", "t", 
                                                                     "u", "v", "w", "x", "y", 
                                                                     "z"));
        return alphabet.contains(userInput);
    }

    
    //This method checks if the userinputted a letter they had already guessed before. 
    //Returns true if it has been guessed before, and returns false if it has not been guessed.
    public static boolean userGuessed(String userInput, ArrayList<String> lettersGuessed){
        if(lettersGuessed.contains(userInput))
            return true;
        else{
            lettersGuessed.add(userInput);
            return false;
        }
    }
    
    
    //This method returns true if the userinput is in the word and false if it is not.
    public static boolean isItCorrect(String userInput, String word){
        return (word.contains(userInput));
    }
    
    
    //This method displays the actual hanging man
    public static void displayHangMan(int tracker, boolean guess){
        
        String six = """
                     ________
                     |      |
                     |      
                     |     
                     |     
                     |
                     """;
        String five = """
                      ________
                      |      |
                      |      O
                      |     
                      |     
                      |
                      """;
        String four = """
                     ________
                     |      |
                     |      O
                     |      |
                     |     
                     |
                      """;
        String three = """
                     ________
                     |      |
                     |      O
                     |     /|
                     |     
                     |
                       """;
        String two = """
                     ________
                     |      |
                     |      O
                     |     /|\
                     |     
                     |
                     """;
        String one = """
                     ________
                     |      |
                     |      O
                     |     /|\
                     |     /
                     |
                     """;
        String zero = """
                     ________
                     |      |
                     |      O
                     |     /|\
                     |     / \
                     |
                      """;
        String outPut;
        if(guess == true){
            outPut = (tracker == 6 ? six : tracker == 5 ? five : tracker == 4 ? four : tracker == 3 ? three : tracker == 2 ? two : tracker == 1 ? one : zero);
        }
        else{
            outPut = (tracker == 6 ? six : tracker == 5 ? five : tracker == 4 ? four : tracker == 3 ? three : tracker == 2 ? two : tracker == 1 ? one : zero);
       
        }
        System.out.println(outPut);
    }
    
    //This method prints out what letters the user has guessed correctly in the word.
    //(e.g. e x _ m _ l e) 
    public static boolean checkPoint(String word, String[]answerGiven){
        
        return true;
    }
    
}//end of class

