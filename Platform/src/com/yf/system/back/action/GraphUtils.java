/**
 * 
 */
package com.yf.system.back.action;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicEditorPaneUI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GraphUtils {

  private final static Log log = LogFactory.getLog(GraphUtils.class);

  public static int DEFAULT_IMAGE_WIDTH = 1230;

  public static int DEFAULT_IMAGE_HEIGHT = 528;

  /**
   * 将ＢｕｆｆｅｒｅｄＩｍａｇｅ转换为图片的信息
   * 
   * @param image
   * @return
   */
  public static String toJpeg(BufferedImage image, String nsrlsh, String year,String uuid) {
    
	  
	  
	  
	  String imageName = "D:\\tomcat\\webapps\\lthk_home\\sendticket-images\\"+uuid + ".jpg";
	  try {
		ImageIO.write(image, "JPG", new File(imageName));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	  /*
	  System.out.println(imageName);
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(baos);
      JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
      param.setQuality(1.0f, false);
      encoder.setJPEGEncodeParam(param);
      encoder.encode(image);
      byte[] buff = baos.toByteArray();
      baos.close();
      // 将字节流写入文件保存为图片
      FileUtils.writeByteArrayToFile(new File(imageName), buff);
      System.out.println("保存成功!....");
    } catch (Exception ex) {
      log.error("保存删除图片失败:" + ex.getMessage());
    }
    */
    return imageName;
  }

  /**
   * html转换为ｊｐｅｇ文件
   * 
   * @param bgColor
   *          图片的背景色
   * @param html
   *          html的文本信息
   * @param width
   *          显示图片的Ｔｅｘｔ容器的宽度
   * @param height
   *          显示图片的Ｔｅｘｔ容器的高度
   * @param eb
   *          設置容器的边框
   * @return
   * @throws Exception
   */
  private static ArrayList<String> html2jpeg(Color bgColor, String html, int width, int height, EmptyBorder eb,
      String nsrlsh, String year,String uuid) throws Exception {
    ArrayList<String> ret = new ArrayList<String>();
    try {
      JTextPane tp = new JTextPane();
      tp.setSize(width, height);
      if (eb == null) {
        eb = new EmptyBorder(0, 50, 0, 50);
      }
      if (bgColor != null) {
        tp.setBackground(bgColor);
      }
      if (width <= 0) {
        width = DEFAULT_IMAGE_WIDTH;
      }
      if (height <= 0) {
        height = DEFAULT_IMAGE_HEIGHT;
      }
      tp.setBorder(eb);
      tp.setContentType("text/html");
      tp.setText(html);
      Dimension d = ((BasicEditorPaneUI) tp.getUI()).getPreferredSize(tp);
      //此处是将一个页面生成一张图片，如果要人为控制图片大小进行分页生成，则再自行进行高度设置，但是分页之后可能出现的情况就是分页的时候字体被截断的可能，因为在截断的之后，他不知道流是否刚好将一行字显示完成
      if(d.height>DEFAULT_IMAGE_HEIGHT){
        height=d.height;
      }
      PrintView m_printView = new PrintView(tp);
      int pageIndex = 1;
      boolean bcontinue = true;
      while (bcontinue) {
        BufferedImage image = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setClip(0, 0, width, height);
        bcontinue = m_printView.paintPage(g, height, pageIndex);
        g.dispose();
      
        String path = toJpeg(image, nsrlsh, year,uuid);
        ret.add(path);
        pageIndex++;
      }
    } catch (Exception ex) {
      throw ex;
    }
    return ret;
  }

  
  /**
   * 将一個html转换为图片
   * 
   * @param htmls
   * @return
   * @throws Exception
   */
  public static ArrayList<String> toImages(String html, String nsrlsh, String year,String uuid) throws Exception {
    return html2jpeg(null, html, DEFAULT_IMAGE_WIDTH, DEFAULT_IMAGE_HEIGHT, new EmptyBorder(0, 0, 0, 0), nsrlsh, year,uuid);
  }
  
  public static void createImagebyhtml(String htmlstr,String struuid)
  {
	  try {
	      String nextLine = null;
	      System.out.println(htmlstr);
	      GraphUtils.toImages(htmlstr, "000000003126754", "2010",struuid);
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
  }

  public static void main(String[] args) {
    try {
  String htmlstr = "";
  htmlstr+="<html><body style='font-size:16px;line-height:9px;font-family:Tahoma,TEC;'><table border='0' width='1030' id='tbprint' style='margin:0 auto; margin-left:80px; border-collapse:collapse;border-spacing:0;'><tr><td colspan='7' style='font-size:28px; line-height:24px; text-align:center; font-weight:bold'>&nbsp;&nbsp;&nbsp;东航国旅送票单</td><td width='15%' valign='bottom'><font size='2em'>无</font></td></tr>";

  htmlstr+="<tr  >";
  htmlstr+="<td align='right'><font  >Customer:</font></td>";
  htmlstr+="<td align='left'><font  >南瑞信通公司</font></td>";
  htmlstr+="<td align='right'><font  >Contact:</font></td>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>张华锋</td>";
  htmlstr+="<td align='right'><font  >No:</font></td>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'><font  >A22121</font></td>";
  htmlstr+="<td align='right' style='height:9px;line-height:9px;'><font  >PNR:</font></td>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'><font  >HR7K8C </font></td>";
  htmlstr+="</tr>";

  htmlstr+="<tr >";
  htmlstr+="<td  style='height:9px;line-height:50%;' align='right'><font >Tel:</font></td>";
  htmlstr+="<td align='left'style='height:9px;line-height:50%;'><font >无</font></td>";
  htmlstr+="<td align='right' style='height:9px;line-height:50%;'><font >Delivery:</font></td>";
  htmlstr+="<td align='left' style='height:9px;line-height:50%;'></td>";
  htmlstr+="<td align='right' style='height:9px;line-height:50%;'><font >Issue:</font></td>";
  htmlstr+="<td align='left' style='height:9px;line-height:50%;'><font >2010-12-27 12:49:14</font></td>";
  htmlstr+="<td align='right' style='height:9px;line-height:50%;'><font >Payment:</font></td>";
  htmlstr+="<td align='left' style=' ;height:9px;line-height:50%;'><font >客户挂账</font></td>";
  htmlstr+="</tr>";

  htmlstr+="<tr style='line-height:14px'>";

  htmlstr+="<td align='right' style='height:9px;line-height:9px;'><font  >Addr:</font></td>";
  htmlstr+="<td align='left'><font  >无</font></td>";
  htmlstr+="<td align='right'></td>";
  htmlstr+="<td align='left'></td>";
  htmlstr+="<td align='right'><font  >Memo:</font></td>";
  htmlstr+="<td align='left'><font  >无</font></td>";
  htmlstr+="<td align='right' style='height:9px;line-height:9px;'><font  >Print:</font></td>";
  htmlstr+="<td align='left'><font  >2010-12-28</font></td>";
  htmlstr+="</tr>";

  htmlstr+="<tr>";
  htmlstr+="<td colspan='8'><hr style='height:1px; width:100%'></td>";
  htmlstr+="</tr>";

  htmlstr+="<tr>";
  htmlstr+="<td colspan='8'>";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
  htmlstr+="<tr>";
  htmlstr+="<td>";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
 htmlstr+="<tr>";
  htmlstr+="<td width='35%' valign='top' >";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
  htmlstr+="<tr>";
  htmlstr+="<td valign='top'style='height:9px;line-height:9px;' >";
  htmlstr+="<table width='100%' border='0' style='height:9px;line-height:9px;' cellspacing='0' cellpadding='0'><tr><td style='height:9px;line-height:9px;'>Line1:</td></tr></table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="<tr>";
  htmlstr+="<td  valign='top'style='height:9px;line-height:9px;' >";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td style='height:9px;line-height:9px;'>CGOPEK&nbsp;CZ3115&nbsp;H&nbsp;09JAN&nbsp;08:10&nbsp;</td></tr></table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="<tr>";
  htmlstr+="<td valign='top'style='height:9px;line-height:9px;' >";
  htmlstr+="<table width='100%' border='0' style='height:9px;line-height:9px;' cellspacing='0' cellpadding='0'><tr><td style='height:9px;line-height:9px;'>Line1:</td></tr></table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="<tr>";
  htmlstr+="<td  valign='top'style='height:9px;line-height:9px;' >";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'> <tr><td style='height:9px;line-height:9px;'>CGOPEK&nbsp;CZ3115&nbsp;H&nbsp;09JAN&nbsp;08:10&nbsp;</td></tr></table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="</table>";  																																												  htmlstr+="</td>";
  htmlstr+="<td width='100%' valign='top'>";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'> ";
  htmlstr+="<tr>";
  htmlstr+="<td valign='top' align='left' width='50%'>";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="</table>";
  htmlstr+="</td>";
  htmlstr+="<td valign='top'>";
  htmlstr+="<table width='100%' border='0' cellspacing='0' cellpadding='0'>";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="<tr>";
  htmlstr+="<td align='left' style='height:9px;line-height:9px;'>&nbsp;&nbsp;&nbsp;372929198707130014&nbsp;&nbsp;&nbsp;&nbsp;张华锋";
  htmlstr+="</td>";    																																																					 
  htmlstr+="</tr> ";
  htmlstr+="</table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="</table>";
  htmlstr+="</td>";
  htmlstr+="</tr> ";
  htmlstr+="</table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";
  htmlstr+="</table>";
  htmlstr+="</td>";
  htmlstr+="</tr>";

  htmlstr+="<tr><td height='10px'></td></tr>";
  htmlstr+="<tr><td align='center' colspan='8'>Amt:640.00/返点0/返金额0 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;等共：1张</td></tr>";
  htmlstr+="<tr><td height='10px'></td></tr>";

  htmlstr+="</table></body></html>";

      String nextLine = null;

      System.out.println(htmlstr);
      GraphUtils.toImages(htmlstr, "000000003126754", "2010",UUID.randomUUID().toString());
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
