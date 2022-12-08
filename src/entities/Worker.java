
package entities;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;

import enums.WorkerLevel;

public class Worker {

  private String name;
  private WorkerLevel level;
  private Double baseSalary;

  private Department department;
  private List<HourContract> contracts = new ArrayList<>();

  public Worker() {
  }

  public Worker(final String name, final WorkerLevel level, final Double baseSalary, final Department department) {
    this.name = name;
    this.level = level;
    this.baseSalary = baseSalary;
    this.department = department;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public WorkerLevel getLevel() {
    return level;
  }

  public void setLevel(final WorkerLevel level) {
    this.level = level;
  }

  public Double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(final Double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(final Department department) {
    this.department = department;
  }

  public List<HourContract> getContracts() {
    return contracts;
  }

  public void addContract(final HourContract contract) {
    contracts.add(contract);
  }

  public void removeContract(HourContract contract) {
    contracts.remove(contract);
  }

  public double income(int year, int month) {
    double soma = baseSalary;
    Calendar cal = Calendar.getInstance();
    for (HourContract c : contracts) {
      cal.setTime(c.getDate());
      int c_year = cal.get(Calendar.YEAR);
      int c_month = 1 + cal.get(Calendar.MONTH);
      if (year == c_year && month == c_month) {
        soma += c.totalValue();
      }
    }
    return soma;
  }
}
