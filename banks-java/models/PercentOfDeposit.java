package models;

import java.util.*;

public class PercentOfDeposit
{
    public Map<Integer, Double> percents;
    public PercentOfDeposit() {

        percents = new HashMap<>();
    }

    public void addPercentAndSum(int sum, double percent)
    {
        percents.put(sum,percent);
    }
}
