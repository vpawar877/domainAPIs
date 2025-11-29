package com.icici.DTO;
import java.util.List;




public class DomainRequest {

    private String domainName;
    private List<SubDomainRequest> subDomains;
    
    

    public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<SubDomainRequest> getSubDomains() {
		return subDomains;
	}

	public void setSubDomains(List<SubDomainRequest> subDomains) {
		this.subDomains = subDomains;
	}

	
    public static class SubDomainRequest {
        private String subDomainName;
        private List<SubSubDomainRequest> subSubDomains;
		public String getSubDomainName() {
			return subDomainName;
		}
		public void setSubDomainName(String subDomainName) {
			this.subDomainName = subDomainName;
		}
		public List<SubSubDomainRequest> getSubSubDomains() {
			return subSubDomains;
		}
		public void setSubSubDomains(List<SubSubDomainRequest> subSubDomains) {
			this.subSubDomains = subSubDomains;
		}
        
    }

    
    public static class SubSubDomainRequest {
        private String subSubDomainName;
        private List<BranchRequest> branches;
		public String getSubSubDomainName() {
			return subSubDomainName;
		}
		public void setSubSubDomainName(String subSubDomainName) {
			this.subSubDomainName = subSubDomainName;
		}
		public List<BranchRequest> getBranches() {
			return branches;
		}
		public void setBranches(List<BranchRequest> branches) {
			this.branches = branches;
		}
        
    }

   
    public static class BranchRequest {
        private String branchName;
        private List<ApiRequest> apis;
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public List<ApiRequest> getApis() {
			return apis;
		}
		public void setApis(List<ApiRequest> apis) {
			this.apis = apis;
		}
        
        
    }

    
    public static class ApiRequest {
        private String apiId;
        private String apiName;
		public String getApiId() {
			return apiId;
		}
		public void setApiId(String apiId) {
			this.apiId = apiId;
		}
		public String getApiName() {
			return apiName;
		}
		public void setApiName(String apiName) {
			this.apiName = apiName;
		}
        
        
    }
}