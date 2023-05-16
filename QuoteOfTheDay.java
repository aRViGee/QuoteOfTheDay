import java.time.*;

public class QuoteOfTheDay {

    public static void main(String[] args) {
        String[][] quotes = {
                { "galileo", "eppur si muove" },
                { "archimedes", "eureka!" },
                { "erasmus", "in regione caecorum rex est luscus" },
                { "socrates", "I know nothing except the fact of my ignorance" },
                { "rené descartes", "cogito, ergo sum" },
                { "sir isaac newton", "if I have seen further it is by standing on the shoulders of giants" }

        };

        String inputDate = "2023-01-13";
        int dayOfYear = getDayOfYear(inputDate);

        System.out.println("Day of the year is: " + getDayOfYear(inputDate));
        String getQuote = getQuote(quotes, dayOfYear);
        String getPerson = getPerson(quotes, dayOfYear);
        String getFullStop = getFullStop(getQuote);
        String capitalizeNames = capitalizeNames(getPerson);
        String completeQuote = completeQuote(getFullStop, capitalizeNames);
        System.out.println(completeQuote);

    }

    private static String capitalizeNames(String getPerson) {
        String[] splitNames = getPerson.split(" ");
        String capitalizedPerson = "";
        for (int i = 0; i < splitNames.length; i++) {
            splitNames[i] = splitNames[i].substring(0, 1).toUpperCase() + splitNames[i].substring(1);
            capitalizedPerson += splitNames[i] + " ";
        }

        return capitalizedPerson;
    }

    private static String completeQuote(String getQuote, String getPerson) {
        getFullStop(getQuote);
        String completeQuote = "\"" + (getQuote.substring(0, 1).toUpperCase() + getQuote.substring(1)) + "\"" + " -- "
                + getPerson;

        return completeQuote;
    }

    private static String getFullStop(String getQuote) {
        String addFullStop = ".";
        char getLastChar = getQuote.charAt(getQuote.length() - 1);
        if ((getLastChar != '.') && (getLastChar != '!')) {
            getQuote = getQuote + addFullStop;
        }
        return getQuote;
    }

    private static String getPerson(String[][] quotes, int dayOfYear) {
        if (dayOfYear % quotes.length > 0) {
            return (quotes[(dayOfYear % quotes.length) - 1][0]);
        } else {
            return quotes[5][0];
        }
    }

    private static String getQuote(String[][] quotes, int dayOfYear) {
        if (dayOfYear % quotes.length > 0) {
            return (quotes[(dayOfYear % quotes.length) - 1][1]);
        } else {
            return quotes[5][1];
        }

    }

    private static int getDayOfYear(String inputDate) {
        LocalDate dayOfYear = LocalDate.parse(inputDate);
        return dayOfYear.getDayOfYear();
    }

}
