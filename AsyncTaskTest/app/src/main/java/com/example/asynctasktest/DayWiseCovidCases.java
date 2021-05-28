package com.example.asynctasktest;

public class DayWiseCovidCases {
    String date,confirmedcases,activecases,recovered,deaths;

    public DayWiseCovidCases(String date, String confirmedcases, String activecases, String recovered, String deaths) {
        this.date = date;
        this.confirmedcases = confirmedcases;
        this.activecases = activecases;
        this.recovered = recovered;
        this.deaths = deaths;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConfirmedcases() {
        return confirmedcases;
    }

    public void setConfirmedcases(String confirmedcases) {
        this.confirmedcases = confirmedcases;
    }

    public String getActivecases() {
        return activecases;
    }

    public void setActivecases(String activecases) {
        this.activecases = activecases;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
