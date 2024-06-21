package edu.utnfrc.ppai_diseno_siistemas_utn_frc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class PpaiDisenoSiistemasUtnFrcApplication extends Application {

	@Getter
	public static Stage primaryStage;
	@Getter
	public static Pane primaryView;

	@Getter
	public static final ConfigurableApplicationContext context = SpringApplication.run(PpaiDisenoSiistemasUtnFrcApplication.class);

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		primaryStage = stage;
		primaryStage.setTitle("Ranking de Vinos");
		showPrimaryView();
	}

	private void showPrimaryView() throws IOException {
		FXMLLoader fxml = new FXMLLoader(getClass().getResource("/views/PpaiDisenoSiistemasUtnFrcApplication.fxml"));
		fxml.setControllerFactory(context::getBean);
		primaryView = fxml.load();
		Scene scene = new Scene(primaryView);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
