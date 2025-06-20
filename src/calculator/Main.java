package calculator;

import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Point d'entrée de l'application :
 * - Instancie le modèle (CalculatorModel)
 * - Instancie l'interface graphique (CalculatorUI)
 * - Lie le bouton "Calculer" à la logique du modèle
 * - Ajoute chaque calcul à l'historique
 */
public class Main {
    public static void main(String[] args) {
        // Crée l'UI sur le Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            CalculatorModel model = new CalculatorModel();  // Modèle de calcul
            CalculatorUI ui = new CalculatorUI();          // Interface graphique

            // Ajout de l'écouteur sur le bouton "Calculer"
            ui.getCalculateButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String op = (String) ui.getOperationBox().getSelectedItem();
                        double a = Double.parseDouble(ui.getFieldA().getText());
                        double b = 0;
                        boolean isBinary = !op.equals("√") && !op.equals("!");
                        if (isBinary) {
                            b = Double.parseDouble(ui.getFieldB().getText());
                        }

                        // Calcul du résultat
                        double result = 0;
                        long longResult = 0;
                        boolean isLongResult = false;
                        switch (op) {
                            case "+": result = model.add(a, b); break;
                            case "-": result = model.subtract(a, b); break;
                            case "*": result = model.multiply(a, b); break;
                            case "/": result = model.divide(a, b); break;
                            case "%": result = model.modulo(a, b); break;
                            case "^": result = model.power(a, b); break;
                            case "√": result = model.sqrt(a); break;
                            case "abs": result = model.abs(a); break;
                            case "log": result = model.log(a); break;
                            case "!": 
                                longResult = model.factorial((int) a);
                                isLongResult = true;
                                break;
                            default:
                                throw new UnsupportedOperationException("Opération inconnue : " + op);
                        }

                        // Formatage du résultat : supprime ".0" si le nombre est entier
                        String resultStr;
                        if (isLongResult) {
                            resultStr = String.valueOf(longResult);
                        } else {
                            if (result == Math.floor(result)) {
                                resultStr = String.valueOf((long) result);
                            } else {
                                resultStr = String.valueOf(result);
                            }
                        }
                        ui.getResultLabel().setText("Résultat: " + resultStr);

                        // Formatage des opérandes pour l'historique
                        String aStr = (a == Math.floor(a)) ? String.valueOf((long) a) : String.valueOf(a);
                        String bStr = (b == Math.floor(b)) ? String.valueOf((long) b) : String.valueOf(b);

                        // Création de l'entrée d'historique
                        String entry;
                        if (isLongResult) {
                            entry = op + "(" + aStr + ") = " + resultStr;
                        } else if (!isBinary) {
                            entry = op + "(" + aStr + ") = " + resultStr;
                        } else {
                            entry = aStr + " " + op + " " + bStr + " = " + resultStr;
                        }
                        // Ajout en tête de l'historique
                        ui.addHistoryEntry(entry);

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
