/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ytu.yazilimmuhendisligi;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author omerhamidkamisli
 */
public class Employee {

    private String TC;
    private int projectId;
    private String name;
    private String surname;
    private String phone;
    private int type;
    private String address;
    private float salary;
    private int salaryType;
    private String begin;
    private String end;
    private int isWorking;
    private float compensation;

    public Employee() {
    }

    public Employee(String TC, int projectId, String name, String surname, String phone, int type, String address, float salary, int salaryType, String begin, String end, int isWorking, float compensation) {
        this.TC = TC;
        this.projectId = projectId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
        this.address = address;
        this.salary = salary;
        this.salaryType = salaryType;
        this.begin = begin;
        this.end = end;
        this.isWorking = isWorking;
        this.compensation = compensation;
    }

    public Employee(String TC, int projectId, String name, String surname, String phone, int type, String address, float salary, int salaryType, String begin, int isWorking, float compensation) {
        this.TC = TC;
        this.projectId = projectId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
        this.address = address;
        this.salary = salary;
        this.salaryType = salaryType;
        this.begin = begin;
        this.isWorking = isWorking;
        this.compensation = compensation;
    }

    public Employee(String TC, int projectId, String name, String surname, String phone, int type, String address, float salary, int salaryType, String begin, int isWorking) {
        this.TC = TC;
        this.projectId = projectId;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
        this.address = address;
        this.salary = salary;
        this.salaryType = salaryType;
        this.begin = begin;
        this.isWorking = isWorking;
    }

    public Employee(String TC, String name, String surname, String phone, int type, String address, float salary, int salaryType) {
        this.TC = TC;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.type = type;
        this.address = address;
        this.salary = salary;
        this.salaryType = salaryType;
        this.isWorking = 1;
        this.begin = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        this.compensation = 0;
        
    }


    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(int salaryType) {
        this.salaryType = salaryType;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(int isWorking) {
        this.isWorking = isWorking;
    }

    public float getCompensation() {
        return compensation;
    }

    public void setCompensation(float compensation) {
        this.compensation = compensation;
    }

    /**
     * Fire Employee
     * @author omerhamidkamisli
     * 
     */
    public void fire(){
        this.isWorking = 0;
        this.projectId = -1;
        this.end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        this.compensation = this.salary * 20;
    }

}
