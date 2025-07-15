package skillbuilder.java8.set4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TotalDistinctWordsInSentences {
    /**
     *  count the total number of distinct words (case-insensitive) in all the sentences.
     *
     */
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList(
                "Java Stream API provides a fluent interface for processing sequences of elements.",
                "It supports functional-style operations on streams of elements, such as map-reduce transformations.",
                "In this exercise, you need to count the total number of words in all sentences."
        );
        countDistinctWords(sentences); //37
        countDistinctWords2(sentences);//37
        countDistinctWordsByCoreJava(sentences); //Distinct word count: 37
    }

    private static void countDistinctWords(List<String> sentences) {
        long count = sentences.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct().count();
        System.out.println(count);
    }
    private static void countDistinctWords2(List<String> sentences) {
        long count = sentences.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .filter(s->!s.isEmpty())
                        .collect(Collectors.toSet()).size();
        System.out.println(count);
    }
    private static void countDistinctWordsByCoreJava(List<String> sentences){
        Set<String> uniqueWords = new HashSet<>();

        for (String sentence : sentences) {
            String[] words = sentence.split("\\W+"); // split by non word
            for (String word : words) {
                if (!word.isEmpty()) {
                    uniqueWords.add(word.toLowerCase());
                }
            }
        }

        System.out.println("Distinct word count: " + uniqueWords.size());

    }
}
