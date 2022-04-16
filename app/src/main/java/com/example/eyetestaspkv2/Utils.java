package com.example.eyetestaspkv2;

import java.util.ArrayList;

public class Utils {
    private static Utils instance;

    private static ArrayList<Employee> allEmployees;

    private Utils() {
        if (null == allEmployees){
            allEmployees = new ArrayList<>();
            initData();
        }
    }

    private void initData() {
        //TODO: add initial data
        allEmployees.add(new Employee(1, "James Bond", "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2022/01/27/2309444343.jpg",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(2, "Ana de Armas", "https://asset.kompas.com/crops/IzZtNkxmBvE8hxA4nbbAwI8s7-o=/0x20:840x580/750x500/data/photo/2021/01/19/6006c41ae4abf.jpg",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(3, "Abdu Rozik", "https://fameimpact.com/wp-content/uploads/2021/08/Abdu-Rozik-Singer-1.png",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Rangga Sasana", "https://assets.promediateknologi.com/crop/0x0:0x0/x/photo/2021/09/24/14976380.jpg",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(5, "Joseph Monsieur", "https://akcdn.detik.net.id/community/media/visual/2022/04/13/screenshot-youtube-paytren-official-6_43.jpeg?w=250&q=",
                "SAYA BUTUH 200 TRILIUN, MAU ANDA PATUNGAN? MAU?", "this is long desc"));
    }

    public static Utils getInstance() {
        if (null != instance){
            return instance;
        }else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Employee> getAllEmployees() {
        return allEmployees;
    }

    public Employee getEmployeeById(int id){
        for (Employee employee: allEmployees){
            if (employee.getId() == id){
                return employee;
            }
        }
        return null;
    }
}
