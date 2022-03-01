package com.afpa.travailCalculator;

import com.afpa.travailCalculator.controller.CalculatorController;
import com.afpa.travailCalculator.view.CalculatorView;

import java.util.Scanner;

public class CalculatorApplicationTravail {
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


//        System.out.println("Type opération : " + typeOperation + ", Premier nombre : " + nb1 +
//                " Deuxieme nombre : " + nb2 + ".");

            // réalisation de l'opération
            CalculatorController calculatorController = new CalculatorController(typeOperation, nb1, nb2);

            // double result = calculatorController.getResult();

            if (calculatorController.getErrorMessage().isBlank()) {
                calculatorView.affichResult(calculatorController.getResult());

            } else {
                System.out.println(calculatorController.getErrorMessage());
            }

            // Continue ou pas ?
            System.out.println("Voulez vous réaliser une autre opération ? (O/N)");
            reponse = sc.nextLine();

            continueOrNot = reponse.equals("oui");

        }

        while (reponse.equalsIgnoreCase("o"));
        System.out.println();
        System.out.println(CalculatorController.getNbOperations() + " opération(s) a (ont) été réalisée(s).");

    }

}
