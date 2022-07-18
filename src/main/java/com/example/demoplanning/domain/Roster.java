package com.example.demoplanning.domain;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.List;

@PlanningSolution
public class Roster {
    @ValueRangeProvider(id = "employeeRange")
    @ProblemFactCollectionProperty
    private List<Employee> employeeList;

    @ProblemFactCollectionProperty
    private List<Skill> skillList;

    @ProblemFactCollectionProperty
    private List<Agency> agencyList;

    @ProblemFactCollectionProperty
    private List<Permanence> permanenceList;

    @PlanningEntityCollectionProperty
    private List<PermanenceAssignment> permanenceAssignmentList;



    @PlanningScore
    private HardSoftScore score;

    public Roster() {
    }

    public Roster(List<Employee> employeeList, List<Skill> skillList, List<Agency> agencyList, List<PermanenceAssignment> permanenceAssignmentList, List<Permanence> permanenceList) {
        this.employeeList = employeeList;
        this.skillList = skillList;
        this.agencyList = agencyList;
        this.permanenceAssignmentList = permanenceAssignmentList;
        this.permanenceList = permanenceList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public List<Agency> getAgencyList() {
        return agencyList;
    }

    public List<Permanence> getPermanenceList() {
        return permanenceList;
    }

    public void setPermanenceList(List<Permanence> permanenceList) {
        this.permanenceList = permanenceList;
    }

    public void setAgencyList(List<Agency> agencyList) {
        this.agencyList = agencyList;
    }

    public List<PermanenceAssignment> getPermanenceAssignmentList() {
        return permanenceAssignmentList;
    }

    public void setPermanenceAssignmentList(List<PermanenceAssignment> permanenceAssignmentList) {
        this.permanenceAssignmentList = permanenceAssignmentList;
    }



    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
