package com.sattler;

import java.util.Random;
import java.util.Scanner;

public class MergeSort {

//Teiler-Methode
    void merge(int arr[], int beg, int mid, int end) {

        int l = mid - beg + 1;  //Index 0 bis midLength - defines Size depending on Arraylength
        int r = end - mid;      //midLength bis Ende - defines Size depending on Arraylength

        int LeftArray[] = new int[l];   //creates array of needed Size
        int RightArray[] = new int[r];

//Wertübertragung
        for (int i = 0; i < l; i++) {
            LeftArray[i] = arr[beg + i];
        }
        for (int j = 0; j < r; j++) {
            RightArray[j] = arr[mid + 1 + j];
        }
//Sortieren
        int i = 0, j = 0;
        int k = beg;
        while (i < l && j < r) {
            if (LeftArray[i] <= RightArray[j]) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < r) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
//        System.out.println("Check:");
//        for (int a = 0; a < arr.length; a++) {
//            System.out.print(arr[a] + " ");
//        }
//        System.out.println();
    }

//Teilung - Rekursiv
    void sort(int arr[], int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;  //definition Mitte
            sort(arr, beg, mid);
            sort(arr, mid + 1, end);
            merge(arr, beg, mid, end); //Aufruf Merge - Teilung in Links und Rechts
        }
    }

//Main
    public static void main(String args[]) {

        Random rd = new Random();

        Scanner sc1 = new Scanner (System.in);
        System.out.print("Amount of Numbers (max.50): ");
        int nbrs = sc1.nextInt();

        int[] arr = new int[nbrs];		//zu sortieren

        for (int i = 0; i < nbrs; i++)  //generiert zufällige Zahlen
        {
            arr[i] = rd.nextInt(100)+1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        MergeSort ob = new MergeSort(); //Methodenaufruf
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
