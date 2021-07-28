////-----------------------------------com.example.mainscreen2.Model.Play.java-----------------------------------
//package com.example.mainscreen2.Model;
//
//import javax.annotation.Generated;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;
//
//@Generated("jsonschema2pojo")
//public class Playlist {
//
//    @SerializedName("singer_id")
//    @Expose
//    private Object singerId;
//    @SerializedName("playlist_name")
//    @Expose
//    private String playlistName;
//    @SerializedName("playlist_image_url")
//    @Expose
//    private String playlistImageUrl;
//    @SerializedName("playlist_icon_url")
//    @Expose
//    private String playlistIconUrl;
//    @SerializedName("user_id")
//    @Expose
//    private Object userId;
//
//    public Object getSingerId() {
//        return singerId;
//    }
//
//    public void setSingerId(Object singerId) {
//        this.singerId = singerId;
//    }
//
//    public String getPlaylistName() {
//        return playlistName;
//    }
//
//    public void setPlaylistName(String playlistName) {
//        this.playlistName = playlistName;
//    }
//
//    public String getPlaylistImageUrl() {
//        return playlistImageUrl;
//    }
//
//    public void setPlaylistImageUrl(String playlistImageUrl) {
//        this.playlistImageUrl = playlistImageUrl;
//    }
//
//    public String getPlaylistIconUrl() {
//        return playlistIconUrl;
//    }
//
//    public void setPlaylistIconUrl(String playlistIconUrl) {
//        this.playlistIconUrl = playlistIconUrl;
//    }
//
//    public Object getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Object userId) {
//        this.userId = userId;
//    }
//
//}
package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Playlist {

    @SerializedName("playlist_id")
    @Expose
    private String playlistId;
    @SerializedName("playlist_name")
    @Expose
    private String playlistName;
    @SerializedName("playlist_image_url")
    @Expose
    private String playlistImageUrl;
    @SerializedName("user_id")
    @Expose
    private String userId;

    public Playlist(String playlistName, String userId) {
        this.playlistName=playlistName;
        this.userId=userId;
    }

    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistImageUrl() {
        return playlistImageUrl;
    }

    public void setPlaylistImageUrl(String playlistImageUrl) {
        this.playlistImageUrl = playlistImageUrl;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId='" + playlistId + '\'' +
                ", playlistName='" + playlistName + '\'' +
                ", playlistImageUrl='" + playlistImageUrl + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}