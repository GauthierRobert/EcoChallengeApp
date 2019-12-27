package com.eco.challengeservice.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Entity(name = "Challenges")
@Table(name = "Challenges")
public class Challenge implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "POINT", nullable = false)
    private Integer point;
    @Column(name = "LEVEL_ID", nullable = false)
    private Integer level;
    @Column(name = "CATEGORY_ID")
    private Category category;

    private Challenge() { }

    public Challenge(Integer point, Integer level, Category category) {
        this.point = point;
        this.level = level;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Challenge)) return false;
        Challenge challenge = (Challenge) o;
        return Objects.equals(id, challenge.id) &&
               Objects.equals(point, challenge.point) &&
               Objects.equals(level, challenge.level) &&
               Objects.equals(category, challenge.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, point, level, category);
    }

    @Override
    public String toString() {
        return "Challenge{" +
               "id=" + id +
               ", point=" + point +
               ", levelId=" + level +
               ", categoryId=" + category +
               '}';
    }
}
