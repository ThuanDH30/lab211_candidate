/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import com.thuanfpt.candidate.Validation;
import java.util.ArrayList;
import java.util.Calendar;
/**
 *
 * @author Bravo
 */
public class CandidateManager {
    ArrayList<Candidate> candidates = new ArrayList<>();
    Validation validation = new Validation();
    
    public void createCandidate(int type) {
        while (true) {
            String id;
            while (true) {
                id = validation.inputString("Enter ID: ", "[A-Za-z0-9\\s]+");
                if (validation.checkIdExist(candidates, id)) {
                    break;
                } else {
                    System.out.println("ID is existed");
                }
            }
            String firstName = validation.inputString("Enter first name: ", "[A-Za-z\\s]+");
            String lastName = validation.inputString("Enter last name: ", "[A-Za-z\\s]+");
            int birthDate = validation.inputInt("Enter bithdate: ", 1900,Calendar.getInstance().get(Calendar.YEAR));
            String address = validation.inputString("Enter address: ", ".+");
            String phone = validation.inputPhoneNumber("Enter phone number: ");
            String email = validation.inputEmail("Enter email: ");
            switch (type) {
                case 0:
                    int yearExperience = validation.inputInt("Enter year of experience:", 0, 100);
                    String professionalSkill = validation.inputString("Enter professional skill:", ".+");
                    candidates.add(new Experience(yearExperience, professionalSkill, id, firstName, lastName, birthDate, address, phone, email, 0));
                    break;
                case 1:
                    String graduationDate = validation.inputDate("Enter graduation date:");
                    System.out.print("Enter graduation rank: ");
                    String graduationRank = validation.checkInputGraduationRank();
                    candidates.add(new Fresher(graduationDate, graduationRank, id, firstName, lastName, birthDate, address, phone, email, 1));
                    break;
                case 2:
                    String major = validation.inputString("Enter major:", ".+");
                    String semester = validation.inputString("Enter major:", ".+");
                    String university = validation.inputString("Enter university:", ".+");
                    candidates.add(new Intern(major, semester, university, id, firstName, lastName, birthDate, address, phone, email, 2));
                    break;
            }
            System.out.print("Do you want to continue (Y/N): ");
            if (!validation.checkInputYN()) {
                break;
            }
        }
    }
    public void searchCandidate() {
        printListNameCandidate();
        String nameSearch = validation.inputString("Enter andidate name (First name or Last name): ", ".+");
        int typeCandidate = validation.inputInt("Enter type of candidate: ", 0, 2);
        int count = 0;
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("not found");
        }
    }
    public void printListNameCandidate() {
        int countExperience = 0;
        int countFresher = 0;
        int countIntern = 0;
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                countExperience++;
                if (countExperience == 1) {
                    System.out.println("Experience Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
            if (candidate instanceof Fresher) {
                countFresher++;
                if (countFresher == 1) {
                    System.out.println("Fresher Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
            if (candidate instanceof Intern) {
                countIntern++;
                if (countIntern == 1) {
                    System.out.println("Internship Candidate");
                }
                System.out.println(candidate.getFirstName() + " "
                        + candidate.getLastName());
            }
        }
    }
}
