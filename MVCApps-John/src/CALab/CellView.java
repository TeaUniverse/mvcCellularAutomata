package CALab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import mvc.*;


public class CellView extends JButton implements ActionListener, Subscriber {
    private Cell myCell;

    public CellView(Cell c) {
        myCell = c;
        if (c != null) { c.subscribe(this); }
        this.addActionListener(this);
        setBorder(BorderFactory.createLineBorder(Color.black));
        update();
    }

    public CellView() { this(null); }
    public void setCell(Cell cell){
        myCell = cell;
        update();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        myCell.nextState();
        update();
    }

    // called by notifySubscribers and GridView.update

    @Override
    public void update() {
        setBackground(myCell.getColor());
        setText("" + myCell.getStatus());
        repaint();
    }
}