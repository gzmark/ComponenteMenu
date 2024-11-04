package barracolapsable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopCollapsibleToolbar extends JPanel {

    private boolean isCollapsed = false;
    private Color barColor = new Color(185, 200, 171);
    private JButton toggleButton;
    private JPanel menuPanel;

    public TopCollapsibleToolbar() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 100));

        toggleButton = new JButton("▲");
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleToolbar();
            }
        });
        toggleButton.setFocusPainted(false);
        toggleButton.setBackground(barColor);
        toggleButton.setForeground(Color.WHITE);

        menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(new Color(221, 52, 54));

        addMenuItem("Inicio", "prueba");
        addMenuItem("Ajustes", "prueba2");
        addMenuItem("Perfil", "prueba3");

        add(toggleButton, BorderLayout.NORTH);
        add(menuPanel, BorderLayout.CENTER);
    }

    public void addMenuItem(String text1, String text2) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBackground(new Color(221, 120, 54));

        JLabel label = new JLabel(text1, JLabel.CENTER);
        label.setForeground(Color.DARK_GRAY);
        label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5));

        JPanel submenuPanel = new JPanel();
        submenuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        submenuPanel.setBackground(new Color(138, 128, 73));
        submenuPanel.setVisible(false);

        JButton submenuItem1 = new JButton(text2);
        JButton submenuItem2 = new JButton("Boton 2");
        styleSubmenuButton(submenuItem1);
        styleSubmenuButton(submenuItem2);

        submenuPanel.add(submenuItem1);
        submenuPanel.add(submenuItem2);

        itemPanel.add(label, BorderLayout.CENTER);
        itemPanel.add(submenuPanel, BorderLayout.SOUTH);

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submenuPanel.setVisible(!submenuPanel.isVisible());
                revalidate();
                repaint();
            }
        });

        menuPanel.add(itemPanel);
    }

    private void styleSubmenuButton(JButton button) {
        button.setBackground(barColor.darker());
        button.setForeground(Color.BLUE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }

    private void toggleToolbar() {
        isCollapsed = !isCollapsed;
        menuPanel.setVisible(!isCollapsed);
        toggleButton.setText(isCollapsed ? "▼" : "▲");
        setPreferredSize(isCollapsed ? new Dimension(500, 30) : new Dimension(500, 100));
        revalidate();
        repaint();
    }

    public void setBarColor(Color color) {
        this.barColor = color;
        menuPanel.setBackground(barColor);
        //toggleButton.setBackground(barColor);
        revalidate();
        repaint();
    }

    public void setBarColor2(Color color) {
        this.barColor = color;
        //menuPanel.setBackground(barColor);
        toggleButton.setBackground(barColor);
        revalidate();
        repaint();
    }

}
