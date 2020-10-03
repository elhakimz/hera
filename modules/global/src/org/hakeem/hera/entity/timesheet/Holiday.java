package org.hakeem.hera.entity.timesheet;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "HERA_HOLIDAY")
@Entity(name = "hera_Holiday")
@NamePattern("%s|name")
public class Holiday extends StandardEntity {
    private static final long serialVersionUID = -6811482603412914491L;

    @Column(name="NAME",length = 100)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="DATEOFHOLIDAY")
    private LocalDate dateOfHoliday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfHoliday() {
        return dateOfHoliday;
    }

    public void setDateOfHoliday(LocalDate dateOfHoliday) {
        this.dateOfHoliday = dateOfHoliday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Holiday)) return false;
        if (!super.equals(o)) return false;
        Holiday holiday = (Holiday) o;
        return Objects.equals(getName(), holiday.getName()) &&
                Objects.equals(getDescription(), holiday.getDescription()) &&
                Objects.equals(getDateOfHoliday(), holiday.getDateOfHoliday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getDescription(), getDateOfHoliday());
    }
}