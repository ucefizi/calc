package com.izi.views;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import calc.helpers.CalculHelper;

public class CalculView implements ActionListener, ItemListener {

	public static void main(String[] args) {
		CalculView c = new CalculView();
		c.start();
	}

	String s = "";
	JTextArea t;

	JButton b11;
	JButton b61;
	JButton b101;
	JButton b12;
	JButton b62;
	JButton b102;
	JButton b13;
	JButton b63;
	JButton b103;
	JButton b14;
	JButton b64;
	JButton b104;
	JButton b31;
	JButton b71;
	JButton b21;
	JButton b32;
	JButton b72;
	JButton b22;
	JButton b33;
	JButton b73;
	JButton b23;
	JButton b34;
	JButton b74;
	JButton b24;
	JButton b41;
	JButton b91;
	JButton b42;
	JButton b92;
	JButton b43;
	JButton b93;
	JButton b44;
	JButton b94;
	JButton b51;
	JButton b81;
	JButton b52;
	JButton b82;
	JButton b53;
	JButton b83;
	JButton b54;
	JButton b84;

	CheckboxGroup st;
	CheckboxGroup stt;
	Checkbox rad, deg, courbe, normal;

	public void start() {
		GridBagConstraints c = new GridBagConstraints();
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 5, 5, 5);
		c.weightx = 4;
		c.weighty = 14;
		// ---------------------------------------------
		t = new JTextArea(5, 20);
		t.setEditable(false);
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.gridheight = 2;
		p.add(t, c);

		c.gridwidth = 1;
		c.gridheight = 1;

