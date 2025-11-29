package com.icici.controller;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.icici.DTO.DomainRequest;
import com.icici.DTO.DomainResponse;
import com.icici.entity.Domain;
import com.icici.service.DomainService;

@RestController
@RequestMapping("/api/domain")
public class DomainController {

    private final DomainService domainService;

    public DomainController(DomainService domainService) {
        this.domainService = domainService;
    }

    @PostMapping("/save")
    public Domain saveFullHierarchy(@RequestBody DomainRequest req) {
        return domainService.saveDomainHierarchy(req);
    }
    
    @GetMapping("/{id}")
    public DomainResponse getDomainHierarchy(@PathVariable Long id) {
        return domainService.getDomainHierarchy(id);
    }

    @GetMapping("/all")
    public List<DomainResponse> getAllHierarchy() {
        return domainService.getAllDomainHierarchy();
    }
}