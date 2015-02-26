package be.vdab.voertuigen.div;

import java.io.Serializable;

/**
 * Created by zi08 on 10/02/2015.
 */
public final class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String plaat;

    public Nummerplaat(String plaat) {
        this.plaat=plaat;
    }

    public String getPlaat() {
        return plaat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nummerplaat that = (Nummerplaat) o;

        if (!plaat.equals(that.plaat)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return plaat.hashCode();
    }

    @Override
    public String toString() {
        return "Nummerplaat: " + plaat;
    }

    @Override
    public int compareTo(Nummerplaat o) {
        return this.plaat.compareTo(o.getPlaat());
    }
}










