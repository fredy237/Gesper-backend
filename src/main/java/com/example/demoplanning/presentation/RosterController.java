package com.example.demoplanning.presentation;

import com.example.demoplanning.domain.Roster;
import org.optaplanner.core.api.solver.SolverJob;
import org.optaplanner.core.api.solver.SolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
@ComponentScan
@RestController
@RequestMapping("/roster")
@CrossOrigin("http://localhost:4200")
public class RosterController {
    @Autowired
    private SolverManager<Roster, UUID> solverManager;

    @PostMapping("/solve")
    public Roster solve(@RequestBody Roster problem) {
        UUID problemId = UUID.randomUUID();
        // Submit the problem to start solving
        SolverJob<Roster, UUID> solverJob = solverManager.solve(problemId, problem);
        Roster solution;
        try {
            // Wait until the solving ends
            solution = solverJob.getFinalBestSolution();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException("Solving failed.", e);
        }
        return solution;
    }
}
