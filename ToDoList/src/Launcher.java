import java.util.ArrayList;
import java.util.Scanner;

public class Launcher
{
    private ArrayList<Task> tasks;
    private Scanner scanner;

    // 생성자 선언
    public Launcher()
    {
        tasks = new ArrayList<>(); // tasks 초기화
        scanner = new Scanner(System.in); // Scanner 초기화

        // 임시로 넣는 부분(나중에 파일 입출력 혹은 DB로 구현)
        // H2 DB를 연결하고(로컬DB),, 추가,수정,삭제 할때마다 DB에 반영하도록
        // 이 플젝 끝나고 뭐할지 아이디어 고민해오기
        tasks.add(new Task("빨래하기", "20/01/02"));
        tasks.add(new Task("샤워하기", "20/01/01"));
        tasks.add(new Task("운동하기", "19/12/27"));
    }

    /**
     * launcher 실행
     */
    public void start()
    {
        while(true)
        {
            printTitle();
            printTasks();
            selectMenu();
        }
    }

    /**
     * 콘솔 창 지우기 (임시 구현)
     */
    public void clear() {
        for(int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    /**
     * Title 출력
     */
    public void printTitle()
    {
        clear();
        System.out.println("[To Do List]");
    }

    /**
     * 등록된 할 일 출력
     */
    void printTasks()
    {
       for(int i = 0; i < tasks.size(); i++)
       {
           System.out.println((i+1) + ". " + tasks.get(i));
       }
    }

    /**
     * 메뉴 선택
     */
    void selectMenu()
    {
        System.out.println("(1)추가 (2)수정 (3)삭제 (4)종료");
        System.out.print("선택) ");
        String select = scanner.nextLine();

        if(select.equals("1"))
            addTask();
        else if(select.equals("2"))
            updateTask();
        else if(select.equals("3"))
            deleteTask();
        else if(select.equals("4"))
            System.exit(0);
        else {
            System.out.println("다시 입력하세요");
            selectMenu();
        }
    }

    /**
     * 할 일 추가
     */
    void addTask()
    {
        printTitle();
        printTasks();
        System.out.print("+) ");
        String newTask = scanner.nextLine();

        tasks.add(new Task(newTask));
    }

    /**
     * 할 일 수정
     */
    void updateTask()
    {
        try {
            printTitle();
            printTasks();
            System.out.print("수정할 번호) ");
            int num = Integer.parseInt(scanner.nextLine()) - 1;

            // 인덱스 범위 검사를 여기서 해야 됨

            System.out.print("▶) ");
            String content = scanner.nextLine();

            tasks.set(num, new Task(content));
        }
        catch(IndexOutOfBoundsException e) {
            // 올바르지 않은 번호입니다. 다시 입력해주세요.
        }
    }

    /**
     * 할 일 삭제
     */
    void deleteTask()
    {
        try {
            printTitle();
            printTasks();
            System.out.print("X) ");
            int num = Integer.parseInt(scanner.nextLine()) - 1;

            tasks.remove(num);
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

}