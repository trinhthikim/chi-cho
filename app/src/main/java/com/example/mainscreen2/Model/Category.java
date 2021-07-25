//-----------------------------------com.example.mainscreen2.Model.Category.java-----------------------------------

package com.example.mainscreen2.Model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("jsonschema2pojo")
public class Category implements Serializable {

    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("topic_id")
    @Expose
    private String topicId;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("category_image_url")
    @Expose
    private String categoryImageUrl;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

}
