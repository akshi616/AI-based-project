import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatBotGUI extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;
    private ChatBot bot;

    public ChatBotGUI() {
        bot = new ChatBot("knowledgebase.txt");

        setTitle("Smart Java Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        inputField = new JTextField();
        sendButton = new JButton("Send");

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(sendButton, BorderLayout.EAST);

        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        sendButton.addActionListener(new SendListener());
        inputField.addActionListener(new SendListener());
    }

    private class SendListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput = inputField.getText();
            if (!userInput.isEmpty()) {
                chatArea.append("You: " + userInput + "\n");
                String response = bot.getResponse(userInput);
                chatArea.append("Bot: " + response + "\n");
                inputField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChatBotGUI gui = new ChatBotGUI();
            gui.setVisible(true);
   });
}
}