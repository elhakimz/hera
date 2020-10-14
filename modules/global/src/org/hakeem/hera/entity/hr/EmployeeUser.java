package org.hakeem.hera.entity.hr;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "HERA_EMPLOYEE_USER")
@Entity(name = "hera_EmployeeUser")
@NamePattern("%s|user")
public class EmployeeUser extends StandardEntity {
    private static final long serialVersionUID = 5509710316183059179L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "REGISTER_DATE")
    private LocalDate registerDate = LocalDate.now();

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


}