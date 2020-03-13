package com.sample.core.dto;

public class ResultLogin {
    private String textResult;
    private String reason;

    public ResultLogin(String textResult, String reason){
        this.textResult = textResult;
        this.reason = reason;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
