
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
@Table(name = "sub_sub_domain")
public class SubSubDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subSubDomainName;

    @ManyToOne
    @JoinColumn(name = "sub_domain_id")
    private SubDomain subDomain;

    @OneToMany(mappedBy = "subSubDomain", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Branch> branches = new ArrayList<>();

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

	public SubDomain getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(SubDomain subDomain) {
		this.subDomain = subDomain;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}
    
    
}
