package com.example.demo.configuration;


public class PayPalConfig {

	private String authToken;
    private String posturl;
    private String business;
    private String returnurl;
    private String cancelurl;
    private String cmd;

    public String getAuthToken() {
        return authToken;
    }

    public String getPosturl() {
        return posturl;
    }

    public String getBusiness() {
        return business;
    }

    public String getReturnurl() {
        return returnurl;
    }

    public String getCancelurl() {
        return cancelurl;
    }

    public String getCmd() {
        return cmd;
    }

    public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public void setPosturl(String posturl) {
		this.posturl = posturl;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public void setReturnurl(String returnurl) {
		this.returnurl = returnurl;
	}

	public void setCancelurl(String cancelurl) {
		this.cancelurl = cancelurl;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
}
