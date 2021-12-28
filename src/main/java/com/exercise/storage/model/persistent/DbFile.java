package com.exercise.storage.model.persistent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
public class DbFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column
    private String type;
    @Column
    private String size;
    @Lob
    private byte[] content;
}
