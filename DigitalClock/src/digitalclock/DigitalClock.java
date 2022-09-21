package digitalclock;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DigitalClock extends Applet implements Runnable
{
	Thread t;
	String date = "";
	String time = "";
	String day =  "";
	public void start()
	{
		setSize(1130, 500);
		setBackground(Color.BLACK);
		t = new Thread(this);
		t.start();
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.setFont(new Font("Arial",Font.BOLD,250));
		g.drawString(time, 50, 380);
		
		g.setFont(new Font("Arial",Font.BOLD,60));
		g.drawString(date, 80, 80);
		
		g.drawString(day, 840, 80);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				
				DateTimeFormatter date_formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
				DateTimeFormatter time_formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				
				LocalDate localdate = LocalDate.now(); 
				date = localdate.format(date_formatter);
				
				LocalTime localtime = LocalTime.now();
				time = localtime.format(time_formatter);
				
				Calendar calender = Calendar.getInstance();
				Date d = calender.getTime();
				
				SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.ENGLISH);
				day = sdf.format(d);
				
				repaint();
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
