package com.msjexports.handlers;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.renderer.DefaultWordRenderer;

public class Captchahandler extends HttpServlet{


	private static final long serialVersionUID = 1L;
	final static Logger logger = LoggerFactory.getLogger(Captchahandler.class);
	
	 	@Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 		try {
			        List<Color> colors = new ArrayList<Color> ();
			        colors.add(Color.black);
			        colors.add(Color.red);
			        colors.add(Color.DARK_GRAY);
			        colors.add(Color.BLUE);
			         
			        List<Font> fonts = new ArrayList<Font>();
			        fonts.add(new Font("Arial", Font.ITALIC, 40));
			        fonts.add(new Font("Verdana", Font.HANGING_BASELINE, 35));
			        fonts.add(new Font("Calibri", Font.ITALIC, 30));
			        fonts.add(new Font("Palatino Linotype", Font.ITALIC,25));
			         
			        Captcha captcha = new Captcha.Builder(120, 50)
			                .addText(new DefaultWordRenderer(colors, fonts))
			                .addBackground(new GradiatedBackgroundProducer(Color.white, Color.white))
			                .gimp()
			                .addBorder()
			                .build();
			        
			        logger.info("Generated captcha value :"+captcha.getAnswer());
			        
			        request.getSession().setAttribute("captcha",captcha.getAnswer());
			        // display the image produced
			        CaptchaServletUtil.writeImage(response, captcha.getImage());
	 
	        
	 		}
	 		catch(Exception e)
			{
				logger.error("Exception in Captchahandler",e);
			}
	 	}

}