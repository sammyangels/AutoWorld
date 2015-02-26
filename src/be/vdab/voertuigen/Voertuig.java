package be.vdab.voertuigen;

import be.vdab.voertuigen.div.Div;
import be.vdab.voertuigen.div.Nummerplaat;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by zi08 on 10/02/2015.
 */
public abstract class Voertuig implements Comparable<Voertuig>,Serializable {
    private static final long serialVersionUID = 1L;
    private final Nummerplaat nummerplaat = Div.INSTANCE.getNummerplaat(); // getNummerplaat via Div?
    private String merk;
    private int aankoopprijs;

    public Nummerplaat getNummerplaat() {
        return nummerplaat;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {

        if (aankoopprijs>=0) {
            this.aankoopprijs = aankoopprijs;
        } else {
            this.aankoopprijs = 0;
        }
    }

    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public static Comparator<Voertuig> getMerkComparator() {
        return new Comparator<Voertuig>() {
            @Override
            public int compare(Voertuig v1, Voertuig v2) {
                if (v1.getMerk().compareTo(v2.getMerk()) == 0)
                    return 1;
                else
                    if (v1.getMerk().compareTo(v2.getMerk()) > 0)
                        return 1;
                    else
                        return -1;
            }
        };

    }

    public static Comparator<Voertuig> getPrijsComparator() {
        return new Comparator<Voertuig>() {
            @Override
            public int compare(Voertuig v1, Voertuig v2) {
                return v1.getAankoopprijs() == v2.getAankoopprijs() ? -1 : v1.getAankoopprijs() - v2.getAankoopprijs();
            }
        };

    }


    @Override
    public String toString() {
        return nummerplaat + " | merk: " + merk +
                " | aankoopprijs: " + aankoopprijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voertuig that = (Voertuig) o;

        if (!nummerplaat.equals(that.nummerplaat)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nummerplaat.hashCode();
    }

    @Override
    public int compareTo(Voertuig voertuig) {
        return this.getNummerplaat().compareTo(voertuig.getNummerplaat());
    }

}
