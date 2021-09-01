import java.time.LocalDateTime;
import java.time.Month;

public class JulianDate {

    public static void main(String[] args) {
        JulianDate juliandate = new JulianDate(1, 1, 1, 0, 0, 0);
        System.out.println(juliandate.getJD());
        // System.out.println(juliandate.daysBetween(LocalDateTime.now(),
        // LocalDateTime.of(2029, Month.MAY, 14, 3, 50, 36)));
        System.out.println(juliandate.daysBetween(LocalDateTime.of(2021, Month.APRIL, 20, 18, 4, 23),
                LocalDateTime.of(2021, Month.MAY, 30, 18, 4, 23)));
        System.out.println(juliandate.tomorrow());
        System.out.println(juliandate.yesterday());
    }

    private double jd;

    public JulianDate(int year, int month, int day, int hours, int min, int sec) {
        setJD(year, month, day, hours, min, sec);
    }

    // addition for/during 2.
    public JulianDate(LocalDateTime bDate) {
        int year = bDate.getYear();
        int month = bDate.getMonth().getValue();
        int day = bDate.getDayOfMonth();
        int hour = bDate.getHour();
        int min = bDate.getMinute();
        int sec = bDate.getSecond();
        setJD(year, month, day, hour, min, sec);
    }

    // addition
    public double getJD() {
        return jd;
    }

    public void setJD(int year, int month, int day, int hours, int min, int sec) {
        jd = calculateJD(year, month, day, hours, min, sec);
    }

    // addition
    public double calculateJD(int year, int month, int day, int hours, int min, int sec) {
        int y;
        int m;
        if (month > 2) {
            y = year;
            m = month;
        } else {
            y = year - 1;
            m = month + 12;
        }
        int d = day;
        double b = 2 - Math.floor(y / 100.0) + Math.floor(y / 400.0);

        return jd = (Math.floor(365.25 * (y + 4716)) + Math.floor(30.6001 * (m + 1)) + d + b - 1524.5 + hours / 24
                + min / 1440 + sec / 86400) + 1;// Rundungsfehler, durch Umwandlung von double zu Integer, deshalb +1
    }

    public void getGD() {

        double z = Math.floor(jd + 0.5);
        double f = jd + 0.5 - z;

        double alpha = Math.floor((z - 1867216.25) / 36524.25);
        double a = z + 1 + alpha - Math.floor(alpha / 4);

        double b = a + 1524;
        double c = Math.floor((b - 122.1) / 365.25);
        double d = Math.floor(365.25 * c);
        double e = Math.floor((b - d) / 30.6001);

        double day = b - d - Math.floor(30.6001 * e) + f;
        double month;
        double year;
        if (e <= 13) {
            month = e - 1;
            year = c - 4716;
        } else {
            month = e - 13;
            year = c - 4715;
        }
        System.out.println(year + month + day);
    }

    public double daysBetween(LocalDateTime startDate, LocalDateTime endDate) {
        JulianDate sDate = new JulianDate(startDate);
        JulianDate eDate = new JulianDate(endDate);

        double cc = eDate.getJD();
        double ca = sDate.getJD();
        System.out.println(cc + "," + ca);
        return cc - ca;
    }

    public LocalDateTime tomorrow() {
        return LocalDateTime.now().plusDays(1);
    }

    public LocalDateTime yesterday() {
        return LocalDateTime.now().minusDays(1);
    }
}
