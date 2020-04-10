package com.hugh.java.fun.book;



/**
 * @Author Fly.Hugh
 * @Date 2020/3/27 10:40
 * @Version 1.0
 * @Describe read story book when u r working.
 *           every starting programming check will turn the book forward 10000 lines
 **/

import com.hugh.java.fun.util.PathUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadBook {
    public static final int LINELENGTH=100;//自定义行的长度

    public static void main(String[] args) throws Exception{


        
        File file=new File(PathUtil.pathGet("ARecordofaMortal'sJourneytoImmortality.txt"));

        int pageNum = ReadPage.getPage();

        try {
            BufferedReader in=new BufferedReader(new FileReader(file));
            String str;
            int i=1;
            while((str=in.readLine())!=null){
                if(str.isEmpty()) continue;
                if(i>pageNum&&i<=pageNum+10000){
                    //控制台一次打印不了全部内容，后面的会把前面的覆盖
                    while(str.length()>LINELENGTH){
                        //将长的行自动换行
                        System.out.println(i+"\t"+str.substring(0, LINELENGTH));
                        str=str.substring(LINELENGTH);
                    }
                    System.out.println(i+"\t"+str);//记录当前第几行，便于下次阅读
                }
                i++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // write
        File writer =new File(PathUtil.pathGet("PageNumRecord"));
        if(!writer.exists()){
            writer.createNewFile();
        }

        FileWriter fileWritter = new FileWriter(writer);
        String wr = (pageNum + 10000) + "";

        fileWritter.write(wr);
        fileWritter.flush();
        fileWritter.close();
        System.out.println("finish");
    }
}