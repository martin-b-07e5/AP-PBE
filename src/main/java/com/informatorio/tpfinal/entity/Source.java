package com.informatorio.tpfinal.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "sources")
public class Source {
    @Id  // for PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for AI
    private Long id_source;
    private String name;
    private Long code;
    private String content;
    private LocalDate created_at;

    // constructor
    public Source() {
    }

    // constructor
    public Source(Long id_source, String name, Long code, String content, LocalDate created_at) {
        this.id_source = id_source;
        this.name = name;
        this.code = code;
        this.content = content;
        this.created_at = created_at;
    }

    // getters and setters
    public Long getId_source() {
        return id_source;
    }

    public void setId_source(Long id_source) {
        this.id_source = id_source;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    // Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Source)) return false;
        Source source = (Source) o;
        return id_source.equals(source.id_source) &&
               name.equals(source.name) &&
               code.equals(source.code) &&
               content.equals(source.content) &&
               created_at.equals(source.created_at);
    }

    // HashCode
    @Override
    public int hashCode() {
        return Objects.hash(id_source, name, code, content, created_at);
    }

    // ToString
    @Override
    public String toString() {
        return "Source{" +
                "id_source=" + id_source +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
