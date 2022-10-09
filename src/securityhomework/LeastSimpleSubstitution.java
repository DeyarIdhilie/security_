/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package securityhomework;
import java.util.*;
import java.util.Map.Entry;

/**
 *
 * @author lenovo
 */
public class LeastSimpleSubstitution {
    public Map<Character,Character> map_letter_to_cipher = new HashMap<>();
    public char[] letter_ordered_by_frequency_to_occure = {'e', 't', 'a', 'o', 'i', 'n', 's', 'r', 'h', 'd', 'l', 'u', 'c', 'm', 'f', 'y', 'w', 'g', 'p', 'b', 'v', 'k', 'x', 'q', 'j', 'z'};
    public void create_letter_mapping(){
          
               for (char ch = 'A'; ch <= 'Z'; ++ch) 
                   map_letter_to_cipher.put(ch, ' ');
        List <Character> list = new ArrayList();
        for (char ch = 'a'; ch <= 'z'; ++ch) 
                  list.add(ch);
        Collections.shuffle(list);
        int i =0;
        for (Character ch : map_letter_to_cipher.keySet()) {
            map_letter_to_cipher.put(ch, list.get(i));
            i++;
        }
        print_the_key_map();
//        char letter ='A';     
//        List <Character> list = new ArrayList();
//        for(char ch = 'a'; ch <= 'z'; ++ch) 
//                  list.add(ch);
//        Collections.shuffle(list);
//        
//        for(int i=0;i<list.size();i++)
//        {
//            map_letter_to_cipher.put(list.get(i), ' ');
//        }
//        
//        for (Character ch : map_letter_to_cipher.keySet()) {
//            map_letter_to_cipher.put(ch, letter);
//            letter++;
//            
//        }
//        
//        print_the_key_map();
        
    }
    public void figure_original_letter(LinkedHashMap<Character,Float>sortedMap, String text){
        HashMap<Character,Character> map=  new HashMap<>();
        int i=0;
        for(char c: sortedMap.keySet()){
            map.put(c,letter_ordered_by_frequency_to_occure[i]);
            i++;
        }
        System.out.print("The original text might be: \n");
        for(int t=0; t<text.length();t++){
           System.out.print(Character.toUpperCase(map.get(text.charAt(t)))); 
        }
        System.out.print("\n");
    }
    public void sort_the_ciphered_letters_by_frequency(Map<Character,Float>letters_map, String text){
        LinkedHashMap<Character,Float> sortedMap = new LinkedHashMap<>();
        ArrayList<Float> list = new ArrayList<>();
//        for (Map.Entry<Character,Float> entry : letters_map.entrySet()) {
//            list.add(entry.getValue());
//        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        letters_map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//        Collections.sort(list, new Comparator<Float>() {
//            public int compare(Float f, Float f1) {
//                return (f).compareTo(f1);
//            }
//        });
//        for (Float f : list) {
//            for (Entry<Character,Float> entry : letters_map.entrySet()) {
//                if (entry.getValue().equals(f)) {
//                    sortedMap.put(entry.getKey(), f);
//                }
//            }
//        }
        System.out.println(sortedMap);
        figure_original_letter(sortedMap,text);
    }
    public void find_frequency_of_letter_in_Text(String text){
          Map<Character,Float> map_letters_to_occurence = new HashMap<>();
          for (char ch = 'a'; ch <= 'z'; ++ch) 
              map_letters_to_occurence.put(ch, 0.0f); 
          
          for (int x=0; x<text.length();x++){
           
            
              //if character already traversed, increment it
              map_letters_to_occurence.put(Character.toLowerCase(text.charAt(x)), ((map_letters_to_occurence.get(Character.toLowerCase(text.charAt(x))) + 1)));
           
          
    }
          for (char ch = 'a'; ch <= 'z'; ++ch) {
              map_letters_to_occurence.put(ch,(map_letters_to_occurence.get(ch)/text.length())*100); 
          }
//          for (Character x : map_letters_to_occurence.keySet()) {
//              System.out.println( x + " : " + map_letters_to_occurence.get(x));
//}
        sort_the_ciphered_letters_by_frequency(map_letters_to_occurence,text);
    }
    public void print_the_key_map(){
       
       for (Character cha : map_letter_to_cipher.keySet()) {
              System.out.println( cha + " : " + map_letter_to_cipher.get(cha));
        }
       
    }
    public void print_the_cipher(String text){
        System.out.print("The cipher: \n");
        for (int p=0; p<text.length();p++){
            System.out.print(map_letter_to_cipher.get(text.charAt(p)));
        }
         
         System.out.print("\n");
    }
    
    public void least_simple_substitution_decrypt(String text)
    {
        
        for(int cipher =0;cipher<text.length();cipher++)
        {
            for(Entry<Character,Character> entry: map_letter_to_cipher.entrySet())
            {
                   if(entry.getValue() == text.charAt(cipher)) 
                   {
                       System.out.print(entry.getKey());
                       break;
                   }
            }
        }
        System.out.print("\n");
        
    }
    public  void least_simple_substitution(String plain_text) {
//        System.out.print(plain_text +"\n");
      
        create_letter_mapping();
        print_the_cipher(plain_text);
        



    }
}
