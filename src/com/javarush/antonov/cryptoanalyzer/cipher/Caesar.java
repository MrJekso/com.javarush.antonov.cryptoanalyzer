package com.javarush.antonov.cryptoanalyzer.cipher;

import java.io.*;
import java.io.IOException;

public class Caesar extends Alphabet {
    /**
     * Цезарь проектируется по паттерну "Одиночка" т.к. создавать копии не потребуется.
     */
    private final static Caesar caesar = new Caesar();
    private Caesar(){}
    public static Caesar get(){return  caesar;}

    private char[] language = super.rus; //Задается язык поумолчанию.(русский)

    //При появление нового алфавита необходимо прописать инициализацию в данном классе
    public void  setLanguage(String languageString) throws ThereIsNoSuchLanguage {
        if(languageString.equalsIgnoreCase("рус") || languageString.equalsIgnoreCase("русский") || languageString.equalsIgnoreCase("rus") || languageString.equalsIgnoreCase("russia")){
            this.language = super.rus;
        }else {
            throw new ThereIsNoSuchLanguage("There is no such language");
        }
    }

    public void encrypt(String pathInputFile,int key, String pathOutputFile) throws FileNotFoundException{
        try(BufferedReader fir = new BufferedReader(new FileReader(pathInputFile));
            BufferedWriter fow = new BufferedWriter(new FileWriter(pathOutputFile))
        ){
            if(key > language.length){
                key = key % language.length;
            }
            String text = "";
            char symbol;
            boolean addSymbolFlag;
            while (fir.ready()){
                addSymbolFlag = true;
                symbol = (char)fir.read();
                if(symbol == '\n'){
                    text += '\n';
                    continue;
                }
                for(int i = 0; i < language.length; ++i){
                    if(symbol == language[i]){
                        if(i == language.length - 1){
                            symbol = language[key - 1];
                        }else{
                            if(i + key > language.length - 1){
                                symbol = language[i + key - language.length];
                            }else {
                                symbol = language[i + key];
                            }
                        }
                        text += symbol;
                        addSymbolFlag = false;
                        break;
                    }
                }
                if(addSymbolFlag){
                    text += symbol;
                }
            }

            fow.write(text);

        }catch (FileNotFoundException e){
            throw new FileNotFoundException();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}