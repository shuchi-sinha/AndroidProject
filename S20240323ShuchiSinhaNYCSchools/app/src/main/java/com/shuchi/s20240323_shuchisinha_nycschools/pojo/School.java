package com.shuchi.s20240323_shuchisinha_nycschools.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "school_table")
public class School implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dbn")
    private String dbn;

    @NonNull
    @ColumnInfo(name = "school_name")
    private String school_name;

    @NonNull
    @ColumnInfo(name = "overview_paragraph")
    private String overview_paragraph;

    @NonNull
    @ColumnInfo(name = "phone_number")
    private String phone_number;

    @NonNull
    @ColumnInfo(name = "school_email")
    private String school_email;

    @NonNull
    @ColumnInfo(name = "website")
    private String website;
    @NonNull
    @ColumnInfo(name = "total_students")
    private String total_students;

    @NonNull
    @ColumnInfo(name = "primary_address_line_1")
    private String primary_address_line_1;

    @NonNull
    @ColumnInfo(name = "city")
    private String city;

    @NonNull
    @ColumnInfo(name = "zip")
    private String zip;

    @NonNull
    @ColumnInfo(name = "latitude")
    private String latitude;

    @NonNull
    public String getDbn() {
        return dbn;
    }

    public void setDbn(@NonNull String dbn) {
        this.dbn = dbn;
    }

    @NonNull
    public String getOverview_paragraph() {
        return overview_paragraph;
    }

    public void setOverview_paragraph(@NonNull String overview_paragraph) {
        this.overview_paragraph = overview_paragraph;
    }

    @NonNull
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@NonNull String phone_number) {
        this.phone_number = phone_number;
    }

    @NonNull
    public String getSchool_email() {
        return school_email;
    }

    public void setSchool_email(@NonNull String school_email) {
        this.school_email = school_email;
    }

    @NonNull
    public String getWebsite() {
        return website;
    }

    public void setWebsite(@NonNull String website) {
        this.website = website;
    }

    @NonNull
    public String getTotal_students() {
        return total_students;
    }

    public void setTotal_students(@NonNull String total_students) {
        this.total_students = total_students;
    }

    @NonNull
    public String getPrimary_address_line_1() {
        return primary_address_line_1;
    }

    public void setPrimary_address_line_1(@NonNull String primary_address_line_1) {
        this.primary_address_line_1 = primary_address_line_1;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    @NonNull
    public String getZip() {
        return zip;
    }

    public void setZip(@NonNull String zip) {
        this.zip = zip;
    }

    @NonNull
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(@NonNull String latitude) {
        this.latitude = latitude;
    }

    @NonNull
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(@NonNull String longitude) {
        this.longitude = longitude;
    }

    @NonNull
    @ColumnInfo(name = "longitude")
    private String longitude;

    @NonNull
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(@NonNull String school_name) {
        this.school_name = school_name;
    }

    /**
     * Parcelable support from here
     */
    public School(@NonNull String dbn) {
        this.dbn = dbn;
        school_name = "";
        longitude = "";
        latitude = "";
        zip = "";
        city = "";
        primary_address_line_1 = "";
        overview_paragraph = "";
        phone_number = "";
        school_email = "";
        website = "";
        total_students = "";
    }

    public School(Parcel parcel) {
        dbn = parcel.readString();
        school_name = parcel.readString();
        longitude = parcel.readString();
        latitude = parcel.readString();
        zip = parcel.readString();
        city = parcel.readString();
        primary_address_line_1 = parcel.readString();
        overview_paragraph = parcel.readString();
        phone_number = parcel.readString();
        school_email = parcel.readString();
        website = parcel.readString();
        total_students = parcel.readString();
    }

    public static final Creator<School> CREATOR = new Creator<School>() {

        @Override
        public School createFromParcel(Parcel parcel) {
            return new School(parcel);
        }

        @Override
        public School[] newArray(int size) {
            return new School[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dbn);
        dest.writeString(school_name);
        dest.writeString(longitude);
        dest.writeString(latitude);
        dest.writeString(zip);
        dest.writeString(city);
        dest.writeString(primary_address_line_1);
        dest.writeString(overview_paragraph);
        dest.writeString(phone_number);
        dest.writeString(school_email);
        dest.writeString(website);
        dest.writeString(total_students);
    }

}