package com.farmer.model;

import com.farmer.util.ItemType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="item")
public class Item implements Serializable {

    @Id
    @Column(name="id")
    private long id;

    @Column(name="user_id")
    private long userId;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private ItemType type;

}
