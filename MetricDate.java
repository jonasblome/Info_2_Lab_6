import java.time.LocalDateTime;

public class MetricDate extends JulianDate {

    public MetricDate(int year, int month, int day, int hour, int min, int sec) {
        super(year, month, day, hour, min, sec);
    }

    public MetricDate(LocalDateTime now) {
        super(now);
    }

    int metricWeeks;
    int metricMonths;
    int metricYears;
    
    public static void main(String[] args) {
        MetricDate birthdJK = new MetricDate(2001, 6, 14, 0, 0, 0);
        MetricDate birthdJB = new MetricDate(2001, 8, 4, 0, 0, 0);
        MetricDate todayM = new MetricDate(LocalDateTime.now());
        todayM.calculateMetric();
        birthdJK.calculateMetric();
        birthdJB.calculateMetric();
        int ageJK = todayM.metricYears - birthdJK.metricYears;
        int ageJB = todayM.metricYears - birthdJB.metricYears;
        System.out.println(ageJK);
        System.out.println(ageJB);
    }
    
    public String calculateMetric() {
        int days = (int) getJD();
        metricYears = 0; 
        while(days >= 1000) {
            days = days - 1000;
            metricYears++;
        }
        metricMonths = 0;
        while(days >= 100) {
            days = days - 100;
            metricMonths++;
        }
        metricWeeks = 0;
        while(days >= 10) {
            days = days - 10;
            metricWeeks++;
        }
        return (metricYears + "-" + metricMonths + "-" + metricWeeks);
    }
    
    public int calculateMetricToJulian() {
        int jdYears = metricYears * 1000;
        int jdMonths = metricMonths * 100;
        int jdWeeks = metricWeeks * 10;
        return(jdYears + jdMonths + jdWeeks);
    }

}
