package calculator;

import java.awt.*;
import javax.swing.*;

/**
 * Interface graphique basique pour la calculatrice.
 * Utilise Swing pour créer une fenêtre, deux champs de saisie,
 * un menu déroulant pour choisir l'opération, un bouton pour calculer
 * et un label pour afficher le résultat.
 */
public class CalculatorUI extends JFrame {
    // Champ de saisie pour le premier nombre (A)
    private JTextField fieldA;
    // Champ de saisie pour le second nombre (B)
    private JTextField fieldB;
    // ComboBox pour sélectionner l'opération à effectuer
    private JComboBox<String> operationBox;
    // Bouton pour déclencher le calcul
    private JButton calculateButton;
    // Label pour afficher le résultat du calcul
    private JLabel resultLabel;

    /**
     * Constructeur : initialise tous les composants et les place dans la fenêtre.
     */
    public CalculatorUI() {
        // Titre de la fenêtre
        setTitle("Calculatrice");
        // Fermer l'application lorsque l'utilisateur ferme la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Utilisation d'un GridBagLayout pour flexibilité des positions
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        // Marges internes autour de chaque composant
        gbc.insets = new Insets(5, 5, 5, 5);
        // Les composants remplissent horizontalement leur cellule
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Champ Nombre A =====
        gbc.gridx = 0;        // colonne 0
        gbc.gridy = 0;        // ligne 0
        add(new JLabel("Nombre A:"), gbc);  // Étiquette "Nombre A"
        gbc.gridx = 1;        // colonne 1
        fieldA = new JTextField(10);        // Champ texte de largeur 10
        add(fieldA, gbc);

        // ===== Champ Nombre B =====
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nombre B:"), gbc);  // Étiquette "Nombre B"
        gbc.gridx = 1;
        fieldB = new JTextField(10);
        add(fieldB, gbc);

        // ===== Sélection de l'opération =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Opération:"), gbc); // Étiquette "Opération"
        gbc.gridx = 1;
        // Liste des opérations disponibles
        String[] operations = {"+", "-", "*", "/", "%", "^", "√", "abs", "!", "log"};
        operationBox = new JComboBox<>(operations);
        add(operationBox, gbc);

        // ===== Bouton Calculer =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;    // le bouton occupe deux colonnes
        calculateButton = new JButton("Calculer");
        add(calculateButton, gbc);

        // ===== Label Résultat =====
        gbc.gridy = 4;
        resultLabel = new JLabel("Résultat: ");
        add(resultLabel, gbc);

        // Ajuste la taille de la fenêtre selon le contenu
        pack();
        // Centre la fenêtre à l'écran
        setLocationRelativeTo(null);
        // Rend la fenêtre visible
        setVisible(true);
    }

    // ===== Getters pour accéder aux composants =====
    /** Retourne le champ de saisie du nombre A */
    public JTextField getFieldA() { return fieldA; }
    /** Retourne le champ de saisie du nombre B */
    public JTextField getFieldB() { return fieldB; }
    /** Retourne le JComboBox des opérations */
    public JComboBox<String> getOperationBox() { return operationBox; }
    /** Retourne le JButton de calcul */
    public JButton getCalculateButton() { return calculateButton; }
    /** Retourne le JLabel de résultat */
    public JLabel getResultLabel() { return resultLabel; }
}

// Dans Main.java, pour lancer l'UI depuis la méthode main :
// SwingUtilities.invokeLater(() -> new CalculatorUI());
