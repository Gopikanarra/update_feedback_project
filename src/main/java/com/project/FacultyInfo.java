package com.project;

import java.io.Serializable;

public class FacultyInfo implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure version control for serialization

    private int fid;
    private String sub;
    private String fname;

    public FacultyInfo(int fid, String sub, String fname) {
        this.fid = fid;
        this.sub = sub;
        this.fname = fname;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
