package calculator;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Point d'entrée de l'application :
 * - Instancie le modèle (CalculatorModel)
 * - Instancie l'interface graphique (CalculatorUI)
 * - Lie le bouton "Calculer" à la logique du modèle
 */
public class Main {
    public static void main(String[] args) {
        // S'assure que la création de l'UI se fait sur le thread Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Création du modèle de calcul
            CalculatorModel model = new CalculatorModel();
            // Création de l'interface utilisateur
            CalculatorUI ui = new CalculatorUI();

            // Ajout de l'écouteur sur le bouton "Calculer"
            ui.getCalculateButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        // Lecture de l'opération choisie
                        String op = (String) ui.getOperationBox().getSelectedItem();
                        // Lecture et conversion des valeurs saisies
                        double a = Double.parseDouble(ui.getFieldA().getText());
                        double b = 0;
                        // Certaines opérations n'ont besoin que d'un seul opérande
                        if (!op.equals("√") && !op.equals("!")) {
                            b = Double.parseDouble(ui.getFieldB().getText());
                        }

                        // Sélection de l'opération et appel au modèle
                        switch (op) {
                            case "+":
                                ui.getResultLabel().setText("Résultat: " + model.add(a, b));
                                break;
                            case "-":
                                ui.getResultLabel().setText("Résultat: " + model.subtract(a, b));
                                break;
                            case "*":
                                ui.getResultLabel().setText("Résultat: " + model.multiply(a, b));
                                break;
                            case "/":
                                ui.getResultLabel().setText("Résultat: " + model.divide(a, b));
                                break;
                            case "%":
                                ui.getResultLabel().setText("Résultat: " + model.modulo(a, b));
                                break;
                            case "^":
                                ui.getResultLabel().setText("Résultat: " + model.power(a, b));
                                break;
                            case "√":
                                ui.getResultLabel().setText("Résultat: " + model.sqrt(a));
                                break;
                            case "abs":
                                ui.getResultLabel().setText("Résultat: " + model.abs(a));
                                break;
                            case "log":
                                ui.getResultLabel().setText("Résultat: " + model.log(a));
                                break;
                            case "!":
                                // Convertit en int pour factorial
                                ui.getResultLabel().setText("Résultat: " + model.factorial((int) a));
                                break;
                            default:
                                ui.getResultLabel().setText("Opération inconnue");
                        }
                    } catch (NumberFormatException ex) {
                        ui.getResultLabel().setText("Entrée invalide : veuillez saisir un nombre.");
                    } catch (Exception ex) {
                        ui.getResultLabel().setText("Erreur : " + ex.getMessage());
                    }
                }
            });
        });
    }
}
