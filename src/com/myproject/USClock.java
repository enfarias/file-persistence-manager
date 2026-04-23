package com.myproject;

public non-sealed class USClock extends Clock {

    private String periodIndicator;

    public void setAfterMidday() {
        this.periodIndicator = "PM";
    }

    public void setBeforeMidday() {
        this.periodIndicator = "AM";
    }

    public void setHour(int hour) {
        setBeforeMidday();
        if ((hour > 12) && (hour <= 23)) {
            setAfterMidday();
            this.hour = hour - 12;
        } else if (hour >= 24) {
            this.hour = 0;
        } else {
            this.hour = hour;
        }
    }

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    @Override
    Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();
        switch (clock) {
            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
            }
            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }
        return this;

    }

    @Override
    public String getTime() {
        return super.getTime() + " " + periodIndicator;
    }
}
