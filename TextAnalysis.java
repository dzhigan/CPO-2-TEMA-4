import java.util.*;

public class TextAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String text = scanner.nextLine();

        analyzeText(text);
    }

    public static void analyzeText(String text) {
      
        text = text.toLowerCase();

     
        text = text.replaceAll("[.,!?;:\"()\\[\\]]", "");

       
        String[] words = text.split("\\s+");

      
        int wordCount = words.length;

    
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) continue;

            if (wordFreq.containsKey(word)) {
                wordFreq.put(word, wordFreq.get(word) + 1);
            } else {
                wordFreq.put(word, 1);
            }
        }

    
        Map<String, Integer> repeatedWords = new HashMap<>();

        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() > 1) {
                repeatedWords.put(entry.getKey(), entry.getValue());
            }
        }

     
        System.out.println("\n📊 Результаты анализа:");
        System.out.println("Количество слов: " + wordCount);

        System.out.println("\nЧастота слов:");
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nПовторяющиеся слова:");
        if (repeatedWords.isEmpty()) {
            System.out.println("Нет повторяющихся слов.");
        } else {
            for (Map.Entry<String, Integer> entry : repeatedWords.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}