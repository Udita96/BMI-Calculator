


import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.*;
//class PaintPanel extends JPanel
//{
//	PaintPanel() {
//		
//		}
//	protected void paintComponent(Graphics g)
//	{
//		super.paintComponents(g);
//	}
//}

//class Frame2 extends JPanel
//{
//	Frame2()
//	{
//		setBorder(BorderFactory.createLineBorder(Color.YELLOW,5));
//		setBackground(Color.green);
//	}
//}

//class ImageImplement extends JPanel {
//	private Image img;
//	public ImageImplement(Image img) { 
//		this.img = img; Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
//		setPreferredSize(size); 
//		setMinimumSize(size); 
//		setMaximumSize(size); 
//		setSize(size); 
//		setLayout(null); }
//	public void paintComponent(Graphics g) { 
//		g.drawImage(img, 0, 0, null); 
//		} }


class MarqueePanel extends JPanel implements ActionListener {

    private static final int RATE = 12;
    private final Timer timer = new Timer(1000 / RATE, this);
    private final JLabel label = new JLabel();
    private final String s;
    private final int n;
    private int index;

    public MarqueePanel(String s, int n) {
    	setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
    	setBackground(Color.green);

        if (s == null || n < 1) {
            throw new IllegalArgumentException("Null string or n < 1");
        }
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        this.s = sb + s + sb;
        this.n = n;
        label.setFont(new Font("Serif", Font.ITALIC, 36));
        label.setText(sb.toString());
        this.add(label);
    }
   public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        index++;
        if (index > s.length() - n) {
            index = 0;
        }
        label.setText(s.substring(index, index + n));
    }
}
public class Bmi_new extends JPanel{
	JFrame f,f1,g,welcome,f2;
	JTextArea he;
	JTextArea wi,name,age;
	JButton b,l,agree;
	JLabel l1,l2,x,y,name1,age1,gen1,hello,marquee;
	JRadioButton rb1,rb2,hb1,hb2;
	JRadioButton male,female;
	JTable jt;
	JProgressBar jb;
	ButtonGroup bg1,bg2;
	static int TRANSLUCENT = 1;
	JPanel p = new JPanel();
	ButtonGroup gender;
	int i,j,num,ageofuser;
	float h,w,bmi;
	String type,a;
	Bmi_new(){
		p.setBackground(Color.GREEN);
		p.setSize(400, 400);
		welcome = new JFrame();
		welcome.setSize(600,450);
        welcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //welcome.setLayout(new BorderLayout());
		//welcome.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\Downloads\\bmi9.png")));
		//welcome.setLayout(new FlowLayout());
        name=new JTextArea();
        name.setForeground(Color.black);
        name.setFont(new Font("Courier New", Font.ITALIC, 18));
        name.setBounds(180,140,200,20);
//        marquee=new JLabel(); 
//        marquee.setText("WELCOME TO BMI CALCULATOR");
//        marquee.setFont(new Font("Colonna MT", Font.PLAIN, 40));
//        marquee.setForeground(Color.BLACK);
//        marquee.setBounds(5, 0, 1000, 200);
//        welcome.add(marquee);
        name1=new JLabel();
        name1.setText("NAME");
        name1.setFont(new Font("Courier New", Font.BOLD, 20));
        name1.setBounds(100, 50, 200, 200);
        welcome.add(name1);
        welcome.add(name);
        age=new JTextArea();
        age.setForeground(Color.black);
        age.setFont(new Font("Courier New", Font.ITALIC, 18));
        age.setBounds(180,180,30,20);
        welcome.add(age);
        age1=new JLabel();
        age1.setText("AGE");
        age1.setFont(new Font("Courier New", Font.BOLD, 20));
        age1.setBounds(100,90,200,200);
        welcome.add(age1);
        male=new JRadioButton("MALE");
        male.setFont(new Font("Courier New", Font.BOLD, 20));
        male.setBounds(180,230,100,10);
        male.setContentAreaFilled(false);
        male.setFocusPainted(false);
        male.setOpaque(false);
        male.setBackground(Color.green);
        welcome.add(male);
        female=new JRadioButton("FEMALE");
        female.setFont(new Font("Courier New", Font.BOLD, 20));
        female.setBounds(180,260, 100, 10);
        female.setContentAreaFilled(false);
        female.setFocusPainted(false);
        female.setOpaque(false);
        female.setBackground(Color.green);
        welcome.add(female);
        gender=new ButtonGroup();
        gender.add(male);
        gender.add(female);
        gen1=new JLabel();
        gen1.setText("GENDER");
        gen1.setFont(new Font("Courier New", Font.BOLD, 20));
        gen1.setBounds(100, 230, 80, 10);
        welcome.add(gen1);
        agree=new JButton("Enter to check your BMI");
        agree.setFont(new Font("Courier New", Font.BOLD, 20));
        agree.setBounds(100, 350, 400, 20);
        welcome.add(agree);
        
        agree.addActionListener(
        		new ActionListener(){
        			public void actionPerformed(ActionEvent k){
        				if(check()){
        				f=new JFrame();
        				f.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\Downloads\\bmi9.png")));
        				hello=new JLabel();
        				hello.setText("Hello "+name.getText());
        		        hello.setFont(new Font("Courier New", Font.BOLD, 20));
        				hello.setBounds(100,0,200,100);
        				f.add(hello);
        				b=new JButton("Done !");
        		        b.setFont(new Font("Courier New", Font.BOLD, 17));
        				b.setBounds(130,300,100,40); 
        				he=new JTextArea();
        				he.setForeground(Color.black);
        		        he.setFont(new Font("Courier New", Font.ITALIC, 17));
        				he.setBounds(250,220,100,20);
        				l1=new JLabel();
        				l1.setText("Enter your height");
        		        l1.setFont(new Font("Courier New", Font.BOLD, 17));
        				l1.setBounds(20, 220, 200, 20);
        				hb1=new JRadioButton("cm",true);//Ab unit conversion ho chuka hai
        		        hb1.setFont(new Font("Courier New", Font.BOLD, 17));
        				hb1.setBounds(20,240,60,20);
        				hb1.setContentAreaFilled(false);
        		        hb1.setFocusPainted(false);
        		        hb1.setOpaque(false);
        				//hb1.setBackground(Color.GREEN);
        				hb2=new JRadioButton("inches");
        				hb2.setFont(new Font("Courier New", Font.BOLD, 17));
        				hb2.setBounds(20, 260, 100, 50);
        				hb2.setContentAreaFilled(false);
        		        hb2.setFocusPainted(false);
        		        hb2.setOpaque(false);
        				//hb2.setBackground(Color.GREEN);
        				bg2=new ButtonGroup();
        				bg2.add(hb1);
        				bg2.add(hb2);
        				wi=new JTextArea();
        				wi.setForeground(Color.black);
        				wi.setFont(new Font("Courier New", Font.ITALIC, 17));
        				wi.setBounds(250,80,100,20);
        				l2=new JLabel();
        				l2.setText("Enter your weight");
        				l2.setFont(new Font("Courier New", Font.BOLD, 17));
        				l2.setBounds(20,80, 200, 20);
        				rb1=new JRadioButton("kg",true);
        				rb1.setFont(new Font("Courier New", Font.BOLD, 17));
        				rb1.setBounds(20,100,60,20);
        				rb1.setContentAreaFilled(false);
        		        rb1.setFocusPainted(false);
        		        rb1.setOpaque(false);
        				//rb1.setBackground(Color.GREEN);
        				rb2=new JRadioButton("pounds");
        				rb2.setFont(new Font("Courier New", Font.BOLD, 17));
        				rb2.setBounds(20,120,100,60);
        				rb2.setContentAreaFilled(false);
        		        rb2.setFocusPainted(false);
        		        rb2.setOpaque(false);
        				//rb2.setBackground(Color.GREEN);
        				bg1=new ButtonGroup();
        				bg1.add(rb1);
        				bg1.add(rb2);
        				f.add(rb1);
        				f.add(rb2);
        				f.add(hb1);
        				f.add(hb2);
        				f.add(b);
        				b.addActionListener(
        						new ActionListener(){
        						public void actionPerformed(ActionEvent e){
        							if(checkValidity())
        							{
        								
        								
        								jb = new JProgressBar(0,100);
        								jb.setValue(0);
        								jb.setBounds(50,200,300,10);
        								jb.setStringPainted(true);        								
        								f1 = new JFrame();
        								//f1.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\workspace\\Final\\progress.png")));
        								f1.setTitle("Progress");
        								f1.add(jb);
        								f1.setSize(400,400);        								
        								f1.setLayout(null);        								
        							    f1.setVisible(true);                  
        							   for(int i=0;i<=100;i+=5){
        							          jb.setValue(i);
        							         // jProgressBar1.setIndeterminate(false);              
        							          try{
        							              jb.paintImmediately(0, 0, 300, 10);//0, 1, 100, 10
        							          Thread.sleep(100);
        							          jb.setStringPainted(true);

        							     }
        							          catch(Exception e1){}
        							    }
        							if(rb2.isSelected()){
        								w=(float) (w*0.45);
        								
        							}
        							if(hb2.isSelected()){
        								h=(float) (h*2.54);
        							}
        							bmi=w*100*100/(h*h);
        						    DecimalFormat df=new DecimalFormat("#.#");
        						    a=df.format(bmi);
        							x=new JLabel();
        							g=new JFrame();
        							
        							g.setTitle("RESULTS ARE HERE");
        							y=new JLabel();
        							String str ; 
        							y.setText("BMI : "+String.valueOf(a));
        							y.setBounds(250,0,200,20);
        							y.setFont(new Font("Serif", Font.BOLD,20));
        							
        							if(bmi<18.5)
        								{
        								str = "<html><B>Underweight</B></html>";
        								g.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\workspace\\Final\\underweight.png")));
            							x.setText(str);
        								type = "UW";
        								}
        							else if(bmi>=18.5 && bmi<=24.9)
        							{
        								str = "<html><B>Normal Weight</B></html>";
        								g.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\workspace\\Final\\normal.png")));
        								x.setText(str);
        							type = "NW";
        							}
        							else if(bmi>=25 && bmi<=29.9)
        								{str = "<html><B>Overweight</B></html>";
        								g.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\workspace\\Final\\over.png")));
        								x.setText(str);
        							type = "OW";
        								}
        								else
        								{str = "<html><B>Obese</B></html>";
        								g.setContentPane(new JLabel(new ImageIcon("C:\\Users\\use\\workspace\\Final\\obese.png")));
        								x.setText(str);
        								type = "OB";
        								}

        							x.setFont(new Font("Serif", Font.BOLD,20));
        							x.setBounds(10,0,300,20);
        							g.add(y);
        							l=new JButton("Click here to check your diet!");
        	        				l.setFont(new Font("Serif", Font.BOLD, 17));
        							l.setBounds(20,300,350,30);
        							g.setSize(400,400);
        							g.setLayout(null);
        							g.setVisible(true);
        							f1.setVisible(false);
        							g.add(x);
        							g.add(l);
        							//g.add(p);
        							l.addActionListener(new ActionListener(){
        								public void actionPerformed(ActionEvent l)
        								{
        									f2 = new JFrame();
        									f2.setTitle("DIET CHART");
        									f2.setSize(800, 147);
        									f2.setVisible(true);
        									//f2.add(p);
        									//f2.setLayout(null);
        									//String data[][] = null;
        									String column[] = {"MEAL","FOOD INTAKE"};
        									if(type=="UW")
        									{
        									  String data[][] = {{"EARLY MORNING","1 Cup of Tea, 2 tspn of Sugar, 2 Biscuits"},{"BREAKFAST","Fruit Juice, Cereal with Milk, Boiled egg, Wholewheat toast with butter"},{"LUNCH","Soup, Vegetable/Salad, Pudding, Rice"},{"DINNER","Fruit Juice, Meat/Fish/Egg, Vegetable/Salad, Rice, Dal, Chapatti"},{"BEDTIME","Milk"}};
        									  jt = new JTable(data,column);
        									}
        									else if(type == "NW")
        									{
        										String data[][] = {{"EARLY MORNING","Lukewarm water with Lemon Juice"},{"BREAKFAST","Vegetable Juice, Vegetable Oats,4 Almonds(Soaked), Milk, 1 Slice of Multigrain Bread"},{"LUNCH","Raw Vegetable Salad, 1 Cup Dal, 2 Chapatti, 1 Cup curd, 1 Cup Vegetable"},{"DINNER","Soup, 1 Chapatti, 1 Cup Vegetable, 1 Cup Rice, 1 Cup Curd/1 Bowl of Chicken Soup"},{"BEDTIME","1 Cup Milk with a pinch of turmeric"}};
        										jt = new JTable(data,column);
        									}
        									else if(type == "OW")
        									{
        										String data[][] = {{"EARLY MORNING","1 Cup of Skimmed Milk w/o sugar"},{"BREAKFAST","Whole Wheat bread with low fat spread, Cereal Mixture, Fruit Juice"},{"LUNCH","Boiled Vegetables, Soup w/o cream, Low fat Yogurt, 1 Fruit, Brown Rice"},{"DINNER","Green salad, Low fat Yogurt, Wheat Pancakes"},{"BEDTIME","Skimmed Milk"}};
        									    jt = new JTable(data,column);
        									}
        									else
        									{
        										String data[][] = {{"EARLY MORNING","Warm water with Lemon Juice"},{"BREAKFAST","Wheat/Chickpea Sprout, Skimmed milk"},{"LUNCH","Salad/Steamed Vegetables"},{"EVENING SNACK","Vegetable Soup/Coconut Water"},{"DINNER","Steamed Salmon, Half Cup of Brown Rice, Half an orange"}};
        									    jt = new JTable(data,column);
        									}
        									jt.setBounds(40,50,80,5);
    										JScrollPane sp = new JScrollPane(jt);
        									f2.add(sp);
//        									ImageImplement panel = new ImageImplement(new ImageIcon("C:\\Users\\SONY\\Desktop\\udita\\bmi9.png").getImage());
//                                            panel.setBounds(0, 300, 400, 200);
//                                            f2.add(panel);
 //        									Icon I = new ImageIcon(this.getresource());
//        									f2.addIcon(I);
        									//f2.setContentPane(new JLabel(new ImageIcon("C:\\Users\\SONY\\Desktop\\udita\\bmi6.png")));
    										
//    										try
//    										{
//    											BufferedImage image = ImageIO.read(new File(null));
//    										}
//    										catch(IOException e)
//    										{
//    											
//    										}
        									g.setVisible(false);
        								}
        							});
        							f.setVisible(false);
        							}
        						}
        				    }	
        			     );
        				//g.setVisible(false);
        				//f = new JFrame();
        				f.add(he);
        				f.add(wi);
        				f.add(l1);
        				f.add(l2);
        				f.setSize(400,400);
        				f.setLayout(null); 
        				
        				//f.add(p);
        				f.setVisible(true);
        				welcome.setVisible(false);
        				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        				}
        			}
        		}
        		);
        String s = "WECOME TO BMI CALCULATOR    ";
        MarqueePanel mp = new MarqueePanel(s, 32);
        welcome.add(mp);
        //welcome.setContentPane(new JLabel(new ImageIcon("C:\\Users\\SONY\\Desktop\\udita\\bmicalculator1\\src\\bd.jpg")));
        welcome.setVisible(true);
        mp.start();
        
	}
	private boolean checkValidity(){	
		try{
				h=Float.parseFloat(he.getText());
			    w=Float.parseFloat(wi.getText());
			}catch(NumberFormatException q){
				JOptionPane.showConfirmDialog(null,"Please enter valid details","Error",JOptionPane.CANCEL_OPTION);
				wi.setText("");
				he.setText("");
				return false;
			}
		return true;}
	private boolean check(){
		try{
			ageofuser=Integer.parseInt(age.getText());
			}catch(NumberFormatException t){
				JOptionPane.showConfirmDialog(null, "Please Enter Valid Details","Error",JOptionPane.CANCEL_OPTION);
				age.setText("");
				name.setText("");
				return false;		
			}
	if(name.getText().trim().isEmpty())	
	{JOptionPane.showConfirmDialog(null, "Please Enter Valid Details","Error",JOptionPane.CANCEL_OPTION);
	age.setText("");
	name.setText("");
	return false;
	}
	return true;	
	}
public static void main(String args[])
{   
	SwingUtilities.invokeLater(new Runnable() {
		public void run() {
		new Bmi_new();
		}
		});
 }
}
// class MyCanvas extends Canvas{
//	 public void paint(Graphics g) {  
//		  
//	        Toolkit t=Toolkit.getDefaultToolkit();  
//	        Image i=t.getImage("p3.gif");  
//	        g.drawImage(i, 120,100,this);  
//	          
//	    }  
//}