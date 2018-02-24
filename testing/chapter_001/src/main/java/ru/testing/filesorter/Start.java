package ru.testing.filesorter;

import java.io.File;
import java.io.IOException;

/**
 * класс Start содержит метод tryCatch.
 * @author Bobrovitskiy_a.
 */
public class Start {
    /**
     * метод tryCatch содержит вызовы методов из класса FileSorter.
     * @param in имя входного файла. in.txt.
     * @param out имя выходного файла. out.txt.
     * @param upDown параметр сортировки: -u по возрастанию, -d по убыванию.
     */
    public void tryCatch(String in, String out, String type, String upDown) {
        FileSorter file = new FileSorter();
        String pathToFile = new File("").getAbsolutePath() + File.separator;
        if (type.equals("-s")) {
            if (upDown.equals("-u")) {
                try {
                    file.arrayToFile(pathToFile + out, file.insertSortStrUp(file.fileToArray(pathToFile + in)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (upDown.equals("-d")) {
                try {
                    file.arrayToFile(pathToFile + out, file.insertSortStrDown(file.fileToArray(pathToFile + in)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        if (type.equals("-i")) {
            if (upDown.equals("-u")) {
                try {
                    file.arrayToFile(pathToFile + out, file.insertSortIntUp(file.fileToArray(pathToFile + in)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (upDown.equals("-d")) {
                try {
                    file.arrayToFile(pathToFile + out, file.insertSortIntDown(file.fileToArray(pathToFile + in)));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        String path = new File("").getAbsolutePath() + File.separator;
        System.out.println(path);
        Start start = new Start();
        start.tryCatch(args[0], args[1], args[2], args[3]);
        System.out.println("######################");
        System.out.println("Файл: " + args[1] + " создан в папке: " + path);
        System.out.println("######################");
    }
}
