package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        String filename = "input.txt";
        int adjectiveCount = 0;
        int adverbCount = 0;
        int verbCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            System.out.println(line + '\n' + "-".repeat(20));

            while (line != null) {
                Pattern adjectivePattern = Pattern.compile("\\b[a-яА-Я]+(ый|ий|ая|ая|ое|ые|ие)\\b", Pattern.UNICODE_CHARACTER_CLASS);
                Pattern adverbPattern = Pattern.compile("\\b[a-яА-Я]+(о|го|му|м|ым|ая|ою)\\b", Pattern.UNICODE_CHARACTER_CLASS);
                Pattern verbPattern = Pattern.compile("\\b[a-яА-Я]+(ть|ться|л|лась|лся|ться)\\b", Pattern.UNICODE_CHARACTER_CLASS);

                Matcher adjectiveMatcher = adjectivePattern.matcher(line);
                while (adjectiveMatcher.find()) {
                    adjectiveCount++;
                }

                Matcher adverbMatcher = adverbPattern.matcher(line);
                while (adverbMatcher.find()) {
                    adverbCount++;
                }

                Matcher verbMatcher = verbPattern.matcher(line);
                while (verbMatcher.find()) {
                    verbCount++;
                }

                line = reader.readLine();
            }

            reader.close();

            System.out.println("Количество прилагательных: " + adjectiveCount);
            System.out.println("Количество наречий: " + adverbCount);
            System.out.println("Количество глаголов: " + verbCount);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
