package mybatis;

import java.math.BigDecimal;
import java.util.Date;


public class Employee {
    int intId;

    @Override
    public String toString() {
        return "Employee{" +
                "intId=" + intId +
                ", strName='" + strName + '\'' +
                ", bdSalary=" + bdSalary +
                ", hireDate=" + hireDate +
                '}';
    }

    private String strName;
    private BigDecimal bdSalary;
    private Date hireDate;

    public Employee() {
    }

    public BigDecimal getBdSalary() {
        return bdSalary;
    }

    public void setBdSalary(BigDecimal bdSalary) {
        this.bdSalary = bdSalary;
    }

    public Employee(int intId, String strName, BigDecimal bdSalary) {
        this.intId = intId;
        this.strName = strName;
        this.bdSalary = bdSalary;
        this.hireDate = hireDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getIntId() {
        return intId;
    }

    public void setIntId(int intId) {
        this.intId = intId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

}
