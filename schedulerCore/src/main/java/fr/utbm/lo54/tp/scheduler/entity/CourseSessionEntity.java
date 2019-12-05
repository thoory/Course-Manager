package fr.utbm.lo54.tp.scheduler.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "Course_session", schema = "catalogue", catalog = "")
public class CourseSessionEntity implements Serializable {
    private int id;
    private Date startDate;
    private Date endDate;
    private Integer max;
    private LocationEntity location_id;
    private CourseEntity course_code;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "max")
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_code", referencedColumnName = "code", nullable = false)

    public CourseEntity getCourse_code() {
        return course_code;
    }

    public void setCourse_code(CourseEntity course_code) {
        this.course_code = course_code;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    public LocationEntity getLocation_id() {
        return location_id;
    }

    public void setLocation_id(LocationEntity location_id) {
        this.location_id = location_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSessionEntity that = (CourseSessionEntity) o;
        return id == that.id &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, max);
    }
}
