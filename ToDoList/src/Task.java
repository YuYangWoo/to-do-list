import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Task {
    private String content; // 할 일
    private String registrationTime; // 등록 시간

    // 사용자가 task를 추가할 경우
    public Task(String content)
    {
        this.content = content;
        this.registrationTime = convertDate();
    }

    // 관리자가 직접 사용할 경우
    public Task(String content, String registrationTime) {
        this.content = content;
        this.registrationTime = registrationTime;
    }

    // Getter, Setter
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
    public String getRegistrationTime() { return this.registrationTime; }
    public void setRegistrationTime(String registrationTime) { this.registrationTime = registrationTime; }

    /**
     * Date 클래스에서 현재 날짜를 받아서 String으로 반환
     * @return today 현재 날짜(yy/MM/dd)
     */
    private String convertDate() {
        // Date 클래스를 선언하고, 현재 날짜로 초기화
        // 이 정보를 String 형식으로 변환(19/01/01 처럼)
        // 변환된 String을 return  // 지금은 임의의 String 반환
        DateFormat dateformat = new SimpleDateFormat("yy/MM/dd");
        Date date = new Date();
        String today = dateformat.format(date);
        return today;
    }

    @Override
    public String toString() {
        return getContent() + " " + getRegistrationTime();
    }

}
