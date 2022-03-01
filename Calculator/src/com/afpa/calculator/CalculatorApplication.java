package com.afpa.calculator;

import com.afpa.travailCalculator.controller.CalculatorController;
import com.afpa.travailCalculator.view.CalculatorView;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        boolean continueOrNot;
        String typeOperation;
        double nb1;
        double nb2;
        String reponse;

        Scanner sc = new Scanner(System.in);

        CalculatorView calculatorView = new CalculatorView();

        do {
            // Interrogation de  l'utilisateur sur ce qu'il veut faire
            typeOperation = calculatorView.askOperationtype();

            nb1 = calculatorView.askNumber();
            nb2 = calculatorView.askNumber();

            // réalisation de l'opération
            CalculatorController calculatorController = new CalculatorController(typeOperation, nb1, nb2);

            if (calculatorController.getErrorMessage().isBlank()) {
                calculatorView.affichResult(calculatorController.getResult());

            } else {
                System.out.println(calculatorController.getErrorMessage());
            }

            // Continue ou pas ?
            System.out.println("Voulez vous réaliser une autre opération ? (O/N)");
            reponse = sc.nextLine();

            continueOrNot = reponse.equals("O");
        }

        while (reponse.equalsIgnoreCase("o"));

        System.out.println();
        System.out.println(CalculatorController.getNbOperations() + " opération(s) a (ont) été réalisée(s).");


    }
}
