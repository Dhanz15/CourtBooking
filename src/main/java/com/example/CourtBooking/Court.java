package com.example.CourtBooking;

/*
 * Class object to store court no and number of players
 */
public class Court {

    private short courtNumber;
    private int numPlayers = 0;
    private final int MAX_PLAYER_PER_COURT = 4;

    public Court(short courtNumber)
    {
        this.courtNumber = courtNumber;
        this.numPlayers = 0;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public String addPlayer()
    {
        if (isMaxPlayersReached())
            return "Court "+courtNumber+" is fully booked";

        if (++numPlayers == MAX_PLAYER_PER_COURT)
            return "Game is on for Court "+courtNumber;
        else
            return "Player added to Court "+courtNumber;

    }

    public boolean isMaxPlayersReached()
    {
        return numPlayers == MAX_PLAYER_PER_COURT;
    }
}
