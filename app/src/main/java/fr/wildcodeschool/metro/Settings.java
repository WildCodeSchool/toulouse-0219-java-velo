package fr.wildcodeschool.metro;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

public class Settings implements Parcelable {
    int zoom;
    boolean dropOff;
    Location location;
    boolean init;
    boolean changeActivity;

    public Settings(int zoom, boolean dropOff, Location location, boolean init, boolean changeActivity) {
        this.zoom = zoom;
        this.dropOff = dropOff;
        this.location = location;
        this.init = init;
        this.changeActivity = changeActivity;
    }

    protected Settings(Parcel in) {
        zoom = in.readInt();
        dropOff = in.readByte() != 0;
        location = in.readParcelable(Location.class.getClassLoader());
    }


    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };

    public int getZoom() {
        return zoom;
    }

    public boolean isDropOff() {
        return dropOff;
    }

    public Location getLocation() {
        return location;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public void setDropOff(boolean dropOff) {
        this.dropOff = dropOff;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public boolean isChangeActivity() {
        return changeActivity;
    }

    public void setChangeActivity(boolean changeActivity) {
        this.changeActivity = changeActivity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(zoom);
        dest.writeByte((byte) (dropOff ? 1 : 0));
        dest.writeParcelable(location, flags);
        dest.writeByte((byte) (init ? 1 : 0));
        dest.writeByte((byte) (changeActivity ? 1 : 0));
    }
}


