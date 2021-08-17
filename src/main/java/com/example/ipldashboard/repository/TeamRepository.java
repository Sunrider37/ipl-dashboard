package com.example.ipldashboard.repository;

import com.example.ipldashboard.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Long> {

    Team findByTeamName(String teamName);
}
