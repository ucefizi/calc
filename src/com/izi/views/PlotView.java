package com.izi.views;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.MathContext;

import calc.helpers.CalculHelper;
import calc.helpers.StdDraw;

public class PlotView {

	String f;
	int max;
	int N = 1000;

	PlotView(String f, int max) {
		this.f = f;
		this.max = max;
	}

	public void start1() {

		double[] x = new double[N + 1];
		double[] y = new double[N + 1];

		x[0] = max;

		String l;
		int i = 1;

		while (i <= 1000 && x[i] <= -max) {

			l = "";
			x[i] = x[i - 1] + 20.0 / 1000;
			l = tobigdecimal(x[i]);

			try {

				y[i] = Double.parseDouble(virgule_to_point(CalculHelper.Cal(CalculView.fonction(f, l))));

			} catch (NumberFormatException e) {
				i = i + 1;
				y[i] = Double.parseDouble("NaN");
			}
			i++;
		}

		// calcul de max y[i] et min de y[i]

		// rescale the coordinate system

		StdDraw.setXscale(-10.0, 10.0);
		StdDraw.setYscale(-10.0, 10.0);
		StdDraw.line(0.0, -20.0, 0.0, 20.0);
		StdDraw.line(-10.0, 0.0, 10.0, 0.0);
		StdDraw.line(1.0, -0.05, 1, 0.05);
		StdDraw.line(-0.05, 1.0, 0.05, 1.0);

		// plot the approximation to the function
		StdDraw.setPenColor(Color.RED);
		for (int j = 1; j < N; j++) {
			StdDraw.line(x[j], y[j], x[j + 1], y[j + 1]);

		}

	}

	public static String tobigdecimal(double d) {

		MathContext mc = new MathContext(10);
		BigDecimal b = new BigDecimal(d, mc);
		return b.toPlainString();
	}

	public String virgule_to_point(String s) {

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ',') {
				s = s.substring(0, i) + "." + s.substring(i + 1, s.length());
				break;
			}
		}
		return s;
	}

}
