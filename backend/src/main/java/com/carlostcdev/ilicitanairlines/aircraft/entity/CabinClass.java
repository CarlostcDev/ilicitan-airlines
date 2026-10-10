package com.carlostcdev.ilicitanairlines.aircraft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Table(name = "cabin_class")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CabinClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    @Pattern(regexp = "^[A-Z][A-Z0-9_]*$")
    @Column(name = "code", nullable = false, length = 30)
    private String code;

    @NotBlank
    @Size(max= 50)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Builder
    public CabinClass(String code, String name) {
        this.code = code;
        this.name = name;
    }
}