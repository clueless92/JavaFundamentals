import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pr16ExtractHyperlinks {
            public static void main(String[] args) throws IOException {
                String regex = "<a[^>]+href\\s*=\\s*(?:\"([^\"]*)\"|'([^']*)'|([^\\s>]*))[^>]*>";
                StringBuilder builder = new StringBuilder();

                BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
                String line = scanner.readLine();

                while (! line.equals("END")) {
                    builder.append(line);
                    line = scanner.readLine();
                }

                String text = builder.toString();

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(text);

                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        System.out.println(matcher.group(1));
                    } else if (matcher.group(2) != null) {
                        System.out.println(matcher.group(2));
                    } else if (matcher.group(3) != null) {
                        System.out.println(matcher.group(3));
                    }
                }
            }
        }