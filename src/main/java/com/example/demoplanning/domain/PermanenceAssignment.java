package com.example.demoplanning.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.*;

@Entity
@Data
@Table(name = "t_permanenceAssignment")
@PlanningEntity
public class PermanenceAssignment {
    @PlanningId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="idPeriod")
    private Permanence period;


    @ManyToOne
    @JoinColumn(name="idRole")
    private Skill role;

    @ManyToOne
    @JoinColumn(name="idAgency")
    private Agency agency;



    @PlanningVariable(valueRangeProviderRefs = "employeeRange")
    @ManyToOne
    private Employee employee;

    public PermanenceAssignment(Long id, Permanence period, Skill role, Agency agency) {
        this.id = id;
        this.period = period;
        this.role = role;
        this.agency = agency;

    }

    public PermanenceAssignment() {
    }

    public boolean hasRequiredSkill() {

        return employee.getSkill().getId().equals(role.getId());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Permanence getPeriod() {
        return period;
    }

    public void setPeriod(Permanence period) {
        this.period = period;
    }

    public Skill getRole() {
        return role;
    }

    public void setRole(Skill role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }
}
