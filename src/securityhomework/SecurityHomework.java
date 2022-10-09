/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package securityhomework;
import java.util.*;
public class SecurityHomework {
    
    
    public static char show_menu(){
        System.out.print("Do you want to:\n"
                + "a.encrypt a text\n"
                + "b.decrypt a cipher\n"
                + "c.crack a cipher\n");
        Scanner read_chosen_crypt = new Scanner(System.in);
        char crypt = read_chosen_crypt.next().charAt(0);
        return crypt;
    }
   
    
    public static String remove_spaces(String original_text) {
        String text_without_spaces = original_text.replaceAll("[^\\p{IsAlphabetic}]", "");
        return text_without_spaces;
    }
    
    
    public static String read_user_text() {
        Scanner text_scanner = new Scanner(System.in);
        System.out.print("enter your text \n");
        String user_text = text_scanner.nextLine();
        String text_without_spaces = remove_spaces(user_text);
        return text_without_spaces;
    }
    
    
    
    public static void main(String[] args) {
        RailFenceCipher rail_fence_cipher_obj = new RailFenceCipher();
        LeastSimpleSubstitution least_simple_substitution_obj = new LeastSimpleSubstitution();
         while(true) {
            try {

                System.out.println("please choose an encryption technique from the menu:\n 1-Rail Fence Cipher\n 2-Least-Simple Substitution\n");
                Scanner input_scanner = new Scanner(System.in);

                int chosen_tech = input_scanner.nextInt();
                if (chosen_tech == 1) 
                {
                    char chosen_crypt = show_menu();
                    String text = read_user_text();
                    if (chosen_crypt == 'a'|| chosen_crypt == 'A')
                         rail_fence_cipher_obj.rail_fence_cipher(text);
                    else if (chosen_crypt == 'b'|| chosen_crypt == 'B')
                         rail_fence_cipher_obj.decrypt_rail_fence_cipher(text);
                    else if (chosen_crypt == 'c'|| chosen_crypt == 'C')
                         rail_fence_cipher_obj.try_to_crypt_rail_fence_cipher(text);
                    else
                        System.out.print("Not from the options");

                } 
                else if (chosen_tech == 2) 
                {
                    char chosen_crypt = show_menu();
                    String plain_text = read_user_text();
                    if (chosen_crypt == 'a'|| chosen_crypt == 'A')
                        least_simple_substitution_obj.least_simple_substitution(plain_text);
                    else if (chosen_crypt == 'b'|| chosen_crypt == 'B')
                        least_simple_substitution_obj.least_simple_substitution_decrypt(plain_text);
                    else if (chosen_crypt == 'c'|| chosen_crypt == 'C')
                        least_simple_substitution_obj.find_frequency_of_letter_in_Text(plain_text);
                }
                else {
                    System.out.print("please choose a number from the menu");
                    System.out.print("\n");
                }


            } catch (Exception e) {
                // System.out.print(e.printStackTrace());
                e.printStackTrace();
                System.out.print("you can only choose a number \n");

            }
         }
    }
}