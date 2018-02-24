import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static Document getPage() throws IOException{
        String url = "http://pogoda.spb.ru";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    //\d{2}\.\d{2}
    final private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Невозможно получить дату из строки!");
    }

    private static int printPartValues(Elements values, int index) {
        int iteratorCount = 4;
        Element valueLn = values.get(3);
        boolean isMorning;
        if (index == 0) {
            isMorning =  valueLn.text().contains("Утро");
            if (isMorning) {
                iteratorCount = 3;
            }
        } else if (index == 0) {
            isMorning =  valueLn.text().contains("День");
            if (isMorning) {
                iteratorCount = 2;
            }
        } else if (index == 0) {
            isMorning =  valueLn.text().contains("Вечер");
            if (isMorning) {
                iteratorCount = 1;
            }
        }
            for (int i = 0; i < iteratorCount; i++) {
                Element valueLine = values.get(index + i);
                for (Element td : valueLine.select("td")) {
                    System.out.printf("%.25s", td.text().trim() + "\t");
                    System.out.print(" | ");
                }
                System.out.println();
            }
            return iteratorCount;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        Element tableWth = page.select("table[class=wt]").first();
        Elements names = tableWth.select("tr[class=wth]");
        Elements values = tableWth.select("tr[valign=top]");
        int index = 0;
        for (Element name : names) {
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            System.out.println("----------------------------------------------------------------------------");
            System.out.printf("%-8s%-30s%-7s%-4s%-10s%-7s%n", date + "\t", "Погодные явления" +"\t", "t C" + "\t", "Давл." + "\t", "Влажн." + "\t", "Ветер");
            System.out.println("----------------------------------------------------------------------------");
            int iteratorCount = printPartValues(values, index);
            index = index + iteratorCount;
        }


    }
}
