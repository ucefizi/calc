package com.izi.helpers;

import java.util.Stack;

import com.izi.views.PlotView;

public class CalculHelper {

	static char[] cara = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	static char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	static char[] tab = { '*', '/', '-', '+', '^' };
	static char[] tab1 = { '*', '/', '^' };
	static char[] tab2 = { '-', '+' };
	static String[] fonc = { "sin", "cos", "tan", "ln", "exp", "racin", "fact", "log", "acos", "asin", "atan" };

	public static String Mod_synta(String s) {
		String d = "";

		if (bienparenthese(s)) {

			// ---------------------------------------------------------------------------------------------------------------
			if (isOper("" + s.charAt(0))) {
				return "ERROR SYNTAX";
			}

			if (isOper("" + s.charAt(s.length() - 1))) {
				return "ERROR SYNTAX";
			}

			// -----------------------------------------------------------------------------------------------------------------

			int i = 0;

			while (i != s.length() - 1) {

				/*-----------------------Les Modifications--------------------------------------------------------*/
				if ((("" + s.charAt(i)).equals(")")) && (("" + s.charAt(i + 1)).equals("("))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta(l + k);
				} // 1ere modification
				// -----------------------------------------------------------------------------
				if ((("" + s.charAt(i)).equals("("))
						&& (("" + s.charAt(i + 1)).equals("+") || ("" + s.charAt(i + 1)).equals("-"))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "0";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta(l + k);
				} // 2eme modification
				// -------------------------------------------------------------------------------

				// ------------------------------------------------------------------------------

				if (isNum(("" + s.charAt(i))) && (isCara("" + s.charAt(i + 1)))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta(l + k);
				} // 4eme modification

				// ---------------------------------------------------------------------------------

				if (isNum(("" + s.charAt(i))) && (("" + s.charAt(i + 1)).equals("("))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta(l + k);
				} // 5eme modification

				// --------------------------------------------------------------------------

				if ((("" + s.charAt(i)).equals("p")) && (("" + s.charAt(i + 1)).equals("i"))) {
					String l = "", k = "";
					for (int j = 0; j < i; j++) {
						l = l + s.charAt(j);
					}
					l = l + (Math.PI);
					for (int j = i + 2; j < s.length(); j++) {
						k = k + s.charAt(j);
					}

					return Mod_synta(l + k);

				}

				/*--------------sytax_operation---------------------------------------------------------*/

				if (isOper("" + s.charAt(i)) && isOper("" + s.charAt(i + 1))) {

					return "ERROR SYNTAX";

				}

				if ((("" + s.charAt(i)).equals("(")) && isOperPri("" + s.charAt(i + 1))) {

					return "ERROR SYNTAX";

				}

				if (isOper("" + s.charAt(i)) && (("" + s.charAt(i + 1)).equals(")"))) {

					return "ERROR SYNTAX";
				}

				// ------------------------------------------------------important--------------------------

				if (isCara("" + s.charAt(i))) {
					d = d + s.charAt(i);

					if (("" + s.charAt(i + 1)).equals("(")) {
						if (!existInTab(d)) {
							return "ERROR SYNTAX";
						} else {
							int c = 1;
							String y = "";
							String l = "(", k = "";
							int j = i + 2;
							while (c != 0) {
								l = l + s.charAt(j);
								if (("" + s.charAt(j)).equals("(")) {
									c++;
								}
								if (("" + s.charAt(j)).equals(")")) {
									c--;
								}
								j++;
							}
							if (!Mod_synta(l).equals("ERROR SYNTAX")) {

								l = calcul_fonc(d, calcul_polopnais(polonais(Mod_synta(l))));
								if (l.equals("Math Error")) {
									return "Math Error";
								} else {
									y = l;

									// System.out.println(y);

									if (contient_E("" + y)) {
										y = PlotView.tobigdecimal(Double.parseDouble(y));
										y = y.substring(0, 12);

										// System.out.println(y);

									}
								}
								l = "";
								for (int p = 0; p < i + 1 - d.length(); p++) {
									l = l + s.charAt(p);
								}
								for (int u = j; u < s.length(); u++) {
									k = k + s.charAt(u);
								}

								return Mod_synta(l + "(" + y + ")" + k);

							}

							else {
								return "ERROR SYNTAX";
							}

						} // fin else
					} // fin_if
				}
				i++;

			} // Fin While

			return s;
		}
		// ! (bien parenth�s�)

		else {
			return "ERROR SYNTAX";
		}

	}// fin de_la_fonction

