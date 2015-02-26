package be.vdab.voertuigen;

import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Pickup extends Personenwagen implements Laadbaar {
    private Volume laadvolume;

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, Volume laadvolume) {
        super(merk, aankoopprijs, zitplaatsen);
        setLaadvolume(laadvolume);
    }

    @Override
    public void setLaadvolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

    @Override
    public Volume getLaadvolume() {
        return laadvolume;
    }

    @Override
    public String toString() {
        try {
            return "Pickup: " + super.toString() +
                    " | laadvolume: " + laadvolume.getVolume() + "cm³";
        } catch (Exception e) {
            e.printStackTrace();
            return "Pickup: " + super.toString();
        }
    }
}
