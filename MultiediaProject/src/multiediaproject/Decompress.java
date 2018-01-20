/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiediaproject;

import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author nhan-kute
 */
public class Decompress {
    private String encode;
    private String decode;
    private String Type_compress = "";
    private String Result;
    
    public Decompress(String str){
        this.encode = str;
        
        this.DecompressString();
    }

    private void DecompressString() {
        String str = "";
        switch (encode.toCharArray()[0]){
            case 'R':
                int count;
                Type_compress += "RLC";
                encode = encode.substring(1,encode.length());
                String[] Split;
                Vector<String> SplitEncode = new Vector<>();
                String temp = "";
                for(int i = 0; i < encode.length()-1; i++){
                    if(encode.charAt(i) != ' '){
                        temp += encode.charAt(i);
                    }else{
                        if(encode.charAt(i+1) == ' '){
                            temp += encode.charAt(i);
                        }
                        else{
                            SplitEncode.add(temp);
                            //c[count] = temp;
                            temp = "";
                        }
                    }
                }
                temp += encode.charAt(encode.length() - 1);
                SplitEncode.add(temp);
                for(String c : SplitEncode){
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
                encode = encode.substring(1);
		String BinaryCode;
                BinaryCode= encode.split(" ",2)[0];
                String TableCode;
                TableCode= encode.split(" ",2)[1];
                while(TableCode.charAt(1)!='-'){
                    BinaryCode += " " +TableCode.split(" ",2)[0];
                    TableCode = TableCode.split(" ",2)[1];
                }
                temp = "";
                count = Integer.parseInt(BinaryCode.substring(0,1));
                if(count == 8)
                    count = 0;
                BinaryCode = BinaryCode.substring(1);
                boolean Turn = true;
                HashMap<String , Character> buffer = new HashMap<String , Character>();

                for(int i = TableCode.length() - 1; i > 0; i--){
                    if(TableCode.charAt(i) != ' '){
                        if(TableCode.charAt(i) == '-')
                            Turn = false;
                        else{
                            if(Turn == true)
                                temp += TableCode.charAt(i);
                            else{
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                            }
                        }
                    }else{
                        if(TableCode.charAt(i-1) == ' '){
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                        }
                        else{
                            Turn = true;
                            //c[count] = temp;
                            temp = "";
                        }
                    }
                }
                temp = new StringBuffer(temp).reverse().toString();
                buffer.put(temp, TableCode.charAt(0));

                String Binary;
                Binary = convertStringToBinaryString(BinaryCode);

                Binary = Binary.substring(count);
                    str = "";
                    String c1 = "";
                    for(Character c : Binary.toCharArray()){
                            c1 = c1 + Character.toString(c) ;
                            if(buffer.containsKey(c1)){
                                    str += buffer.get(c1);
                                    c1 = "";	
                            }		
                    }
                break;
            case 'L':
                Type_compress += "LZW";
                encode = encode.substring(1);
                BinaryCode = encode.split(" ",2)[0];
                TableCode = encode.split(" ",2)[1];
                
                Turn = true;
                HashMap<Integer , String> bufferLZW = new HashMap<Integer , String>();
                String tempKey = "";
                String tempValue = "";
                Character cc;
                for(String i : BinaryCode.split("-")){
                    int LzwCode = Integer.parseInt(i);
                    bufferLZW.put(LzwCode, TableCode.substring(String.valueOf(LzwCode).length() + 2 + TableCode.indexOf(" " + String.valueOf(i) + "-"), TableCode.indexOf(" " + String.valueOf(LzwCode+1) + "-")));
                }
                for(String i : BinaryCode.split("-")){
                    str += bufferLZW.get(Integer.parseInt(i));
		}
                
                
                break;
            case 'H':
                Type_compress += "Huffman";
                encode = encode.substring(1);
		BinaryCode = encode.split(" ",2)[0];
                TableCode = encode.split(" ",2)[1];
                while(TableCode.charAt(1) != '-'){
                    BinaryCode += " " +TableCode.split(" ",2)[0];
                    TableCode = TableCode.split(" ",2)[1];
                }
                temp = "";
                count = Integer.parseInt(BinaryCode.substring(0,1));
                if(count == 8)
                    count = 0;
                BinaryCode = BinaryCode.substring(1);
                Turn = true;
                buffer = new HashMap<String , Character>();

                for(int i = TableCode.length() - 1; i > 0; i--){
                    if(TableCode.charAt(i) != ' '){
                        if(TableCode.charAt(i) == '-')
                            Turn = false;
                        else{
                            if(Turn == true)
                                temp += TableCode.charAt(i);
                            else{
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                            }
                        }
                    }else{
                        if(TableCode.charAt(i-1) == ' '){
                                temp = new StringBuffer(temp).reverse().toString();
                                buffer.put(temp, TableCode.charAt(i));
                        }
                        else{
                            Turn = true;
                            //c[count] = temp;
                            temp = "";
                        }
                    }
                }
                temp = new StringBuffer(temp).reverse().toString();
                buffer.put(temp, TableCode.charAt(0));

                Binary = convertStringToBinaryString(BinaryCode);

                Binary = Binary.substring(count);
                    str = "";
                    c1 = "";
                    for(Character c : Binary.toCharArray()){
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
    
    public static String convertStringToBinaryString(String string){
            String sb = "";
            String str = "";
            for(Character c : string.toCharArray()){
                sb += Integer.toBinaryString((int) c);
                while(sb.length()%8 != 0){
                    sb = "0" + sb;
                }
                str += sb;
                sb = "";
            }
            return str;
        }
}
