package com.company;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> lista  = new ArrayList<String>();
    public static void main(String[] args) {
        // write your code here

        System.out.println();
        System.out.println("........................MENIU..........................");
        System.out.println("Tastati  1 - pentru inserarea unui nod in lista.");
        System.out.println("Tastati  2 - pentru parcurgerea listei de la stanga la dreapta.");
        System.out.println("Tastati  3 - pentru parcurgerea listei de la dreapta la stanga.");
        System.out.println("Tastati  4 - pentru cautarea unui nod in lista.");
        System.out.println("Tastati  5 - pentru stergerea unui nod din lista.");
        System.out.println("Tastati  6 - pentru schimbul între ele a elementelor adiacente ale listei.");
        System.out.println("Tastati  X - pentru parasirea programului.");

        Scanner scanner = new Scanner(System.in);
        char op;
        getList(lista);
        do {

            System.out.println();
            System.out.println("Alegeti o optiune: ");
            op= scanner.next().charAt(0);
            op = Character.toUpperCase(op);

            switch(op){
                case '1' : insertElement(lista); break;
                case '2' : printListUpward(lista); break;
                case '3' : printListDownward(lista); break;
                case '4' : findElement(lista); break;
                case '5' : deleteElement(lista); break;
                case '6' : adiacente(lista); break;
                case 'X' : System.out.println("Ati ales sa iesiti din program!"); break;
                default: System.out.println("OPTIUNE ERONATA......Mai incearca!");
            }

        }while(op!='x' && op!='X');
    }


    public static void getList(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCate elemente doriti sa aiba lista? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <n ; i++) {
            System.out.print("Introduceti elementul # "+(i+1)+" : ");
            String element = scanner.nextLine();
            lista.add(element);
        }
    }


    public static void printListUpward(ArrayList lista)
    {
        System.out.println("Elementele listei de la stanga la dreapta sunt: ");
        lista.forEach(elem -> System.out.println(elem));
    }


    public static void printListDownward(ArrayList lista)
    {
        System.out.println("Elementele listei de la dreapta la stanga sunt: ");
        for (int i = lista.size()-1; i >=0 ; i--) {
            System.out.println(lista.get(i));
        }
    }


    public static void insertElement(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduceti elementul pe care doriti sa-l adaugati in lista: ");
        String element = scanner.nextLine();
        System.out.print("\nIntroduceti pozitia la care doriti sa inserati elemntul in lista: ");
        int poz = scanner.nextInt();
        lista.add(poz,element);
    }


    public static void findElement(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIntroduceti elementul pe care doriti sa-l cautati in lista: ");
        String element = scanner.nextLine();
        boolean ok = false;
        for (int i = 0; i <lista.size() && ok== false ; i++) {
            if(element.equals( (String) lista.get(i)))
            {
                ok = true;
                System.out.println("Elementul " + element + " se afla in lista!");
            }
        }
        if(ok==false)
            System.out.println("Elementul " + element + " NU se afla in lista!");
    }


    public static void deleteElement(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti elementul pe care doriti sa-l stergeti din lista:  ");
        String element = scanner.nextLine();
        boolean ok = false;
        for (int i = 0; i <lista.size() ; i++) {
            if(element.equals( (String) lista.get(i)))
            {
                lista.remove(i);
                ok = true;
            }
        }
        if(ok==false)
            System.out.println("Elementul "+ element + " nu se afla in lista!");
    }


    public static void adiacente(ArrayList lista)
    {
        for (int i = 0; i <lista.size()-1 ; i++) {
            String aux1= (String) lista.get(i);
            String aux2= (String) lista.get(i+1);
            lista.set(i,aux2);
            lista.set(i+1,aux1);

        }

    }
}

