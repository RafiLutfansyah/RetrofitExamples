package com.rafilutfansyah.retrofitexamples;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Rafi Lutfansyah on 10/04/2017.
 */

public class ResultUser {

    @SerializedName("user")
    @Expose
    private List<InfoUser> user = null;

    public List<InfoUser> getUser() {
        return user;
    }

    public void setUser(List<InfoUser> user) {
        this.user = user;
    }
}