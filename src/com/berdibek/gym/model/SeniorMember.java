package com.berdibek.gym.model;

import com.berdibek.gym.Discountable;
import com.berdibek.gym.exception.InvalidInputException;

public class SeniorMember extends Member implements Discountable {

    private int retirementAge;
    private double healthDiscount;

    public SeniorMember(int id, String name, int age, String type,
                        int retirementAge, double healthDiscount)
            throws InvalidInputException {

        super(id, name, age, type);
        setRetirementAge(retirementAge);
        setHealthDiscount(healthDiscount);
    }

    public void setRetirementAge(int retirementAge) throws InvalidInputException {
        if (retirementAge < 50 || retirementAge > 80)
            throw new InvalidInputException("Retirement age must be 50–80.");
        this.retirementAge = retirementAge;
    }

    public void setHealthDiscount(double healthDiscount) throws InvalidInputException {
        if (healthDiscount < 0 || healthDiscount > 100)
            throw new InvalidInputException("Discount must be 0–100.");
        this.healthDiscount = healthDiscount;
    }

    @Override
    public double getDiscount() {
        return healthDiscount;
    }

    @Override
    public void workout() {
        System.out.println("Senior " + name + " is doing light exercises.");
    }

    @Override
    public String getRole() {
        return "Senior Member";
    }
}