package com.fatihbaser.footballapp.util

object Constant {
    const val BASE_URL = "https://api-football-v1.p.rapidapi.com/v2/"
    const val API_KEY = "x-rapidapi-key: b80858fa71msheeaa27763e9b5d9p1cde55jsnade66bb8b684"
    const val GET_LEAGUE_TABLE = "leagueTable/{league_id}"
    const val GET_TOP_SCORERS = "topscorers/{league_id}"
    const val GET_ALL_TEAMS_OF_LEAGUE = "teams/league/{league_id}"
    const val GET_ALL_PLAYERS_OF_TEAM = "players/squad/{team_id}/2019"
    const val GET_ALL_TRANSFERS_OF_TEAM = "transfers/team/{team_id}"
    const val GET_ALL_FIXTURE_OF_LEAGUE = "fixtures/league/{league_id}"
    const val GET_ALL_H2H_ITEMS = "fixtures/h2h/{home_team_id}/{away_team_id}"
    const val GET_FIXTURE_STATISTICS = "statistics/fixture/{fixture_id}"

    const val TEAM_ID = "team_id"
    const val FIXTURE_TEAM_IDS = "h2h_team_ids"
}