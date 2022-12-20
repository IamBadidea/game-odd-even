package view;

import java.util.Scanner;

public class ViewConsole implements IView {
    @Override
    public void output(String string) {
        System.out.println(string);
    }

    @Override
    public String input() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
