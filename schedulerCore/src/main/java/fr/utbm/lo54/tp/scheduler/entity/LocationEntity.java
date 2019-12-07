package fr.utbm.lo54.tp.scheduler.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Location", schema = "catalogue", catalog = "")
public class LocationEntity implements Serializable {
    private int id;
    private String city;
    private List<CourseSessionEntity> location_id;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @OneToMany
    @JoinColumn(name = "location_id")
    public List<CourseSessionEntity> getLocation_id() {
        return location_id;
    }

    public void setLocation_id(List<CourseSessionEntity> c) {
        location_id = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return id == that.id &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
