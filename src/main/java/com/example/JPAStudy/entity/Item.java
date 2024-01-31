package com.example.JPAStudy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "startingThousand")
    @SequenceGenerator(name="startingThousand", sequenceName = "sequenceName", initialValue = 1000, allocationSize = 1)
    private Long id;

    private String name;

    // item은 completeItemConfig에서 Item 객체의 필드 이름 item
    @OneToMany(mappedBy = "item", fetch = FetchType.EAGER)
    private List<CompleteItemConfig> completeItemConfigs = new ArrayList<>();





}
