/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

/**
 *
 * @author nhan-kute
 */
public class RLC {
    private String originalString;
    private String compressResult;
    
    public RLC(String str){
        super();
        this.originalString = str;
        this.compressResult = "R";
        
        this.compressString();
    }
    
    private void compressString(){
        int count = 0;
        Character temp = originalString.toCharArray()[0];
        for(Character c : originalString.toCharArray()){
            if(temp == c){
                count++;
            }else{
                compressResult += String.valueOf(count);
                compressResult += "-";
                compressResult += temp;
                compressResult += " ";
                temp = c;
                count = 1;
            }
        }
        compressResult += String.valueOf(count);
        compressResult += "-";
        compressResult += temp;
        System.out.println(compressResult);
    }
    
    @Override
    public String toString(){
        return compressResult;
    }
}
