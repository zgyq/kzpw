package com.yf.system.back.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: ValidateCodeServlet
 *
 */
public class ValidateCodeServlet extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {

	private static final String code = "0123456789";

	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		OutputStream outs = response.getOutputStream();
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0L);
		int width = 90;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, 1);
		Graphics g = image.getGraphics();
		Random random = new Random();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", 0, 20));
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		StringBuffer sRand = new StringBuffer();
		char c[] = "0123456789".toCharArray();
		for (int i = 0; i < 4; i++) {
			char rand = c[(int) (Math.random() * (double) c.length)];
			sRand.append(rand);
			g.setColor(new Color(20 + (int) (Math.random() * 110D),
					20 + (int) (Math.random() * 110D), 20 + (int) (Math
							.random() * 110D)));
			g.drawString(String.valueOf(rand), 18 * i + 6, 24);
		}

		session.setAttribute("validate", sRand.toString());
		g.dispose();
		ImageIO.write(image, "PNG", outs);
		outs.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	public void destroy() {
	}
}