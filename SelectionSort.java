package com.sattler;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

        public static void main(String[] args) {
            /* 1 Array - Einteilung in zwei Teilen: sortiert und unsortiert
             * kleinster Wert Unsortiert wird vorangeschoben in Sortiert
             * U U U U U 	Pick smalles Value of U
             * S U U U U	Insert in front - repeat
             * S S U U U .. Insert behind 1st value - repeat
             */

            Random rd = new Random();
            Scanner sc1 = new Scanner (System.in);

            System.out.print("Amount of Numbers (max.50): ");
            int nbrs = sc1.nextInt();
//Initialisieren der Größe des Arrays
            int[] numbers = new int[nbrs];		//zu sortieren

//Befüllen mit Random Zahlen
            for (int i = 0; i < nbrs; i++)
            {
                numbers[i] = rd.nextInt(100)+1;
                System.out.print(numbers[i] + " ");	//Startzahlen zu sortieren
            }
            System.out.println();

            int len = numbers.length;
            int x,y;	//Zwischenspeicher

            for(int j = 0; j < len-1; j++)	//Index Wahl
            {
                for(int k = j+1; k < len; k++)	//Kontrollwerte ab Indexwahl + 1
                {
                    if (numbers[j] > numbers[k])	//Vergleich ob gewählte Zahl die Kleinste gegenüber den Folgenden ist
                    {
                        x = numbers[j];		//setze als (Nächst)kleinste Zahl sollte numbers[j] > numbers[k] sein
                        y = numbers[k];
                        numbers[j] = y;
                        numbers[k] = x;
                    }
                }
                for(int a : numbers) //Ausgabe des Arrays nach jedem Schritt
                {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }

}
