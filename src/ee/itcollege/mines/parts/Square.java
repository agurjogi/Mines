package ee.itcollege.mines.parts;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Square extends StackPane {

	public static final int SQUARE_SIZE = 60;
	
	private static final Color DEFAULT_COLOR = new Color(.2, .2, .2, 1);

	private Rectangle box = new Rectangle(SQUARE_SIZE - 1, SQUARE_SIZE - 1);
	private Label label = new Label();
	private int bombCount = 0;
	private int x, y;
	private boolean hasBomb = false;
	private boolean flag = false;
	private boolean shown = false;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		
		
		setLayoutX(x * (SQUARE_SIZE));
		setLayoutY(y * (SQUARE_SIZE));
		getChildren().addAll(box, label);

		box.setFill(Color.KHAKI);
		setCursor(Cursor.HAND);
		label.setFont(new Font(30));
	}

	// String.valueOf
	// Integer.toString

	public void show() {
		shown = true;
		box.setFill(Color.RED);
		if (hasBomb) {
			label.setTextFill(Color.LIME);
			label.setText("*");
			// label.setText(String.valueOf(bombCount));

		} else {
			if (bombCount > 0) {
				label.setText(String.valueOf(bombCount));
			}
		}
	}
	
	public void toggleFlag() {
		if (!shown) {
			flag = !flag;
			label.setTextFill(flag ? DEFAULT_COLOR : Color.AQUA);
			label.setText(flag ? "B" : "");
		}
	}

	public boolean hasBomb() {
		return hasBomb;
	}

	public void setHasBomb(boolean hasBomb) {
		this.hasBomb = hasBomb;
	}

	public int getBombCount() {
		return bombCount;
	}
	
	public boolean hasFlag() {
		return flag;
	}


	public void setBombCount(int bombCount) {
		this.bombCount = bombCount;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
