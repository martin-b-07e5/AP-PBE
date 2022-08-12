package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "sources")  // table name
public class Source {
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    @Column(name = "id_source") // column name
    private Long idSource;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Code is mandatory")
    private String code;

    //    baeldung.com/javax-validation
    @PastOrPresent
    @Column(name = "created_at") // column name
    private LocalDate createdAt;

    //     constructor
    public Source() {
    }

    //     constructor
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

    public void setIdSource(Long idSource) {
        this.idSource = idSource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    //     Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;
        Source source = (Source) o;
        return idSource.equals(source.idSource) &&
                name.equals(source.name) &&
                code.equals(source.code) &&
                createdAt.equals(source.createdAt);
    }

    //     HashCode
    @Override
    public int hashCode() {
        return Objects.hash(idSource, name, code, createdAt);
    }

    //     ToString
    @Override
    public String toString() {
        return "Source{" +
                "id_source=" + idSource +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", created_at=" + createdAt +
                '}';
    }

}
