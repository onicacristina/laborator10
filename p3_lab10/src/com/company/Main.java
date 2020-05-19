package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static ArrayList<Integer> lista = new ArrayList<Integer>();
    public static int n;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        Meniu meniu = new Meniu();
        char op;
        getList(lista);
        do {
            meniu.printMenu();
            System.out.println();
            System.out.println("Alegeti o optiune: ");
            op= scanner.next().charAt(0);
            op = Character.toUpperCase(op);

            switch(op){
                case '1' : addElement(lista); break;
                case '2' : deleteElement(lista); break;
                case '3' : sort(lista);
                           printList(lista); break;
                case 'X' : System.out.println("Ati ales sa iesiti din program!"); break;
                default: System.out.println("OPTIUNE ERONATA......Mai incearca!");
            }

        }while(op!='x' && op!='X');

    }


    public static void getList(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cate elemente doriti sa aiba lista? ");
        n = scanner.nextInt();
        for (int i = 0; i <n ; i++) {
            System.out.print("Introduceti elementul #"+(i+1)+" : ");
            int element = scanner.nextInt();
            lista.add(element);
        }
    }


    public static void addElement(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti elementul pe care doriti sa-l adaugati in lista:  ");
        int element = scanner.nextInt();
        lista.add(element);

    }


    public static void deleteElement(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti elementul pe care doriti sa-l stergeti din lista:  ");
        int element = scanner.nextInt();
        int ok =0;
        for (int i = 0; i <lista.size() ; i++) {
            if(element== (int) lista.get(i))
            {
                lista.remove(i);
                ok = 1;
            }
        }
        if(ok==0)
            System.out.println("elementul "+ element + " nu se afla in lista!");
    }


    public static void printList(ArrayList lista)
    {
        System.out.println("Elementele listei sunt: ");
        lista.forEach((l) -> System.out.print(l + "   "));
    }


    public static void sort(ArrayList lista)
    {
        ArrayList<Integer> pare = new ArrayList<>();
        for (int i = 0; i <lista.size() ; i=i+2) {
            pare.add((int)lista.get(i));
        }

        Collections.sort(pare);

        ArrayList<Integer> impare = new ArrayList<>();
        for (int i = 1; i <lista.size() ; i=i+2) {
            impare.add((int)lista.get(i));
        }

        Collections.sort(impare,Collections.reverseOrder());
        int npare=0;
        int nimpare=0;

        for (int i = 0; i <lista.size() ; i++) {
            if(i%2==0)
            {
                lista.set(i,(int)pare.get(npare));
                npare++;
            }
            else
            {
                lista.set(i,(int)impare.get(nimpare));
                nimpare++;
            }

        }
    }

}
