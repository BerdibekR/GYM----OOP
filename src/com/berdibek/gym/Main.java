package com.berdibek.gym;

import com.berdibek.gym.menu.Menu;
import com.berdibek.gym.menu.MenuManager;

public class Main {
    public static void main(String[] args) {
        Menu menu = new MenuManager();
        menu.run();
    }
}