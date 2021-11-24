package com.sattler;

import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static void main(String[] args) {

        /*	Sortiert ein Array
         * 	Hierbei werden zwei benachbarte Elemente verglichen und je nach Regel von klein nach groß oder umgekehrt sortiert
         * 	Am Ende ist die Liste nach Größe sortiert
         *
         * 	Hasen sind Elemente, die nach hinten rutschen
         * 	-- schnell, weil Algorithmus von vorne beginnt und ein Element fast durchgehend nach hinten zieht
         * 	Schildkröten sind Elemente, die nach vorne rutschen
         * 	-- langsam, weil Algorithmus von vorne nach hinten wandert und Elemente nur pro Durchlauf eins nach vor setzt
         *
         * 	SpezialArten:
         * 	Combsort oder Gapsort vergleicht weit voneinander liegende Objekte
         * 	Cocktailsort alterniert beim sortieren und beginnt mal vorne und mal hinten
         */
        Random rd = new Random();

        Scanner sc1 = new Scanner (System.in);
        System.out.print("Amount of Numbers (max.50): ");
        int nbrs = sc1.nextInt();

        int[] numbers = new int[nbrs];		//zu sortieren

        for (int i = 0; i < nbrs; i++)
        {
            numbers[i] = rd.nextInt(100)+1;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();


        int	len = numbers.length;				// Array Länge
        boolean order;
        int x,y;

        //es soll so oft die Schleife checken, bis Array sortiert ist
        do
        {
            order = true;

            for(int i = 0; i < len-1; i++ )	//geht jeden Array-Index durch -- len-1 weil bei größe 10 Index 0-9
            {
                for(int j = len-1; j > 0; j--)
                {

                    if (numbers[i] > numbers[j])		//check links größer als rechts
                    {
                        x = numbers[i];			//Zwischenspeicher
                        y = numbers[j];

                        numbers[i] = y;
                        numbers[j] = x; 		//Platztausch der Werte im Array

                        for (int a : numbers)		//Ausgabe
                        {
                            System.out.print(a + " ");
                        }
                        System.out.println();
                        order=false;
                    }
                }
            }
            len--;
        }		//da größtes/kleinstes Element ganz am Ende - Länge gleich um 1 kürzer
        while(order==false);

    }

}
