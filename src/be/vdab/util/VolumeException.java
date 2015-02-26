package be.vdab.util;

/**
 * Created by zi08 on 10/02/2015.
 */
public class VolumeException extends Exception {
    public VolumeException() {}

    public VolumeException(String omschrijving) {
        super(omschrijving);
    }

    public VolumeException(String omschrijving, Throwable oorzaak) {
        super(omschrijving, oorzaak);
    }

    public VolumeException(Throwable oorzaak) {
        super(oorzaak);
    }
}
