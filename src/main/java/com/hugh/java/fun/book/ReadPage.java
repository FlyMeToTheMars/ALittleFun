package com.hugh.java.fun.book;

import com.hugh.java.fun.util.PathUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadPage {
    public static int getPage() throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new FileReader(PathUtil.pathGet("PageNumRecord")));
        String s = br.readLine();
        while(s != null){
            sb.append(s);
            s = br.readLine();
        }
        s = sb.toString();
        return Integer.parseInt(s);
    }

}
