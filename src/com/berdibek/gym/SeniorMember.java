package com.berdibek.gym;

public class SeniorMember extends Member {

    private int retirementAge;
    private double healthDiscount;

    public SeniorMember(int id, String name, int age,
                        String type, int retirementAge,
                        double healthDiscount) {
        super(id, name, age, type);
        this.retirementAge = retirementAge;
        this.healthDiscount = healthDiscount;
    }

    @Override
    public void workout() {
        System.out.println("Senior member " + name +
                " is doing light health-care exercises.");
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