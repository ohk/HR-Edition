/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ytu.yazilimmuhendisligi;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omerhamidkamisli
 */
public class Projects {

    private int projectID;
    private String projectName;
    private int managerMIN;
    private int managerMAX;
    private int managerCNT;
    private int designerMIN;
    private int designerMAX;
    private int designerCNT;
    private int developerMIN;
    private int developerMAX;
    private int developerCNT;
    private int analystMIN;
    private int analystMAX;
    private int analystCNT;
    private int testerMIN;
    private int testerMAX;
    private int testerCNT;
    private int projectStatus;
    private String begin;
    private String end;

    public Projects() {
    }

    public Projects(int projectID, String projectName, int managerMIN, int managerMAX, int managerCNT, int designerMIN, int designerMAX, int designerCNT, int developerMIN, int developerMAX, int developerCNT, int analystMIN, int analystMAX, int analystCNT, int testerMIN, int testerMAX, int testerCNT, int projectStatus, String begin, String end) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.managerMIN = managerMIN;
        this.managerMAX = managerMAX;
        this.managerCNT = managerCNT;
        this.designerMIN = designerMIN;
        this.designerMAX = designerMAX;
        this.designerCNT = designerCNT;
        this.developerMIN = developerMIN;
        this.developerMAX = developerMAX;
        this.developerCNT = developerCNT;
        this.analystMIN = analystMIN;
        this.analystMAX = analystMAX;
        this.analystCNT = analystCNT;
        this.testerMIN = testerMIN;
        this.testerMAX = testerMAX;
        this.testerCNT = testerCNT;
        this.projectStatus = projectStatus;
        this.begin = begin;
        this.end = end;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Projects(String projectName, int managerMIN, int managerMAX, int designerMIN, int designerMAX, int developerMIN, int developerMAX, int analystMIN, int analystMAX, int testerMIN, int testerMAX) {
        this.projectName = projectName;
        this.managerMIN = managerMIN;
        this.managerMAX = managerMAX;
        this.designerMIN = designerMIN;
        this.designerMAX = designerMAX;
        this.developerMIN = developerMIN;
        this.developerMAX = developerMAX;
        this.analystMIN = analystMIN;
        this.analystMAX = analystMAX;
        this.testerMIN = testerMIN;
        this.testerMAX = testerMAX;
        
        this.begin = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
        this.managerCNT = 0;
        this.designerCNT = 0;
        this.developerCNT = 0;
        this.analystCNT = 0;
        this.testerCNT = 0;
        this.projectStatus = 1;
    }
    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getManagerMIN() {
        return managerMIN;
    }

    public void setManagerMIN(int managerMIN) {
        this.managerMIN = managerMIN;
    }

    public int getManagerMAX() {
        return managerMAX;
    }

    public void setManagerMAX(int managerMAX) {
        this.managerMAX = managerMAX;
    }

    public int getManagerCNT() {
        return managerCNT;
    }

    public void setManagerCNT(int managerCNT) {
        this.managerCNT = managerCNT;
    }

    public int getDesignerMIN() {
        return designerMIN;
    }

    public void setDesignerMIN(int designerMIN) {
        this.designerMIN = designerMIN;
    }

    public int getDesignerMAX() {
        return designerMAX;
    }

    public void setDesignerMAX(int designerMAX) {
        this.designerMAX = designerMAX;
    }

    public int getDesignerCNT() {
        return designerCNT;
    }

    public void setDesignerCNT(int designerCNT) {
        this.designerCNT = designerCNT;
    }

    public int getDeveloperMIN() {
        return developerMIN;
    }

    public void setDeveloperMIN(int developerMIN) {
        this.developerMIN = developerMIN;
    }

    public int getDeveloperMAX() {
        return developerMAX;
    }

    public void setDeveloperMAX(int developerMAX) {
        this.developerMAX = developerMAX;
    }

    public int getDeveloperCNT() {
        return developerCNT;
    }

    public void setDeveloperCNT(int developerCNT) {
        this.developerCNT = developerCNT;
    }

    public int getAnalystMIN() {
        return analystMIN;
    }

    public void setAnalystMIN(int analystMIN) {
        this.analystMIN = analystMIN;
    }

    public int getAnalystMAX() {
        return analystMAX;
    }

    public void setAnalystMAX(int analystMAX) {
        this.analystMAX = analystMAX;
    }

    public int getAnalystCNT() {
        return analystCNT;
    }

    public void setAnalystCNT(int analystCNT) {
        this.analystCNT = analystCNT;
    }

    public int getTesterMIN() {
        return testerMIN;
    }

    public void setTesterMIN(int testerMIN) {
        this.testerMIN = testerMIN;
    }

    public int getTesterMAX() {
        return testerMAX;
    }

    public void setTesterMAX(int testerMAX) {
        this.testerMAX = testerMAX;
    }

    public int getTesterCNT() {
        return testerCNT;
    }

    public void setTesterCNT(int testerCNT) {
        this.testerCNT = testerCNT;
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
    /**
     * Finish Project Details
     * @author omerhamidkamisli
     * 
     */
    public void finishProject(){
        projectStatus = 0;
        end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
    }
    
}
