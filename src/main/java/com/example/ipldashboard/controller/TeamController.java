package com.example.ipldashboard.controller;

import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.repository.MatchRepository;
import com.example.ipldashboard.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;


    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
          Team team = teamRepository.findByTeamName(teamName);
        Pageable pageable = PageRequest.of(0,4);
          team.setMatches(matchRepository.findLatestMatchesByTeam(teamName,4));
          return team;
    }

    @GetMapping("/team/{teamName}/matches")
    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.matchRepository.getMatchesByTeamBetweenDates(
                teamName,
                startDate,
                endDate
        );
    }

    @GetMapping("/team")
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

}
