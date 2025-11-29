package com.icici.DTO;

import java.util.List;


public class DomainResponse {

    private Long id;
    private String domainName;
    private List<SubDomainResponse> subDomains;
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public List<SubDomainResponse> getSubDomains() {
		return subDomains;
	}

	public void setSubDomains(List<SubDomainResponse> subDomains) {
		this.subDomains = subDomains;
	}

	
    public static class SubDomainResponse {
        private Long id;
        private String subDomainName;
        private List<SubSubDomainResponse> subSubDomains;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getSubDomainName() {
			return subDomainName;
		}
		public void setSubDomainName(String subDomainName) {
			this.subDomainName = subDomainName;
		}
		public List<SubSubDomainResponse> getSubSubDomains() {
			return subSubDomains;
		}
		public void setSubSubDomains(List<SubSubDomainResponse> subSubDomains) {
			this.subSubDomains = subSubDomains;
		}
        
        
    }

    
    public static class SubSubDomainResponse {
        private Long id;
        private String subSubDomainName;
        private List<BranchResponse> branches;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getSubSubDomainName() {
			return subSubDomainName;
		}
		public void setSubSubDomainName(String subSubDomainName) {
			this.subSubDomainName = subSubDomainName;
		}
		public List<BranchResponse> getBranches() {
			return branches;
		}
		public void setBranches(List<BranchResponse> branches) {
			this.branches = branches;
		}
        
        
    }
    
    public static class BranchResponse {
        private Long id;
        private String branchName;
        private List<ApiResponse> apis;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public List<ApiResponse> getApis() {
			return apis;
		}
		public void setApis(List<ApiResponse> apis) {
			this.apis = apis;
		}
        
    }
   
    public static class ApiResponse {
        private Long id;
        private String apiId;
        private String apiName;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
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