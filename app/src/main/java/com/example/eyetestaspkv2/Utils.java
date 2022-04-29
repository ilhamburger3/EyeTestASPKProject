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
                "SAYA BUTUH 200 TRILIUN, MAU ANDA PATUNGAN? MAU?", "SAYA BUTUH 200 TRILIUN, MAU ANDA PATUNGAN? MAU?"+
                "\r\n Jam'an Nurkhatib Mansur (born December 19, 1976), better known as Yusuf Mansur, is a popular Indonesian Islamic preacher, writer, and businessman from Jakarta, as well as the principal of the pesantren boarding school Daarul Qur'an Ketapang in Tangerang." +
                "\r\n He is considered as among the many pop Islamic preachers who employ pop psychology and management theory to promote and propagate Islam (dawah) through self-help seminars and televangelism."));
        allEmployees.add(new Employee(4, "Jong-un", "https://live-production.wcms.abc-cdn.net.au/e4c9bfb3087bd447351428ef1bb88329?impolicy=wcms_crop_resize&cropH=485&cropW=862&xPos=0&yPos=0&width=862&height=485",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Joe Rohan", "https://variety.com/wp-content/uploads/2021/12/Joe-Rogan-Spotify.png",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Brian as.", "https://images.theconversation.com/files/311911/original/file-20200126-81357-1ysqznj.jpg?ixlib=rb-1.1.0&rect=0%2C50%2C1166%2C626&q=20&auto=format&w=320&fit=clip&dpr=2&usm=12&cs=strip",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Maggie", "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRJcJMxW3VcTd3c7dsggIzuVymTyRpW4zE1WDKs1sSvHABCD5wg",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Vincent Vega", "https://mir-s3-cdn-cf.behance.net/project_modules/disp/9c90da18945163.562d202b749c9.jpg",
                "this is the short description", "this is long desc"));
        allEmployees.add(new Employee(4, "Hans Landa", "https://static.wikia.nocookie.net/villains/images/1/11/HANSLANDA.jpg/revision/latest/top-crop/width/360/height/360?cb=20180926202456",
                "this is the short description", "this is long desc"));

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
