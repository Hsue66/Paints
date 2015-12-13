
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;


public class GraphicsEdit extends JFrame implements ActionListener{
	static DrawingPanel painter;
	static ToolPanel tool;
	JMenuBar menuBar;
	JMenu file;
	JMenu etc;
	JMenuItem fNew, fOpen, fSave, fExit, help, maker;
	
	static boolean New = false;
	
	public static void main(String[] args){
		GraphicsEdit editor = new GraphicsEdit();
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();	// 스크린의 Size를 저장한다.
		editor.setDefaultCloseOperation(EXIT_ON_CLOSE);
		editor.setSize(1000,800);	// 화면크기 설정
		editor.setLocation(screenSize.width/2 - 500, screenSize.height/2-400);	// 화면 중앙에오도록 설정
		editor.setVisible(true);
		
	}
	
	public GraphicsEdit(){
		super("Graphics Editor");
		/* painter  : 여러 기능들을 그려주는 객체 
		 * tool		: 여러 기능들을 사용하기위한 객체
		 * colors	: 색관련 객체 */
		painter = new DrawingPanel();
		ToolPanel tool = new ToolPanel();
		ColorPanel colors = new ColorPanel();
		painter.setBackground(Color.WHITE);
		
	/* Menu를 만들기위해 memuBar 객체를 생성하고 하위 Item들을 Add 해준다. */
		menuBar = new JMenuBar();
		file = new JMenu("파일(F)");
		file.setMnemonic('F');
		
		fNew = new JMenuItem("새로만들기(N)",new ImageIcon("image/새로만들기.jpg"));
		fNew.setMnemonic('N');
		fNew.addActionListener(this);
		file.add(fNew);
		
		fOpen = new JMenuItem("열기(O)",new ImageIcon("image/열기.jpg"));
		fOpen.setMnemonic('O');
		fOpen.addActionListener(this);
		file.add(fOpen);
		
		fSave = new JMenuItem("저장(S)",new ImageIcon("image/저장.jpg"));
		fSave.setMnemonic('S');
		fSave.addActionListener(this);
		file.add(fSave);
		
		file.addSeparator();
		
		fExit = new JMenuItem("끝내기(X)",new ImageIcon("image/끝내기.jpg"));
		fExit.setMnemonic('X');
		fExit.addActionListener(this);
		file.add(fExit);
		
		menuBar.add(file);
		
		etc = new JMenu("기타");
		help = new JMenuItem("help");
		help.addActionListener(this);
		maker = new JMenuItem("팀");
		maker.addActionListener(this);
		
		etc.add(help);
		etc.add(maker);
		
		menuBar.add(etc);
		
		setJMenuBar(menuBar);
		
		this.add(painter,BorderLayout.CENTER);
		this.add(tool,BorderLayout.WEST);
		this.add(colors,BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.fNew)
		{
			painter.x1=painter.y1=painter.x2=painter.y2=painter.width=painter.height=0;	// 초기화
			painter.figure.clear();	//백터에 저장된 내용 초기화
			painter.repaint(); 
			painter.setFunc(0); // 0이면 펜 
		}
		else if(e.getSource()==this.fOpen) {
			FileDialog openDialog = new FileDialog(this, "열기", FileDialog.LOAD);
			
			openDialog.setVisible(true);	// 열기를 나타내는 filedialog 화면에 띄움
			String dir = openDialog.getDirectory(); // 파일의 위치 저장
			String files = openDialog.getFile(); // 파일 자체
			if (dir == null || files == null) // 입력또는 파일이 없을 경우 실행X 
				return;
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new BufferedInputStream(new FileInputStream(new File(dir, files))));
				// 객체 내용을 읽어옴
				painter.x1=painter.x2=painter.y1=painter.y2=painter.width=painter.height=0; // 초기화 
				painter.figure.clear();// 벡터에 저장된 내용 초기화

				Vector memo=new Vector(); // 벡터 객체 생성
				memo = (Vector)ois.readObject(); // 내용을 읽어온 것을 memo에 할당
				painter.figure=(Vector)memo.elementAt(0); // memo의 인덱스값 첫번째를 figure에 할당
				painter.repaint();
				ois.close(); // 닫힘
				New = true;
			} 
			catch (IOException ee) {} //파일 input/output에 대한 exception
			catch (ClassNotFoundException ee) {} //잘못된 클래스 이름에 대한 exception
		}

		else if(e.getSource()==this.fSave) {

			FileDialog saveDialog = new FileDialog(this , "저장", FileDialog.SAVE);
			saveDialog.setVisible(true);
			String dir = saveDialog.getDirectory();
			String file = saveDialog.getFile();
			if (dir == null || file == null)
				return;
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(new File(dir, file))));
				Vector memo=new Vector();
				memo.add(painter.figure);	//memo에 figure를 더함
				oos.writeObject(memo);	//내용(객체) 쓰기(저장)
				oos.close(); //창 닫힘
			} 
			catch (IOException ee) {}
		}
		else if(e.getSource() == this.fExit)
				System.exit(1);
		else if(e.getSource() == this.help){
			JOptionPane.showMessageDialog(this,				     
							"선택기능 : 선택 버튼을 누르고 미리 그려놓은 도형안을 선택하면 선택된다.\n\n" +
							"이동하기 : 선택 버튼을 누르고 도형안을 클릭하고 드래그하면 된다.\n\n" +
							"크기바꾸기 : 선택 버튼을 누르고 도형 외곽을 클릭하고 드래그하면 크기가 바뀐다.\n\n" +
							"※이동하기와 크기바꾸기의 모드를 바꾸려면 각 영역을 더블클릭하면 된다.\n\n" +
							"실행취소기능 : 기능창에 실행취소를 누르거나 Alt + z 키를누르면 실행이 취소된다.\n\n"
							,"그림판 설명서 " , JOptionPane.QUESTION_MESSAGE);
		}
		else if(e.getSource() == this.maker){
			JOptionPane.showMessageDialog(this,
					"학번 : 2013122280 성명 : 최경륜 \n학번 : 2013122310 성명 : 홍수민 \n학번 : 2013122285 성명 : 최민섭 \n학번 : 2012122184 성명 : 이도훈 \n","항공대학교",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
