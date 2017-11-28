package com.hzit.authcode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthCode extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 30;
	private String codes = "ABC0DEF1GHI2JKL3MNO4PQR5STUV6WX7YZ89";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics graph = image.getGraphics();
		setBackGround(graph);//设置背景
		setBorder(graph);//设置边框
		drawRandomLine(graph);//设置干扰线
		String code = drawRandomNum((Graphics2D) graph);//设置随机数
		HttpSession session = request.getSession();//用于存储验证码的session
		session.setAttribute("authcode", code);
		response.setContentType("image/jpeg");//设置图片格式
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");//设置响应头，不要缓存验证码图片
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private void setBackGround(Graphics graph) {
		// TODO Auto-generated method stub
		graph.setColor(Color.WHITE);
		graph.fillRect(0, 0, WIDTH, HEIGHT);
	}

	private void setBorder(Graphics graph) {
		// TODO Auto-generated method stub
		graph.setColor(Color.BLUE);
		graph.drawRect(1, 1, (WIDTH-2), (HEIGHT-2));
	}

	private void drawRandomLine(Graphics graph) {
		// TODO Auto-generated method stub
		graph.setColor(Color.GREEN);
		for(int i=0;i<5;++i){
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			graph.drawLine(x1, y1, x2, y2);
		}
	}

	private String drawRandomNum(Graphics2D graph) {
		// TODO Auto-generated method stub
		char[] authcode = new char[4];
		graph.setColor(Color.RED);
		graph.setFont(new Font("楷体",Font.BOLD,20));
		for(int i =0;i<4;++i){
			int degree = new Random().nextInt()%45;
			int index = new Random().nextInt(codes.length());
			graph.rotate(degree*Math.PI/180, 10+30*i, 20);
			graph.drawString(((Character)codes.charAt(index)).toString(), 10+30*i, 20);
			authcode[i] = codes.charAt(index);
			graph.rotate(-degree*Math.PI/180, 10+30*i, 20);
		}
		String code = new String(authcode);
		return code;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
