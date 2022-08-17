package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sources")  // table name
public class Source {
    // https://www.baeldung.com/jpa-many-to-many
    @ManyToMany(mappedBy = "sources")
    Set<Article> articles;

    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_source") // column name
    private Long idSource;
    @NotBlank(message = "Name is mandatory")
    private String name;
    private String code;
    // baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at") // column name
    private LocalDate createdAt = LocalDate.now();


    //     constructors
    public Source() {
    }

    public Source(Long idSource, String name, String code, LocalDate createdAt) {
        this.idSource = idSource;
        this.name = name;
        this.code = code;
        this.createdAt = createdAt;
    }


    //     getters and setters
    public Long getIdSource() {
        return idSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
        setCode(this.name);  // necessary
    }

    public String getCode() {
        return code;
    }

    public void setCode(String name) {
        this.code = name.toLowerCase().replace(" ", "-");
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
