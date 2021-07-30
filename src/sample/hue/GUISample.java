package src.sample.hue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUISample {
	// Hueの数
	public static final int HUE_NUM = 3;

	// IPアドレス
	private static final String address = "192.168.1.26";
	private static final String username = "bdgiXxlcWWgUr2go9YhQzc8JIXJMGt3saEAJB9Kq";

	public static final int OFFSET = 10;
	public static final int PANEL_WIDTH = 200;
	public static final int PANEL_HEIGHT = 380;
	public static final int MAIN_WIDTH = PANEL_WIDTH * HUE_NUM + OFFSET * (HUE_NUM + 2);
	public static final int MAIN_HEIGHT = PANEL_HEIGHT + OFFSET * 2;

	private static Hue[] hue = new Hue[HUE_NUM];

	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setBounds(10, 10, MAIN_WIDTH, MAIN_HEIGHT);

		for(int n = 0; n < 3; n++){
			ConfigPanel cp = new ConfigPanel();
			cp.setLayout(null);

			/////////////////////////////////////////////////////////////////////////////
			//
			// [1]: コンストラクタにIPアドレス、ユーザーネーム、Hueの番号を割り当てる
			//
			/////////////////////////////////////////////////////////////////////////////
			hue[n] = new Hue(address, username, n + 1);
			cp.setBackground(Color.LIGHT_GRAY);
			cp.setBounds(OFFSET * (n + 1) + n * PANEL_WIDTH, OFFSET, PANEL_WIDTH, PANEL_HEIGHT);
			cp.init(hue[n]);
			frame.add(cp);
		}

		frame.setVisible(true);
	}
}

class ConfigPanel extends JPanel{
	private Hue hue;

	private JLabel numLabel = new JLabel("num");
	private JToggleButton toggleBtn = new JToggleButton();
	private JSlider hueSlider = new JSlider(0, Hue.MAX_HUE, 0);
	private JSlider satSlider = new JSlider(0, 255, 255);
	private JSlider briSlider = new JSlider(0, 255, 255);
	private JButton sendBtn = new JButton("send");

	public void init(Hue hue){
		this.hue = hue;

		numLabel.setText(String.valueOf(hue.getNum()));
		numLabel.setBounds(10, 10, 30, 30);
		this.add(numLabel);

		toggleBtn.setBounds(50, 10, 100, 30);
		toggleBtn.setText("OFF");
		toggleBtn.addChangeListener(new MyChangeListener());
		this.add(toggleBtn);

		JLabel hueLabel = new JLabel("Hue");
		hueLabel.setBounds(30, 50, 30, 20);
		this.add(hueLabel);
		hueSlider.setOrientation(JSlider.VERTICAL);
		hueSlider.setBounds(30, 70, 20, 200);
		this.add(hueSlider);

		JLabel satLabel = new JLabel("Sat");
		satLabel.setBounds(90, 50, 30, 20);
		this.add(satLabel);
		satSlider.setOrientation(JSlider.VERTICAL);
		satSlider.setBounds(90, 70, 20, 200);
		this.add(satSlider);


		JLabel briLabel = new JLabel("Bri");
		briLabel.setBounds(150, 50, 30, 20);
		this.add(briLabel);
		briSlider.setOrientation(JSlider.VERTICAL);
		briSlider.setBounds(150, 70, 20, 200);
		this.add(briSlider);

		sendBtn.setBounds(20, 300, 160, 30);
		sendBtn.addActionListener(new MyButtonListener());
		this.add(sendBtn);
	}

	class MyButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() ==  sendBtn){

				/////////////////////////////////
				//
				// [2]: Hueに値をセットする
				//
				/////////////////////////////////
				hue.newState();
				hue.setOn(toggleBtn.isSelected());
				hue.setHue(hueSlider.getValue());
				hue.setSat(satSlider.getValue());
				hue.setBri(briSlider.getValue());

				printHueData(hue);


				/////////////////////////////////
				//
				// [3]: セットしたデータを送信する
				//
				/////////////////////////////////
				hue.sendData();
			}
		}
	}

	class MyChangeListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			JToggleButton changeToggle = (JToggleButton) e.getSource();
			if(changeToggle.isSelected()){
				changeToggle.setText("ON");
			}else{
				changeToggle.setText("OFF");
			}
		}
	}

	private void printHueData(Hue hue){
		//System.out.println("[" + hue.getNum() +"]");
		//System.out.println("ON: " + hue.getOn());
		//System.out.println("Hue: " + hue.getHue());
		//System.out.println("Sat: " + hue.getSat());
		//System.out.println("Bri: " + hue.getBri());
	}
}