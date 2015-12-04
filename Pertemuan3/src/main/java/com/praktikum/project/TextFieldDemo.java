import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.GroupLayout.*;

public class TextFieldDemo extends JFrame{
  implements DocumentListener{
    private JTextField entry;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JLabel status;
    private JTextArea textArea;
	
	final static Colour HILIT_COLOUR = Color.LIGHT_GRAY;
	final static Colour ERROR_COLOUR = Color.PINK;
	final static Colour CANCEL_ACTION = "cancel-search";
	
	final Color entryBg;
	final Hightlighter hilit;
	final Hightlighter.HighlightPainter painter;
	
	public TextFielDemo(){
	  initComponents();
	  
	  InputStream in = getClass().getResourceAsStream("content.txt");
	  try{
	    textArea.read(new InputStreamReader(in), null);
	  }catch(IOException e){
	    e.printStackTrace();
	  }
	}
	
	hilit = new DefaultHighlighter();
	painter = new DefaultHighlighter.DefaultHighlighPainter(HILIT_COLOR);
	textArea.setHighlighter(hilit);
	
	entryBg = entry.getBackground();
	entry.getDocument().addDocumentListener(this);
	
	InputMap im = entry.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	ActionMap am = entry.getActionMap();
	im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
	am.put(CANCEL_ACTION, new CancelAction());
  }
  
  private void initComponents(){
    entry = new JTextField();
	textArea = new JTextArea();
	status = new JLabel();
	jLabel1 = new JLabel();
	
	setDefaultCloseOperation(WindowConstant.EXIT_ON_CLOSE);
	setTitle("TextFielDemo");
	
	textArea.setColumns(20);
	textArea.setLineWrap(true);
	textArea.setRows(5);
	textArea.setWrapStyleWord(true);
	textArea.setEditable(false);
	jScrollPane1 = new JScrollPane(textArea);
	
	jLabel1.setText("enter text to search: ");
	GroupLayout layout = new GroupLayout(getContentPane());
	getContentPane().setLayout(layout);
	
	//create a parallel group for the hohrizontanl axis
	ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
	
	//create a sequential and a parallel groups
	SequentialGroup h1 = layout.createSequentialGroup();
	ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
	
	//add a container gap to the sequential group h1
	h1.addContainerGap();
	
	//add a scroll pane and a label to the parallel group h2
	h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
	h2.addComponent(status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
	
	//create a sequential group h3
	SequentialGroup h3 = layout.createSequentialGroup();
	h3.addComponent(jLabel1);
	h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
	h3.addComponent(entry, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);
	
	//add the group h3 to the group h2
	h2.addGroup(h3);
	//add the group h2 to the group h1
	h1.addGroup(h2);
	
	h1.addContainerGap();
	
	//add the group h1 to the group
	hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
	//create the horizontal group
	layout.setHorizontalGroup(hGroup);
  }
}