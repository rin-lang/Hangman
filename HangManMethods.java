/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hangman;

import java.util.*;
import java.io.File;
//import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


public class HangManMethods {
    
    public static String randomWord(int difficulty) throws FileNotFoundException, MalformedURLException, IOException{
        //File wordBank = new File("C:\\Users\\24rla\\OneDrive\\Desktop\\Hangman_WordBank.txt");
        //Scanner x = new Scanner(new File("C:\\Users\\24rla\\OneDrive\\Desktop\\Hangman_WordBank.txt"));
        java.net.URL url = new java.net.URL("http://www-personal.umich.edu/~jlawler/wordlist");
        Scanner x = new Scanner(url.openStream());
        ArrayList<String> wordBankEasy = new ArrayList<>();
        ArrayList<String> wordBankMedium = new ArrayList<>();
        ArrayList<String> wordBankHard = new ArrayList<>();
        ArrayList<String> wordBankExpert = new ArrayList<>();
        while(x.hasNext()){
            String check = x.nextLine();
            if(check.length() >= 1 && check.length() <= 6){
                wordBankEasy.add(check);
            }
            else if(check.length() >= 7 && check.length() <= 10){
                wordBankMedium.add(check);
            }
            else if(check.length() >= 11 && check.length() <= 15){
                wordBankHard.add(check);
            }
            else if(check.length() >= 16){
                wordBankExpert.add(check);
            }
        }//end of while
        String word = "";
        switch (difficulty) {
            case 1 -> word = wordBankEasy.get((int)(Math.random() * wordBankEasy.size()));
            case 2 -> word = wordBankMedium.get((int)(Math.random() * wordBankMedium.size()));
            case 3 -> word = wordBankHard.get((int)(Math.random() * wordBankHard.size()));
            case 4 -> word = wordBankExpert.get((int)(Math.random() * wordBankExpert.size()));
           /* default -> {
            }*/
        }
       return word;
       //return "trythisword";
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
                                                                     "z", "-"));
        return alphabet.contains(userInput.toLowerCase());
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
    public static void displayHangMan(int tracker){
        
        String ten = """
                     ________
                     |      |
                     |      
                     |     
                     |    
                     |     
                     |     
                     |    
                     |
                     """;
        String nine = """
                     ________
                     |      |
                     |      O
                     |    
                     |    
                     |     
                     |    
                     |   
                     |
                      """;
        String eight = """
                     ________
                     |      |
                     |      O
                     |      |
                     |      | 
                     |      |
                     |     
                     |    
                     |
                      """;
        String seven = """
                     ________
                     |      |
                     |      O
                     |     /|
                     |      | 
                     |      |
                     |     
                     |    
                     |
                       """;
        String six = """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |      | 
                     |      |
                     |     
                     |    
                     |
                     """;
        String five = """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |    o | 
                     |      |
                     |    
                     |    
                     |
                     """;
        String four = """
                   ________
                   |      |
                   |      O
                   |     /|\\
                   |    o | o
                   |      |
                   |    
                   |    
                   |
                      """;
        String three = """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |    o | o
                     |      |
                     |     / 
                     |      
                     |
                       """;
        String two = """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |    o | o
                     |      |
                     |     / \\
                     |    
                     |
                       """;
        String one= """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |    o | o
                     |      |
                     |     / \\
                     |    o   
                     |
                       """;
        String zero = """
                     ________
                     |      |
                     |      O
                     |     /|\\
                     |    o | o
                     |      |
                     |     / \\
                     |    o   o
                     |
                       """;
                       
        
        String outPut = (tracker == 10 ? ten: tracker == 9 ? nine: tracker == 8 ? eight: tracker == 7 ? seven : tracker == 6 ? six : 
                         tracker == 5 ? five : tracker == 4 ? four : tracker == 3 ? three : tracker == 2 ? two : tracker == 1 ? one : zero);
        
        /*if(guess == true){
            outPut = (tracker == 6 ? six : tracker == 5 ? five : tracker == 4 ? four : tracker == 3 ? three : tracker == 2 ? two : tracker == 1 ? one : zero);
        }
        else{
            outPut = (tracker == 6 ? six : tracker == 5 ? five : tracker == 4 ? four : tracker == 3 ? three : tracker == 2 ? two : tracker == 1 ? one : zero);
       
        }*/
        System.out.print(outPut);
    }
    
    //This method checks the progress of how much of the word has been checked. 
    //If the word has been fully and correctly guessed, it returns false to end the while loop.
    public static boolean checkPoint(String[] fullWord, String[]answerGiven){
        return !Arrays.toString(answerGiven).equals(Arrays.toString(fullWord));
    }
    
    
    //This method prints out what letters the user has guessed correctly in the word.
    //(e.g. e x _ m _ l e) 
    public static String[] wordDisplay(String userInput, String word, String[] answerGiven){
        char temp = userInput.charAt(0);
        if(isItCorrect(userInput, word)){
            for(int k = 0; k < answerGiven.length; k++){
                //System.out.println(temp);
                    if(temp == word.charAt(k)){
                        answerGiven[k] = userInput;
                    }  
               /* if(k == 0){
                    if(userInput.equals(word.substring(0 , 1)))
                    answerGiven[k] = userInput;
                }
                
                else{
                    if(userInput.equals(word.substring((k - 1), k))){
                        answerGiven[k] = userInput;
                    }  
                }*/
            }
        }
        return answerGiven;
    }
    
    public static boolean wholeWordGuess(String userInput){
        return true;
    }
    
    
   // public static 
}//end of class

