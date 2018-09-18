import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class WebScraper {

        /**
         * Retrieve contents from a URL and return them as a string.
         *
         * @param url url to retrieve contents from
         * @return the contents from the url as a string, or an empty string on error
         */
        public static String urlToString(final String url) {
                Scanner urlScanner;
                try {
                        urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
                } catch (IOException e) {
                        return "";
                }
                String contents = urlScanner.useDelimiter("\\A").next();
                urlScanner.close();
                return contents;
        }


        public static int wordCount(final String contents) {

                String[] words= contents.split("\\s+");
                ArrayList<String> val = new ArrayList<String>();

                for (int i = 0; i < words.length; i++) {

                        if (!words[i].equals("")) {

                            val.add(words[i]);
                        }
                }
                return val.size();
        }

        public static int specificWordCount(final String contents, final String word) {


                String[] words= contents.split("\\s+");
                int counter = 0;

                for(int i = 0; i < words.length; i++) {


                        if (words[i].equalsIgnoreCase(word)) {

                                counter = counter + 1;

                        }
                }

                return counter;

        }

        public static void newWordCount(String contents, String word) {

                Pattern pattern = Pattern.compile(word);
                Matcher matcher = pattern.matcher(contents);
                int count = 0;

                while(matcher.find()) {

                        count++;
                        System.out.println("found: " + count + " : "
                                + matcher.start() + " - " + matcher.end());
                }


        }

        public static void main(String[] args) {

                String s = "Prince prince Prince Prince";
               // System.out.println("Word count :" + wordCount((urlToString("http://erdani.com/tdpl/hamlet.txt"))));
              // System.out.println(specificWordCount((urlToString("http://erdani.com/tdpl/hamlet.txt")), "prince"));
             //   System.out.println(specificWordCount(s, "prince"));
                newWordCount(urlToString("http://erdani.com/tdpl/hamlet.txt"), "prince");
        }
}
