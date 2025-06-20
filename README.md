# Projet : Calculatrice Java

Ce projet implémente une calculatrice de bureau en Java, utilisant Swing pour l'interface graphique et une classe modèle pour les opérations mathématiques.

## 🚀 Fonctionnalités

* **Opérations de base** : addition, soustraction, multiplication, division, modulo
* **Opérations avancées** : puissance, racine carrée, valeur absolue, logarithme base 10, factorielle
* **Interface graphique** :

  * Champs de saisie pour deux nombres
  * Menu déroulant pour sélectionner l’opération
  * Bouton « Calculer » et affichage du résultat
* **Gestion des erreurs** : validation des entrées, division par zéro, log de nombre négatif, factorielle d’entier négatif

## 📂 Structure du projet

```
src/
└── calculator/
    ├── CalculatorModel.java   // Modèle de calcul (toutes les méthodes)
    ├── CalculatorUI.java      // Interface graphique Swing
    └── Main.java              // Point d’entrée et liaison UI ↔ Modèle
```

## ⚙️ Prérequis

* Java Development Kit (JDK) 8 ou supérieur
* Un IDE (IntelliJ IDEA, Eclipse, VS Code...) ou la ligne de commande

## 🛠 Compilation et exécution

1. **Compiler**

   En ligne de commande depuis la racine du projet :

   ```bash
   javac -d bin src/calculator/*.java
   ```

2. **Exécuter**

   Toujours depuis la racine du projet :

   ```bash
   java -cp bin calculator.Main
   ```

3. **Ou** ouvrir le projet dans votre IDE et lancer la méthode `main` de `calculator.Main`.

## 📝 Utilisation

1. Saisir un ou deux nombres (selon l’opération) dans les champs « Nombre A » et « Nombre B ».
2. Choisir l’opération dans la liste déroulante.
3. Cliquer sur **Calculer**.
4. Le résultat s’affiche sous le bouton.

## 🔧 Personnalisation et extensions possibles

* Ajouter un historique des calculs (liste déroulante ou table).
* Thèmes clair/sombre via `UIManager`.
* Choix de la police et de la taille.
* Refactorisation en pattern MVC plus strict.
* Ajout d’opérations (sin, cos, tan, etc.)
---

*Ce README évoluera au fur et à mesure de l’avancement du projet.*
