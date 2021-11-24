package com.sattler;

import java.net.StandardSocketOptions;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {

        /* 1 Array - Einteilung in zwei Teilen: sortiert und unsortiert
         * erster Teil U wird gepickt und eingereiht
         * zweiter Teil U wird gepickt und mit S Wert verglichen
         * vor oder danach eingeteilt - repeat
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
        int x,y,z;

        /* Pick Number[x] and check with Numbers[before::x] if Number[x] > Number[before::x]
         */

        for (int j = 1; j < len; j++)	//steuert jeden Wert im Array an - Index 0 schon gesetzt
        {
            System.out.println("Sort in " + numbers[j]);
            z = j;

            for (int k = j-1; k >= 0; k--) //Abgleich mit allen vorherigen Zahlen
            {
                if (numbers[k] > numbers[j])    //Wenn vorherige Zahl größer als gepickt
                {
                    while (numbers[z] < numbers[z - 1])   //Platztausch
                    {
                        x = numbers[z];
                        y = numbers[z - 1];
                        numbers[z] = y;
                        numbers[z - 1] = x;
                        if (z > 1)  // Untere Begrenzung, darf 0 nicht unterschreiten
                        {
                            z--;
                        }
                    }
                    for (int a : numbers)
                    {
                        System.out.print(a + " ");
                    }
                    System.out.println();
                }
            }
        }

    }
}
