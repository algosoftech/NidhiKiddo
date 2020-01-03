package com.mykiddo.app.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Submit_result {
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

        @SerializedName("userData")
        @Expose
        private UserData userData;

        public UserData getUserData() {
            return userData;
        }

        public void setUserData(UserData userData) {
            this.userData = userData;
        }

        public class UserData {

            @SerializedName("user_id")
            @Expose
            private Long userId;
            @SerializedName("user_login_id")
            @Expose
            private String userLoginId;
            @SerializedName("user_phone")
            @Expose
            private String userPhone;
            @SerializedName("user_type")
            @Expose
            private Long userType;
            @SerializedName("register_otp")
            @Expose
            private Integer registerOtp;

            public Long getUserId() {
                return userId;
            }

            public void setUserId(Long userId) {
                this.userId = userId;
            }

            public String getUserLoginId() {
                return userLoginId;
            }

            public void setUserLoginId(String userLoginId) {
                this.userLoginId = userLoginId;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public Long getUserType() {
                return userType;
            }

            public void setUserType(Long userType) {
                this.userType = userType;
            }

            public Integer getRegisterOtp() {
                return registerOtp;
            }

            public void setRegisterOtp(Integer registerOtp) {
                this.registerOtp = registerOtp;
            }
        }
    }
}
