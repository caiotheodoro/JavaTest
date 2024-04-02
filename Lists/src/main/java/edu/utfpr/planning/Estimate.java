package edu.utfpr.planning;

public class Estimate {
    private Integer estimate;
    private String developer;

    public Estimate(String dev, int estimate) {
       this.estimate = estimate;
       this.developer = dev;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getEstimate() {
        return estimate;
    }

    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }
}
