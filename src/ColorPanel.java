
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
        setPreferredSize(new Dimension(640,60)); //사이즈 설정
        setLayout(new FlowLayout(FlowLayout.LEFT, 25,5)); //플로우레이아웃 왼쪽정렬 사이즈 15,5
        setBorder(BorderFactory.createEtchedBorder()); // 테두리 설정
        Dimension IconSize = new Dimension(20,20);
         
        nowColor = new JPanel();    //현재 선택된 색이 보이는 패널
		nowColor.setBorder(BorderFactory.createEtchedBorder());
        
        selectColor = new JPanel();
		selectColor.setBorder(BorderFactory.createEtchedBorder());	// 테두리 설정
		selectColor.setBackground(Color.BLACK);
		selectColor.setToolTipText("선택된 색상");
		selectColor.setPreferredSize(new Dimension(25, 25));	
		selectColor.addMouseListener(this);
		
		
		/* 기본 정의된 색상외에 고급 색상을 추가하기위한 객체 */
		customColor = new JPanel();
		customColor.add(new JLabel(new ImageIcon("image/customColor.png")));
		customColor.setToolTipText("고급선택");
		customColor.addMouseListener(this);
		
		/* 선택된 색상을 보여주는 객체 */
		nowColor.setLayout(new GridLayout(1,2));
	    nowColor.add(selectColor);
	    nowColor.add(customColor);
	    nowColor.setCursor(new Cursor(Cursor.HAND_CURSOR));//손모양커서
	    nowColor.addMouseListener(this);
		add(nowColor);
		
		JPanel Color = new JPanel();
		
		/* 기본 색상을 정의하는 Color 객체를 만든다. */
		Color.setLayout(new GridLayout(2,9));
        Color.setBorder(BorderFactory.createRaisedBevelBorder());
        Color.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Color);
        
        /* 색 버튼을 만든다.
         * 버튼에 마우스를 올렸을시 무슨 색인지 Text로 보여준다.
         * 이 버튼을 Color 객체에 등록한다.*/
        Black = new JToggleButton(("검정"),new ImageIcon("Colors/Black.jpg"));
        Black.setToolTipText("검정");
        Black.setPreferredSize(IconSize);
        Black.addActionListener(this);
		Black.setSelected(true);
     	Color.add(Black);
     	
        Gray = new JToggleButton(("진한회색"),new ImageIcon("Colors/gray.jpg"));
        Gray.setToolTipText("진한회색");
        Gray.setPreferredSize(IconSize);
        Gray.addActionListener(this);
        Color.add(Gray);
        
        Red2 = new JToggleButton(("진한빨강"),new ImageIcon("Colors/Red2.jpg"));
        Red2.setToolTipText("진한빨강");
        Red2.setPreferredSize(IconSize);    
        Red2.addActionListener(this);
        Color.add(Red2);
        
        Red = new JToggleButton(("빨강"),new ImageIcon("Colors/Red.jpg"));
        Red.setToolTipText("빨강");
        Red.setPreferredSize(IconSize);  
        Red.addActionListener(this);
        Color.add(Red);
        
        Orange = new JToggleButton(("주황"),new ImageIcon("Colors/Orange.jpg"));
        Orange.setToolTipText("주황");
        Orange.setPreferredSize(IconSize);   
        Orange.addActionListener(this);
        Color.add(Orange);
        
        Yellow = new JToggleButton(("노랑"),new ImageIcon("Colors/Yellow.jpg"));
        Yellow.setToolTipText("노랑");
        Yellow.setPreferredSize(IconSize);
        Yellow.addActionListener(this);
        Color.add(Yellow);
        
        Green = new JToggleButton(("녹색"),new ImageIcon("Colors/Green.jpg"));
        Green.setToolTipText("녹색");
        Green.setPreferredSize(IconSize); 
        Green.addActionListener(this);
        Color.add(Green);
        
        Blue = new JToggleButton(("옥색"),new ImageIcon("Colors/Blue.jpg"));
        Blue.setToolTipText("옥색");
        Blue.setPreferredSize(IconSize);   
        Blue.addActionListener(this);
        Color.add(Blue);  
        
        Indigo = new JToggleButton(("남색"),new ImageIcon("Colors/Indigo.jpg"));
        Indigo.setToolTipText("남색");
        Indigo.setPreferredSize(IconSize);  
        Indigo.addActionListener(this);
        Color.add(Indigo);  
        
        Wine = new JToggleButton(("자주"),new ImageIcon("Colors/Wine.jpg"));
     	Wine.setToolTipText("자주");
        Wine.setPreferredSize(IconSize);
    	Wine.addActionListener(this);
        Color.add(Wine);
        
        White = new JToggleButton(("흰색"),new ImageIcon("Colors/White.jpg"));
     	White.setToolTipText("흰색");
     	White.setPreferredSize(IconSize);   
     	White.addActionListener(this);
     	Color.add(White);
     	
        Gray2 = new JToggleButton(("연한회색"),new ImageIcon("Colors/gray2.jpg"));
        Gray2.setToolTipText("연한회색");
        Gray2.setPreferredSize(IconSize); 
        Gray2.addActionListener(this);
        Color.add(Gray2);
 
        Brown = new JToggleButton(("브라운"),new ImageIcon("Colors/Brown.jpg"));
        Brown.setToolTipText("브라운");
        Brown.setPreferredSize(IconSize);   
        Brown.addActionListener(this);
        Color.add(Brown);
        
        Pink = new JToggleButton(("핑크색"),new ImageIcon("Colors/Pink.jpg"));
        Pink.setToolTipText("핑크색");
        Pink.setPreferredSize(IconSize);   
        Pink.addActionListener(this);
        Color.add(Pink);
        
        Gold = new JToggleButton(("황금색"),new ImageIcon("Colors/Gold.jpg"));
        Gold.setToolTipText("황금색");
        Gold.setPreferredSize(IconSize);  
        Gold.addActionListener(this);
        Color.add(Gold);  
        
        Yellow2 = new JToggleButton(("연한노랑"),new ImageIcon("Colors/Yellow2.jpg"));
        Yellow2.setToolTipText("연한노랑");
        Yellow2.setPreferredSize(IconSize);
        Yellow2.addActionListener(this);
        Color.add(Yellow2);
        
        Lime = new JToggleButton(("라임"),new ImageIcon("Colors/Lime.jpg"));
        Lime.setToolTipText("라임");
        Lime.setPreferredSize(IconSize);     
        Lime.addActionListener(this);
        Color.add(Lime);
        
        Sky = new JToggleButton(("하늘색"),new ImageIcon("Colors/Sky.jpg"));
        Sky.setToolTipText("하늘색");
        Sky.setPreferredSize(IconSize); 
        Sky.addActionListener(this);
        Color.add(Sky);
        
        Jinblue = new JToggleButton(("청회색"),new ImageIcon("Colors/JinBlue.jpg"));
        Jinblue.setToolTipText("청회색");
        Jinblue.setPreferredSize(IconSize);
        Jinblue.addActionListener(this);
        Color.add(Jinblue);
        
        Violet = new JToggleButton(("연한보라"),new ImageIcon("Colors/violet.jpg"));
        Violet.setToolTipText("연한보라");
        Violet.setPreferredSize(IconSize);
        Violet.addActionListener(this);
        Color.add(Violet);   
        
        /* Stamp를 찍기위한 객체 생성 
         * 객체의 Layout 는 GridLayout */
        JPanel Stamp = new JPanel();
        
    	Stamp.setLayout(new GridLayout(1,4));
    	Stamp.setBorder(BorderFactory.createRaisedBevelBorder());
    	Stamp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Stamp);
		Dimension size2 = new Dimension(50, 50);
		
		/* 각 도장의 버튼을 생성한다. */
		stamp =new JButton(new ImageIcon(((
				new ImageIcon("image/stamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//도장 버튼 생성
		stamp.addActionListener(this);
		stamp.setToolTipText("도장");
		stamp.setPreferredSize(size2);
		Stamp.add(stamp);// 추가
		
		minstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/minstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//도장 버튼 생성
		minstamp.addActionListener(this);
		minstamp.setToolTipText("수민도장");
		minstamp.setPreferredSize(size2);
		Stamp.add(minstamp);// 추가
		
		ryunstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/ryunstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//도장 버튼 생성
		ryunstamp.addActionListener(this);
		ryunstamp.setToolTipText("경륜도장");
		ryunstamp.setPreferredSize(size2);
		Stamp.add(ryunstamp);// 추가
		
		seopstamp =new JButton(new ImageIcon(((
				new ImageIcon("image/seopstamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//도장 버튼 생성
		seopstamp.addActionListener(this);
		seopstamp.setToolTipText("민섭도장");
		seopstamp.setPreferredSize(size2);
		Stamp.add(seopstamp);// 추가
		
		dostamp =new JButton(new ImageIcon(((
				new ImageIcon("image/dostamp.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH)));//도장 버튼 생성
		dostamp.addActionListener(this);
		dostamp.setToolTipText("도훈도장");
		dostamp.setPreferredSize(size2);
		Stamp.add(dostamp);// 추가
		
	}
	
	public void actionPerformed(ActionEvent e) { 
		// 버튼이 눌리면 현재색나오는 패널변경 변경하고 색설정
		String col = (String)e.getActionCommand(); 
		if (col.equals("검정")) {
			selectColor.setBackground(Color.black);
			GraphicsEdit.painter.color=Color.black;
		}
		else if (col.equals("진한회색")) {
			selectColor.setBackground(new Color(127,127,127));
			GraphicsEdit.painter.color=new Color(127,127,127);
		}
		else if (col.equals("진한빨강")) {
			selectColor.setBackground(new Color(136,0,21));
			GraphicsEdit.painter.color= new Color(136,0,21);
		}
		else if (col.equals("빨강")) {
			selectColor.setBackground(new Color(237,28,36));
			GraphicsEdit.painter.color=new Color(237,28,36);
		}	
		else if (col.equals("주황")) {
			selectColor.setBackground(new Color(255,127,39));
			GraphicsEdit.painter.color=new Color(255,127,39);
		}
		else if (col.equals("노랑")) {
			selectColor.setBackground(new Color(255,242,0));
			GraphicsEdit.painter.color=new Color(255,242,0);
		}
		else if (col.equals("녹색")) {
			selectColor.setBackground(new Color(34,177,76));
			GraphicsEdit.painter.color=new Color(34,177,76);
		}
		else if (col.equals("옥색")) {
			selectColor.setBackground(new Color(0,162,232));
			GraphicsEdit.painter.color=new Color(0,162,232);
		}
		else if (col.equals("남색")) {
			selectColor.setBackground(new Color(63,71,204));
			GraphicsEdit.painter.color=new Color(63,71,204);
		}
		else if (col.equals("자주")) {
			selectColor.setBackground(new Color(163,73,164));
			GraphicsEdit.painter.color=new Color(163,73,164);
		}
		else if (col.equals("흰색")) {
			selectColor.setBackground(Color.white);
			GraphicsEdit.painter.color=Color.white;
		}
		else if (col.equals("연한회색")) {
			selectColor.setBackground(new Color(195,195,195));
			GraphicsEdit.painter.color=new Color(195,195,195);
		}
		else if (col.equals("브라운")) {
			selectColor.setBackground(new Color(185,122,87));
			GraphicsEdit.painter.color=new Color(185,122,87);
		}
		else if (col.equals("핑크색")) {
			selectColor.setBackground(new Color(255,174,201));
			GraphicsEdit.painter.color=new Color(255,174,201);
		}
		else if (col.equals("황금색")) {
			selectColor.setBackground(new Color(255,201,14));
			GraphicsEdit.painter.color=new Color(255,201,14);
		}
		else if (col.equals("연한노랑")) {
			selectColor.setBackground(new Color(239,228,176));
			GraphicsEdit.painter.color=new Color(239,228,176);
		}
		else if (col.equals("라임")) {
			selectColor.setBackground(new Color(181,230,29));
			GraphicsEdit.painter.color=new Color(181,230,29);
		}
		else if (col.equals("하늘색")) {
			selectColor.setBackground(new Color(128,255,255));
			GraphicsEdit.painter.color=new Color(128,255,255);
		}
		else if (col.equals("청회색")) {
			selectColor.setBackground(new Color(112,146,191));
			GraphicsEdit.painter.color=new Color(112,146,191);
		}
		else if (col.equals("연한보라")) {
			selectColor.setBackground(new Color(200,191,231));
			GraphicsEdit.painter.color=new Color(200,191,231);
		}
		
		/* stamp가 눌렸을때 Stamp의 종류를 설정 */
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

	/* 미사용 구현 Method() */
	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

}