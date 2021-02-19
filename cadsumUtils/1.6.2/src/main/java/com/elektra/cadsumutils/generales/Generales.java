/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elektra.cadsumutils.generales;

/**
 *
 * @author dparra
 */
public class Generales {

    public static Generales getInstance(){
        return new Generales();
    }

    public String substr(String string, int min, int max) {

        if (string == null) {
            return string;
        } else {
            if (string.length() > max) {
                return string.substring(min, max);
            } else {
                return string;
            }
        }

    }

    /***
     * Pads a string (Left or Right) with given pad-Character
     * @param s String to be padded
     * @param rL 0 left - 1 right, default 0
     * @param p pad character
     * @param lenght desired lenght of returned string
     * @return Padded String
     */
    public String padding(String s, int rL, char p, int lenght){
        int padLenght = lenght-s.length();
        String padded;
        if(s.length()>lenght){
            return s;
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<padLenght;i++){
                sb.append(p);
            }
            switch(rL){
                case 0: default:
                    padded=sb.toString()+s;
                    break;
                case 1:
                    padded=s+sb.toString();
                    break;
            }
        }
        return padded;
    }
    
    /***
     * remove v|ED prefix or ekt-NN suffix
     * @param pedido
     * @return String without prefix or suffix
     */
    public String soToNumber(String pedido){
        String s = pedido.replaceAll("[a-zA-z]","").replaceAll("(-[0-9]*)", "");
        return s;
    }
}
