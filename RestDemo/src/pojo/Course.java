package pojo;

import java.util.List;

public class Course {
	private List<WebAutomation> webAutomation;
	private List<Api> api;
	private List<Mobile> mobile;
	
	
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	
	public void setApi(List<Api> api) {
		this.api = api;
	}
	
	public void setMobile(List<Mobile> mobile) {
		this.mobile = mobile;
	}	
	
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}

	public List<Api> getApi() {
		return api;
	}
	
	public List<Mobile> getMobile(){
		return mobile;
	}
}
