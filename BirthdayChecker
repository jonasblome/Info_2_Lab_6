import java.time.LocalDateTime;

public class BirthdayChecker {

    public static void main(String[] args) {
        BirthdayChecker birthdaychecker = new BirthdayChecker();
        birthdaychecker.checkAge(2001, 6, 14);
        birthdaychecker.checkAge(2001, 8, 4);
    }

    private JulianDate juliandate;
    private LocalDateTime today;
    private int birthDate;

    public BirthdayChecker() {
        juliandate = new JulianDate(0, 0, 0, 0, 0, 0);
    }

    public void checkAge(int year, int month, int day) {
        LocalDateTime birthJD = LocalDateTime.of(year, month, day, 0, 0, 0);
        today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        double age = juliandate.daysBetween(birthJD, today);
        birthDate = (int) new JulianDate(birthJD).getJD();
        System.out.println(age);
        if (age % 100 == 0) {
            System.out.println("Welcome to club 100!");
        }
        dayofBirth(birthDate);
        happyBirthday(birthJD);
    }
    
    public void dayofBirth(int birthDate) {
        if(birthDate % 7 == 0) {
            System.out.println("MONDAY");
        }else if(birthDate % 7 == 1) {
            System.out.println("TUESDAY");
        }else if(birthDate % 7 == 2) {
            System.out.println("WEDNESDAY");
        }else if(birthDate % 7 == 3) {
            System.out.println("THURSDAY");
        }else if(birthDate % 7 == 4) {
            System.out.println("FRIDAY");
        }else if(birthDate % 7 == 5) {
            System.out.println("SATUARDAY");
        }else if(birthDate % 7 == 6) {
            System.out.println("SUNDAY");
        }
    }

    public void happyBirthday(LocalDateTime birthJD) {
        System.out.println(birthJD.withYear(0).withHour(0).withMinute(0).withSecond(0).withNano(0));
        System.out.println(LocalDateTime.now().withYear(0).withHour(0).withMinute(0).withSecond(0).withNano(0));

        int birthDay = birthJD.getDayOfMonth();
        int birthMonth = birthJD.getMonthValue();

        if (birthDay == today.getDayOfMonth() && birthMonth == today.getMonthValue()) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("It is not your birthday today:(");
        }
    }
}
