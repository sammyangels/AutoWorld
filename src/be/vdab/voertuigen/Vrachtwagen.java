package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import be.vdab.util.VolumeException;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Vrachtwagen extends Voertuig implements Laadbaar {
    private static final long serialVersionUID = 1L;
    private Volume laadvolume;
    private int maximaalToegelatenMassa, aantalAssen;

    public Vrachtwagen(String merk, int aankoopprijs, Volume laadvolume, int maximaalToegelatenMassa, int aantalAssen) {
        super(merk, aankoopprijs);
        setLaadvolume(laadvolume);
        setMaximaalToegelatenMassa(maximaalToegelatenMassa);
        setAantalAssen(aantalAssen);
    }

    @Override
    public Volume getLaadvolume() throws VolumeException {
        return laadvolume;
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

    public int getMaximaalToegelatenMassa() {
        return maximaalToegelatenMassa;
    }

    public void setMaximaalToegelatenMassa(int maximaalToegelatenMassa) {
        if (maximaalToegelatenMassa > 0) {
            this.maximaalToegelatenMassa = maximaalToegelatenMassa;
        } else {
            this.maximaalToegelatenMassa = 500;
        }
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0) {
            this.aantalAssen = aantalAssen;
        } else {
            this.aantalAssen = 2;
        }
    }

    @Override
    public String toString() {
        try {
            return "Vrachtwagen: " +super.toString() +
                    " | laadvolume: " + laadvolume.getVolume() + "cm³" +
                    " | maximaalToegelatenMassa: " + maximaalToegelatenMassa +
                    " | aantalAssen: " + aantalAssen;
        } catch (VolumeException e) {
            e.printStackTrace();
            return "Vrachtwagen: " +super.toString() +
                    " | maximaalToegelatenMassa: " + maximaalToegelatenMassa +
                    " | aantalAssen: " + aantalAssen;
        }
    }
}
