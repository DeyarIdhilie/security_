/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package securityhomework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author lenovo
 */
public class RailFenceCipher {
    
    
   public static void rail_fence_cipher(String plain_text) {
        Scanner rails_scanner = new Scanner(System.in);
        System.out.print("enter number of rails \n");
        int number_of_rails = rails_scanner.nextInt();
        if(number_of_rails>0)
        {
            
            filling_the_fence_rails(number_of_rails,plain_text);
        }
        else
           System.out.print("rails must be a positive integer \n"); 
       
        return;
    } 
   
   
   public static void print_the_output_cipher_of_rail_fence(int rails,int text_length,List<List<Character>> fence){
            
            for (int y=0; y<rails; y++)
            {
                
                for (int x =0; x<text_length; x++)
                {
                    if(fence.get(y).get(x)!=' ')
                    {
                        System.out.print(fence.get(y).get(x));
                    }
                    else 
                        continue;
                }
            }
           System.out.print("\n print"); 
           return;
    }
   
   
    public static void filling_the_fence_rails(int rails,String text)
    {
        //CREATE 2D ARRAYLIST 
        List<List<Character>> fence = new ArrayList<List<Character>>();
        //THIS ARRAYLIST SHOULD HAVE NUMBER OF RAWS EQUAL TO THE RAILS
        for(int add_rail=0; add_rail<rails; add_rail++)
        {
            fence.add(new ArrayList<Character>());
        }
        //ITS TIME TO FILL THE MATRIX 
       int flag =0;
       int column = 0;
       int column_to_fill = 0;
       int counter = 0;
       int row = 0;
       int j = 1;//j is used to decide wether to move downword or upword in the matrix
       int i =0;
       for(int c=0; c< text.length() ; c++)
       {
           for(int r=0; r<rails; r++)
           {
                if(r==row && c==column_to_fill)
                {
                        char letter= text.charAt(i);
                        Character letter_to_add=  Character.valueOf(letter);
                        fence.get(r).add(c, letter_to_add);
                        i++; //next char in the text
                        if(rails > 1)
                           row = row + j;
                        counter++;
                        column_to_fill++;
                        if(counter == rails-1)
                        {
                           j = j*-1;
                           counter = 0;
                        }
                }
                else
                {
                    fence.get(r).add(c,' ');
                }
           
           
           }
        }

    
        print_the_output_cipher_of_rail_fence(rails,text.length(),fence);
        return;
    }
    
    
     public static void decrypt_rail_fence_cipher(String cipher){
         Scanner rails_scanner = new Scanner(System.in);
        System.out.print("enter number of rails \n");
        int number_of_rails = rails_scanner.nextInt();
        if(number_of_rails>0)
        {
            
            marking_the_path(number_of_rails,cipher);
        }
        else
           System.out.print("rails must be a positive integer \n"); 
       
        return;
    }
     
     
    public static void try_to_crypt_rail_fence_cipher(String cipher){
        for(int try_rail=1 ; try_rail<=10; try_rail++ ){
            System.out.print("rails = "+try_rail+":\n");
            marking_the_path(try_rail,cipher);
             System.out.print("\n");
        }
    }
    
    
    /*my approach for dycreption would be to create a 2d matrix of rails rows and cipher length columns
    the i will walk in zig zag path through the matrix to mark the cells that i will fill as dirty*/
    public static void marking_the_path(int rails,String cipher){
        List<List<Character>> fence = new ArrayList<List<Character>>();
        //THIS ARRAYLIST SHOULD HAVE NUMBER OF RAWS EQUAL TO THE RAILS
        for(int add_rail=0; add_rail<rails; add_rail++){
            fence.add(new ArrayList<Character>());
        }
        //ITS TIME TO FILL THE MATRIX 
       
       int column_to_fill = 0;
       int counter = 0;
       int row = 0;
       int j = 1;//j is used to decide wether to move downword or upword in the matrix
       
    //   char white_space = '\s';
    //   Character white_space_to_add = Character.valueOf(white_space);
       for(int c=0; c< cipher.length() ; c++){
          
           for(int r=0; r<rails; r++){
             if(r==row && c==column_to_fill){
                        
                        fence.get(r).add(c,'D');
                        
                        if(rails > 1)
                           row = row + j;
                        counter++;
                        column_to_fill++;
                        if(counter == rails-1){
                           j = j*-1;
                           counter = 0;
                        }
                    }
                    else{
                        fence.get(r).add(c,' ');
                    }  
           }
          
    }
        filling_the_fence_rails_for_decryption(rails,cipher,fence);
        return;
    }
    
    
    public static void zig_zag_read_to_figure_plain(int rails,int cipher_length,List<List<Character>>fence){
       int column_to_fill = 0;
       int counter = 0;
       int row = 0;
       int j = 1;//j is used to decide wether to move downword or upword in the matrix
       
    //   char white_space = '\s';
    //   Character white_space_to_add = Character.valueOf(white_space);
       for(int c=0; c< cipher_length ; c++){
          
           for(int r=0; r<rails; r++){
             if(r==row && c==column_to_fill){
                        
                        System.out.print(fence.get(r).get(c));
                        
                        if(rails > 1)
                           row = row + j;
                        counter++;
                        column_to_fill++;
                        if(counter == rails-1){
                           j = j*-1;
                           counter = 0;
                        }
                    }
                     
           }
          
    }
       System.out.print("\n");
    }
    
    
    /*the entered cipher will be entered in the matrix row by row
    what cells will be filled? the dirty cell that we marked*/
    public static void filling_the_fence_rails_for_decryption(int rails,String cipher,List<List<Character>> fence){
        List<List<Character>> fence2= fence;
        int i =0;
        for(int r=0; r<rails;r++)
        {   
            //WIREEEDSEEEACAECVDLTNROFO
            for(int c =0;c<cipher.length();c++)
            {

                if(fence.get(r).get(c)== 'D'){
                    
                    char letter= cipher.charAt(i);
                    Character letter_to_add=  Character.valueOf(letter);
                    fence.get(r).set(c, letter_to_add);
                    i++; //next char in the text
                    
                }
               
            }
        }
        zig_zag_read_to_figure_plain(rails,cipher.length(),fence);
        return;
    }
}
