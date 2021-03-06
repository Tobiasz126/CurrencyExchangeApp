package com.example.demo.models;

public class Rate
{
    private String no;
    private String effectiveDate;
    private String mid;

    public Rate(String no, String effectiveDate, String mid)
    {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public Rate()
    {

    }

    public String getNo()
    {
        return no;
    }

    public void setNo(String no)
    {
        this.no = no;
    }

    public String getEffectiveDate()
    {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate)
    {
        this.effectiveDate = effectiveDate;
    }

    public String getMid()
    {
        return mid;
    }

    public void setMid(String mid)
    {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return mid;
    }
}