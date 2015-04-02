/*______________________________*/
/**
 * 
 */
package Control;

/**
 * @author qfdk
 * Cree le 2015年4月1日
 */
import javax.swing.*;

import View.MaFenetre;

import java.awt.*;
import java.net.*;

public class Lancer extends JWindow implements Runnable {
	Thread splashThread; // 进度条更新线程
	JProgressBar progress; // 进度条

	public Lancer() {
		Container container = getContentPane(); // 得到容器
//		container.setLayout(new GridLayout(2, 1));
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // 设置光标
		URL url = getClass().getResource("images/logo.png"); // 图片的位置
		if (url != null) {
			JLabel lb=new JLabel(new ImageIcon(url));
			lb.setBackground(new Color(000, true));
			container.add(lb,BorderLayout.CENTER); // 增加图片
		}
		progress = new JProgressBar(1, 100); // 实例化进度条
		progress.setStringPainted(true); // 描绘文字
		progress.setString("Loading ......"); // 设置显示文字
//		progress.setBackground(Color.green); // 设置背景色
		container.add(progress,BorderLayout.SOUTH); // 增加进度条到容器上
		Dimension screen = getToolkit().getScreenSize(); // 得到屏幕尺寸
		pack(); // 窗口适应组件尺寸
		setLocation((screen.width - getSize().width) / 2,
				(screen.height - getSize().height) / 2); // 设置窗口位置
	}

	public void start() {
		this.toFront(); // 窗口前端显示
		splashThread = new Thread(this); // 实例化线程
		splashThread.start(); // 开始运行线程
	}

	public void run() {
		setVisible(true); // 显示窗口
		try {
			for (int i = 0; i < 100; i++) {
				Thread.sleep(10); // 线程休眠
				progress.setValue(progress.getValue() + 1); // 设置进度条值
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		dispose(); // 释放窗口
		showFrame(); // 运行主程序
	}

	static void showFrame() {
		MaFenetre f=new MaFenetre("Gestion d'emploi du temps (ESIR)");
		f.setVisible(true);
		f.setSize(750, 500);
		f.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		Lancer splash = new Lancer();
		splash.start(); // 运行启动界面
	}
}

	    			

/*______________________________*/
/*___________FIN_______________*/
/*______________________________*/