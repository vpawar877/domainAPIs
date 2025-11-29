package com.icici.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchName;

    @ManyToOne
    @JoinColumn(name = "sub_sub_domain_id")
    private SubSubDomain subSubDomain;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApiEntity> apis = new ArrayList<>();

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

	public SubSubDomain getSubSubDomain() {
		return subSubDomain;
	}

	public void setSubSubDomain(SubSubDomain subSubDomain) {
		this.subSubDomain = subSubDomain;
	}

	public List<ApiEntity> getApis() {
		return apis;
	}

	public void setApis(List<ApiEntity> apis) {
		this.apis = apis;
	}
    
    
}
