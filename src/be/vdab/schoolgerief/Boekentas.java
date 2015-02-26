package be.vdab.schoolgerief;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;

import java.io.Serializable;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Boekentas implements Laadbaar,Serializable {
    private static final long serialVersionUID = 1L;
    private Volume laadvolume;
    private String kleur;

    public Boekentas(Volume laadvolume, String kleur) {
        try {
            setLaadvolume(laadvolume);
            setKleur(kleur);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        try {
            return "Boekentas: " +
                    " | laadvolume: " + laadvolume.getVolume() + "cm³" +
                    " | kleur: " + kleur;
        } catch (VolumeException e) {
            e.printStackTrace();
            return "Boekentas: " +
                    " | kleur: " + kleur;
        }
    }

    @Override
    public Volume getLaadvolume() {

        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boekentas boekentas = (Boekentas) o;

        if (!kleur.equals(boekentas.kleur)) return false;
        if (!laadvolume.equals(boekentas.laadvolume)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = laadvolume.hashCode();
        result = 31 * result + kleur.hashCode();
        return result;
    }
}
