package ru.itmo.razrab.persistence.model;

import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "XT_COLORS",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID_COLOR" }) })
public class ColorCat {

    @Id() @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLOR")
    private Long id;

    @NaturalId(mutable=true)
    @Column(name = "NAIM_COLOR", nullable = false, unique = true)
    private String naim;

    public ColorCat(Long id, String naim) {
        this.id = id;
        this.naim = naim;
    }

    public ColorCat() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaim() {
        return naim;
    }

    public void setNaim(String naim) {
        this.naim = naim;
    }

    @Override
    public String toString() {
        return "ColorCat{" +
                "id=" + id +
                ", naim='" + naim + '\'' +
                '}';
    }
}
