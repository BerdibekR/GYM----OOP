package com.berdibek.gym;

public class SeniorMember extends Member {

    private int retirementAge;
    private double healthDiscount;

    public SeniorMember(int id, String name, int age, String type, int retirementAge, double healthDiscount) {
        super(id, name, age, type);
        setRetirementAge(retirementAge);
        setHealthDiscount(healthDiscount);
    }

    public void setRetirementAge(int retirementAge) {
        if (retirementAge >= 50 && retirementAge <= 80) {
            this.retirementAge = retirementAge;
        } else {
            System.out.println(" Retirement age must be between 50 and 80. Setting default = 60.");
            this.retirementAge = 60;
        }
    }

    public void setHealthDiscount(double healthDiscount) {
        if (healthDiscount >= 0 && healthDiscount <= 100) {
            this.healthDiscount = healthDiscount;
        } else {
            System.out.println(" Discount must be between 0 and 100%. Setting to 0%.");
            this.healthDiscount = 0;
        }
    }

    public int getRetirementAge() {
        return retirementAge;
    }

    public double getHealthDiscount() {
        return healthDiscount;
    }

    @Override
    public void workout() {
        System.out.println("Senior member " + name + " is doing light health-care exercises.");
    }

    @Override
    public String getRole() {
        return "Senior Member";
    }

    public boolean hasMedicalDiscount() {
        return healthDiscount > 0;
    }

    public boolean isRetired() {
        return age >= retirementAge;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Retirement Age: " + retirementAge +
                " | Health Discount: " + healthDiscount + "%";
    }
}