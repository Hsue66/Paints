
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ColorPanel extends JPanel implements ActionListener, MouseListener
{

	JToggleButton Black,Gray,Red2,Red,Orange,Yellow,Green,Blue,Indigo,Wine,White,Gray2,Brown,Pink,Gold,Yellow2,Lime,Sky,Jinblue,Violet;
	JPanel selectColor;
	JPanel nowColor;
	JPanel customColor;
	
	JButton stamp,seopstamp,ryunstamp,minstamp,dostamp;
	
	public ColorPanel(){	
        setPreferredSize(new Dimension(640,60)); //������ ����
        setLayout(new FlowLayout(FlowLayout.LEFT, 25,5)); //�÷ο췹�̾ƿ� �������� ������ 15,5
        setBorder(BorderFactory.createEtchedBorder()); // �׵θ� ����
        Dimension IconSize = new Dimension(20,20);
         
        nowColor = new JPanel();    //���� ���õ� ���� ���̴� �г�
		nowColor.setBorder(BorderFactory.createEtchedBorder());
        
        selectColor = new JPanel();
		selectColor.setBorder(BorderFactory.createEtchedBorder());	// �׵θ� ����
		selectColor.setBackground(Color.BLACK);
		selectColor.setToolTipText("���õ� ����");
		selectColor.setPreferredSize(new Dimension(25, 25));	
		selectColor.addMouseListener(this);
		
		
		/* �⺻ ���ǵ� ����ܿ� ��� ������ �߰��ϱ����� ��ü */
		customColor = new JPanel();
		customColor.add(new JLabel(new ImageIcon("image/customColor.png")));
		customColor.setToolTipText("��޼���");
		customColor.addMouseListener(this);
		
		/* ���õ� ������ �����ִ� ��ü */
		nowColor.setLayout(new GridLayout(1,2));
	    nowColor.add(selectColor);
	    nowColor.add(customColor);
	    nowColor.setCursor(new Cursor(Cursor.HAND_CURSOR));//�ո��Ŀ��
	    nowColor.addMouseListener(this);
		add(nowColor);
		
		JPanel Color = new JPanel();
		
		/* �⺻ ������ �����ϴ� Color ��ü�� �����. */
		Color.setLayout(new GridLayout(2,9));
        Color.setBorder(BorderFactory.createRaisedBevelBorder());
        Color.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Color);
        
        /* �� ��ư�� �����.
         * ��ư�� ���콺�� �÷����� ���� ������ Text�� �����ش�.
         * �� ��ư�� Color ��ü�� ����Ѵ�.*/
        Black = new JToggleButton(("����"),new ImageIcon("Colors/Black.jpg"));
        Black.setToolTipText("����");
        Black.setPreferredSize(IconSize);
        Black.addActionListener(this);
		Black.setSelected(true);
     	Color.add(Black);
     	
        Gray = new JToggleButton(("����ȸ��"),new ImageIcon("Colors/gray.jpg"));
        Gray.setToolTipText("����ȸ��");
        Gray.setPreferredSize(IconSize);
        Gray.addActionListener(this);
        Color.add(Gray);
        
        Red2 = new JToggleButton(("���ѻ���"),new ImageIcon("Colors/Red2.jpg"));
        Red2.setToolTipText("���ѻ���");
        Red2.setPreferredSize(IconSize);    
        Red2.addActionListener(this);
        Color.add(Red2);
        
        Red = new JToggleButton(("����"),new ImageIcon("Colors/Red.jpg"));
        Red.setToolTipText("����");
        Red.setPreferredSize(IconSize);  
        Red.addActionListener(this);
        Color.add(Red);
        
        Orange = new JToggleButton(("��Ȳ"),new ImageIcon("Colors/Orange.jpg"));
        Orange.setToolTipText("��Ȳ");
        Orange.setPreferredSize(IconSize);   
        Orange.addActionListener(this);
        Color.add(Orange);
        
        Yellow = new JToggleButton(("���"),new ImageIcon("Colors/Yellow.jpg"));
        Yellow.setToolTipText("���");
        Yellow.setPreferredSize(IconSize);
        Yellow.addActionListener(this);
        Color.add(Yellow);
        
        Green = new JToggleButton(("���"),new ImageIcon("Colors/Green.jpg"));
        Green.setToolTipText("���");
        Green.setPreferredSize(IconSize); 
        Green.addActionListener(this);
        Color.add(Green);
        
        Blue = new JToggleButton(("����"),new ImageIcon("Colors/Blue.jpg"));
        Blue.setToolTipText("����");
        Blue.setPreferredSize(IconSize);   
        Blue.addActionListener(this);
        Color.add(Blue);  
        
        Indigo = new JToggleButton(("����"),new ImageIcon("Colors/Indigo.jpg"));
        Indigo.setToolTipText("����");
        Indigo.setPreferredSize(IconSize);  
        Indigo.addActionListener(this);
        Color.add(Indigo);  
        
        Wine = new JToggleButton(("����"),new ImageIcon("Colors/Wine.jpg"));
     	Wine.setToolTipText("����");
        Wine.setPreferredSize(IconSize);
    	Wine.addActionListener(this);
        Color.add(Wine);
        
        White = new JToggleButton(("���"),new ImageIcon("Colors/White.jpg"));
     	White.setToolTipText("���");
     	White.setPreferredSize(IconSize);   
     	White.addActionListener(this);
     	Color.add(White);
     	
        Gray2 = new JToggleButton(("����ȸ��"),new ImageIcon("Colors/gray2.jpg"));
        Gray2.setToolTipText("����ȸ��");
        Gray2.setPreferredSize(IconSize); 
        Gray2.addActionListener(this);
        Color.add(Gray2);
 
        Brown = new JToggleButton(("����"),new ImageIcon("Colors/Brown.jpg"));
        Brown.setToolTipText("����");
        Brown.setPreferredSize(IconSize);   
        Brown.addActionListener(this);
        Color.add(Brown);
        
        Pink = new JToggleButton(("��ũ��"),new ImageIcon("Colors/Pink.jpg"));
        Pink.setToolTipText("��ũ��");
        Pink.setPreferredSize(IconSize);   
        Pink.addActionListener(this);
        Color.add(Pink);
        
        Gold = new JToggleButton(("Ȳ�ݻ�"),new ImageIcon("Colors/Gold.jpg"));
        Gold.setToolTipText("Ȳ�ݻ�");
        Gold.setPreferredSize(IconSize);  
        Gold.addActionListener(this);
        Color.add(Gold);  
        
        Yellow2 = new JToggleButton(("���ѳ��"),new ImageIcon("Colors/Yellow2.jpg"));
        Yellow2.setToolTipText("���ѳ��");
        Yellow2.setPreferredSize(IconSize);
        Yellow2.addActionListener(this);
        Color.add(Yellow2);
        
        Lime = new JToggleButton(("����"),new ImageIcon("Colors/Lime.jpg"));
        Lime.setToolTipText("����");
        Lime.setPreferredSize(IconSize);     
        Lime.addActionListener(this);
        Color.add(Lime);
        
        Sky = new JToggleButton(("�ϴû�"),new ImageIcon("Colors/Sky.jpg"));
        Sky.setToolTipText("�ϴû�");
        Sky.setPreferredSize(IconSize); 
        Sky.addActionListener(this);
        Color.add(Sky);
        
        Jinblue = new JToggleButton(("ûȸ��"),new ImageIcon("Colors/JinBlue.jpg"));
        Jinblue.setToolTipText("ûȸ��");
        Jinblue.setPreferredSize(IconSize);
        Jinblue.addActionListener(this);
        Color.add(Jinblue);
        
        Violet = new JToggleButton(("���Ѻ���"),new ImageIcon("Colors/violet.jpg"));
        Violet.setToolTipText("���Ѻ���");
        Violet.setPreferredSize(IconSize);
        Violet.addActionListener(this);
        Color.add(Violet);   
        
        /* Stamp�� ������� ��ü ���� 
         * ��ü�� Layout �� GridLayout */
        JPanel Stamp = new JPanel();
        
    	Stamp.setLayout(new GridLayout(1,4));
    	Stamp.setBorder(BorderFactory.createRaisedBevelBorder());
    	Stamp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Stamp);
		Dimension size2 = new Dimension(50, 50);
		
		/* �� ������ ��ư�� �����Ѵ�. */
		stamp =new JButton(new ImageIcon(((
				new ImageIcon("image/stamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		stamp.addActionListener(this);
		stamp.setToolTipText("����");
		stamp.setPreferredSize(size2);
		Stamp.add(stamp);// �߰�
		
		minstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/minstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		minstamp.addActionListener(this);
		minstamp.setToolTipText("���ε���");
		minstamp.setPreferredSize(size2);
		Stamp.add(minstamp);// �߰�
		
		ryunstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/ryunstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		ryunstamp.addActionListener(this);
		ryunstamp.setToolTipText("�������");
		ryunstamp.setPreferredSize(size2);
		Stamp.add(ryunstamp);// �߰�
		
		seopstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/seopstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		seopstamp.addActionListener(this);
		seopstamp.setToolTipText("�μ�����");
		seopstamp.setPreferredSize(size2);
		Stamp.add(seopstamp);// �߰�
		
		dostamp =new JButton(new ImageIcon(((
				new ImageIcon("image/dostamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//���� ��ư ����
		dostamp.addActionListener(this);
		dostamp.setToolTipText("���Ƶ���");
		dostamp.setPreferredSize(size2);
		Stamp.add(dostamp);// �߰�
		
	}
	
	public void actionPerformed(ActionEvent e) { 
		// ��ư�� ������ ����������� �гκ��� �����ϰ� ������
		String col = (String)e.getActionCommand(); 
		if (col.equals("����")) {
			selectColor.setBackground(Color.black);
			GraphicsEdit.painter.color=Color.black;
		}
		else if (col.equals("����ȸ��")) {
			selectColor.setBackground(new Color(127,127,127));
			GraphicsEdit.painter.color=new Color(127,127,127);
		}
		else if (col.equals("���ѻ���")) {
			selectColor.setBackground(new Color(136,0,21));
			GraphicsEdit.painter.color= new Color(136,0,21);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(237,28,36));
			GraphicsEdit.painter.color=new Color(237,28,36);
		}	
		else if (col.equals("��Ȳ")) {
			selectColor.setBackground(new Color(255,127,39));
			GraphicsEdit.painter.color=new Color(255,127,39);
		}
		else if (col.equals("���")) {
			selectColor.setBackground(new Color(255,242,0));
			GraphicsEdit.painter.color=new Color(255,242,0);
		}
		else if (col.equals("���")) {
			selectColor.setBackground(new Color(34,177,76));
			GraphicsEdit.painter.color=new Color(34,177,76);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(0,162,232));
			GraphicsEdit.painter.color=new Color(0,162,232);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(63,71,204));
			GraphicsEdit.painter.color=new Color(63,71,204);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(163,73,164));
			GraphicsEdit.painter.color=new Color(163,73,164);
		}
		else if (col.equals("���")) {
			selectColor.setBackground(Color.white);
			GraphicsEdit.painter.color=Color.white;
		}
		else if (col.equals("����ȸ��")) {
			selectColor.setBackground(new Color(195,195,195));
			GraphicsEdit.painter.color=new Color(195,195,195);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(185,122,87));
			GraphicsEdit.painter.color=new Color(185,122,87);
		}
		else if (col.equals("��ũ��")) {
			selectColor.setBackground(new Color(255,174,201));
			GraphicsEdit.painter.color=new Color(255,174,201);
		}
		else if (col.equals("Ȳ�ݻ�")) {
			selectColor.setBackground(new Color(255,201,14));
			GraphicsEdit.painter.color=new Color(255,201,14);
		}
		else if (col.equals("���ѳ��")) {
			selectColor.setBackground(new Color(239,228,176));
			GraphicsEdit.painter.color=new Color(239,228,176);
		}
		else if (col.equals("����")) {
			selectColor.setBackground(new Color(181,230,29));
			GraphicsEdit.painter.color=new Color(181,230,29);
		}
		else if (col.equals("�ϴû�")) {
			selectColor.setBackground(new Color(128,255,255));
			GraphicsEdit.painter.color=new Color(128,255,255);
		}
		else if (col.equals("ûȸ��")) {
			selectColor.setBackground(new Color(112,146,191));
			GraphicsEdit.painter.color=new Color(112,146,191);
		}
		else if (col.equals("���Ѻ���")) {
			selectColor.setBackground(new Color(200,191,231));
			GraphicsEdit.painter.color=new Color(200,191,231);
		}
		
		/* stamp�� �������� Stamp�� ������ ���� */
		else if(e.getSource() == this.stamp)
		{
			GraphicsEdit.painter.setFunc(15);
		}
		else if(e.getSource() == this.seopstamp)
		{
			GraphicsEdit.painter.setFunc(16);
		}
		else if(e.getSource() == this.ryunstamp)
		{
			GraphicsEdit.painter.setFunc(17);
		}
		else if(e.getSource() == this.minstamp)
		{
			GraphicsEdit.painter.setFunc(18);
		}
		else if(e.getSource() == this.dostamp)
		{
			GraphicsEdit.painter.setFunc(19);
		}
	}
		
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == nowColor  || e.getSource() == customColor )
		{
			JColorChooser chooser = new JColorChooser();
			Color selectedColor = chooser.showDialog(null,"Color",selectColor.getBackground());
			if(selectedColor != null)
			{
				selectColor.setBackground(selectedColor);
				GraphicsEdit.painter.color=selectedColor;
			}
		}
	}

	/* �̻�� ���� Method() */
	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

}