package be.vdab.util;

import java.io.Serializable;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Volume implements Comparable<Volume>,Serializable {
    private static final long serialVersionUID = 1L;
    private final int breedte, hoogte, diepte;
    private final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) throws VolumeException {
        if (breedte < 0 || hoogte < 0 || diepte < 0) {
            throw new VolumeException("Maten mogen niet negatief zijn.");
        } else {
            this.maat = maat;
            this.breedte = breedte;
            this.hoogte = hoogte;
            this.diepte = diepte;
        }

//        this.breedte = 0;
    }


    public long getVolume() throws VolumeException {
        return breedte * hoogte * diepte * maat.getFactor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volume volume = (Volume) o;

        if (breedte != volume.breedte) return false;
        if (diepte != volume.diepte) return false;
        if (hoogte != volume.hoogte) return false;
        if (maat != volume.maat) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = breedte;
        result = 31 * result + hoogte;
        result = 31 * result + diepte;
        result = 31 * result + maat.hashCode();
        return result;
    }

    @Override
    public int compareTo(Volume o) {
        try {
            if (this.getVolume() < o.getVolume())
                return -1;
        } catch (VolumeException e) {
            e.printStackTrace();
        }
        try {
            if (this.getVolume() == o.getVolume())
                return 0;
        } catch (VolumeException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
