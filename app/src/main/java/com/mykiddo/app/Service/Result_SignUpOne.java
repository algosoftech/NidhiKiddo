package com.mykiddo.app.Service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result_SignUpOne {
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
    public  class Result {
        @SerializedName("signupFormOneData")
        @Expose
        private SignupFormOneData signupFormOneData;

        public SignupFormOneData getSignupFormOneData() {
            return signupFormOneData;
        }

        public void setSignupFormOneData(SignupFormOneData signupFormOneData) {
            this.signupFormOneData = signupFormOneData;
        }


        public class SignupFormOneData {

            @SerializedName("form_id")
            @Expose
            private Long formId;
            @SerializedName("form_name")
            @Expose
            private String formName;
            @SerializedName("form_code")
            @Expose
            private String formCode;
            @SerializedName("category_name")
            @Expose
            private String categoryName;
            @SerializedName("form_fields")
            @Expose
            private ArrayList<FormField> formFields = null;
            @SerializedName("_id")
            @Expose
            private Id id;

            public Long getFormId() {
                return formId;
            }

            public void setFormId(Long formId) {
                this.formId = formId;
            }

            public String getFormName() {
                return formName;
            }

            public void setFormName(String formName) {
                this.formName = formName;
            }

            public String getFormCode() {
                return formCode;
            }

            public void setFormCode(String formCode) {
                this.formCode = formCode;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public ArrayList<FormField> getFormFields() {
                return formFields;
            }

            public void setFormFields(ArrayList<FormField> formFields) {
                this.formFields = formFields;
            }

            public Id getId() {
                return id;
            }

            public void setId(Id id) {
                this.id = id;
            }


        }

        public class FormField {

            @SerializedName("field_id")
            @Expose
            private Long fieldId;
            @SerializedName("title")
            @Expose
            private String title;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("type")
            @Expose
            private String type;
            @SerializedName("placeholder")
            @Expose
            private String placeholder;
            @SerializedName("value")
            @Expose
            private String value;
            @SerializedName("remark")
            @Expose
            private String remark;
            @SerializedName("action_apply")
            @Expose
            private String actionApply;
            @SerializedName("field_order")
            @Expose
            private Integer fieldOrder;
            @SerializedName("required")
            @Expose
            private String required;
            @SerializedName("readonly")
            @Expose
            private String readonly;
            @SerializedName("multiple")
            @Expose
            private String multiple;
//            @SerializedName("attribute_data")
//            @Expose
//            private ArrayList<AttributeDatum> attributeData = null;
            @SerializedName("fields_data")
            @Expose
            private String fieldsData;

            public Long getFieldId() {
                return fieldId;
            }

            public void setFieldId(Long fieldId) {
                this.fieldId = fieldId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPlaceholder() {
                return placeholder;
            }

            public void setPlaceholder(String placeholder) {
                this.placeholder = placeholder;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getActionApply() {
                return actionApply;
            }

            public void setActionApply(String actionApply) {
                this.actionApply = actionApply;
            }

            public Integer getFieldOrder() {
                return fieldOrder;
            }

            public void setFieldOrder(Integer fieldOrder) {
                this.fieldOrder = fieldOrder;
            }

            public String getRequired() {
                return required;
            }

            public void setRequired(String required) {
                this.required = required;
            }

            public String getReadonly() {
                return readonly;
            }

            public void setReadonly(String readonly) {
                this.readonly = readonly;
            }

            public String getMultiple() {
                return multiple;
            }

            public void setMultiple(String multiple) {
                this.multiple = multiple;
            }

//            public ArrayList<AttributeDatum> getAttributeData() {
//                return attributeData;
//            }
//
//            public void setAttributeData(ArrayList<AttributeDatum> attributeData) {
//                this.attributeData = attributeData;
//            }

            public String getFieldsData() {
                return fieldsData;
            }

            public void setFieldsData(String fieldsData) {
                this.fieldsData = fieldsData;
            }

//            public class AttributeDatum {
//
//                @SerializedName("name")
//                @Expose
//                private String name;
//                @SerializedName("value")
//                @Expose
//                private String value;
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getValue() {
//                    return value;
//                }
//
//                public void setValue(String value) {
//                    this.value = value;
//                }
//
//            }
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
}




