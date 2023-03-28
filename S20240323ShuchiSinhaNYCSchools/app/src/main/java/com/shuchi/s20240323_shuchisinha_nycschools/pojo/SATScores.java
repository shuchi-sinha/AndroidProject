package com.shuchi.s20240323_shuchisinha_nycschools.pojo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sat_table")
public class SATScores {
    public SATScores(@NonNull String dbn) {
        this.dbn = dbn;
        this.school_name = "";
        this.num_of_sat_test_takers = "";
        this.sat_critical_reading_avg_score = "";
        this.sat_math_avg_score = "";
        this.sat_writing_avg_score = "";
    }

    @NonNull
    public String getDbn() {
        return dbn;
    }

    public void setDbn(@NonNull String dbn) {
        this.dbn = dbn;
    }

    @NonNull
    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(@NonNull String school_name) {
        this.school_name = school_name;
    }

    @NonNull
    public String getNum_of_sat_test_takers() {
        return num_of_sat_test_takers;
    }

    public void setNum_of_sat_test_takers(@NonNull String num_of_sat_test_takers) {
        this.num_of_sat_test_takers = num_of_sat_test_takers;
    }

    @NonNull
    public String getSat_critical_reading_avg_score() {
        return sat_critical_reading_avg_score;
    }

    public void setSat_critical_reading_avg_score(@NonNull String sat_critical_reading_avg_score) {
        this.sat_critical_reading_avg_score = sat_critical_reading_avg_score;
    }

    @NonNull
    public String getSat_math_avg_score() {
        return sat_math_avg_score;
    }

    public void setSat_math_avg_score(@NonNull String sat_math_avg_score) {
        this.sat_math_avg_score = sat_math_avg_score;
    }

    @NonNull
    public String getSat_writing_avg_score() {
        return sat_writing_avg_score;
    }

    public void setSat_writing_avg_score(@NonNull String sat_writing_avg_score) {
        this.sat_writing_avg_score = sat_writing_avg_score;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dbn")
    private String dbn;

    @NonNull
    @ColumnInfo(name = "school_name")
    private String school_name;

    @NonNull
    @ColumnInfo(name = "num_of_sat_test_takers")
    private String num_of_sat_test_takers;

    @NonNull
    @ColumnInfo(name = "sat_critical_reading_avg_score")
    private String sat_critical_reading_avg_score;

    @NonNull
    @ColumnInfo(name = "sat_math_avg_score")
    private String sat_math_avg_score;

    @NonNull
    @ColumnInfo(name = "sat_writing_avg_score")
    private String sat_writing_avg_score;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("No. of SAT Test Takers : ");
        sb.append(num_of_sat_test_takers);
        sb.append(System.getProperty("line.separator"));
        sb.append("SAT Critical Reading Average score : ");
        sb.append(sat_critical_reading_avg_score);
        sb.append(System.getProperty("line.separator"));
        sb.append("SAT Math Average score : ");
        sb.append(sat_math_avg_score);
        sb.append(System.getProperty("line.separator"));
        sb.append("SAT Writing Average score : ");
        sb.append(sat_writing_avg_score);
        return sb.toString();
    }
}
