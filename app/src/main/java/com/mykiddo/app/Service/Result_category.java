package com.mykiddo.app.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result_category {
    @SerializedName("success")
    @Expose
    private Integer success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private Result result;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }


    public class Result {

        @SerializedName("categoryData")
        @Expose
        private ArrayList<CategoryDatum> categoryData = null;

        public ArrayList<CategoryDatum> getCategoryData() {
            return categoryData;
        }

        public void setCategoryData(ArrayList<CategoryDatum> categoryData) {
            this.categoryData = categoryData;
        }
    }
    public class CategoryDatum {

        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_id")
        @Expose
        private Long categoryId;
        @SerializedName("_id")
        @Expose
        private Id id;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public Id getId() {
            return id;
        }

        public void setId(Id id) {
            this.id = id;
        }

    }
    public class Id {

        @SerializedName("$id")
        @Expose
        private String $id;

        public String get$id() {
            return $id;
        }

        public void set$id(String $id) {
            this.$id = $id;
        }
    }

}
