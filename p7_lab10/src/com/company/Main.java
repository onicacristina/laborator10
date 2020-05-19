package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) {
	// write your code here
        getList(lista);
        System.out.println("\nElementele listei sunt: ");
        printList(lista);
        bubbleSort(lista);
        System.out.println("\nElementele sortate ale listei sunt: ");
        printList(lista);
    }


    public static void getList(ArrayList lista)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cate elemente doriti sa aiba lista? ");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <n ; i++) {
            System.out.println("Introduceti elemntul # "+(i+1)+" : ");
            String element = scanner.nextLine();
            lista.add(element);
        }
    }


    public static void printList(ArrayList lista)
    {
        lista.forEach(elem -> System.out.println(elem));
    }


    public static void bubbleSort(ArrayList lista)
    {

        boolean ok ;
        do {
            ok = false;
            for (int i = 0; i <lista.size()-1 ; i++) {
                String aux1= (String) lista.get(i);
                String aux2= (String) lista.get(i+1);
                if(aux1.compareTo(aux2)>0)
                {
                    lista.set(i,aux2);
                    lista.set(i+1,aux1);
                    ok = true;
                }

            }
        }while(ok==true);
    }
}
