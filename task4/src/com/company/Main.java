package com.company;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    private static void writeDirectoryContentToFile(String targetFolder, String fileToWriteTo) {
        File directory = new File(targetFolder);

        if (directory == null) {
            throw new NullPointerException("There is no such directory.");
        }

        try {
            PrintWriter writer = new PrintWriter(fileToWriteTo, "UTF-8");

            writer.println("Directories:");
            writer.println();

            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    writer.println(file.getName());
                }
            }

            writer.println();
            writer.println("Files:");
            writer.println();


            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    writer.println(file.getName());
                }
            }
            writer.close();
        } catch (Exception ex) {
            System.out.println("Wrong or bad path to file. " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        File directory;
        File file;
        try{
            directory = new File(args[0]);
        }catch(Exception ex){
            System.out.println("Wrong path format or path does not direct to directory or missing argument.\n" + ex.getMessage());
            return;
        }
        try{
            file = new File(args[1]);
        }catch(Exception ex){
            System.out.println("Wrong path format or path does not direct to file or missing argument.\n" + ex.getMessage());
            return;
        }
        if (!file.isFile()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                System.out.println("Wrong path format or path does not direct to file.");
            }
        }

        if (directory.isDirectory()) {
            writeDirectoryContentToFile(directory.getAbsolutePath(), file.getAbsolutePath());
        } else {
            System.out.println("There is no such directory or wrong path.");
        }
    }
}
