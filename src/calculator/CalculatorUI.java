package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

/**
 * Interface graphique pour la calculatrice,
 * avec choix de thème (clair/sombre), de police,
 * historique des opérations et possibilité de le réinitialiser.
 */
public class CalculatorUI extends JFrame {
    // Champs de saisie
    private JTextField fieldA;
    private JTextField fieldB;
    // Choix de l'opération
    private JComboBox<String> operationBox;
    private JButton calculateButton;
    private JLabel resultLabel;
    // Historique
    private DefaultListModel<String> historyModel;
    private JList<String> historyList;
    private JButton resetHistoryButton;
    // Contrôles de thème et de police
    private JComboBox<String> themeBox;
    private JComboBox<String> fontBox;

    public CalculatorUI() {
        setTitle("Calculatrice");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== Sélection du thème =====
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Thème:"), gbc);
        gbc.gridx = 1;
        themeBox = new JComboBox<>(new String[]{"Clair", "Sombre"});
        themeBox.addItemListener(new ThemeListener());
        add(themeBox, gbc);

        // ===== Sélection de la police =====
        gbc.gridx = 2;
        add(new JLabel("Police:"), gbc);
        gbc.gridx = 3;
        fontBox = new JComboBox<>(new String[]{"SansSerif", "Serif", "Monospaced"});
        fontBox.addItemListener(new FontListener());
        add(fontBox, gbc);

        // ===== Champ Nombre A =====
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        add(new JLabel("Nombre A:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        fieldA = new JTextField(10);
        add(fieldA, gbc);

        // ===== Champ Nombre B =====
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        add(new JLabel("Nombre B:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 3;
        fieldB = new JTextField(10);
        add(fieldB, gbc);

        // ===== Choix Opération =====
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        add(new JLabel("Opération:"), gbc);
        gbc.gridx = 1;
        operationBox = new JComboBox<>(new String[]{"+", "-", "*", "/", "%", "^", "√", "abs", "!", "log"});
        add(operationBox, gbc);

        // ===== Bouton Calculer =====
        gbc.gridx = 2; gbc.gridwidth = 2;
        calculateButton = new JButton("Calculer");
        add(calculateButton, gbc);

        // ===== Résultat =====
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 4;
        resultLabel = new JLabel("Résultat: ", SwingConstants.CENTER);
        add(resultLabel, gbc);

        // ===== Historique =====
        gbc.gridy = 5; gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; gbc.weighty = 1.0;
        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setPreferredSize(new Dimension(300, 150));
        add(scrollPane, gbc);

        // ===== Bouton Réinitialiser l'historique =====
        gbc.gridy = 6; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        resetHistoryButton = new JButton("Réinitialiser l'historique");
        // Vide l'historique au clic
        resetHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historyModel.clear();
            }
        });
        add(resetHistoryButton, gbc);

        pack();
        setLocationRelativeTo(null);
        applyLightTheme();  // thème par défaut
        applyFont("SansSerif"); // police par défaut
        setVisible(true);
    }

    /** Applique le thème clair aux composants. */
    private void applyLightTheme() {
        Color bg = Color.WHITE;
        Color fg = Color.BLACK;
        getContentPane().setBackground(bg);
        for (Component c : getContentPane().getComponents()) {
            c.setBackground(bg);
            c.setForeground(fg);
            if (c instanceof JScrollPane) {
                ((JScrollPane)c).getViewport().setBackground(bg);
            }
        }
        historyList.setBackground(Color.LIGHT_GRAY);
    }

    /** Applique le thème sombre aux composants. */
    private void applyDarkTheme() {
        Color bg = Color.DARK_GRAY;
        Color fg = Color.WHITE;
        getContentPane().setBackground(bg);
        for (Component c : getContentPane().getComponents()) {
            c.setBackground(bg);
            c.setForeground(fg);
            if (c instanceof JScrollPane) {
                ((JScrollPane)c).getViewport().setBackground(bg);
            }
        }
        historyList.setBackground(Color.GRAY);
    }

    /** Modifie la police de tous les composants. */
    private void applyFont(String fontName) {
        Font font = new Font(fontName, Font.PLAIN, 12);
        for (Component c : getContentPane().getComponents()) {
            c.setFont(font);
        }
        historyList.setFont(font);
    }

    /** Listener pour changer le thème selon la sélection. */
    private class ThemeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String theme = (String) themeBox.getSelectedItem();
                if ("Sombre".equals(theme)) applyDarkTheme(); else applyLightTheme();
                repaint();
            }
        }
    }

    /** Listener pour changer la police selon la sélection. */
    private class FontListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                applyFont((String) fontBox.getSelectedItem());
                repaint();
            }
        }
    }

    // Getters pour la logique de calcul
    public JTextField getFieldA() { return fieldA; }
    public JTextField getFieldB() { return fieldB; }
    public JComboBox<String> getOperationBox() { return operationBox; }
    public JButton getCalculateButton() { return calculateButton; }
    public JLabel getResultLabel() { return resultLabel; }

    /** Ajoute une ligne à l'historique. */
    public void addHistoryEntry(String entry) {
        historyModel.add(0, entry);
    }
}
