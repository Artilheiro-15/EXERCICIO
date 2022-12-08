
import enums.WorkerLevel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Department;
import entities.HourContract;
import entities.Worker;

public class App {
    public static void main(String[] args) throws Exception {


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("===============================");
        System.out.print("Digite o Nome do Departamento: ");
        String departmentName = sc.nextLine();
    
        System.out.println("Insira os Dados do Trabalhador: ");
        System.out.print("Nome: ");
        String workerName = sc.nextLine();
        System.out.print("Nível: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salário Base: ");
        double baseSalary = sc.nextDouble();
        System.out.println("===============================");
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary,
            new Department(departmentName));
    
        System.out.print("Quantos Contratos Para Este Trabalhador? ");
        int n = sc.nextInt();
    
        for (int i = 1; i <= n; i++) {
          System.out.println("Insira os Dados do #" + i + " Contrato");
          System.out.print("Data (DD/MM/AAAA): ");
          Date contractDate = sdf.parse(sc.next());
          System.out.print("Valor Por Hora: ");
          double valuePerHour = sc.nextDouble();
          System.out.print("Duração do Contrato (horas): ");
          int hours = sc.nextInt();
          System.out.println("===============================");
          HourContract contract = new HourContract(contractDate, valuePerHour, hours);
          worker.addContract(contract);
    
        }
        System.out.println("===============================");
        System.out.print("Digite o Mês e o Ano Para Calcular o Rendimento (MM/AAAA): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartment().getName());
        System.out.println("Renda de: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    
        sc.close();
    
      }
    }
