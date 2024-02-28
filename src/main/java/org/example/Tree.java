package org.example;
//
//import java.io.File;
//
//public class Tree {
//
//    /**
//     * TODO: TODO: Доработать метод print, необходимо распечатывать директории и файлы
//     * @param args
//     */
//    public static void main(String[] args) {
//        print(new File("."), "", true);
//    }
//
//    static void print(File file, String indent, boolean isLast){
//        System.out.print(indent);
//        if (isLast){
//            System.out.print("└─");
//            indent += "  ";
//        }
//        else {
//            System.out.print("├─");
//            indent += "│ ";
//        }
//        System.out.println(file.getName());
//
//        File[] files = file.listFiles();
//        if (files == null)
//            return;
//
//        int subDirTotal = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//            {
//                subDirTotal++;
//            }
//        }
//
//        int subDirCounter = 0;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory())
//            {
//                print(files[i], indent, subDirTotal == ++subDirCounter);
//            }
//        }
//
//    }
//
//}

import java.io.File;

public class Tree {

    public static void main(String[] args) {
        File root = new File("C:\\java\\javacore-5");
        print(root, "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, i == files.length - 1);
            } else {
                System.out.print(indent);
                if (i == files.length - 1) {
                    System.out.print("└─");
                } else {
                    System.out.print("├─");
                }
                System.out.println(files[i].getName());
            }
        }
    }
}