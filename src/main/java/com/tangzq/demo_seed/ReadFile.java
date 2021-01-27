package com.tangzq.demo_seed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public  List<String> getTxt(){
    String tPath = "E:\\___toSync-2020_v2\\_PL_java_lab_sp-h_heroku-blog\\Red_Mansions_Anasoft_A_CHT_Big5_txt.txt";
        File txtFile=new File(tPath);
        List<String> contents= new ArrayList<String>();
        String lineText;
        try{
        //FileReader reader= new FileReader(tPath);
        FileInputStream fip =new FileInputStream(tPath);
        InputStreamReader isr = new InputStreamReader(fip,"big5");
        BufferedReader bufferedReader = new BufferedReader(isr);
        while ( (lineText=bufferedReader.readLine()) !=null) {
            contents.add(lineText);

        }
            fip.close();
            isr.close();
        bufferedReader.close();
        }catch (Exception e){}
        return  contents;
    }
}