		st = new CheckboxGroup();
		stt = new CheckboxGroup();
		// ---------------------------------------
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 10, 3, 3);
		courbe = new Checkbox("courbe", false, stt);
		p.add(courbe, c);
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(10, 3, 3, 3);
		normal = new Checkbox("normal", true, stt);
		p.add(normal, c);
		// ---------
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(10, 3, 3, 3);
		b21 = new JButton("nCp");
		p.add(b21, c);
		c.gridx = 3;
		c.gridy = 2;
		c.insets = new Insets(10, 3, 3, 10);
		b22 = new JButton("fact");
		p.add(b22, c);
		// ------------------------------------------
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10, 10, 3, 3);
		deg = new Checkbox("deg", false, st);
		p.add(deg, c);
		c.gridx = 1;
		c.gridy = 3;
		c.insets = new Insets(10, 3, 3, 3);
		rad = new Checkbox("rad", true, st);
		p.add(rad, c);
		// -----------
		c.gridx = 2;
		c.gridy = 3;
		c.insets = new Insets(10, 3, 3, 3);
		b23 = new JButton("X");
		p.add(b23, c);
		c.gridx = 3;
		c.gridy = 3;
		c.insets = new Insets(10, 3, 3, 10);
		b24 = new JButton("10^X");
		p.add(b24, c);
		// ------------------------------------------
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10, 10, 3, 3);
		b11 = new JButton("exp");
		p.add(b11, c);
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(10, 3, 3, 3);
		b12 = new JButton("atan");
		p.add(b12, c);
		c.gridx = 2;
		c.gridy = 4;
		c.insets = new Insets(10, 3, 3, 3);
		b13 = new JButton("asin");
		p.add(b13, c);
		c.gridx = 3;
		c.gridy = 4;
		c.insets = new Insets(10, 3, 3, 10);
		b14 = new JButton("acos");
		p.add(b14, c);
		// -----------------------------------------
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(3, 10, 3, 3);
		b31 = new JButton("e");
		p.add(b31, c);
		c.gridx = 1;
		c.gridy = 5;
		c.insets = new Insets(3, 3, 3, 3);
		b32 = new JButton("racin");
		p.add(b32, c);
		c.gridx = 2;
		c.gridy = 5;
		c.insets = new Insets(3, 3, 3, 3);
		b33 = new JButton("x^2");
		p.add(b33, c);
		c.gridx = 3;
		c.gridy = 5;
		c.insets = new Insets(3, 3, 3, 10);
		b34 = new JButton("x^3");
		p.add(b34, c);

		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(3, 10, 3, 3);
		b41 = new JButton("/");
		p.add(b41, c);
		c.gridx = 1;
		c.gridy = 6;
		c.insets = new Insets(3, 3, 3, 3);
		b42 = new JButton("ln");
		p.add(b42, c);
		c.gridx = 2;
		c.gridy = 6;
		c.insets = new Insets(3, 3, 3, 3);
		b43 = new JButton("log");
		p.add(b43, c);
		c.gridx = 3;
		c.gridy = 6;
		c.insets = new Insets(3, 3, 3, 10);
		b44 = new JButton("^");
		p.add(b44, c);

		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(3, 10, 3, 3);
		b51 = new JButton("pi");
		p.add(b51, c);
		c.gridx = 1;
		c.gridy = 7;
		c.insets = new Insets(3, 3, 3, 3);
		b52 = new JButton("sin");
		p.add(b52, c);
		c.gridx = 2;
		c.gridy = 7;
		c.insets = new Insets(3, 3, 3, 3);
		b53 = new JButton("cos");
		p.add(b53, c);
		c.gridx = 3;
		c.gridy = 7;
		c.insets = new Insets(3, 3, 3, 10);
		b54 = new JButton("tan");
		p.add(b54, c);
		// -----------------------------------------
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(1, 10, 1, 1);
		b61 = new JButton("(");
		p.add(b61, c);
		c.gridx = 1;
		c.gridy = 8;
		c.insets = new Insets(1, 1, 1, 1);
		b62 = new JButton(")");
		p.add(b62, c);
		c.gridx = 2;
		c.gridy = 8;
		c.insets = new Insets(1, 1, 1, 1);
		b63 = new JButton("CE");
		p.add(b63, c);
		c.gridx = 3;
		c.gridy = 8;
		c.insets = new Insets(1, 1, 1, 10);
		b64 = new JButton("C");
		p.add(b64, c);

		c.gridx = 0;
		c.gridy = 9;
		c.insets = new Insets(1, 10, 1, 1);
		b71 = new JButton("7");
		p.add(b71, c);
		c.gridx = 1;
		c.gridy = 9;
		c.insets = new Insets(1, 1, 1, 1);
		b72 = new JButton("8");
		p.add(b72, c);
		c.gridx = 2;
		c.gridy = 9;
		c.insets = new Insets(1, 1, 1, 1);
		b73 = new JButton("9");
		p.add(b73, c);
		c.gridx = 3;
		c.gridy = 9;
		c.insets = new Insets(1, 1, 1, 10);
		b74 = new JButton("*");
		p.add(b74, c);

		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(1, 10, 1, 1);
		b81 = new JButton("4");
		p.add(b81, c);
		c.gridx = 1;
		c.gridy = 10;
		c.insets = new Insets(1, 1, 1, 1);
		b82 = new JButton("5");
		p.add(b82, c);
		c.gridx = 2;
		c.gridy = 10;
		c.insets = new Insets(1, 1, 1, 1);
		b83 = new JButton("6");
		p.add(b83, c);
		c.gridx = 3;
		c.gridy = 10;
		c.insets = new Insets(1, 1, 1, 10);
		b84 = new JButton("-");
		p.add(b84, c);

		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(1, 10, 1, 1);
		b91 = new JButton("1");
		p.add(b91, c);
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 1);
		b92 = new JButton("2");
		p.add(b92, c);
		c.gridx = 2;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 1);
		b93 = new JButton("3");
		p.add(b93, c);
		c.gridx = 3;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 10);
		b94 = new JButton("+");
		p.add(b94, c);

		c.gridx = 0;
		c.gridy = 12;
		c.insets = new Insets(1, 10, 1, 1);
		b101 = new JButton("0");
		p.add(b101, c);
		c.gridx = 1;
		c.gridy = 12;
		c.insets = new Insets(1, 1, 1, 1);
		b102 = new JButton(".");
		p.add(b102, c);
		c.gridx = 2;
		c.gridy = 12;
		c.insets = new Insets(1, 1, 1, 1);
		b103 = new JButton("Ans");
		p.add(b103, c);
		c.gridx = 3;
		c.gridy = 12;
		c.insets = new Insets(1, 1, 1, 10);
		b104 = new JButton("=");
		p.add(b104, c);

		// -------------------------------------------------------

		b11.addActionListener(this);
		b51.addActionListener(this);
		b12.addActionListener(this);
		b52.addActionListener(this);
		b13.addActionListener(this);
		b53.addActionListener(this);
		b14.addActionListener(this);
		b54.addActionListener(this);
		b31.addActionListener(this);
		b61.addActionListener(this);
		b32.addActionListener(this);
		b62.addActionListener(this);
		b33.addActionListener(this);
		b63.addActionListener(this);
		b34.addActionListener(this);
		b64.addActionListener(this);
		b41.addActionListener(this);
		b71.addActionListener(this);
		b42.addActionListener(this);
		b72.addActionListener(this);
		b43.addActionListener(this);
		b73.addActionListener(this);
		b44.addActionListener(this);
		b74.addActionListener(this);
		b81.addActionListener(this);
		b91.addActionListener(this);
		b82.addActionListener(this);
		b92.addActionListener(this);
		b83.addActionListener(this);
		b93.addActionListener(this);
		b84.addActionListener(this);
		b94.addActionListener(this);
		b101.addActionListener(this);
		b102.addActionListener(this);
		b103.addActionListener(this);
		b104.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		// --------------------------------------------------------

		rad.addItemListener(this);
		deg.addItemListener(this);
		normal.addItemListener(this);
		courbe.addItemListener(this);

		// __________________________________________________________

		JFrame s = new JFrame("Calculatrice");
		s.setContentPane(p);
		s.setSize(400, 600);
		s.setVisible(true);
	}

	String Ans = "";

	public void actionPerformed(ActionEvent e) {

		if (b104 == e.getSource()) {

			if (etat2 == 1 && etat1 == 0) {
				int indice = -1;
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == 'X') {
						t.setText("Mode tracage de courbes");
						indice = 0;
						break;
					} else {
						indice = 1;
					}
				}
				if (indice == 0) {
					int max = -10;
					if (CalculHelper.Mod_synta(fonction(s, "0")).equals("ERROR SYNTAX")) {
						t.setText("ERROR SYNTAX");
						s = "";
					} else {
						fonct_trace(s, max);
					}
				}
				if (indice == 1) {
					int max = -10;
					if (CalculHelper.Mod_synta(s).equals("ERROR SYNTAX")) {
						t.setText("ERROR SYNTAX");
						s = "";
					} else {
						fonct_trace(s, max);
					}
				}

			} else {

				if (etat3 == 1 && etat4 == 0)

				{
					if (t.getText().equals(Ans)) {
						t.setText(Ans);
					} else {
						t.setText(CalculHelper.Cal(s));
						Ans = CalculHelper.Cal(s);
						s = "";
					}
				} else {
					if (t.getText().equals(Ans)) {
						t.setText(Ans);
					} else {
						t.setText(CalculHelper.Cal1(s));
						Ans = CalculHelper.Cal1(s);
						s = "";
					}
				}
			}
		}

		// ----------------------------------------------------------------------------------------------

		if (b103 == e.getSource()) {
			s = s + Ans;
			t.setText(s);
		}
		if (b102 == e.getSource()) {
			s = s + ".";
			t.setText(s);
		}
		if (b101 == e.getSource()) {
			s = s + "0";
			t.setText(s);
		}

		if (b91 == e.getSource()) {
			s = s + "1";
			t.setText(s);
		}
		if (b92 == e.getSource()) {
			s = s + "2";
			t.setText(s);
		}
		if (b93 == e.getSource()) {
			s = s + "3";
			t.setText(s);
		}
		if (b94 == e.getSource()) {
			s = s + "+";
			t.setText(s);
		}

		if (b81 == e.getSource()) {
			s = s + "4";
			t.setText(s);
		}
		if (b82 == e.getSource()) {
			s = s + "5";
			t.setText(s);
		}
		if (b83 == e.getSource()) {
			s = s + "6";
			t.setText(s);
		}
		if (b84 == e.getSource()) {
			s = s + "-";
			t.setText(s);
		}

		if (b71 == e.getSource()) {
			s = s + "7";
			t.setText(s);
		}
		if (b72 == e.getSource()) {
			s = s + "8";
			t.setText(s);
		}
		if (b73 == e.getSource()) {
			s = s + "9";
			t.setText(s);
		}
		if (b74 == e.getSource()) {
			s = s + "*";
			t.setText(s);
		}

		if (b61 == e.getSource()) {
			s = s + "(";
			t.setText(s);
		}
		if (b62 == e.getSource()) {
			s = s + ")";
			t.setText(s);
		}
		if (b63 == e.getSource()) {
			s = "";
			t.setText(s);
		}

		if (b64 == e.getSource()) {
			String l = "";
			for (int i = 0; i < s.length() - 1; i++) {
				l = l + s.charAt(i);
			}
			s = l;
			t.setText(s);
		}

		if (b51 == e.getSource()) {
			s = s + "pi";
			t.setText(s);
		}
		if (b52 == e.getSource()) {
			s = s + "sin(";
			t.setText(s);
		}
		if (b53 == e.getSource()) {
			s = s + "cos(";
			t.setText(s);
		}
		if (b54 == e.getSource()) {
			s = s + "tan(";
			t.setText(s);
		}

		if (b41 == e.getSource()) {
			s = s + "/";
			t.setText(s);
		}
		if (b42 == e.getSource()) {
			s = s + "ln(";
			t.setText(s);
		}
		if (b43 == e.getSource()) {
			s = s + "log(";
			t.setText(s);
		}
		if (b44 == e.getSource()) {
			s = s + "^";
			t.setText(s);
		}

		if (b31 == e.getSource()) {
			s = s + "E";
			t.setText(s);
		}
		if (b32 == e.getSource()) {
			s = s + "racin(";
			t.setText(s);
		}
		if (b33 == e.getSource()) {
			s = s + "^(2)";
			t.setText(s);
		}
		if (b34 == e.getSource()) {
			s = s + "^(3)";
			t.setText(s);
		}

		if (b11 == e.getSource()) {
			s = s + "exp(";
			t.setText(s);
		}
		if (b12 == e.getSource()) {
			s = s + "atan(";
			t.setText(s);
		}
		if (b13 == e.getSource()) {
			s = s + "asin(";
			t.setText(s);
		}
		if (b14 == e.getSource()) {
			s = s + "acos(";
			t.setText(s);
		}

		// if(b21==e.getSource()){s="10^("+s;t.setText(s);}
		if (b22 == e.getSource()) {
			s = s + "fact(";
			t.setText(s);
		}
		if (b23 == e.getSource()) {
			s = s + "X";
			t.setText(s);
		}
		if (b24 == e.getSource()) {
			s = s + "10^(";
			t.setText(s);
		}

	}

	int etat3 = 0, etat4 = 0, etat2 = 0, etat1 = 0;

	@Override
	public void itemStateChanged(ItemEvent e1) {

		if (rad.getState() == true) {
			etat3 = 1;
			etat4 = 0;
		} else {
			etat3 = 0;
			etat4 = 1;
		}

		if (courbe.getState() == true) {
			etat2 = 1;
			etat1 = 0;
		}
		if (normal.getState() == true) {
			etat1 = 1;
			etat2 = 0;
		}
	}

	// ---------------------------------------------------------------------------

	public static String fonction(String s, String i) {

		if (s.charAt(0) == 'X') {
			s = "(" + i + ")" + s.substring(1, s.length());
		}
		for (int j = 1; j < s.length() - 1; j++) {
			if (s.charAt(j) == 'X') {
				s = s.substring(0, j) + "(" + i + ")" + s.substring(j + 1, s.length());
			}
		}
		if (s.charAt(s.length() - 1) == 'X') {
			s = s.substring(0, s.length() - 1) + "(" + i + ")";
		}
		return s;
	}

	// -----------------------------------------------------------------------------
	public void fonct_trace(String s, int max) {

		PlotView f = new PlotView(s, max);
		f.start1();

	}

}