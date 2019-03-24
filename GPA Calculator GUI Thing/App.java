public class App {
    public static void main(String[] args) {
        Student s1 = new Student("Iron", "Man");
        Student s2 = new Student("Black", "Widow");
        Student s3 = new Student("Captain", "America");
        Student s4 = new Student("Spider", "Man");
        
        MainFrame frame = new MainFrame(new Group("Avengers", s1, s2, s3, s4));
        frame.setSize(750,300);
        frame.setVisible(true);
    }
}