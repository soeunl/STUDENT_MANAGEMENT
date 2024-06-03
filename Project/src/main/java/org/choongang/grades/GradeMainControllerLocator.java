package org.choongang.grades;

import org.choongang.admin.adminmain.controllers.AdminMainController;
import org.choongang.global.AbstractControllerLocator;
import org.choongang.global.Controller;
import org.choongang.global.ControllerLocator;
import org.choongang.global.Menu;
import org.choongang.grades.constants.GradeMenu;
import org.choongang.grades.controllers.GSelectController;
<<<<<<< HEAD:Project/src/main/java/org/choongang/grades/GradeMainControllerLocator.java
import org.choongang.start.startmain.controllers.StartMainController;
=======
>>>>>>> 873a9edb4eeb6a9232874524515af18ccdf43d8c:Project/src/main/java/org/choongang/grades/GradeAdminControllerLocator.java

public class GradeMainControllerLocator extends AbstractControllerLocator {
    private static ControllerLocator instance;

    private GradeMainControllerLocator(){}

    public static ControllerLocator getInstance(){
        if(instance == null){
            instance = new GradeMainControllerLocator();
        }
        return instance;
    }

    @Override
    public Controller find(Menu menu) {
        Controller controller = controllers.get(menu);

        if(controller != null){
            return controller;
        }

        if(menu instanceof GradeMenu){
            GradeMenu gradeMenu = (GradeMenu) menu;
            switch (gradeMenu){
                case CLASSCHOICE: controller = new GSelectController(); break;
                case BACK: controller = new AdminMainController(); break;
            }
        } else {
            controller = new StartMainController();
        }
        controller.setMenu(menu);
        controllers.put(menu,controller);
        return controller;
    }
}
