/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ytu.yazilimmuhendisligi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author omerhamidkamisli
 */
public class dbOP {

    private final String host;
    private final String userName;
    private final String password;
    private final Connection connection;

    /**
     * CONSTRUCTOR
     * @author omerhamidkamisli
     * @param host
     * @param userName
     * @param password
     * @throws java.sql.SQLException
     * 
     */
    public dbOP(String host, String userName, String password) throws SQLException {
        this.host = host;
        this.userName = userName;
        this.password = password;
        connection = DriverManager.getConnection(this.host, this.userName, this.password);
        if (connection != null) {
            System.out.println("Connection Complete");
        } else {
            System.out.println("Cannot connect DB ");
        }
    }

    /**
     *
     * CONSTRUCTOR
     * @author omerhamidkamisli
     * @throws java.sql.SQLException
     * 
     */
    public dbOP() throws SQLException {
        this.host = "jdbc:mysql://localhost/employee";
        this.userName = "root";
        this.password = "";
        connection = DriverManager.getConnection(this.host, this.userName, this.password);
        if (connection != null) {
            System.out.println("Connection Complete");
        } else {
            System.out.println("Cannot connect DB ");
        }
    }

    /**
     *
     * @author omerhamidkamisli
     * @throws java.sql.SQLException
     * @return ArrayList Employee
     *  
     */
    public ArrayList<Employee> getEmployees() throws SQLException {
        ArrayList<Employee> emp = new ArrayList<>();
        String query = "Select * From employees";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String TC = rs.getString("TC");
            String phone = rs.getString("phone");
            int salaryType = rs.getInt("salaryType");
            int isWorking = rs.getInt("isWorking");
            int type = rs.getInt("type");
            int projectID = rs.getInt("projectId");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String address = rs.getString("address");
            String begin = rs.getString("begin");
            String end = rs.getString("end");
            float salary = rs.getFloat("salary");
            float compensation = rs.getFloat("compensation");
            Employee tmp = new Employee(TC, projectID, name, surname, phone, type, address, salary, salaryType, begin, end, isWorking, compensation);
            emp.add(tmp);
        }

