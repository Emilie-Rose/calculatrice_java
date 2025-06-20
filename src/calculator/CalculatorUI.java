package calculator;

import java.awt.*;
import javax.swing.*;

/**
 * Interface graphique basique pour la calculatrice, avec historique des calculs.
 */
public class CalculatorUI extends JFrame {
    // Champs de saisie pour les opérandes
    private JTextField fieldA;
    private JTextField fieldB;
    // Sélection de l'opération
    private JComboBox<String> operationBox;
    // Bouton pour déclencher le calcul
    private JButton calculateButton;
    // Label pour afficher le résultat
    private JLabel resultLabel;
    // Modèle et liste pour l'historique
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;

    /**
     * Constructeur : initialise tous les composants et les place dans la fenêtre.
     */
    public CalculatorUI() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Champ Nombre A =====
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nombre A:"), gbc);
        gbc.gridx = 1;
        fieldA = new JTextField(10);
        add(fieldA, gbc);

        // ===== Champ Nombre B =====
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombre B:"), gbc);
        gbc.gridx = 1;
        fieldB = new JTextField(10);
        add(fieldB, gbc);

        // ===== Sélection de l'opération =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Opération:"), gbc);
        gbc.gridx = 1;
        String[] operations = {"+", "-", "*", "/", "%", "^", "√", "abs", "!", "log"};
        operationBox = new JComboBox<>(operations);
        add(operationBox, gbc);

        // ===== Bouton Calculer =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        calculateButton = new JButton("Calculer");
        add(calculateButton, gbc);

        // ===== Label Résultat =====
        gbc.gridy = 4;
        resultLabel = new JLabel("Résultat: ");
        add(resultLabel, gbc);

        // ===== Historique des calculs =====
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setPreferredSize(new Dimension(200, 150));
        add(scrollPane, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // ===== Méthode utilitaire pour ajouter une entrée à l'historique =====
    /**
     * Ajoute une ligne à l'historique des calculs.
     * @param entry chaîne décrivant le calcul et son résultat
     */
    public void addHistoryEntry(String entry) {
        historyModel.add(0, entry);
    }

    // ===== Getters pour accès aux composants =====
    public JTextField getFieldA() { return fieldA; }
    public JTextField getFieldB() { return fieldB; }
    public JComboBox<String> getOperationBox() { return operationBox; }
    public JButton getCalculateButton() { return calculateButton; }
    public JLabel getResultLabel() { return resultLabel; }
}
