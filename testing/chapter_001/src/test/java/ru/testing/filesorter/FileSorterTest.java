package ru.testing.filesorter;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * класс FileSorterTest содержит тесты для методов класса FileSorter
 */
public class FileSorterTest {
    /**
     * метод whenInUnsortedArrayStringThenOutSortedUp тестирует метод insertSortStrUp, сортировку по возрастанию.
     */
    @Test
    public void whenInUnsortedArrayStringThenOutSortedUp() {
        FileSorter file = new FileSorter();
        String[] array = {"ab", "ac", "bc"};
        String[] expected = {"ab", "ac", "bc"};
        String[] result = file.insertSortStrUp(array);
        assertThat(result, is(expected));
    }

    /**
     * метод whenInUnsortedArrayStringThenOutSortedDown тестирует метод insertSortStrDown, сортировку по убыванию.
     */
    @Test
    public void whenInUnsortedArrayStringThenOutSortedDown() {
        FileSorter file = new FileSorter();
        String[] array = {"ab", "ac", "bc"};
        String[] expected = {"bc", "ac", "ab"};
        String[] result = file.insertSortStrDown(array);
        assertThat(result, is(expected));
    }

    /**
     * метод whenInUnsortedArrayIntThenOutSortedDown тестирует метод insertSortIntDown, сортировку по убыванию.
     */
    @Test
    public void whenInUnsortedArrayIntThenOutSortedDown() {
        FileSorter file = new FileSorter();
        String[] array = {"2", "3", "1"};
        String[] expected = {"3", "2", "1"};
        String[] result = file.insertSortIntDown(array);
        assertThat(result, is(expected));
    }

    /**
     * метод whenInUnsortedArrayIntThenOutSortedUp тестирует метод insertSortIntUp, сортировку по возрастанию.
     */
    @Test
    public void whenInUnsortedArrayIntThenOutSortedUp() {
        FileSorter file = new FileSorter();
        String[] array = {"2", "3", "1"};
        String[] expected = {"1", "2", "3"};
        String[] result = file.insertSortIntUp(array);
        assertThat(result, is(expected));
    }

    /**
     * метод whenHasFileThenGetArray проверяет преобразование файла в массив. Файл test_file_in.txt в корне проекта.
     */
    @Test
    public void whenHasFileThenGetArray() {
        FileSorter file = new FileSorter();
        String[] result = new String[3];
        String path = new File("").getAbsolutePath() + File.separator + "test_file_in.txt";
        try {
            result = file.fileToArray(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] expected = {"2", "3", "1"};
        assertThat(result, is(expected));
    }

    /**
     * метод whenHasArrayThenGetFile проверяет преобразование массива в файл. Файл test_file_out.txt в корне проекта.
     */
    @Test
    public void whenHasArrayThenGetFile() {
        FileSorter file = new FileSorter();
        String[] array = {"2", "3", "1"};
        boolean result = false;
        String path = new File("").getAbsolutePath() + File.separator + "test_file_out.txt";
        try {
            result = file.arrayToFile(path, array);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        assertThat(result, is(true));
    }
}
