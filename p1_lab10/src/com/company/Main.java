package com.company;

import java.util.*;

public class Main {

    public static ArrayList<Integer> lista = new ArrayList<>();

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        for (int i = 0; i <50 ; i++) {
            int element = random.nextInt(50)+1;
            lista.add(element);
        }

        Collections.sort(lista);

        System.out.println("\nElementele listei generate sunt(in ordine crescatoare): ");
        printList(lista);
        System.out.println("\nIntroduceti numarul de elemente al setului : ");
        int n = scanner.nextInt();
        int [] sir = new int[n];
        for (int i = 0; i <n ; i++) {
            System.out.print("Introduceti elementul # "+(i+1)+" : ");
            sir[i]=scanner.nextInt();
        }
        cautare(lista,sir);
        System.out.println("\nElementele listei dupa cautarea cu reordonare sunt: ");
        printList(lista);

    }
    public static void cautare(ArrayList lista, int sir[])
    {
            for (int j = 0; j <sir.length ; j++) {
                deleteElement(lista, sir[j]);
            }

        //System.out.println(lista);
    }
    public static void deleteElement(ArrayList lista,int nr)
    {
        for (int i = 0; i <lista.size() ; i++) {
            if(nr == (int) lista.get(i))
            {
                lista.remove(i);
                i--;
            }
        }
        lista.add(0,nr);

    }
    public static void printList(ArrayList lista)
    {
        lista.forEach(elem -> System.out.println(elem));
    }
}
