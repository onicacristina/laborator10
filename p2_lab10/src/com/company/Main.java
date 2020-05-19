package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> polinom1 = new ArrayList<>();
    public static ArrayList<Integer> polinom2 = new ArrayList<>();
    public static ArrayList<Integer> suma = new ArrayList<>();
    public static ArrayList<Integer> produs = new ArrayList<>();
    public static int grad1, grad2;

    public static void main(String[] args) {
        // write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti gradul polinomului 1: ");
        grad1 = scanner.nextInt();
        grad1 ++;
        getPoly(polinom1,grad1);

        System.out.println("\nIntroduceti gradul polinomului 2: ");
        grad2 = scanner.nextInt();
        grad2 ++;
        getPoly(polinom2,grad2);

        System.out.println("\nPolinomul 1 este: ");
        printPoly(polinom1);

        System.out.println("\nPolinomul 2 este: ");
        printPoly(polinom2);

        sum(suma,polinom1,polinom2,grad1,grad2);
        System.out.println("\nPolinomul suma este: ");
        printPoly(suma);

        prod(produs,polinom1,polinom2,grad1,grad2);
        System.out.println("\nPolinomul produs este: ");
        printPoly(produs);

    }

    public static void getPoly(ArrayList polinom,int grad)
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < grad ; i++) {
            System.out.print("Introduceti coeficientul exponentului de grad #"+i + " : ");
            int element = scanner.nextInt();
            polinom.add(element);

        }
        System.out.println();
    }


    public static void printPoly(ArrayList polinom)
    {
        for (int i = polinom.size()-1; i >= 0 ; i--) {
            System.out.print(polinom.get(i));
            if (i != 0)
            {
                System.out.print("x^" + i + " + ");
            }

        }
        System.out.println();
    }


    public static void sum(ArrayList suma,ArrayList polinom1,ArrayList polinom2,int grad1,int grad2)
    {
        if(grad1>grad2)
        {
            for (int i = 0; i <grad2 ; i++) {
                int elem = (int) polinom1.get(i) + (int) polinom2.get(i);
                suma.add(elem);
            }
            for (int i = grad2 ; i <grad1 ; i++) {
                int elem = (int) polinom1.get(i) ;
                suma.add(elem);
            }
        }
        else
        {
            for (int i = 0; i <grad1 ; i++) {
                int elem = (int) polinom1.get(i) + (int) polinom2.get(i);
                suma.add(elem);
            }
            for (int i = grad1 ; i <grad2 ; i++) {
                int elem = (int) polinom2.get(i) ;
                suma.add(elem);
            }
        }

    }


    public static void  prod(ArrayList produs,ArrayList polinom1,ArrayList polinom2,int grad1,int grad2)
    {
        int[] p = new int[grad1 + grad2 - 1];

        for (int i = 0; i < grad1 + grad2 - 1; i++)
        {
            p[i] = 0;
        }

        for (int i = 0; i < grad1; i++)
        {
            for (int j = 0; j < grad2; j++)
            {
                p[i + j] += (int) polinom1.get(i) * (int) polinom2.get(j) ;
            }
        }

        for (int i = 0; i < grad1+ grad2 -1 ; i++) {
            produs.add(p[i]);
        }

    }


}

