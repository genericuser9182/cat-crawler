import java.util.*;				// Scanner
import java.io.*;				// I/O classes
import javafx.application.*;
import javafx.scene.layout.*;	// Panes
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.*;	// Image, ImageView
import javafx.scene.control.*;	// Button
public class Cats extends Application {
	private ArrayList<String> possibleImgNames = new ArrayList<>();
	public void init() {
		try {
			Scanner sc = new Scanner(new FileReader("cat_pictures.txt"));
			while(sc.hasNext()) {
				possibleImgNames.add(sc.nextLine());
			}
		} catch (Exception ex) {}
	}
	public void start(Stage stage) {
		Button bt = new Button("CATTTT!");
		ImageView view = new ImageView();
		bt.setOnAction(e -> {
			Image img = getRandomImg();
			view.setImage(img);
			stage.setMinWidth(img.getWidth());
			stage.setMinHeight(img.getHeight());
		});

		StackPane pane = new StackPane(view, bt);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	
	public Image getRandomImg() {
		String name = possibleImgNames.get((int)(Math.random() * possibleImgNames.size()));
		if(new Image(name).getWidth() > 800)
			return new Image(name, 500, 0, true, false);
		return new Image(name);
	}
}
