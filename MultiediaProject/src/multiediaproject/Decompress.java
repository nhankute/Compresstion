/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.util.HashMap;

/**
 *
 * @author nhan-kute
 */
public class Decompress {
    private String encode;
    private String decode;
    private String Type_compress = "_decode_";
    private String Result;
    
    public Decompress(String str){
        this.encode = str;
        
        this.DecompressString();
    }

    private void DecompressString() {
        String str = "";
        int count;
        switch (encode.toCharArray()[0]){
            case 'R':
                Type_compress += "RLC";
                encode = encode.substring(1,encode.length());
                String[] Split;
                for(String c : encode.split(" ")){
                    Split = c.split("-",2);
                    count = Integer.parseInt(Split[0]);
                    while (count > 0){
                        str += Split[1];
                        count--;
                    }
                }
                break;
            case 'S':
                Type_compress += "Shannon";
                break;
            case 'L':
                Type_compress += "LZW";
                break;
            case 'H':
                Type_compress += "Huffman";
                encode = encode.substring(1,encode.length());
		HashMap<String , String> buffer = new HashMap<String , String>();
                String Input;
                for(String c : encode.split("\n")){
                    if(c.contains("-")){
                        Split = c.split("-",2);
                        buffer.put(Split[1], Split[0]);
                    }else {
                        Input = c;
                    }
                }
                String c1 = "";
		for(Character c : encode.toCharArray()){
			c1 = c1 + Character.toString(c) ;
			if(buffer.containsKey(c1)){
				str += buffer.get(c1);
				c1 = "";	
			}		
		}
                break;
            default :
                Type_compress += null;
                str = "Sir, we can't decode this file";
                break;
        }
        this.decode = str;
    }
    
    public String getType(){
        return this.Type_compress;
    }
    
    @Override
    public String toString(){
        return this.decode;
    }
}