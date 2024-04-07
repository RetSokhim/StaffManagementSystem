import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class Main {
    static int employeeID = 7;
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<StaffMember> staffMembers = new ArrayList<>();
    static CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.center);
    static String rest = "\u001B[0m";
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";

    public static void main(String[] args) {
        staffMembers.add(new Volunteer(1, "Nika", "Siem Reap", 150.0));
        staffMembers.add(new HourlySalaryEmployee(2, "Piseth", "Prey Veng", 10, 15.0));
        staffMembers.add(new SalariedEmployee(3, "Many", "Tbong Kmom", 1000, 250));
        staffMembers.add(new Volunteer(4, "Mary", "Takeo", 350.0));
        staffMembers.add(new HourlySalaryEmployee(5, "Andy", "Kompong Thom", 19, 15.0));
        staffMembers.add(new SalariedEmployee(6, "Mina", "Kompong Cham", 1300, 650));

        do {
            Table table = new Table(2, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
            table.setColumnWidth(0, 5, 5);
            table.setColumnWidth(1, 30, 45);

            table.addCell("STAFF MANAGEMENT SYSTEM", cellStyle, 2);
            table.addCell("1", cellStyle);
            table.addCell("Insert Employee", cellStyle);
            table.addCell("2", cellStyle);
            table.addCell("Update Employee", cellStyle);
            table.addCell("3", cellStyle);
            table.addCell("Display Employee", cellStyle);
            table.addCell("4", cellStyle);
            table.addCell("Remove Employee", cellStyle);
            table.addCell("5", cellStyle);
            table.addCell("Exit", cellStyle);
            System.out.println(table.render());
            System.out.println("-----------------------------------------------------------------------");
            String op;
            boolean check;
            do {
                System.out.print("=> Choose Option (1-5) :");
                op = scanner.next();
                check = op.matches("^[1-5]$");
                if (!check) {
                    System.out.println(red + "Please Input Valid Number !!" + rest);
                }
            } while (!check);
            int option = Integer.parseInt(op);
            switch (option) {
                case 1 -> insertEmployee();
                case 2 -> updateEmployee();
                case 3 -> display();
                case 4 -> removeEmployee();
                case 5 -> {
                    System.out.println("==============================================");
                    System.out.println("               Good Bye (> <)");
                    System.out.println("==============================================");
                    System.exit(0);
                }
//                default -> System.out.println(red+"Please Input Valid Number From 1 to 5"+rest);
            }
        } while (true);
    }

    private static void insertEmployee() {
        System.out.println("========================== Insert Employee ===============================");
        Table table = new Table(4, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        table.setColumnWidth(0, 30, 45);
        table.setColumnWidth(1, 30, 45);
        table.setColumnWidth(2, 30, 45);
        table.setColumnWidth(3, 30, 45);

        System.out.println("Choose Type : ");
        table.addCell("1. Volunteer ", cellStyle);
        table.addCell("2. Salaries Employee ", cellStyle);
        table.addCell("3. Hourly Employee ", cellStyle);
        table.addCell("4. Back ", cellStyle);
        System.out.println(table.render());
        boolean typeMatch;
        String type;
        scanner.nextLine();
        do {
            System.out.print("=> Enter Type Number : ");
            type = scanner.next();
            typeMatch = type.matches("^[1-4]+$");
            if (!typeMatch) {
                System.out.println(red + "Enter Valid Type !!" + rest);
            }
        } while (!typeMatch);
        int employeeType = Integer.parseInt(type);
        switch (employeeType) {
            case 1 -> {
                String volunteerName, volunteerAddress, vSalary;
                boolean check;
                scanner.nextLine();

                System.out.println("ID : " + employeeID);
                do {
                    System.out.print("Enter Name : ");
                    volunteerName = scanner.nextLine();
                    check = volunteerName.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Name !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Address : ");
                    volunteerAddress = scanner.nextLine();
                    check = volunteerAddress.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Address !!" + rest);
                    }
                } while (!check);

                do {
                    System.out.print("Enter Salary : ");
                    vSalary = scanner.nextLine();
                    check = vSalary.matches("^\\d+(\\.\\d+)?$");
                    if (!check) {
                        System.out.println(red + "Please Input Only Number !!" + rest);
                    }
                } while (!check);

                double volunteerSalary = Double.parseDouble(vSalary);
                Volunteer volunteer = new Volunteer(employeeID++, volunteerName, volunteerAddress, volunteerSalary);
                staffMembers.add(volunteer);
                System.out.println(green+"Volunteer Employee Inserted Successfully !!"+rest);
            }
            case 2 -> {
                String salaryEmployeeName, salaryEmployeeAddress, sSalary, sBonus;
                boolean check;
                scanner.nextLine();

                System.out.println("ID : " + employeeID);
                do {
                    System.out.print("Enter Name : ");
                    salaryEmployeeName = scanner.nextLine();
                    check = salaryEmployeeName.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Name !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Address : ");
                    salaryEmployeeAddress = scanner.nextLine();
                    check = salaryEmployeeAddress.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Address !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Salary : ");
                    sSalary = scanner.nextLine();
                    check = sSalary.matches("^[0-9.]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Salary !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Bonus : ");
                    sBonus = scanner.nextLine();
                    check = sBonus.matches("^[0-9.]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Bonus" + rest);
                    }
                } while (!check);
                double salaryEmployeeSalary = Double.parseDouble(sSalary);
                double salaryEmployeeBonus = Double.parseDouble(sBonus);
                SalariedEmployee salariedEmployee = new SalariedEmployee(employeeID++, salaryEmployeeName, salaryEmployeeAddress, salaryEmployeeSalary, salaryEmployeeBonus);
                staffMembers.add(salariedEmployee);
                System.out.println(green+"Salary Employee Inserted Successfully !!"+rest);
            }
            case 3 -> {
                String hourEmployeeName, hourEmployeeAddress, hHour, hRate;
                boolean check;
                scanner.nextLine();
                System.out.println("ID : " + employeeID);
                do {
                    System.out.print("Enter Name : ");
                    hourEmployeeName = scanner.nextLine();
                    check = hourEmployeeName.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Name !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Address : ");
                    hourEmployeeAddress = scanner.nextLine();
                    check = hourEmployeeName.matches("^[A-Z a-z]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Valid Address !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Hour : ");
                    hHour = scanner.nextLine();
                    check = hHour.matches("^[0-9]+$");
                    if (!check) {
                        System.out.println(red + "Please Input Number Only !!" + rest);
                    }
                } while (!check);
                do {
                    System.out.print("Enter Rate : ");
                    hRate = scanner.nextLine();
                    check = hRate.matches("^\\d+(\\.\\d+)?$");
                    if (!check) {
                        System.out.println(red + "Please Input Number Only !!" + rest);
                    }
                } while (!check);
                int hourEmployeeWork = Integer.parseInt(hHour);
                double hourSalaryEmployeeRate = Double.parseDouble(hRate);
                HourlySalaryEmployee hourlySalaryEmployee = new HourlySalaryEmployee(employeeID++, hourEmployeeName, hourEmployeeAddress, hourEmployeeWork, hourSalaryEmployeeRate);
                staffMembers.add(hourlySalaryEmployee);
                System.out.println(green+"Hourly Employee Inserted Successfully !!"+rest);
            }
            case 4 -> {
            }
//            default -> System.out.println(red+"Please input From number 1 to 4"+rest);
        }
        System.out.println("===============================================================================");
    }

    private static void display() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        int pageSize = 3;
        int totalPages = (int) Math.ceil((double) staffMembers.size() / pageSize);

        int currentPage = 1;
        boolean exit = false;
        do {
            System.out.println("===================== Display Employee ========================");

            Table table = getTable(9);
            table.setColumnWidth(7, 10, 15);
            table.setColumnWidth(8, 10, 15);

            table.addCell(" Type ", cellStyle);
            table.addCell(" ID ", cellStyle);
            table.addCell(" Name ", cellStyle);
            table.addCell(" Address ", cellStyle);
            table.addCell(" Salary ", cellStyle);
            table.addCell(" Bonus ", cellStyle);
            table.addCell(" Hour ", cellStyle);
            table.addCell(" Rate ", cellStyle);
            table.addCell(" Pay ", cellStyle);

            int startIndex = (currentPage - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, staffMembers.size());

            for (int i = startIndex; i < endIndex; i++) {
                StaffMember staff = staffMembers.get(i);
                if (staff instanceof Volunteer volunteer) {
                    table.addCell("Volunteer", cellStyle);
                    table.addCell(String.valueOf(volunteer.getVolunteerID()), cellStyle);
                    table.addCell(volunteer.name(), cellStyle);
                    table.addCell(volunteer.getAddress(), cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(volunteer.getSalary())), cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(volunteer.pay())), cellStyle);
                } else if (staff instanceof SalariedEmployee salariedEmployee) {
                    table.addCell("Salaried Employee", cellStyle);
                    table.addCell(String.valueOf(salariedEmployee.id), cellStyle);
                    table.addCell(salariedEmployee.name, cellStyle);
                    table.addCell(salariedEmployee.address, cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getSalary())), cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getBonus())), cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(salariedEmployee.pay())), cellStyle);
                } else if (staff instanceof HourlySalaryEmployee hourlyEmployee) {
                    table.addCell("Hourly Employee", cellStyle);
                    table.addCell(String.valueOf(hourlyEmployee.getHourlySalaryEmployeeID()), cellStyle);
                    table.addCell(hourlyEmployee.getName(), cellStyle);
                    table.addCell(hourlyEmployee.getAddress(), cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell("---", cellStyle);
                    table.addCell(String.valueOf(hourlyEmployee.getHourWorked()), cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(hourlyEmployee.getRate())), cellStyle);
                    table.addCell(String.valueOf(decimalFormat.format(hourlyEmployee.pay())), cellStyle);
                }
            }
            System.out.println(table.render());
            boolean check;
            String op;
            System.out.println("===============================================================================");
            System.out.println("Current Page : " + currentPage + "/" + totalPages);
            System.out.println("Options:");
            System.out.println("1. Next Page");
            System.out.println("2. Previous Page");
            System.out.println("3. Go to Last Page");
            System.out.println("4. Go to First Page");
            System.out.println("5. Exit");
            do {
                scanner.nextLine();
                System.out.print("=> Choose Option (1-5): ");
                op = scanner.next();
                check = op.matches("^[1-5]$");
                if (!check) {
                    System.out.println(red + "Please Input from 1 To 5" + rest);
                }
            } while (!check);
            int option = Integer.parseInt(op);
            switch (option) {
                case 1 -> {
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.out.println(red + "Already on the last page." + rest);
                    }
                }
                case 2 -> {
                    if (currentPage > 1) {
                        currentPage--;
                    } else {
                        System.out.println(red + "Already on the first page." + rest);
                    }
                }
                case 3 -> currentPage = totalPages;
                case 4 -> currentPage = 1;
                case 5 -> exit = true;
