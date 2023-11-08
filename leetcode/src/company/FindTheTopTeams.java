package company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xxx
 *
 * @author tengxq
 */
public class FindTheTopTeams {

    public static void main(String[] args) {
        // case 1: 本人是团队负责人，并且审批下属团队
        List<Team> teams = Arrays.asList(
                new Team(1L, "0/1111"),
                new Team(2L, "0/1111/2222"),
                new Team(2L, "0/2222/3333/4444"),
                new Team(3L, "0/2222/3333"));
        System.out.println(Arrays.toString(findTopTeams(teams).toArray()));
    }

    public static List<Team> findTopTeams(List<Team> teams) {
        // 找出path最短的团队
        int pathLength = Integer.MAX_VALUE;
        for (Team team : teams) {
            if (team.getPath().length() < pathLength) {
                pathLength = team.getPath().length();
            }
        }
        //
        int finalPathLength = pathLength;
        List<Team> topTeams = teams.stream().filter(t -> t.getPath().length() == finalPathLength).collect(Collectors.toList());
        teams = teams.stream()
                .filter(t -> topTeams.stream().noneMatch(topTeam -> topTeam.getTeamId().equals(t.getTeamId())))
                .sorted(Comparator.comparingInt(a -> a.getPath().length()))
                .toList();
        for (Team team : teams) {
            boolean noneMatch = topTeams.stream().noneMatch(topTeam -> team.getPath().startsWith(topTeam.getPath()));
            if (noneMatch) {
                topTeams.add(team);
            }
        }
        return topTeams;
    }

    static class Team {
        private Long teamId;
        private String path;

        public Team(Long teamId, String path) {
            this.teamId = teamId;
            this.path = path;
        }

        public Long getTeamId() {
            return teamId;
        }

        public void setTeamId(Long teamId) {
            this.teamId = teamId;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "teamId=" + teamId +
                    ", path='" + path + '\'' +
                    '}';
        }
    }
}
