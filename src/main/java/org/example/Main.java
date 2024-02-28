package org.example;




/**1. Написать функцию, создающую резервную копию всех файлов в директории во вновь созданную папку ./backup
        2. Доработайте класс Tree и метод print который мы разработали на семинаре. Ваш метод должен распечатать полноценное дерево директорий и файлов относительно корневой директории.

        Данная промежуточная аттестация оценивается по системе "зачет" / "не зачет".
*/
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String[] args) {
        String sourceDirectory = "C:\\java\\javacore-5";
        String backupDirectory = "./backup"; // создаем резервную копию в папке ./backup

        try {
            File sourceDir = new File(sourceDirectory);
            File backupDir = new File(backupDirectory);
            backupDir.mkdir(); // создаем новую папку для резервных копий

            if (sourceDir.isDirectory()) {
                File[] files = sourceDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            Path originalPath = file.toPath();
                            Path newPath = Paths.get(backupDirectory, file.getName() + "_backup");

                            Files.copy(originalPath, newPath, StandardCopyOption.REPLACE_EXISTING);
                        }
                    }
                }
            }
            System.out.println("Резервные копии файлов созданы успешно.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
