package be.vdab.util;

/**
 * Created by zi08 on 10/02/2015.
 */
public interface Laadbaar {
    void setLaadvolume(Volume laadvolume);
    Volume getLaadvolume() throws VolumeException;
}
