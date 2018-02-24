package ru.testing.filesorter;

import java.io.*;

/**
 * класс FileSorter содержит методы для соритровки массивов.
 * @author Bobrovitskiy_a.
 */
public class FileSorter {
    /**
     * метод insertSortStrUp сортирует массив строк по возрастанию.
     * @param array входной массив
     * @return array отсортированный массив.
     */
    public String[] insertSortStrUp(String[] array) {
        String temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1].compareTo(array[j]) > 0; j--) {
                temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }

    /**
     * метод insertSortStrDown сортирует массив строк по убыванию.
     * @param array входной массив
     * @return array отсортированный массив.
     */
    public String[] insertSortStrDown(String[] array) {
        String temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1].compareTo(array[j]) < 0; j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }

    /**
     * метод insertSortIntUp сортирует массив чисел по возрастанию.
     * @param array входной массив
     * @return array отсортированный массив.
     */
    public String[] insertSortIntUp(String[] array) {
        String temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && Integer.parseInt(array[j - 1]) > Integer.parseInt(array[j]); j--) {
                temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
        return array;
    }
    /**
     * метод insertSortIntDown сортирует массив чисел по убыванию.
     * @param array входной массив
     * @return array отсортированный массив.
     */
    public String[] insertSortIntDown(String[] array) {
        String temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && Integer.parseInt(array[j - 1]) < Integer.parseInt(array[j]); j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        return array;
    }

    /**
     * метод fileToArray преобразует входящий файл в массив.
     * @param path путь к файлу.
     * @return возвращает массив.
     * @throws IOException
     */
    public String[] fileToArray(String path) throws IOException {
        String[] array = new String[100];
        int position = 0;
        try {
            FileInputStream fileStream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                array[position++] = strLine;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл для сортировки не найден!");
        }
        String[] resultArray = new String[position];
        System.arraycopy(array, 0, resultArray, 0, position);
        return resultArray;
    }

    /**
     * метод arrayToFile сохраняет массив в файл.
     * @param path путь к файлу.
     * @param inputArray входной массив.
     * @return возвращает true если ошибок нет.
     * @throws IOException
     */
    public boolean arrayToFile(String path, String[] inputArray) throws IOException {
        boolean done = false;
        File file;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWr = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fileWr);

            for (int i = 0; i < inputArray.length; i++) {
                bw.write(inputArray[i]);
                bw.write(System.lineSeparator());
            }
            done = true;
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return done;
    }
}
