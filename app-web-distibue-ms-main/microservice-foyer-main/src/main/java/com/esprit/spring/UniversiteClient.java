package com.esprit.spring;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "service-universite")
public interface UniversiteClient {
    @GetMapping("/universite/afficherUniversites")
    List<Universite> getAllUniversites();
}