
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
		Dimension screenSize = toolkit.getScreenSize();	// ��ũ���� Size�� �����Ѵ�.
		editor.setDefaultCloseOperation(EXIT_ON_CLOSE);
		editor.setSize(1000,800);	// ȭ��ũ�� ����
		editor.setLocation(screenSize.width/2 - 500, screenSize.height/2-400);	// ȭ�� �߾ӿ������� ����
		editor.setVisible(true);
		
	}
	
	public GraphicsEdit(){
		super("Graphics Editor");
		/* painter  : ���� ��ɵ��� �׷��ִ� ��ü 
		 * tool		: ���� ��ɵ��� ����ϱ����� ��ü
		 * colors	: ������ ��ü */
		painter = new DrawingPanel();
		ToolPanel tool = new ToolPanel();
		ColorPanel colors = new ColorPanel();
		painter.setBackground(Color.WHITE);
		
	/* Menu�� ��������� memuBar ��ü�� �����ϰ� ���� Item���� Add ���ش�. */
		menuBar = new JMenuBar();
		file = new JMenu("����(F)");
		file.setMnemonic('F');
		
		fNew = new JMenuItem("���θ����(N)",new ImageIcon("image/���θ����.jpg"));
		fNew.setMnemonic('N');
		fNew.addActionListener(this);
		file.add(fNew);
		
		fOpen = new JMenuItem("����(O)",new ImageIcon("image/����.jpg"));
		fOpen.setMnemonic('O');
		fOpen.addActionListener(this);
		file.add(fOpen);
		
		fSave = new JMenuItem("����(S)",new ImageIcon("image/����.jpg"));
		fSave.setMnemonic('S');
		fSave.addActionListener(this);
		file.add(fSave);
		
		file.addSeparator();
		
		fExit = new JMenuItem("������(X)",new ImageIcon("image/������.jpg"));
		fExit.setMnemonic('X');
		fExit.addActionListener(this);
		file.add(fExit);
		
		menuBar.add(file);
		
		etc = new JMenu("��Ÿ");
		help = new JMenuItem("help");
		help.addActionListener(this);
		maker = new JMenuItem("��");
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
			painter.x1=painter.y1=painter.x2=painter.y2=painter.width=painter.height=0;	// �ʱ�ȭ
			painter.figure.clear();	//���Ϳ� ����� ���� �ʱ�ȭ
			painter.repaint(); 
			painter.setFunc(0); // 0�̸� �� 
		}
		else if(e.getSource()==this.fOpen) {
			FileDialog openDialog = new FileDialog(this, "����", FileDialog.LOAD);
			
			openDialog.setVisible(true);	// ���⸦ ��Ÿ���� filedialog ȭ�鿡 ���
			String dir = openDialog.getDirectory(); // ������ ��ġ ����
			String files = openDialog.getFile(); // ���� ��ü
			if (dir == null || files == null) // �Է¶Ǵ� ������ ���� ��� ����X 
				return;
			try {
				ObjectInputStream ois = new ObjectInputStream(
						new BufferedInputStream(new FileInputStream(new File(dir, files))));
				// ��ü ������ �о��
				painter.x1=painter.x2=painter.y1=painter.y2=painter.width=painter.height=0; // �ʱ�ȭ 
				painter.figure.clear();// ���Ϳ� ����� ���� �ʱ�ȭ

				Vector memo=new Vector(); // ���� ��ü ����
				memo = (Vector)ois.readObject(); // ������ �о�� ���� memo�� �Ҵ�
				painter.figure=(Vector)memo.elementAt(0); // memo�� �ε����� ù��°�� figure�� �Ҵ�
				painter.repaint();
				ois.close(); // ����
				New = true;
			} 
			catch (IOException ee) {} //���� input/output�� ���� exception
			catch (ClassNotFoundException ee) {} //�߸��� Ŭ���� �̸��� ���� exception
		}

		else if(e.getSource()==this.fSave) {

			FileDialog saveDialog = new FileDialog(this , "����", FileDialog.SAVE);
			saveDialog.setVisible(true);
			String dir = saveDialog.getDirectory();
			String file = saveDialog.getFile();
			if (dir == null || file == null)
				return;
			try {
				ObjectOutputStream oos = new ObjectOutputStream(
						new BufferedOutputStream(new FileOutputStream(new File(dir, file))));
				Vector memo=new Vector();
				memo.add(painter.figure);	//memo�� figure�� ����
				oos.writeObject(memo);	//����(��ü) ����(����)
				oos.close(); //â ����
			} 
			catch (IOException ee) {}
		}
		else if(e.getSource() == this.fExit)
				System.exit(1);
		else if(e.getSource() == this.help){
			JOptionPane.showMessageDialog(this,				     
							"���ñ�� : ���� ��ư�� ������ �̸� �׷����� �������� �����ϸ� ���õȴ�.\n\n" +
							"�̵��ϱ� : ���� ��ư�� ������ �������� Ŭ���ϰ� �巡���ϸ� �ȴ�.\n\n" +
							"ũ��ٲٱ� : ���� ��ư�� ������ ���� �ܰ��� Ŭ���ϰ� �巡���ϸ� ũ�Ⱑ �ٲ��.\n\n" +
							"���̵��ϱ�� ũ��ٲٱ��� ��带 �ٲٷ��� �� ������ ����Ŭ���ϸ� �ȴ�.\n\n" +
							"������ұ�� : ���â�� ������Ҹ� �����ų� Alt + z Ű�������� ������ ��ҵȴ�.\n\n"
							,"�׸��� ���� " , JOptionPane.QUESTION_MESSAGE);
		}
		else if(e.getSource() == this.maker){
			JOptionPane.showMessageDialog(this,
					"�й� : 2013122280 ���� : �ְ�� \n�й� : 2013122310 ���� : ȫ���� \n�й� : 2013122285 ���� : �ֹμ� \n�й� : 2012122184 ���� : �̵��� \n","�װ����б�",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
