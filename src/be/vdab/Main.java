package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.Laadbaar;
import be.vdab.util.Maat;
import be.vdab.util.Volume;
import be.vdab.voertuigen.Personenwagen;
import be.vdab.voertuigen.Pickup;
import be.vdab.voertuigen.Voertuig;
import be.vdab.voertuigen.Vrachtwagen;

import java.io.*;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Personenwagen volvo1 = new Personenwagen("Volvo", 13999, 6);
        Personenwagen volvo2 = new Personenwagen("Volvo", 11999, 5);

        Pickup ford = new Pickup("Ford", 18999, 4, new Volume(2, 1, 2, Maat.METER));
        Pickup nissan = new Pickup("Nissan", 17999, 5, new Volume(180, 120, 170, Maat.CENTIMETER));

        Vrachtwagen mercedes = new Vrachtwagen("Mercedes-Benz", 150999, new Volume(3, 3, 5, Maat.METER), 1500, 5);
        Vrachtwagen mol = new Vrachtwagen("Mol", 149599, new Volume(280, 290, 550, Maat.CENTIMETER), 1300, 4);

        // Eerste sorted set met uitvoer

        SortedSet<Voertuig> voertuigen= new TreeSet<Voertuig>();
        voertuigen.add(volvo1);
        voertuigen.add(volvo2);
        voertuigen.add(ford);
        voertuigen.add(nissan);
        voertuigen.add(mercedes);
        voertuigen.add(mol);

        System.out.println("*** SortedSet op basis van nummerplaat (standaard): ");
        for (Object obj : voertuigen) {
            System.out.println(obj);
        }
        System.out.println();

        // Tweede sorted set, met prijsComparator in omgekeerde volgorde

        SortedSet<Voertuig> voertuigen2 = new TreeSet<Voertuig>(Collections.reverseOrder(Voertuig.getPrijsComparator()));
        voertuigen2.addAll(voertuigen);

        System.out.println("*** SortedSet op basis van dalende prijs: ");
        System.out.println();
        for (Object obj : voertuigen2) {
            System.out.println(obj);
        }
        System.out.println();

        // Derde sorted set, met merkComparator

        SortedSet<Voertuig> voertuigen3 = new TreeSet(Voertuig.getMerkComparator());
        voertuigen3.addAll(voertuigen);

        System.out.println("*** SortedSet op basis van merk: ");
        System.out.println();
        for (Object obj : voertuigen3) {
            System.out.println(obj);
        }
        System.out.println();

        // Opslaan naar bestand

        File file = new File("wagenpark.ser");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(voertuigen);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Derde set inlezen naar vierde set en uitvoeren

        SortedSet<Voertuig> voertuigen4 = new TreeSet();
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            voertuigen4 = (SortedSet<Voertuig>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("*** Ingelezen SortedSet: ");
        System.out.println();
        for (Object obj : voertuigen4) {
            System.out.println(obj);
        }
        System.out.println();

        // Array van interfacetype Laadbaar

        Boekentas eastpak = new Boekentas(new Volume(30, 40, 20, Maat.CENTIMETER), "groen");

        Laadbaar[] laadbareDingen = new Laadbaar[3];
        laadbareDingen[0] = ford;
        laadbareDingen[1] = mercedes;
        laadbareDingen[2] = eastpak;

        System.out.println("*** Array van laadbare dingen: ");
        System.out.println();
        for (Object obj : laadbareDingen) {
            System.out.println(obj);
        }

    }
}
