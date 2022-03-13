package ca.cal;

import ca.cal.persistence.ClientDaoJpa;
import ca.cal.persistence.DocumentDao;
import ca.cal.service.AdminService;

public class Main {
    public static void main(String[] args) {

        AdminService adminService = new AdminService(new ClientDaoJpa(), new DocumentDao());

        adminService.createClient("francois");
        System.out.println(adminService.findClient("francois"));

        adminService.createDocument("livre");
        System.out.println(adminService.findDocument("livre"));



    }
}
