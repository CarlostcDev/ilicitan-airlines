package com.ilicitan_airlines.backend.aircraft.controller.admin;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/cabin-class")
@Tag(name = "cabin-class", description = "Managing in-cabin classes for administrators")
public class CabinClassController {

}