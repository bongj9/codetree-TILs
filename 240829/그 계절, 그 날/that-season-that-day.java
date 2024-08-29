import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int Y = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (isValidDate(Y, M, D)) {
            System.out.println(getSeason(M));
        } else {
            System.out.println(-1);
        }
    }

    public static boolean isValidDate(int year, int month, int day) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 윤년 체크
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; // 2월의 일수를 29일로 변경
        }

        // 유효한 날짜인지 확인
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > daysInMonth[month - 1]) {
            return false;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static String getSeason(int month) {
        if (month >= 3 && month <= 5) {
            return "Spring";
        } else if (month >= 6 && month <= 8) {
            return "Summer";
        } else if (month >= 9 && month <= 11) {
            return "Fall";
        } else {
            return "Winter";
        }
    }
}