	private static boolean contient_E(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (("" + s.charAt(i)).equals("E") && ("" + s.charAt(i + 1)).equals("-")) {
				return true;
			}
		}
		return false;
	}

	static double calcul_polopnais(String s) {

		double l;
		double k = 0;
		Stack p = new Stack();

		double cal = 0;
		String h = "";
		for (int i = 0; i < s.length(); i++) {

			if ((!("" + s.charAt(i)).equals(" ")) && !isOper("" + s.charAt(i))) {
				h = h + s.charAt(i);
			}

			if (("" + s.charAt(i)).equals(" ") && !isOper("" + s.charAt(i - 1))) {
				p.push(h);
				h = "";
			}

			if (isOper("" + s.charAt(i))) {

				l = Double.parseDouble("" + p.peek());
				p.pop();
				k = Double.parseDouble("" + p.peek());
				p.pop();
				cal = calcule_1(k, l, "" + s.charAt(i));

				p.push(cal);

			}

		}

		if (h.equals("")) {
			return (cal);
		}

		else {
			return (Double.parseDouble(h));
		}

	}

	static String polonais(String s) {

		Stack<Character> p = new Stack<Character>();
		String l = "";
		String r = "";

		for (int i = 0; i < s.length(); i++) {

			if ((l + s.charAt(i)).equals("(")) {
				p.push(s.charAt(i));
			}

			if ((l + s.charAt(i)).equals(")")) {

				while (!(l + p.peek()).equals("(")) {
					r = r + " " + p.peek();
					p.pop();
				}
				p.pop();
			}
			// __________________________________________________________________________________________

			if (isOper(l + s.charAt(i))) {
				r = r + " ";

				if (p.isEmpty()) {
					p.push(s.charAt(i));
				} else {

					if (!isOper(l + p.peek())) {
						p.push(s.charAt(i));
					}

					else {

						if (priorite(l + s.charAt(i), l + p.peek())) {
							p.push(s.charAt(i));
						}

						else {

							if (!priorite(l + s.charAt(i), l + p.peek())) {

								r = r + p.peek() + " ";

								p.pop();
								if (!p.isEmpty()) {
									if (isOper(l + p.peek())) {
										if (!p.isEmpty() && !priorite(l + s.charAt(i), l + p.peek())) {
											r = r + p.peek() + " ";
											p.pop();
											p.push(s.charAt(i));
										} else {
											p.push(s.charAt(i));
										}
									}

									else {
										p.push(s.charAt(i));
									}
								} else {
									p.push(s.charAt(i));
								}
								// -------------------------------------------------------------------------//--

							}
						}

					}
				}
				// ______________________________________________________________________________________

			}

			if (!isOper(l + s.charAt(i)) && !(l + s.charAt(i)).equals("(") && !(l + s.charAt(i)).equals(")")) {
				r = r + s.charAt(i);
			}

		}

		while (!p.isEmpty()) {
			r = r + " " + p.peek();
			p.pop();
		}

		return (r);

	}// fin_main

	private static boolean isNum(String s) {

		for (int i = 0; i < num.length; i++) {

			if (s.equals("" + num[i])) {
				return true;
			}
		}

		return false;
	}

	private static boolean isCara(String c) {

		for (int i = 0; i < cara.length; i++) {
			if (c.equals("" + cara[i]))
				return true;
		}
		return false;
	}

	// --------------------------------------------------------------------

	private static String calcul_fonc(String l, double res) {

		String r = "";
		for (int i = 0; i < fonc.length; i++) {
			if (l.equals(fonc[i])) {
				try {
					if (i == 10) {
						r = "" + Math.atan(res);
					}
					if (i == 9) {
						r = "" + Math.asin(res);
					}
					if (i == 8) {
						r = "" + Math.acos(res);
					}

					if (i == 7) {
						r = "" + Math.log10(res);
					}
					if (i == 6) {
						int n = (int) res;
						if (n != res) {
							return "Math Error";
						} else {
							r = "" + factor(n);
						}
					}
					if (i == 2) {
						if (tan(res).equals("Math Error")) {
							return "Math Error";
						} else {
							r = "" + tan(res);
						}
					}

					if (i == 5) {
						r = "" + Math.sqrt(res);
					}
					if (i == 4) {
						r = "" + Math.exp(res);
					}
					if (i == 3) {
						r = "" + Math.log(res);
					}

					if (i == 1) {
						r = "" + cos(res);
					}

					if (i == 0) {
						r = "" + sin(res);
					}

				} catch (ArithmeticException e) {

					return ("Math Error");
				}
			}
		}
		return r;

	}

	// ---------------------------------------------------
	private static double cos(double res) {

		double t = Math.abs(res % Math.PI);
		if (t == Math.PI / 2)
			return 0;
		else {
			return Math.cos(res);
		}
	}
	// ----------------------------------------------------

	private static double sin(double res) {

		double t = res % Math.PI / 4;
		if (t == 0)
			return 0;
		if (t == Math.PI / 2)
			return 1;
		if (t == -Math.PI / 2)
			return -1;

		else {
			return Math.sin(res);
		}
	}
	// ----------------------------------------------------s

	private static String tan(double res) {

		double t = Math.abs(res % Math.PI);
		if (t == 0 || t == Math.PI)
			return 0 + "";
		if (t == Math.PI / 2)
			return "Math Error";
		if (t == Math.PI / 4)
			return 1 + "";

		else {

			return "" + Math.tan(res);
		}

	}

	// -------------------------------------------------------------------

	private static boolean existInTab(String l) {
		for (int i = 0; i < fonc.length; i++) {
			if (l.equals(fonc[i])) {
				return true;
			}
		}
		return false;
	}

	public static Boolean isOper(String c) {
		String h = "";
		for (int i = 0; i < tab.length; i++) {
			if (c.equals(h + tab[i])) {
				return true;
			}
		}
		return false;
	}

	public static Boolean isOperPri(String c) {
		String h = "";
		for (int i = 0; i < tab1.length; i++) {
			if (c.equals(h + tab1[i])) {
				return true;
			}
		}
		return false;
	}

	// -------------------------------------------------------------------
	static boolean priorite(String op1, String op2) {

		boolean b = false;
		if (op1.equals("^")) {
			b = true;
		}

		if (op1.equals("*")) {
			if (op2.equals("^") || op2.equals("/"))
				b = false;
			else
				b = true;
		}

		if (op1.equals("/")) {
			if (op2.equals("^") || op2.equals("*"))
				b = false;

			else
				b = true;
		}

		if (op1.equals("+")) {
			if (op2.equals("-"))
				b = false;
			else
				b = false;
		}
		if (op1.equals("-")) {
			if (op2.equals("+"))
				b = false;
			else
				b = false;
		}
		return b;
	}

	// ----------------------------------------------------------------------

	public static double calcule_1(double k, double l, String s) {

		double r = 0;
		for (int i = 0; i < tab.length; i++) {

			if (s.equals("" + tab[i])) {

				if (i == 0) {
					r = k * l;
				}
				if (i == 1) {
					r = k / l;
				}
				if (i == 2) {
					r = k - l;
				}
				if (i == 3) {
					r = k + l;
				}
				if (i == 4) {
					r = Math.pow(k, l);
				}

			}

		}
		return r;
	}

	// ----------------factoriel---------------------------------------------

	public static int factor(int n) {

		if (n == 0) {
			return 1;
		} else
			return n * factor(n - 1);
	}

	// ---------------------------------------------------------------------

	private static boolean bienparenthese(String s) {

		boolean b = true;
		if (s.charAt(0) == ')')
			b = false;
		else {
			for (int i = 0; i < s.length() - 1; i++) {
				if ((s.charAt(i) == '(') && (s.charAt(i + 1) == ')'))
					b = false;
			}
			Stack<String> st = new Stack<String>();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					st.push("" + s.charAt(i));
				if (s.charAt(i) == ')') {
					if (st.isEmpty())
						b = false;
					else
						st.pop();
				}

			}
			if (!(st.isEmpty()))
				b = false;
		}
		return b;
	}

	// _________________________________________________________________________________________________________________________________

	public static String Cal(String s) {
		try {
			if (Mod_synta(s).equals("ERROR SYNTAX")) {
				return ("ERROR SYNTAX");
			}
			if (Mod_synta(s).equals("Math Error")) {
				return ("Math Error");
			}

			else {
				return "" + calcul_polopnais(polonais(CalculHelper.Mod_synta(s)));

			}
		} catch (NumberFormatException e) {
			return "Math Error";
		}
	}
	// -----------------------------------------------------------------------------------------------------------------------------------

	public static String Cal1(String s) {
		try {
			if (Mod_synta(s).equals("ERROR SYNTAX")) {
				return ("ERROR SYNTAX");
			}
			if (Mod_synta(s).equals("Math Error")) {
				return ("Math Error");
			}

			else {

				return "" + calcul_polopnais(polonais(CalculHelper.Mod_synta1(s)));
			}
		} catch (NumberFormatException e) {
			return "Math Error";
		}

	}

	// ------------------------------------------------------------------------------------------------------------------------------------

	public static String Mod_synta1(String s) {
		String d = "";

		if (bienparenthese(s)) {

			// ---------------------------------------------------------------------------------------------------------------
			if (isOper("" + s.charAt(0))) {
				return "ERROR SYNTAX";
			}

			if (isOper("" + s.charAt(s.length() - 1))) {
				return "ERROR SYNTAX";
			}

			// -----------------------------------------------------------------------------------------------------------------

			int i = 0;

			while (i != s.length() - 1) {

				/*-----------------------Les Modifications--------------------------------------------------------*/
				if ((("" + s.charAt(i)).equals(")")) && (("" + s.charAt(i + 1)).equals("("))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta1(l + k);
				} // 1ere modification
				// -----------------------------------------------------------------------------
				if ((("" + s.charAt(i)).equals("("))
						&& (("" + s.charAt(i + 1)).equals("+") || ("" + s.charAt(i + 1)).equals("-"))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "0";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta1(l + k);
				} // 2eme modification
				// -------------------------------------------------------------------------------

				// ------------------------------------------------------------------------------

				if (isNum(("" + s.charAt(i))) && (isCara("" + s.charAt(i + 1)))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta1(l + k);
				} // 4eme modification

				// ---------------------------------------------------------------------------------

				if (isNum(("" + s.charAt(i))) && (("" + s.charAt(i + 1)).equals("("))) {
					String l = "", k = "";
					for (int j = 0; j <= i; j++) {
						l = l + s.charAt(j);
					}
					l = l + "*";
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}
					return Mod_synta1(l + k);
				} // 5eme modification

				// --------------Problemes here
				// !!!------------------------------------------------------------

				if ((("" + s.charAt(i)).equals("p")) && (("" + s.charAt(i + 1)).equals("i"))) {
					String l = "", k = "";
					for (int j = 0; j < i; j++) {
						l = l + s.charAt(j);
					}
					l = l + (Math.PI);
					for (int j = i + 2; j < s.length(); j++) {
						k = k + s.charAt(j);
					}

					return Mod_synta1(l + k);

				}

				if (("" + s.charAt(i)).equals("E")) {
					String l = "", k = "";
					for (int j = 0; j < i; j++) {
						l = l + s.charAt(j);
					}

					l = l + Math.E;
					for (int j = i + 1; j < s.length(); j++) {
						k = k + s.charAt(j);
					}

					return Mod_synta1(l + k);

				}

				/*--------------sytax_operation---------------------------------------------------------*/

				if (isOper("" + s.charAt(i)) && isOper("" + s.charAt(i + 1))) {

					return "ERROR SYNTAX";

				}

				if ((("" + s.charAt(i)).equals("(")) && isOperPri("" + s.charAt(i + 1))) {

					return "ERROR SYNTAX";

				}

				if (isOper("" + s.charAt(i)) && (("" + s.charAt(i + 1)).equals(")"))) {

					return "ERROR SYNTAX";
				}

				// ------------------------------------------------------important------------------------------------------------------------------------

				if (isCara("" + s.charAt(i))) {
					d = d + s.charAt(i);

					if (("" + s.charAt(i + 1)).equals("(")) {
						if (!existInTab(d)) {
							return "ERROR SYNTAX";
						} else {
							int c = 1;
							String l = "(", k = "";
							int j = i + 2;
							double m = 0;
							while (c != 0) {
								l = l + s.charAt(j);
								if (("" + s.charAt(j)).equals("(")) {
									c++;
								}
								if (("" + s.charAt(j)).equals(")")) {
									c--;
								}
								j++;
							}
							if (!Mod_synta(l).equals("ERROR SYNTAX")) {

								l = calcul_fonc1(d, calcul_polopnais(polonais(Mod_synta1(l))));
								if (l.equals("Math Error")) {
									return "Math Error";
								} else {
									m = Double.parseDouble(l);

								}
								l = "";
								for (int p = 0; p < i + 1 - d.length(); p++) {
									l = l + s.charAt(p);
								}
								for (int u = j; u < s.length(); u++) {
									k = k + s.charAt(u);
								}

								return Mod_synta1(l + "(" + m + ")" + k);
							}

							else {
								return "ERROR SYNTAX";
							}

						} // fin else
					} // fin_if
				}
				i++;

			} // Fin While

			return s;
		}
		// ! (bien parenth�s�)

		else {
			return "ERROR SYNTAX";
		}

	}// fin de_la_fonction

	// --------------------------------------------------------

	private static String calcul_fonc1(String l, double res) {

		String r = "";
		for (int i = 0; i < fonc.length; i++) {
			if (l.equals(fonc[i])) {
				try {
					if (i == 10) {
						r = "" + Math.atan(res);
					}
					if (i == 9) {
						r = "" + Math.asin(res);
					}
					if (i == 8) {
						r = "" + Math.acos(res);
					}

					if (i == 7) {
						r = "" + Math.log10(res);
					}
					if (i == 6) {
						int n = (int) res;
						if (n != res) {
							return "Math Error";
						} else {
							r = "" + factor(n);
						}
					}
					if (i == 2) {
						if (tan(Math.toRadians(res)).equals("Math Error")) {
							return "Math Error";
						} else {
							r = "" + tan(Math.toRadians(res));
						}
					}
					if (i == 1) {
						r = "" + cos(Math.toRadians(res));
					}

					if (i == 0) {
						r = "" + sin(Math.toRadians(res));
					}

					if (i == 5) {
						r = "" + Math.sqrt(res);
					}
					if (i == 4) {
						r = "" + Math.exp(res);
					}
					if (i == 3) {
						r = "" + Math.log(res);
					}

				} catch (ArithmeticException e) {

					return ("Math Error");
				}
			}
		}

		return r;

	}

}
