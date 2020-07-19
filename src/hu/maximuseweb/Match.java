package hu.maximuseweb;

class Match {
    private String homeName;
    private String guestName;
    private int homePoints;
    private int guestPoints;
    private String venue;
    private String date;

    Match(String homeName, String guestName, int homePoints, int guestPoints, String venue, String date) {
        this.homeName = homeName;
        this.guestName = guestName;
        this.homePoints = homePoints;
        this.guestPoints = guestPoints;
        this.venue = venue;
        this.date = date;
    }

    String getHomeName() {
        return homeName;
    }

    String getGuestName() {
        return guestName;
    }

    int getHomePoints() {
        return homePoints;
    }

    int getGuestPoints() {
        return guestPoints;
    }

    String getVenue() {
        return venue;
    }

    String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeName='" + homeName + "'" +
                ", guestName='" + guestName + "'" +
                ", homePoints=" + homePoints +
                ", guestPoints=" + guestPoints +
                ", venue='" + venue + "'" +
                ", date='" + date + "'" +
                "}\n";
    }
}