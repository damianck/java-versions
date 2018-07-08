package com.damianck.pl.lambda.example_1;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

    public static void main(String[] args) {

        FileFilter filterLambda = (File pathname) ->
                pathname.getName().endsWith(".java");

        File dir = new File("c:/tmp");
        
        File[] files = dir.listFiles(filterLambda);

        for (File f : files) {
            System.out.println(f);
        }
    }
}
