package ToDoList;

import ToDoList.Task;

import java.util.ArrayList;
import java.util.Iterator;
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
    // iterator 공부하고 적용해오기
    void printTasks()
    {
       /* for(int i = 0; i < tasks.size(); i++)
        {
            System.out.println((i+1) + ". " + tasks.get(i).getContent() + " " + tasks.get(i).getRegistrationTime());
        }
        */
        Iterator <Task> it = tasks.iterator();
        Iterator <Task> it1=tasks.iterator();
        int i=0;
       while(it.hasNext())
       {
           System.out.println((i+1)+"."+it.next().getContent()+" "+it1.next().getRegistrationTime());
           i++;
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
            // 1,2,3,4 이외에 다른 문자열을 입력했을 때 어떻게 처리할 것인지 완료
            // 다시 입력하세요 출력하고 select 메뉴로 돌아가도록  완료
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
    // IndexOutOfBounds Exception을 검색해서 예외처리 해오기 ( 왜 필요한지, 어떻게 해야하는지 ) try~catch~finally
    void updateTask()
    {
        // 이 부분도 addTask()처럼 화면 전환 자연스럽게 만들기 완료
        try {
            printTitle();
            printTasks();
            System.out.print("수정할 번호) ");
            int num = Integer.parseInt(scanner.nextLine()) - 1;

            System.out.print("▶) ");
            String content = scanner.nextLine();

            tasks.set(num, new Task(content));
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    /**
     * 할 일 삭제
     */
    // IndexOutOfBounds Exception을 검색해서 예외처리 해오기 ( 왜 필요한지, 어떻게 해야하는지 ) try~catch~finally
    void deleteTask()
    {
        // 이 부분도 addTask()처럼 화면 전환 자연스럽게 만들기  완료
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
