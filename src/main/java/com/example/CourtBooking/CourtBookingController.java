package com.example.CourtBooking;

import org.springframework.web.bind.annotation.*;

@RestController
public class CourtBookingController {

    private final int MAX_COURTS = 3;
    public Court[] tennisCourts = new Court[MAX_COURTS];

    public CourtBookingController() {
        for (int i=0; i<MAX_COURTS; i++)
        {
            tennisCourts[i] = new Court((short)i);
        }
    }

    @GetMapping("/booking")
    public String booking(@RequestParam(value = "court", defaultValue = "0") String strCourt) {
        int courtIndex = Integer.parseInt(strCourt);
        if (isFullyBooked())
            return "Sorry, no more courts available!";
        else
            return tennisCourts[courtIndex].addPlayer();
    }

    @GetMapping("/check")
    public String check(@RequestParam(value = "court", defaultValue = "0") String strCourt) {
        int courtIndex = Integer.parseInt(strCourt);
        return "No of players for Court "+courtIndex+" is "+tennisCourts[courtIndex].getNumPlayers();
    }

    private boolean isFullyBooked()
    {
        if (tennisCourts[0].isMaxPlayersReached() && tennisCourts[1].isMaxPlayersReached() && tennisCourts[2].isMaxPlayersReached())
        {
            return true;
        }
        return false;
    }
}
