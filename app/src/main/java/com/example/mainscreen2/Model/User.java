package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class User {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("user_avatar_url")
    @Expose
    private String userAvatarUrl;

    public User() {
        this.userId=null;
        this.username=null;
        this.email=null;
        this.password=null;
        this.userAvatarUrl="https://musicplay0123456789.000webhostapp.com/img/user.png";
    }

    public User(String email, String password) {
        this.email=email;
        this.password=password;
    }

    public User(String username, String email, String password) {
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public User(String userId, String username, String email, String password) {
        this.userId=userId;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                '}';
    }
}