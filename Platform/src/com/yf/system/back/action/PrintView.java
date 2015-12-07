/**
 * 
 */
package com.yf.system.back.action;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextPane;
import javax.swing.plaf.basic.BasicEditorPaneUI;


public class PrintView {

  public JTextPane panel = null;

  public PrintView(JTextPane panel) {
    this.panel = panel;
  }

  /**
   * 绘制图片的方法
   * 
   * @param g
   * @param hPage
   * @param pageIndex
   * @return
   */
  public boolean paintPage(Graphics g, int hPage, int pageIndex) {
    Graphics2D g2 = (Graphics2D) g;
    Dimension d = ((BasicEditorPaneUI) panel.getUI()).getPreferredSize(panel);
    double panelHeight = d.height;
    double pageHeight = hPage;
    int totalNumPages = (int) Math.ceil(panelHeight / pageHeight);
    g2.translate(0f, -(pageIndex - 1) * pageHeight);
    panel.paint(g2);
    boolean ret = true;
    if (pageIndex >= totalNumPages) {
      ret = false;
      return ret;
    }
    return ret;
  }
}
