package edu.autocar.base;

import edu.autocar.base.menu.MenuBar;
import edu.autocar.base.util.Input;

public class Application {
	MenuBar mainMenu;
	
	public Application() {
		mainMenu = new MenuBar();
		createMenu(mainMenu);
	}	
	
	protected void createMenu(MenuBar menu) {
		
	}

	public void run() {
		while(true) {
			// 메뉴 출력
			mainMenu.print();
			String sel = Input.getString("선택:");			
			try {
				// 메뉴 실행
				mainMenu.execute(sel);
			} catch (Exception e) {
				System.out.println("잘못된 명령입니다.");
				e.printStackTrace();
			}
		}
	}
}
