package CalculationsTests;

//@author Sam Hildebrand

import java.util.ArrayList;
import java.util.Scanner;
import parkingappcalculations.Suggestion;
import parkingappcalculations.SuggestionCompilation;

public class SuggestionCompilationTester {

    public static void main(String args[]) {
        System.out.print("Enter Building to test for: ");
        Scanner scanner = new Scanner(System.in);
        String buildingName = scanner.next();
        SuggestionCompilation sg = new SuggestionCompilation(buildingName);
        ArrayList<Suggestion> suggestions = sg.getSuggestions();
        for (Suggestion suggestion : suggestions){
            System.out.println(suggestion.getLot().getName() + ", " + suggestion.getScore());
        }
    }
}
