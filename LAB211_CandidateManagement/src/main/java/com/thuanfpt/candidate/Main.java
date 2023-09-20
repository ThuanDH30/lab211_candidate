/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thuanfpt.candidate;

import Controller.CandidateManager;
import View.Menu;

/**
 *
 * @author Bravo
 */
public class Main {

    public static void main(String[] args) {

        CandidateManager manager = new CandidateManager();
        Validation validation = new Validation();
        String[] options = {"Experience", "Fresher", "Internship", "Searching", "Exit"};
        Menu menu = new Menu("CANDIDATE MANAGEMENT SYSTEM", options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        manager.createCandidate(0);
                        break;
                    case 2:
                        manager.createCandidate(1);
                        break;
                    case 3:
                        manager.createCandidate(2);
                        break;
                    case 4:
                        manager.searchCandidate();
                        break;
                    case 5:
                        System.out.println("Exit");
                        break;
                }
            }
        };

        menu.run();
    }
}
