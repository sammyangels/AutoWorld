package be.vdab.voertuigen;

/**
 * Created by zi08 on 10/02/2015.
 */
public class Personenwagen extends Voertuig {
    private int zitplaatsen;

    public Personenwagen(String merk, int aankoopprijs, int zitplaatsen) {
        super(merk, aankoopprijs);
        setZitplaatsen(zitplaatsen);
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public void setZitplaatsen(int zitplaatsen) {
        if (zitplaatsen>0) {
            this.zitplaatsen = zitplaatsen;
        } else {
            zitplaatsen = 5;
        }
    }

    @Override
    public String toString() {
        return "Personenwagen: " + super.toString() +
                " | zitplaatsen: " + zitplaatsen;
    }
}