        return emp;
    }

    /**
     *
     * @author omerhamidkamisli
     * @param projectID
     * @return ArrayList Employee
     * @throws java.sql.SQLException
     */
    public ArrayList<Employee> getEmployees(int projectID) throws SQLException {
        ArrayList<Employee> emp = new ArrayList<>();
        String query = "Select * From employees where projectId = \"" + projectID + "\"";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String TC = rs.getString("TC");
            String phone = rs.getString("phone");
            int salaryType = rs.getInt("salaryType");
            int isWorking = rs.getInt("isWorking");
            int type = rs.getInt("type");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String address = rs.getString("address");
            String begin = rs.getString("begin");
            String end = rs.getString("end");
            float salary = rs.getFloat("salary");
            float compensation = rs.getFloat("compensation");
            Employee tmp = new Employee(TC, projectID, name, surname, phone, type, address, salary, salaryType, begin, end, isWorking, compensation);
            emp.add(tmp);
        }

        return emp;
    }

    /**
     *
     * @author omerhamidkamisli
     * @param TC
     * @return Employee
     * @throws java.sql.SQLException
     */
    public Employee getEmployee(String TC) throws SQLException {
        Employee emp = new Employee();
        emp.setTC(TC);
        String query = "Select * From employees where TC = \"" + TC + "\"";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            emp.setProjectId(rs.getInt("projectID"));
            emp.setPhone(rs.getString("phone"));
            emp.setSalary(rs.getInt("salaryType"));
            emp.setIsWorking(rs.getInt("isWorking"));
            emp.setType(rs.getInt("type"));
            emp.setName(rs.getString("name"));
            emp.setSurname(rs.getString("surname"));
            emp.setAddress(rs.getString("address"));
            emp.setBegin(rs.getString("begin"));
            emp.setEnd(rs.getString("end"));
            emp.setSalary(rs.getFloat("salary"));
            emp.setCompensation(rs.getFloat("compensation"));

        }

        return emp;
    }

    /**
     *
     * @author omerhamidkamisli
     * @param e:Employee
     * @return int result
     * @throws java.sql.SQLException
     */
    public int fireEmployee(Employee e) throws SQLException {
        e.fire();
        return updateEmployee(e);
    }

    /**
     *
     * @author omerhamidkamisli
     * @param e:Employee
     * @return int result
     * @throws java.sql.SQLException 
     */
    public int updateEmployee(Employee e) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE employees SET projectId = ?,name = ?,surname = ?,phone = ?, type = ?, address = ?,salary = ?, salaryType = ?, begin = ?, end = ?, isWorking = ?, compensation = ? WHERE TC = ?");

        update.setInt(1, e.getProjectId());
        update.setString(2, e.getName());
        update.setString(3, e.getSurname());
        update.setString(4, e.getPhone());
        update.setInt(5, e.getType());
        update.setString(6, e.getAddress());
        update.setFloat(7, e.getSalary());
        update.setInt(8, e.getSalaryType());
        update.setString(9, e.getBegin());
        update.setString(10, e.getEnd());
        update.setInt(11, e.getIsWorking());
        update.setFloat(12, e.getCompensation());
        update.setString(13, e.getTC());

        return update.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param e:Employee
     * @return int result
     * @throws java.sql.SQLException
     */
    public int addEmployee(Employee e) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("INSERT INTO employees(TC ,name ,surname,phone , type, address,salary ,salaryType ,isWorking ,begin, compensation) values(?,?,?,?,?,?,?,?,?,?,?)");
        insert.setString(1, e.getTC());
        insert.setString(2, e.getName());
        insert.setString(3, e.getSurname());
        insert.setString(4, e.getPhone());
        insert.setInt(5, e.getType());
        insert.setString(6, e.getAddress());
        insert.setFloat(7, e.getSalary());
        insert.setInt(8, e.getSalaryType());
        insert.setInt(9, 1);
        insert.setString(10, e.getBegin());
        insert.setFloat(11, e.getCompensation());

        return insert.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param e:Employee
     * @return int result
     * @throws java.sql.SQLException     
     */
    public int assignToProject(Employee e) throws SQLException {
        int pID = getProjectID(e.getType());
        if (pID != -1) {
            System.out.println(pID);
            e.setProjectId(pID);
            PreparedStatement update = connection.prepareStatement("UPDATE employees SET projectId = ? WHERE TC = ?");
            update.setInt(1, e.getProjectId());
            update.setString(2, e.getTC());
            if (update.executeUpdate() > 0) {
                return assignedProject(e);
            } else {
                return -1;
            }
        } else {
            fireEmployee(e);
            return -2;
        }
    }

    /**
     *
     * @author omerhamidkamisli
     * @param e:Employee
     * @return int result
     * @throws java.sql.SQLException     
     */
    private int assignedProject(Employee e) throws SQLException {
        String query = "SELECT * FROM projects WHERE projectID = " + e.getProjectId();
        e.toString();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        int cnt = 0;
        if (rs.next()) {

            switch (e.getType()) {
                case 0:
                    cnt = rs.getInt("managerCNT");
                    break;
                case 1:
                    cnt = rs.getInt("designerCNT");
                    break;
                case 2:
                    cnt = rs.getInt("developerCNT");
                    break;
                case 3:
                    cnt = rs.getInt("analystCNT");
                    break;
                case 4:
                    cnt = rs.getInt("testerCNT");
                    break;
            }

        }
        cnt++;
        PreparedStatement update = null;
        switch (e.getType()) {
            case 0:
                update = connection.prepareStatement("UPDATE projects SET managerCNT = ? WHERE projectID = ?");
                break;
            case 1:
                update = connection.prepareStatement("UPDATE projects SET designerCNT = ? WHERE projectID = ?");
                break;
            case 2:
                update = connection.prepareStatement("UPDATE projects SET developerCNT = ? WHERE projectID = ?");
                break;
            case 3:
                update = connection.prepareStatement("UPDATE projects SET analystCNT = ? WHERE projectID = ?");
                break;
            case 4:
                update = connection.prepareStatement("UPDATE projects SET testerCNT = ? WHERE projectID = ?");
                break;
        }
        update.setInt(1, cnt);
        update.setInt(2, e.getProjectId());

        return update.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param int type
     * @throws java.sql.SQLException 
     */
    private int getProjectID(int type) throws SQLException {
        int projectID = -1;
        String queryType1 = "SELECT projectId FROM projects WHERE managerCNT<managerMIN  AND projectStatus = 1";
        String queryType2 = "SELECT projectId FROM projects WHERE designerCNT<designerMIN  AND projectStatus = 1";
        String queryType3 = "SELECT projectId FROM projects WHERE developerCNT<developerMIN  AND projectStatus = 1";
        String queryType4 = "SELECT projectId FROM projects WHERE analystCNT<analystMIN  AND projectStatus = 1";
        String queryType5 = "SELECT projectId FROM projects WHERE testerCNT<testerMIN AND projectStatus = 1";
        String queryType6 = "SELECT projectId FROM projects WHERE managerCNT<managerMAX AND projectStatus = 1";
        String queryType7 = "SELECT projectId FROM projects WHERE designerCNT<designerMAX AND projectStatus = 1";
        String queryType8 = "SELECT projectId FROM projects WHERE developerCNT<developerMAX AND projectStatus = 1";
        String queryType9 = "SELECT projectId FROM projects WHERE analystCNT<analystMAX AND projectStatus = 1";
        String queryType10 = "SELECT projectId FROM projects WHERE testerCNT<testerMAX AND projectStatus = 1";
        ResultSet rs = null;
        Statement stmt = connection.createStatement();
        switch (type) {
            case 0:
                rs = stmt.executeQuery(queryType1);
                try{
                    rs.next();
                    projectID = rs.getInt("projectId");
                }catch(Exception e){
                    try{
                        rs = stmt.executeQuery(queryType6);
                    rs.next();
                    projectID = rs.getInt("projectId");
                    } catch(Exception t){
                        System.out.println("Project not found!");
                    }
                }
                break;
            case 1:
                rs = stmt.executeQuery(queryType2);
                try{
                     rs.next();
                projectID = rs.getInt("projectId");
                }catch(Exception e){
                    try{
                        rs = stmt.executeQuery(queryType7);
                    rs.next();
                    projectID = rs.getInt("projectId");
                    } catch(Exception t){
                        System.out.println("Project not found!");
                    }
                }
                break;
            case 2:
                rs = stmt.executeQuery(queryType3);
                try{
                    rs.next();
                    projectID = rs.getInt("projectId");
                }catch(Exception e){
                    try{
                        rs = stmt.executeQuery(queryType8);
                        rs.next();
                        projectID = rs.getInt("projectId");
                    } catch(Exception t){
                        System.out.println("Project not found!");
                    }
                }
                break;
            case 3:
                rs = stmt.executeQuery(queryType4);
                try{
                    rs.next();
                    projectID = rs.getInt("projectId");
                }catch(Exception e){
                    try{
                        rs = stmt.executeQuery(queryType9);
                        rs.next();
                        projectID = rs.getInt("projectId");
                    } catch(Exception t){
                        System.out.println("Project not found!");
                    }
                }
                break;
            case 4:
                rs = stmt.executeQuery(queryType5);
                try{
                    rs.next();
                    projectID = rs.getInt("projectId");
                }catch(Exception e){
                    try{
                        rs = stmt.executeQuery(queryType10);
                    rs.next();
                    projectID = rs.getInt("projectId");
                    } catch(Exception t){
                        System.out.println("Project not found!");
                    }
                }
                break;
            default:
                break;
        }
        System.out.println("Gelen projectID: "+ projectID);
        return projectID;
    }

    /**
     *
     * @author omerhamidkamisli
     * @param p:Project
     * @return int result
     * @throws java.sql.SQLException
     */
    public int addProject(Projects p) throws SQLException {
        PreparedStatement insert = connection.prepareStatement("INSERT INTO projects(projectName ,managerMIN ,managerMAX,managerCNT ,designerMIN,designerMAX ,designerCNT ,developerMIN ,developerMAX ,developerCNT ,analystMIN ,analystMAX ,analystCNT ,testerMIN ,testerMAX ,testerCNT ,projectStatus,begin) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        insert.setString(1, p.getProjectName());
        insert.setInt(2, p.getManagerMIN());
        insert.setInt(3, p.getManagerMAX());
        insert.setInt(4, p.getManagerCNT());
        insert.setInt(5, p.getDesignerMIN());
        insert.setInt(6, p.getDesignerMAX());
        insert.setInt(7, p.getDesignerCNT());
        insert.setInt(8, p.getDeveloperMIN());
        insert.setInt(9, p.getDeveloperMAX());
        insert.setInt(10, p.getDeveloperCNT());
        insert.setInt(11, p.getAnalystMIN());
        insert.setInt(12, p.getAnalystMAX());
        insert.setInt(13, p.getAnalystCNT());
        insert.setInt(14, p.getTesterMIN());
        insert.setInt(15, p.getTesterMAX());
        insert.setInt(16, p.getTesterCNT());
        insert.setInt(17, p.getProjectStatus());
        insert.setString(18, p.getBegin());

        return insert.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param p:Project
     * @return int result
     * @throws java.sql.SQLException     
     */
    public int updateProject(Projects p) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE projects SET projectName = ?,managerMIN = ?,managerMAX = ?, managerCNT = ?,designerMIN = ?, designerMAX = ?,designerCNT = ?,developerMIN = ?,developerMAX = ?,developerCNT = ?,analystMIN = ?,analystMAX = ?,analystCNT = ?,testerMIN = ?,testerMAX = ?,testerCNT = ? WHERE projectID = ?");

        update.setString(1, p.getProjectName());
        update.setInt(2, p.getManagerMIN());
        update.setInt(3, p.getManagerMAX());
        update.setInt(4, p.getManagerCNT());
        update.setInt(5, p.getDesignerMIN());
        update.setInt(6, p.getDesignerMAX());
        update.setInt(7, p.getDesignerCNT());
        update.setInt(8, p.getDeveloperMIN());
        update.setInt(9, p.getDeveloperMAX());
        update.setInt(10, p.getDeveloperCNT());
        update.setInt(11, p.getAnalystMIN());
        update.setInt(12, p.getAnalystMAX());
        update.setInt(13, p.getAnalystCNT());
        update.setInt(14, p.getTesterMIN());
        update.setInt(15, p.getTesterMAX());
        update.setInt(16, p.getTesterCNT());
        update.setInt(17, p.getProjectID());

        return update.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param p:Project
     * @return int result
     * @throws java.sql.SQLException     
     */
    public int finishProject(Projects p) throws SQLException {
        p.finishProject();
        //TODO project employee reasign
        ArrayList<Employee> eS = getEmployees(p.getProjectID());
        for (Employee e : eS) {
            assignToProject(e);
        }
        PreparedStatement update = connection.prepareStatement("UPDATE projects SET projectStatus = ?,end = ? WHERE projectId = ?");
        update.setInt(1, p.getProjectStatus());
        update.setString(2, p.getEnd());
        update.setInt(3, p.getProjectID());

        return update.executeUpdate();
    }

    /**
     *
     * @author omerhamidkamisli
     * @param projectID
     * @return int result
     * @throws java.sql.SQLException    
    */
    public Projects getProject(int projectID) throws SQLException {
        Projects p = new Projects();
        String query = "Select * From projects where projectID = \"" + projectID + "\"";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            p.setProjectID(rs.getInt("projectID"));
            p.setProjectName(rs.getString("projectName"));
            p.setManagerMIN(rs.getInt("managerMIN"));
            p.setManagerMAX(rs.getInt("managerMAX"));
            p.setManagerCNT(rs.getInt("managerCNT"));
            p.setDesignerMIN(rs.getInt("designerMIN"));
            p.setDesignerMAX(rs.getInt("designerMAX"));
            p.setDesignerCNT(rs.getInt("designerCNT"));
            p.setDeveloperMIN(rs.getInt("developerMIN"));
            p.setDeveloperMAX(rs.getInt("developerMAX"));
            p.setDeveloperCNT(rs.getInt("developerCNT"));
            p.setAnalystMIN(rs.getInt("analystMIN"));
            p.setAnalystMAX(rs.getInt("analystMAX"));
            p.setAnalystCNT(rs.getInt("analystCNT"));
            p.setTesterCNT(rs.getInt("testerCNT"));
            p.setTesterMIN(rs.getInt("testerMIN"));
            p.setTesterMAX(rs.getInt("testerMAX"));
            p.setBegin(rs.getString("begin"));
            p.setEnd(rs.getString("end"));
            p.setProjectStatus(rs.getInt("projectStatus"));
        }
        return p;
    }

    /**
     *
     * @author omerhamidkamisli
     * @return ArrayList Projects
     * @throws java.sql.SQLException
     */
    public ArrayList<Projects> getProjects() throws SQLException {
        ArrayList<Projects> pS = new ArrayList<>();
        String query = "Select * From projects";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Projects p = new Projects();
            p.setProjectID(rs.getInt("projectID"));
            p.setProjectName(rs.getString("projectName"));
            p.setManagerMIN(rs.getInt("managerMIN"));
            p.setManagerMAX(rs.getInt("managerMAX"));
            p.setManagerCNT(rs.getInt("managerCNT"));
            p.setDesignerMIN(rs.getInt("designerMIN"));
            p.setDesignerMAX(rs.getInt("designerMAX"));
            p.setDesignerCNT(rs.getInt("designerCNT"));
            p.setDeveloperMIN(rs.getInt("developerMIN"));
            p.setDeveloperMAX(rs.getInt("developerMAX"));
            p.setDeveloperCNT(rs.getInt("developerCNT"));
            p.setAnalystMIN(rs.getInt("analystMIN"));
            p.setAnalystMAX(rs.getInt("analystMAX"));
            p.setAnalystCNT(rs.getInt("analystCNT"));
            p.setTesterCNT(rs.getInt("testerCNT"));
            p.setTesterMIN(rs.getInt("testerMIN"));
            p.setTesterMAX(rs.getInt("testerMAX"));
            p.setBegin(rs.getString("begin"));
            p.setEnd(rs.getString("end"));
            p.setProjectStatus(rs.getInt("projectStatus"));
            pS.add(p);
        }
        return pS;
    }
}
