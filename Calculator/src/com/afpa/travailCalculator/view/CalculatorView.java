package com.afpa.travailCalculator.view;

import java.util.Scanner;

public class CalculatorView {
    private static final Scanner sc = new Scanner(System.in);

    private String typeOperation;
    private double nb;

    public CalculatorView() {
    }

    public String askOperationtype() {
        System.out.println("Quelle opération voulez vous effectuer ? " +
                "(addition (+), soustraction(-), multiplication(*), division(/)");
        String typeOperation = sc.nextLine();
        return typeOperation;
    }

    public double askNumber() {
        System.out.print("Entrez le premier nombre: ");
        this.nb = sc.nextDouble();
        sc.nextLine();
        return nb;
    }

    public void affichResult(double result) {
        System.out.println("Le résultat de l'opération est " + result);
    }
}