//                default -> System.out.println(red + "Invalid option. Please choose again." + rest);
            }
        } while (!exit);
    }

    private static void updateEmployee() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        String idUp;
        boolean check;
        do{
            scanner.nextLine();
            System.out.println("Enter or Search ID to Update : ");
            idUp = scanner.next();
            check = idUp.matches("^[0-9]+$");
            if(!check){
                System.out.println(red+"Please Input Valid ID"+rest);
            }
        }while (!check);
        int idToUpdate = Integer.parseInt(idUp);
        for (StaffMember staff : staffMembers) {
            if (staff.getId() == idToUpdate) {
                switch (staff) {
                    case Volunteer volunteer -> {
                        Table table1 = new Table(6, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
                        table1.setColumnWidth(0, 20, 25);
                        table1.setColumnWidth(1, 10, 15);
                        table1.setColumnWidth(2, 10, 15);
                        table1.setColumnWidth(3, 10, 15);
                        table1.setColumnWidth(4, 10, 15);
                        table1.setColumnWidth(5, 10, 15);

                        table1.addCell(" Type ", cellStyle);
                        table1.addCell(" ID ", cellStyle);
                        table1.addCell(" Name ", cellStyle);
                        table1.addCell(" Address ", cellStyle);
                        table1.addCell(" Salary ", cellStyle);
                        table1.addCell(" Pay ", cellStyle);
                        table1.addCell("Volunteer", cellStyle);
                        table1.addCell(String.valueOf(volunteer.id), cellStyle);
                        table1.addCell(volunteer.name, cellStyle);
                        table1.addCell(volunteer.address, cellStyle);
                        table1.addCell(String.valueOf(decimalFormat.format(volunteer.getSalary())), cellStyle);
                        table1.addCell(String.valueOf(decimalFormat.format(volunteer.pay())), cellStyle);
                        System.out.println(table1.render());
                        String vColUpdate;
                        do {
                            scanner.nextLine();
                            System.out.println("Select One Column to Update :");
                            System.out.println("1.Name \t\t 2.Address \t\t 3.Salary \t\t 0.Cancel");
                            System.out.print("=> Choose : ");
                            vColUpdate = scanner.next();
                            check = vColUpdate.matches("^[0-3]+$");
                            if (!check) {
                                System.out.println(red + "Please Input Number From 0 to 3" + rest);
                            }
                        } while (!check);
                        int vColumnUpdate = Integer.parseInt(vColUpdate);
                        switch (vColumnUpdate) {
                            case 0 -> {
                            }
                            case 1 -> {
                                String vUpdateName;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Name To Update : ");
                                    vUpdateName = scanner.nextLine();
                                    check = vUpdateName.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Name !!" + rest);
                                    }
                                } while (!check);
                                volunteer.setName(vUpdateName);
                                System.out.println(green+"Name Updated Successfully !!"+rest);
                            }
                            case 2 -> {
                                String vUpdateAddress;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Address To Update : ");
                                    vUpdateAddress = scanner.nextLine();
                                    check = vUpdateAddress.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Address !!" + rest);
                                    }
                                } while (!check);
                                volunteer.setAddress(vUpdateAddress);
                                System.out.println(green+"Address Updated Successfully !!"+rest);
                            }
                            case 3 -> {
                                String vUpSalary;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Salary To Update : ");
                                    vUpSalary = scanner.nextLine();
                                    check = vUpSalary.matches("^\\d+(\\.\\d+)?$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Number Only !!" + rest);
                                    }
                                } while (!check);
                                volunteer.setSalary(Double.parseDouble(vUpSalary));
                                System.out.println(green+"Salary Updated Successfully !!"+rest);
                            }
                        }
                    }
                    case SalariedEmployee salariedEmployee -> {
                        Table table2 = getTable(7);

                        table2.addCell(" Type ", cellStyle);
                        table2.addCell(" ID ", cellStyle);
                        table2.addCell(" Name ", cellStyle);
                        table2.addCell(" Address ", cellStyle);
                        table2.addCell(" Salary ", cellStyle);
                        table2.addCell(" Bonus ", cellStyle);
                        table2.addCell(" Pay ", cellStyle);
                        table2.addCell("Salaried Employee", cellStyle);
                        table2.addCell(String.valueOf(salariedEmployee.id), cellStyle);
                        table2.addCell(salariedEmployee.name, cellStyle);
                        table2.addCell(salariedEmployee.address, cellStyle);
                        table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getSalary())), cellStyle);
                        table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getBonus())), cellStyle);
                        table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.pay())), cellStyle);
                        System.out.println(table2.render());
                        String sColUpdate;
                        do {
                            scanner.nextLine();
                            System.out.println("Select One Column to Update :");
                            System.out.println("1.Name \t\t 2.Address \t\t 3.Salary \t\t 4.Bonus \t\t 0.Cancel");
                            System.out.print("=> Choose : ");
                            sColUpdate = scanner.next();
                            check = sColUpdate.matches("^[0-4]+$");
                            if (!check) {
                                System.out.println(red + "Please Input Number From 0 to 4" + rest);
                            }
                        } while (!check);
                        int sColumnUpdate = Integer.parseInt(sColUpdate);
                        switch (sColumnUpdate) {
                            case 0 -> {
                            }
                            case 1 -> {
                                String sUpdateName;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Name To Update : ");
                                    sUpdateName = scanner.nextLine();
                                    check = sUpdateName.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Name !!" + rest);
                                    }
                                } while (!check);
                                salariedEmployee.setName(sUpdateName);
                                System.out.println(green+"Name Updated Successfully !!"+rest);
                            }
                            case 2 -> {
                                String sUpdateAddress;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Address To Update : ");
                                    sUpdateAddress = scanner.nextLine();
                                    check = sUpdateAddress.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Address !!" + rest);
                                    }
                                } while (!check);
                                salariedEmployee.setAddress(sUpdateAddress);
                                System.out.println(green+"Address Updated Successfully !!"+rest);
                            }
                            case 3 -> {
                                String sUpSalary;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Salary To Update : ");
                                    sUpSalary = scanner.nextLine();
                                    check = sUpSalary.matches("^\\d+(\\.\\d+)?$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Number Only !!" + rest);
                                    }
                                } while (!check);
                                salariedEmployee.setSalary(Double.parseDouble(sUpSalary));
                                System.out.println(green+"Salary Updated Successfully !!"+rest);
                            }
                            case 4 -> {
                                String sUpBonus;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Bonus To Update : ");
                                    sUpBonus = scanner.nextLine();
                                    check = sUpBonus.matches("^\\d+(\\.\\d+)?$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Number Only !!" + rest);
                                    }
                                } while (!check);
                                salariedEmployee.setBonus(Double.parseDouble(sUpBonus));
                                System.out.println(green+"Bonus Updated Successfully !!"+rest);
                            }
                        }
                    }
                    case HourlySalaryEmployee hourlySalaryEmployee -> {
                        Table table3 = getTable(7);

                        table3.addCell(" Type ", cellStyle);
                        table3.addCell(" ID ", cellStyle);
                        table3.addCell(" Name ", cellStyle);
                        table3.addCell(" Address ", cellStyle);
                        table3.addCell(" Hour ", cellStyle);
                        table3.addCell(" Rate ", cellStyle);
                        table3.addCell(" Pay ", cellStyle);
                        table3.addCell("Hourly Employee", cellStyle);
                        table3.addCell(String.valueOf(hourlySalaryEmployee.id), cellStyle);
                        table3.addCell(hourlySalaryEmployee.name, cellStyle);
                        table3.addCell(hourlySalaryEmployee.address, cellStyle);
                        table3.addCell(String.valueOf(hourlySalaryEmployee.getHourWorked()), cellStyle);
                        table3.addCell(String.valueOf(decimalFormat.format(hourlySalaryEmployee.getRate())), cellStyle);
                        table3.addCell(String.valueOf(decimalFormat.format(hourlySalaryEmployee.pay())), cellStyle);
                        System.out.println(table3.render());
                        String hColUpdate;
                        do {
                            scanner.nextLine();
                            System.out.println("Select One Column to Update :");
                            System.out.println("1.Name \t\t 2.Address \t\t 3.Hour \t\t 4.Rate \t\t 0.Cancel");
                            System.out.print("=> Choose : ");
                            hColUpdate = scanner.next();
                            check = hColUpdate.matches("^[0-4]+$");
                            if (!check) {
                                System.out.println(red + "Please Input Number From 0 to 4" + rest);
                            }
                        } while (!check);
                        int hColumnUpdate = Integer.parseInt(hColUpdate);
                        switch (hColumnUpdate) {
                            case 0 -> {
                            }
                            case 1 -> {
                                String hUpdateName;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Name To Update : ");
                                    hUpdateName = scanner.nextLine();
                                    check = hUpdateName.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Name !!" + rest);
                                    }
                                } while (!check);
                                hourlySalaryEmployee.setName(hUpdateName);
                                System.out.println(green+"Name Updated Successfully !!"+rest);
                            }
                            case 2 -> {
                                String hUpdateAddress;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Address To Update : ");
                                    hUpdateAddress = scanner.nextLine();
                                    check = hUpdateAddress.matches("^[A-Z a-z]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Valid Address !!" + rest);
                                    }
                                } while (!check);
                                hourlySalaryEmployee.setAddress(hUpdateAddress);
                                System.out.println(green+"Address Updated Successfully !!"+rest);
                            }
                            case 3 -> {
                                String hUpHour;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Hour To Update : ");
                                    hUpHour = scanner.nextLine();
                                    check = hUpHour.matches("^[0-9]+$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Number Only !!" + rest);
                                    }
                                } while (!check);
                                hourlySalaryEmployee.setHourWorked(Integer.parseInt(hUpHour));
                                System.out.println(green+"Hour Updated Successfully !!"+rest);
                            }
                            case 4 -> {
                                String hUpRate;
                                scanner.nextLine();
                                do {
                                    System.out.println("Enter Rate To Update : ");
                                    hUpRate = scanner.nextLine();
                                    check = hUpRate.matches("^\\d+(\\.\\d+)?$");
                                    if (!check) {
                                        System.out.println(red + "Please Input Only Number" + rest);
                                    }
                                } while (!check);
                                hourlySalaryEmployee.setRate(Double.parseDouble(hUpRate));
                                System.out.println(green+"Rate Updated Successfully !!"+rest);
                            }
                        }
                    }
                    default -> {
                    }
                }
            }
        }
    }

    private static void removeEmployee() {
        DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
        Iterator<StaffMember> iterator = staffMembers.iterator();
        String idRemove;
        boolean check;
        do{
            scanner.nextLine();
            System.out.println("Enter ID to Remove : ");
            idRemove = scanner.next();
            check = idRemove.matches("^[0-9]+$");
            if(!check){
                System.out.println(red+"Please Input Valid ID !!"+rest);
            }
        }while (!check);
        int idToRemove = Integer.parseInt(idRemove);
        while (iterator.hasNext()) {
            StaffMember staff = iterator.next();
                if (staff.getId() == idToRemove) {
                    switch (staff) {
                        case Volunteer volunteer -> {
                            System.out.println("======================= Display Employee Before Removal =============================");
                            Table table1 = new Table(6, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
                            table1.setColumnWidth(0, 20, 25);
                            table1.setColumnWidth(1, 10, 15);
                            table1.setColumnWidth(2, 10, 15);
                            table1.setColumnWidth(3, 10, 15);
                            table1.setColumnWidth(4, 10, 15);
                            table1.setColumnWidth(5, 10, 15);

                            table1.addCell(" Type ", cellStyle);
                            table1.addCell(" ID ", cellStyle);
                            table1.addCell(" Name ", cellStyle);
                            table1.addCell(" Address ", cellStyle);
                            table1.addCell(" Salary ", cellStyle);
                            table1.addCell(" Pay ", cellStyle);
                            table1.addCell("Volunteer", cellStyle);
                            table1.addCell(String.valueOf(volunteer.id), cellStyle);
                            table1.addCell(volunteer.name, cellStyle);
                            table1.addCell(volunteer.address, cellStyle);
                            table1.addCell(String.valueOf(decimalFormat.format(volunteer.getSalary())), cellStyle);
                            table1.addCell(String.valueOf(decimalFormat.format(volunteer.pay())), cellStyle);
                            System.out.println(table1.render());
                            System.out.println("====================================================================================");
                        }
                        case SalariedEmployee salariedEmployee -> {
                            System.out.println("======================= Display Employee Before Removal ============================");
                            Table table2 = getTable(7);

                            table2.addCell(" Type ", cellStyle);
                            table2.addCell(" ID ", cellStyle);
                            table2.addCell(" Name ", cellStyle);
                            table2.addCell(" Address ", cellStyle);
                            table2.addCell(" Salary ", cellStyle);
                            table2.addCell(" Bonus ", cellStyle);
                            table2.addCell(" Pay ", cellStyle);
                            table2.addCell("Salaried Employee", cellStyle);
                            table2.addCell(String.valueOf(salariedEmployee.id), cellStyle);
                            table2.addCell(salariedEmployee.name, cellStyle);
                            table2.addCell(salariedEmployee.address, cellStyle);
                            table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getSalary())), cellStyle);
                            table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.getBonus())), cellStyle);
                            table2.addCell(String.valueOf(decimalFormat.format(salariedEmployee.pay())), cellStyle);
                            System.out.println(table2.render());
                            System.out.println("===================================================================================");
                        }
                        case HourlySalaryEmployee hourlySalaryEmployee -> {
                            System.out.println("======================= Display Employee Before Removal ============================");
                            Table table3 = getTable(7);

                            table3.addCell(" Type ", cellStyle);
                            table3.addCell(" ID ", cellStyle);
                            table3.addCell(" Name ", cellStyle);
                            table3.addCell(" Address ", cellStyle);
                            table3.addCell(" Hour ", cellStyle);
                            table3.addCell(" Rate ", cellStyle);
                            table3.addCell(" Pay ", cellStyle);
                            table3.addCell("Hourly Employee", cellStyle);
                            table3.addCell(String.valueOf(hourlySalaryEmployee.id), cellStyle);
                            table3.addCell(hourlySalaryEmployee.name, cellStyle);
                            table3.addCell(hourlySalaryEmployee.address, cellStyle);
                            table3.addCell(String.valueOf(hourlySalaryEmployee.getHourWorked()), cellStyle);
                            table3.addCell(String.valueOf(decimalFormat.format(hourlySalaryEmployee.getRate())), cellStyle);
                            table3.addCell(String.valueOf(decimalFormat.format(hourlySalaryEmployee.pay())), cellStyle);
                            System.out.println(table3.render());
                            System.out.println("=================================================================================");
                        }
                        default -> {
                        }
                    }
                    String confirm;
                    scanner.nextLine();
                    do {
                        System.out.print("Are You Sure Want To Remove This Employee ? (Y/N) : ");
                        confirm = scanner.nextLine();
                        check = confirm.matches("^[YyNn]$");
                        if (!check) {
                            System.out.println(red + "Please Input Only Y or N" + rest);
                        }
                    } while (!check);
                    if (confirm.equalsIgnoreCase("y")) {
                        iterator.remove();
                        System.out.println(green+"Employee with ID " + idToRemove + " removed successfully."+rest);
                        break;
                    }else if (confirm.equalsIgnoreCase("n")) {
                        System.out.println(red+"Removal Canceled !!"+rest);
                        break;
                    }
                }
            }
        }

    private static Table getTable(int totalColumns) {
        Table table2 = new Table(totalColumns, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        table2.setColumnWidth(0, 20, 25);
        table2.setColumnWidth(1, 5, 5);
        table2.setColumnWidth(2, 10, 15);
        table2.setColumnWidth(3, 10, 15);
        table2.setColumnWidth(4, 10, 15);
        table2.setColumnWidth(5, 10, 15);
        table2.setColumnWidth(6, 10, 15);
        return table2;
    }
}