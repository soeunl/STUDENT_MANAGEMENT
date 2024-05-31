package org.choongang.start.startmain.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.start.constants.StartMenu;
import org.choongang.start.startmain.StartMainRouter;

public class StartMainController extends AbstractController {

    @Override
    public void show() {
        System.out.println("메인템플릿 출력");//Templates.getInstance().render(StartMenu.STARTMAIN);
    }

    @Override
    public void prompt() {
        Router router = StartMainRouter.getInstance();
        try {
            router.change(StartMenu.STARTMAIN);
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }
}
