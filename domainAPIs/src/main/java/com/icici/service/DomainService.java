package com.icici.service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import com.icici.DTO.DomainRequest;
import com.icici.DTO.DomainResponse;
import com.icici.entity.*;

import com.icici.repository.DomainRepository;

@Service
public class DomainService {

    private final DomainRepository domainRepository;

    public DomainService(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @Transactional
    public Domain saveDomainHierarchy(DomainRequest req) {

        Domain domain = new Domain();
        domain.setDomainName(req.getDomainName());

        req.getSubDomains().forEach(sdReq -> {
            SubDomain sd = new SubDomain();
            sd.setSubDomainName(sdReq.getSubDomainName());
            sd.setDomain(domain);

            sdReq.getSubSubDomains().forEach(ssReq -> {
                SubSubDomain ssd = new SubSubDomain();
                ssd.setSubSubDomainName(ssReq.getSubSubDomainName());
                ssd.setSubDomain(sd);

                ssReq.getBranches().forEach(brReq -> {
                    Branch b = new Branch();
                    b.setBranchName(brReq.getBranchName());
                    b.setSubSubDomain(ssd);

                    brReq.getApis().forEach(apiReq -> {
                        ApiEntity api = new ApiEntity();
                        api.setApiId(apiReq.getApiId());
                        api.setApiName(apiReq.getApiName());
                        api.setBranch(b);
                        b.getApis().add(api);
                    });

                    ssd.getBranches().add(b);
                });

                sd.getSubSubDomains().add(ssd);
            });
            domain.getSubDomains().add(sd);
        });

        return domainRepository.save(domain);
    }
    

public DomainResponse getDomainHierarchy(Long id) {
    Domain domain = domainRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Domain Not Found"));

    return convertToResponse(domain);
}

public List<DomainResponse> getAllDomainHierarchy() {
    return domainRepository.findAll()
            .stream()
            .map(this::convertToResponse)
            .collect(Collectors.toList());
}

private DomainResponse convertToResponse(Domain domain) {
    DomainResponse resp = new DomainResponse();
    resp.setId(domain.getId());
    resp.setDomainName(domain.getDomainName());

    resp.setSubDomains(
        domain.getSubDomains().stream().map(sd -> {
            DomainResponse.SubDomainResponse sdResp = new DomainResponse.SubDomainResponse();
            sdResp.setId(sd.getId());
            sdResp.setSubDomainName(sd.getSubDomainName());

            sdResp.setSubSubDomains(
                sd.getSubSubDomains().stream().map(ssd -> {
                    DomainResponse.SubSubDomainResponse ssdResp =
                            new DomainResponse.SubSubDomainResponse();
                    ssdResp.setId(ssd.getId());
                    ssdResp.setSubSubDomainName(ssd.getSubSubDomainName());

                    ssdResp.setBranches(
                        ssd.getBranches().stream().map(br -> {
                            DomainResponse.BranchResponse brResp =
                                    new DomainResponse.BranchResponse();
                            brResp.setId(br.getId());
                            brResp.setBranchName(br.getBranchName());

                            brResp.setApis(
                                br.getApis().stream().map(api -> {
                                    DomainResponse.ApiResponse apiResp =
                                            new DomainResponse.ApiResponse();
                                    apiResp.setId(api.getId());
                                    apiResp.setApiId(api.getApiId());
                                    apiResp.setApiName(api.getApiName());
                                    return apiResp;
                                }).collect(Collectors.toList())
                            );

                            return brResp;
                        }).collect(Collectors.toList())
                    );

                    return ssdResp;
                }).collect(Collectors.toList())
            );

            return sdResp;
        }).collect(Collectors.toList())
    );

    return resp;
}
    
    
}