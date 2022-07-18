package com.example.demoplanning.solver;


import com.example.demoplanning.domain.PermanenceAssignment;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;


public class RosterConstraintProvider implements ConstraintProvider {


    //Déclaration des contraintes
    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                employeeRoleConflict(constraintFactory),
                requiredSkillForPermanence(constraintFactory),
                assignConflict(constraintFactory),
               // noMoreThanTwoConsecutivePermanence(constraintFactory),
                // Soft constraints are only implemented in the optaplanner-quickstarts code
        };
    }
/*
    private Constraint chiefConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory
                .forEach(Permanence.class)
                // ... and pair it with another lesson ...
                .join(Permanence.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Permanence::getDate),
                        // ... in the same room ...
                        Joiners.equal(Permanence::getSkill),
                        // ... and the pair is unique (different id, no reverse pairs) ...
                        Joiners.lessThan(Permanence::getId))
                // ... then penalize each pair with a hard weight.
                .penalize("chief conflict", HardSoftScore.ONE_HARD);
    }*/


    //Contrainte qui permet de définir qu'il faut posséder certaines aptitudes pour occuper un poste de permanence
    private Constraint requiredSkillForPermanence(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory.forEach(PermanenceAssignment.class)
                .filter(permanenceAssignment -> permanenceAssignment.hasRequiredSkill()==false)
                .penalize("skill conflict", HardSoftScore.ONE_HARD);
    }

    //Contrainte qui permet de définir que le poste d'une permanence n'est pas nulle
    private Constraint assignConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory.forEachIncludingNullVars(PermanenceAssignment.class)
                .filter(PermanenceAssignment -> PermanenceAssignment.getEmployee() == null)
                .penalize("assign conflict", HardSoftScore.ONE_HARD);
    }

    //Contrainte qui permet de définir que deux employés ne peuvent pas avoir le même rôle pour une permanence
    private Constraint employeeRoleConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory
                .forEach(PermanenceAssignment.class)
                // ... and pair it with another lesson ...
                .join(PermanenceAssignment.class,
                        // ... in the same timeslot ...
                        Joiners.equal(PermanenceAssignment::getPeriod),
                        // ... in the same room ...

                        Joiners.equal(PermanenceAssignment::getEmployee))
                        // ... and the pair is unique (different id, no reverse pairs) ...
                        //Joiners.lessThan(PermanenceAssignment::getDate))
                // ... then penalize each pair with a hard weight.
                .penalize("employee role conflict", HardSoftScore.ONE_HARD);
    }
/*
    //Contrainte qui permet de définir qu'un employé n'a pas plus de deux périodes de permanence consécutives
    private Constraint noMoreThanTwoConsecutivePermanence(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return null;
    }*/



}
