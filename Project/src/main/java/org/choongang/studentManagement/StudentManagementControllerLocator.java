package org.choongang.studentManagement;

import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.admin.controllers.StudentAdminController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.studentManagement.constants.StSMMenu;
import org.choongang.studentManagement.controllers.SelectStudentController;

public class StudentManagementControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private StudentManagementControllerLocator(){}

    public static ControllerLocator getInstance() {
        if(instance == null) {
            instance = new StudentManagementControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);
        if(controller != null) {
            return controller;
        }

        if(menu instanceof StSMMenu){
            StSMMenu stsmMenu = (StSMMenu) menu;
            switch(stsmMenu) {
                case STUDENTMAIN : controller = new SelectStudentController(); break; // 반 선택하기
                case BACK: controller = new AdminMainController(); break; // 뒤로 가기
            }
        }else {
            controller = new StudentAdminController();
        }
        return controller;
    }
}
