import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ChatBot {
    private HashMap<String, String> knowledgeBase;

    public ChatBot(String filename) {
        knowledgeBase = new HashMap<>();
        loadKnowledgeBase(filename);
    }

    private void loadKnowledgeBase(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] pair = line.split("=", 2);
                if (pair.length == 2) {
                    knowledgeBase.put(pair[0].trim().toLowerCase(), pair[1].trim());
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading knowledge base: " + e.getMessage());
        }
    }

    public String getResponse(String input) {
        String processedInput = NLPProcessor.preprocess(input);
        return knowledgeBase.getOrDefault(processedInput, "Sorry, I don't understand that.");
}
}